import java.util.Scanner;

public class Coder {

	static Code code;
	public static void main(String [] args){
		Vvod();
	
	
	
}
		
	private static void Vvod(){
		

                System.out.println("������������!");
               run(1);
                System.out.println("��� ������������ ��������� ��� "
                 + "����������� ���������� ����� (7,4)");
                 run(2);
                 Scanner sc= new Scanner(System.in);
                                    
                System.out.println("�� ��������� ��������� ������� 1011");
                 run(1);
                 System.out.println("������ ��������?(��//���)");
                  if(sc.nextLine().toLowerCase().equals("��")){
                
                 code=Code.getInstance(Prov());

                 }
                 else{
                 code=Code.getInstance();
                 }
                 

                 System.out.println("���� ��������� ������� �� 16 ����"
                 + ",� ������� ������� �� ������ ������������ ��������� ���������");
                 run(2);
                 System.out.println("������� �����:");
                 for(Character c: code.codeM.keySet()){

                 System.out.println(c+":"+Codek.SevenBit(Codek.toString(code.codeM.get(c))));

                 }
                 String stroc="";
                 do{
                 System.out.println("������� ���������:");
                 stroc=stroc+sc.nextLine();
                 System.out.println("������ �������� �������?(��\\���)");

                 }
                 while(!sc.nextLine().toLowerCase().equals("���"));
                 System.out.println("�����������...");
                 run(3);
		
		System.out.println(code.DCode(stroc)+"-�������������� ������");
		String chanel1= "src/res/code.txt";
		Codek.WriteFile(chanel1, code.DCode(stroc.toLowerCase()));
		 System.out.println("�������� �� ������...");
	        run(3);
	        
		new Chanel(chanel1);
		 run(2);
		 System.out.println("������ ������ �� �������");
	        run(1);
	        System.out.println("�������,�� ��� ��������.������...");
	        run(2);
		String DecodeFile="src/res/Decode.txt";
		System.out.println("������� �������� ������.");
        run(2);
		new Decoder(chanel1,DecodeFile);
		
		
	}
	private static void run( int i) {
		
		i = i * 1000;
		try {

			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static String Prov(){
		Scanner sc= new Scanner(System.in);
		String st="";
		while(true){
			System.out.println("������� �������");
					st=sc.nextLine();
			if(st.length()==4){
				try {
				int a=Integer.parseInt(st);
				break;
					
				}
				catch(Exception e){
					System.out.println("������ �����");
					
					
				}
			}
			
			
			
		}
		
		return st;
		
	}
	
	
}

