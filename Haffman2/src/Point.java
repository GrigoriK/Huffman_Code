
public class Point {
	int a;
	private Point up;
	private Point down;	
	private Point parent;
	private String code="";
	Point(Point up,Point down){
	   this.up=up;
		this.down=down;
		this.a=up.a+down.a;
		setParent();
		
	}
	Point(int a){
		this.a=a;
		
		
	}
	public String getRL(){
		if(up!=null&&down!=null){
		
		return ("up:"+Integer.toString(up.a)+" down:"
		 +Integer.toString(down.a));
	}
		return  ("up:"+null+" down:"
		 +null);
	}
	public Point getUp(){
		
	return this.up;
	}
	public Point getDown(){
		
		return this.down;
	}
	public void SetCode(String code){
		this.code=this.code+code;
		
	}
	public String  GetCode(){
		return this.code;
		
	}
public Point getParent(){
	if(parent!=null){
		
		return this.parent;
	}
	
	else{
		return null;
	}
	}
public void  setParent(){
		
		 this.up.parent=this;
		 this.down.parent=this;
	}

}
