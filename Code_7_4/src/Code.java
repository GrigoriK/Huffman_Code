import java.util.BitSet;
import java.util.HashMap;
import java.util.Scanner;

public class Code {


    private static  String alfab;
	private  BitSet pol;
	public  HashMap<BitSet,BitSet> mapMistake;
	private static Code uniqueCode;
	public  HashMap<Character,BitSet> codeM;
	public static  Code getInstance(){
		if(uniqueCode== null){
         
			uniqueCode= new Code();
		}
		return uniqueCode;
	}

	private Code(){
		pol=Codek.fromString("1011");
		alfa_bet();
		mapMistake=Devision();
		codeM=tableCode();

	}
	public  BitSet getpol(){
		return pol;
	}


/*–î–∞–Ω–Ω–æ–µ –æ–±—ä–µ–≤–ª–µ–Ω–∏–µ —ç–∫–∑–µ–º–ø–ª—è—Ä–∞ –∫–ª–∞—Å—Å–∞ –≤ —Å–ª—É—á–∞–µ
–≤—ã–±–æ—Ä–∞ –Ω–µ —Å—Ç–∞–Ω–¥–∞—Ä—Ç–Ω–æ–≥–æ –ø–æ–ª–∏–Ω–æ–º–∞*/
	public static Code getInstance(String st){
		if(uniqueCode== null){

			uniqueCode= new Code(st);
		}
		return uniqueCode;
	}
	private Code(String st){
		pol=Codek.fromString(st);
		mapMistake=Devision();
		alfa_bet();
		codeM=tableCode();
	}


	//—Ç–∞–±–ª–∏—Ü–∞ –æ—à–∏–±–æ–∫
	private  HashMap<BitSet,BitSet> Devision(){
		HashMap<BitSet,BitSet> map=new HashMap<BitSet,BitSet>();
		String strok="";
		String st="";

		for(int i=0;i<7;i++){
			st=Integer.toBinaryString(((int)Math.pow(2, i)));
			strok =Codek.dev(st,pol);
			map.put(Codek.fromString(strok),Codek.fromString(st));

		}
		return map ;
	}


	//–§–æ—Ä–º–∏—Ä–æ–≤–∞–Ω–∏–µ —Ç–∞–±–ª–∏—Ü—ã —Ä–∞–∑—Ä–µ—à—ë–Ω–Ω—ã—Ö –∫–æ–º–±–∏–Ω–∞—Ü–∏–π –¥–ª—è —Ç–∞–±–ª–∏—Ü—ã –±—É–∫–≤
	public  HashMap<Character,BitSet> tableCode(){
		HashMap<Character,BitSet> charMap =new HashMap<Character,BitSet>();
		String [] line=Codek.Read(alfab).split("\n");
		for(int i=0;i<line.length;i++){

			String st=Integer.toBinaryString(i);

			charMap.put(line[i].charAt(0),Codek.fromString(st+Codek.dev(st+Codek.NulZero(3),pol)));


		}
		return charMap;


	}


private void alfa_bet() {
	Scanner sc= new Scanner(System.in);
    System.out.println("œÓ„‡ÏÏ‡ ÔÓ‰‰ÂÊË‚‡ÂÚ ÍÓ‰ËÓ‚‡ÌËÂ Î‡ÚËÌÒÍËı Ë ÛÒÒÍËı ÒËÏ‚ÓÎÓ‚.");
     String line;
    while(true){
    	System.out.println("¬˚·ÂËÚÂ ˇÁ˚Í Ì‡ ÍÓÚÓÓÏ ·Û‰ÂÚ ÔÓËÒıÓ‰ËÚ¸ ÍÓ‰ËÓ‚‡ÌËÂ (en/ru)");
    	   line=sc.nextLine();
    	   System.out.println(line);
        if(line.equals("en")){
        
       	 alfab= "src/res/alfa23.txt";
       	break;
        }
        else if (line.equals("ru")){
       	 alfab= "src/res/alfa2.txt";
       	 break;
        }
        System.out.println("ÕÂÍÓÂÍÚÌ˚È ‚‚Ó‰");
        
    }
	
}
	public  String DCode(String st){
		char[] a=st.toCharArray();
		st="";
		for(int i=0;i<a.length;i++){
			st=st+Codek.SevenBit((Codek.toString(codeM.get(a[i]))));
		}
		return st;

	}
}


