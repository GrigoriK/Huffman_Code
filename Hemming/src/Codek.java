import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.BitSet;

public class Codek {

	public static String subSCode(String line){

		if(line.length()%7!=0){
			System.out.println("Повторите передачу, \r\n" + "Потеряно"+(7-line.length()%7)+" бит‚");
		}
		else if(line.length()>7){


			line=line.substring(7,line.length());

		}
		else{
			return "";
		}
		return  line;

	}
	public static String  SevenBit(String st){
		if(st.length()<7){
			st=NulZero(7-st.length())+st;
		}
		return st;

	}
	public static  String Read(String file�){
	
		  StringBuilder sb = new StringBuilder();
		String line1="";
		try {
			FileReader fr = new FileReader(file�);
			BufferedReader reader = new BufferedReader(fr);

			while ((line1=reader.readLine()) != null) {
				sb.append(line1);
				sb.append("\n");


			}



			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString().trim();
		
	}


	//Метод необходимый для удаления незначящих нулей
	private static String delZero(String st){
		BitSet setB = fromString(st);
		if(setB.length()!=st.length()){

			st=st.substring(st.length()-setB.length(),st.length());
		}

		return st;

	}
	
	//Находит остаток от деления
	public static String dev(String st,BitSet pol){
		int k=pol.length();
		BitSet bOll=new BitSet();

		while(st.length()!=0){

			st=delZero(st);

			if(st.length()<k){
				st=NulZero(k-1-st.length())+st;
				break;
			}
			if(st.substring(0,k).equals(NulZero(k))){

				st=st.substring(k,st.length());
			}
			else{
				if(st.equals(toString(pol))){
					System.out.println("Поздравляю\n" +"Данное число делиться без остатка\n");
					st="0";
					break;
				}
				bOll=fromString(st.substring(0,k));
				bOll.xor(pol);
				st=toString(bOll)+st.substring(k,st.length());


			}
		}
		return st;
	}

	// Bitset to String
	public static String toString(BitSet bs){
		try{
			return Long.toString(bs.toLongArray()[0],2);

		}
		catch(Exception e){

			return NulZero(3);
		}


	}
	/*Метод,необходимый для формирования строки из всех нулей
Заданной длины.*/
	public static String NulZero(int k){
		String s="";
		for(int i=0;i<k;i++){
			s=s+"0";
		}
		return s;
	}
	
	public static BitSet fromString(String st){
		try{
			return BitSet.valueOf(new long[]{
					Long.parseLong(st,2)}
			);
		}
		catch(NumberFormatException e){
			System.out.println("");
			return  new BitSet();
		}


	}

	
	public static void WriteFile(String fileName,String line){
				File file = new File(fileName);
		
		try {
			
			if(!file.exists()){
				file.createNewFile();
			}

			
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());

			try {
				
				out.print(line);
			} finally {
				
				out.close();
			}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}

	}
}
