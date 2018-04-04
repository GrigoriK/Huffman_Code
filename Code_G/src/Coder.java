import java.util.Scanner;

public class Coder {

	static Code code;
	public static void main(String [] args){
		Vvod();
	
	
	
}
		
	private static void Vvod(){
		

                System.out.println("Здравствуйте!");
               run(1);
                System.out.println("Вас приветствует программа для "
                 + "кодирования информации кодом (7,4)");
                 run(2);
                 Scanner sc= new Scanner(System.in);
                                    
                System.out.println("По умолчанию выставлен полином 1011");
                 run(1);
                 System.out.println("Хотите изменить?(да//нет)");
                  if(sc.nextLine().toLowerCase().equals("да")){
                
                 code=Code.getInstance(Prov());

                 }
                 else{
                 code=Code.getInstance();
                 }
                 

                 System.out.println("Ниже приведена таблица из 16 букв"
                 + ",с помощью которых вы можете закодировать некоторое сообщение");
                 run(2);
                 System.out.println("Таблица кодов:");
                 for(Character c: code.codeM.keySet()){

                 System.out.println(c+":"+Codek.SevenBit(Codek.toString(code.codeM.get(c))));

                 }
                 String stroc="";
                 do{
                 System.out.println("Введите сообщение:");
                 stroc=stroc+sc.nextLine();
                 System.out.println("Хотите добавить символы?(да\\нет)");

                 }
                 while(!sc.nextLine().toLowerCase().equals("нет"));
                 System.out.println("Кодирование...");
                 run(3);
		
		System.out.println(code.DCode(stroc)+"-Закодированная строка");
		String chanel1= "src/res/code.txt";
		Codek.WriteFile(chanel1, code.DCode(stroc.toLowerCase()));
		 System.out.println("Передача по каналу...");
	        run(3);
	        
		new Chanel(chanel1);
		 run(2);
		 System.out.println("Строка пришла на декодер");
	        run(1);
	        System.out.println("Хьюстон,он нас проблемы.Ошибки...");
	        run(2);
		String DecodeFile="src/res/Decode.txt";
		System.out.println("Декодер исправил ошибки.");
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
			System.out.println("Введите полином");
					st=sc.nextLine();
			if(st.length()==4){
				try {
				int a=Integer.parseInt(st);
				break;
					
				}
				catch(Exception e){
					System.out.println("Ошибка ввода");
					
					
				}
			}
			
			
			
		}
		
		return st;
		
	}
	
	
}

