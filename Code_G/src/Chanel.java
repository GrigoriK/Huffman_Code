import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Chanel {
	private Code codeC;
	public static String line;



	public Chanel(String filename){
		codeC=Code.getInstance();
		Chanel.ChanelWork(filename);
	}

	public static void ChanelWork(String filename){

		String line=Codek.Read(filename);

		String s="";
		while(!line.equals("")){
			s=s+spoil(line.substring(0,7));
			line=Codek.subSCode(line);
		}
		System.out.println(s+"-Строка после канала");
        
        
        
		Codek.WriteFile(filename, s);

	}

	//Метод порчи одного бита 7-битной комбинации.

	public static String spoil(String st){
		Random random= new Random();
		char [] sym =st.toCharArray();
		int t=random.nextInt(st.length());
		sym[t]=(sym[t]=='0'?'1':'0');
		return (new String(sym));

	}


}
