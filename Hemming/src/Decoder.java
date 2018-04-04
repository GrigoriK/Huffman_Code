import java.util.BitSet;

public class Decoder {

	private Code code;


	public Decoder(String filename,String Writename){
		code=Code.getInstance();
		Decode(filename,Writename);




	}


	private void Decode(String filename,String Writename){
		String line=Codek.Read(filename);
		String str="";
		while(!line.equals("")){
			str=str+DecodeStr(CorMistake(line.substring(0,7)));
			line=Codek.subSCode(line);
		}

		System.out.println(str+" -Строка после прохождения декодера");
		Codek.WriteFile(Writename, str);

	}


	private String CorMistake(String st){
		BitSet bit = Codek.fromString(Codek.dev(st,code.getpol()));
		int l;
		for(BitSet set:code.mapMistake.keySet()){
			if(bit.equals(set)){
				l=code.mapMistake.get(set).nextSetBit(0);
				        	return (Vd(st,l));
			}

		}
		return st;
	}

	//Метод для инверсия бита заданного номера k
	private  static String Vd(String st,int k){
		k++;
		char [] ch=st.toCharArray();
		ch[st.length()-k]=(ch[st.length()-k]=='0'?'1':'0');


		return  new String(ch);
	}

	private Character DecodeStr(String st){

		for(Character c:code.codeM.keySet()){
			if(Codek.SevenBit(Codek.toString(code.codeM.get(c))).equals(st)){
				return c;
			}
		}


		return '?';
	}

}
