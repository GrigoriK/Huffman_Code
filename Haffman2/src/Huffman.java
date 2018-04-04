import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Huffman {
	static ArrayList<String> list1=new ArrayList<>(); 
	static HashMap<String,Integer> map1=new HashMap<>();
	static String code="";
static int k=0;
	
	
	public static void main(String [] args){
		ArrayList<Point> list = new ArrayList<>();
	Point a= new Point(6);
	list.add(a);
	Point b= new Point(4);
	list.add(b);
	Point c= new Point(3);
	list.add(c);
	
	Point d= new Point(2);
	list.add(d);
	Point e= new Point(1);
	list.add(e);
	Point f= new Point(d,e);
	list.add(f);
	Point g= new Point(c,f);
	list.add(g);
	Point h = new Point(g,b);
	list.add(h);
	Point h2 = new Point(h,a);
	list.add(h2);
	//for(int i=0;i<list.size();i++){
	//	System.out.println(list.get(i).a+":"+list.get(i).getRL());
	//}
	
	
	//Point l=G;
	String st="";
	String[] stroc = new String [4];
	int i=0;
	//System.out.println(Huffman.CodeS("Helllow+2"));
	Huffman.createMap("Кисляков Григорий Дмитриевич");
	//Huffman.makeMap(list.get(list.size()-1));
	
	
	//System.out.println(k);
	}
	public static void makeMap(Point root){
		
		if(root.getDown()!=null){
			System.out.println("left");	
			code=code+"0";
			k++;
			//root.getDown().SetCode(code);
			makeMap(root.getDown());
		}
       if(root.getUp()!=null){
    	   System.out.println("right");
    	   
    	   System.out.println(code);
    	   	 //root.getUp().SetCode("1");
    	   code=code+"1";
    	   makeMap(root.getUp());
		}
       if(root.getUp()==null&&root.getDown()==null)      
       root.SetCode(Integer.toString(k)); 
       k++;
      // if(code.length()!=1){
       //code=code.substring(0,code.length()-1);
       }
      	   

	
	public static void BuildTable(Point G){
		String st="";
		Point l=G;
		
		String[] stroc = new String [4];
		if(l.getDown()!=null){
			st=st+"0";
			l=l.getDown();
			Huffman.BuildTable(l);
		}
		if(l.getUp()!=null){
			st=st+"1";
			l=l.getUp();
			Huffman.BuildTable(l);
		}
		if(l.getUp()!=null){
			st=st+"1";
			Huffman.BuildTable(l.getUp());
		}
		list1.add(st);
		st=st.substring(0,st.length()-1);
		System.out.println(st);
	
	}
	public  static Boolean mapP (String mean,HashMap<String,Integer> map1){
		int t= map1.size();
		if(t!=0){
		for(String st:map1.keySet()){
			if(st.equals(mean)){
				return true;
			
			}
		}
		}
		
		
		return false;
	}
	public static void CodeS(int k){
		code=Integer.toString(k);
		
	}
	//Подсчёт кол-ва букв в строке
	public static void createMap(String st2){
		String [] st1 = st2.toLowerCase().split("");		
		System.out.println(st1.length);
		
		for(int i=0;i<st1.length;i++){
			if(!Huffman.mapP(st1[i],map1)){
				map1.put(st1[i], 1);
			}
			else{
				int k=map1.get(st1[i]);
				map1.replace(st1[i], ++k);
			}
		}
		for(String stroc:map1.keySet()){
			System.out.println(stroc+":"+map1.get(stroc));
		}
	}
}
