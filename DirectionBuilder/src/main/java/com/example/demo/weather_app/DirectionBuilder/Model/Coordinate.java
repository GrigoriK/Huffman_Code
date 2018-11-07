package com.example.demo.weather_app.DirectionBuilder.Model;

import com.example.demo.weather_app.DirectionBuilder.error.MassSizeException;
import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.LatLng;
import com.google.maps.model.TravelMode;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class Coordinate {
    private  final GeoApiContext Gcontext;
    private final String APIDirectionKey="AIzaSyBXwTfSt74U8zY0mNpULiJEGPv9ZYOgL7U";
    private final int maxCountOfWayPoints=21;
    private String StartPoint="";
    private String endPoint="";
    private String waypoints="";
    private ArrayList<LatLng> points;
    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
        this.waypoints = waypoints;
    }


    public  Coordinate(){
        Gcontext = getDirectionContext(APIDirectionKey);

    }

    private   GeoApiContext getDirectionContext(String key) {
        return new GeoApiContext.Builder().apiKey(key).build();
    }

    public String getStartPoint() {
        return StartPoint;
    }

    public void setStartPoint(String startPoint) {
        StartPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getPoints(){
        StringBuffer buffer=new StringBuffer();
        for (LatLng p:points){
            buffer.append(p.toString()+"\n");
        }

        return buffer.toString();


}
    public void MakeDirection(){
        points =new ArrayList<>();
        points.add(StringToLatLang(StartPoint));
        points.add(new LatLng(0.000,0.000));
                 if (waypoints.equals("")) {
                     buildDirection(StartPoint,endPoint);
                 } else {
                     String start=getStartPoint();
                     String end=getEndPoint();
                     String por[] = waypoints.replaceAll("\\s+", "").split(";");
                     int AllPoints=por.length;
                     int startPosition=0;
                     while(AllPoints>0){
                         LatLng [] latL;
                         int leng_point=0;
                         if(AllPoints/maxCountOfWayPoints<1){
                             latL =new LatLng[AllPoints%maxCountOfWayPoints] ;
                             end=getEndPoint();
                         }
                         else {
                             latL =new LatLng[maxCountOfWayPoints] ;
                             end=por[startPosition+latL.length];
                         }
                         for(int i=startPosition;i<startPosition+latL.length;i++){

                             latL[leng_point++]=StringToLatLang(por[i]);
                         }

                         buildDirection(start,latL,end);
                         startPosition+=latL.length+1;
                         AllPoints-=latL.length+1;
                         start=end;
                         }
                         points.add(StringToLatLang(endPoint));

                 }





    }


        private void buildDirection(String StartPoint,String endPoint) {
           try {
               DirectionsResult result = DirectionsApi.newRequest(Gcontext)
                       .origin(StartPoint)
                       .destination(endPoint)
                       .mode(TravelMode.WALKING)
                       .language("ru")
                       .await();
               DirectionsStep [] Dirstep=result.routes[0].legs[0].steps;
               for (int i=1;i< Dirstep.length;i++) {
                   points.add(Dirstep[i].endLocation);

               }
           }
            catch (ApiException e){

            }
             catch (InterruptedException e){

            }
             catch (IOException e){

            }
        }
        private void buildDirection(String StartPoint,LatLng[] waypoints,String endPoint ) {

        if(waypoints.length>21) throw new MassSizeException("Quantity of waypoints more  than 21");
        try {
            DirectionsResult result = DirectionsApi.newRequest(Gcontext)

                    .origin(StartPoint)
                    .destination(endPoint)
                    .mode(TravelMode.WALKING)
                    .waypoints(LatLangsToWaypoints(waypoints))
                    .language("ru")
                    .await();

            DirectionsStep [] Dirstep=result.routes[0].legs[0].steps;
            for (int i=1;i< Dirstep.length;i++) {
                points.add(Dirstep[i].endLocation);

            }
            points.add(new LatLng(0.0000,0.0000));
            points.add(new LatLng(0.0000,0.0000));
        }
             catch (ApiException e){

            }
             catch (InterruptedException e){

            }
             catch (IOException e){

            }



        }

        private DirectionsApiRequest.Waypoint [] LatLangsToWaypoints(LatLng [] waypoints){
            DirectionsApiRequest.Waypoint [] lat=new DirectionsApiRequest.Waypoint [waypoints.length];
            for (int i=0 ;i<waypoints.length;i++){
                lat[i]=new DirectionsApiRequest.Waypoint(  waypoints[i], false);
            }
            return lat;
        }

    private LatLng StringToLatLang(String point){
        String [] strMas=point.split(",");
        if(strMas.length>2){
            return null;
        }
        return new LatLng(Double.valueOf(strMas[0]),Double.valueOf(strMas[1]));
    }
}
