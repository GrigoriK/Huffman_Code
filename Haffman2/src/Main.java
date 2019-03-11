import java.awt.*;

import java.util.HashMap;

public class Main {
	 static HuffmanTree tree;
    private static HashMap<String,Integer> map1=new HashMap<>();
    private static  HashMap<String,String> Coded=new HashMap<>();
    public static void main(String [] args){
                String writeC="D:\\\\Table_Coded.txt";//������� �����(������� ����,���-�� ������� �������)
                String CodeT="D:\\\\file3.txt";//�������������� �����
                String DecodeD= "D:\\file4.txt";//����� ����� �������������
                String book ="D:\\Voina_Mir.txt";//�������� ���������� ���� (��� ������� ���� 1�� ��� ����� � ���
               
                Coding.Read(map1,book);
                tree = Coding.buildTree(map1);
                Coding.Delete(writeC,"SYMBOL   WEIGHT   HUFFMAN CODE" );
                Coding.printCodes(tree,writeC, new StringBuffer() ,Coded);
                Coding.Write(Coded,CodeT,book);
                Coding.Delete(DecodeD,"����� ����� �������������" );
                Decoding.Decode(tree,DecodeD,CodeT);
                        
               

    }
}
