import java.awt.*;

import java.util.HashMap;

public class Main {
	 static HuffmanTree tree;
    private static HashMap<String,Integer> map1=new HashMap<>();
    private static  HashMap<String,String> Coded=new HashMap<>();
    public static void main(String [] args){
                String writeC="D:\\\\Table_Coded.txt";//Таблица кодов(подсчёт веса,кол-во каждого символа)
                String CodeT="D:\\\\file3.txt";//Закодированный текст
                String DecodeD= "D:\\file4.txt";//Текст после декодирования
                String book ="D:\\Voina_Mir.txt";//Исходный кодируемый файл (Для примера взят 1ый том Война и Мир
               
                Coding.Read(map1,book);
                tree = Coding.buildTree(map1);
                Coding.Delete(writeC,"SYMBOL   WEIGHT   HUFFMAN CODE" );
                Coding.printCodes(tree,writeC, new StringBuffer() ,Coded);
                Coding.Write(Coded,CodeT,book);
                Coding.Delete(DecodeD,"текст после декодирования" );
                Decoding.Decode(tree,DecodeD,CodeT);
                        
               

    }
}
