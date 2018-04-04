import java.io.*;

/**
 * Created by Grishany on 21.05.2017.
 */
public class Decoding {

    //Декодирование
    public static String decode(HuffmanTree tree, String encode) {
        assert tree != null;

        String decodeText="";
        HuffmanNode node = (HuffmanNode)tree;
        for (char code : encode.toCharArray()){
            if (code == '0'){
                if (node.left instanceof HuffmanLeaf) {
                    decodeText += ((HuffmanLeaf)node.left).value;
                    node = (HuffmanNode)tree;
                }
                else{
                    node = (HuffmanNode) node.left;
                }
            }else if (code == '1'){
                if (node.right instanceof HuffmanLeaf) {
                    decodeText += ((HuffmanLeaf)node.right).value;
                    node = (HuffmanNode)tree;
                }else{
                    node = (HuffmanNode) node.right;
                }
            }
        }

        return decodeText;
    }


    public static void Decode(HuffmanTree tree,String writeF,String readF) {
        File fileW = new File(writeF);
        File file = new File(readF);
        FileWriter frW = null;
        FileReader frR=null;
        BufferedWriter br = null;
        try {
            frR = new FileReader(file);

            BufferedReader reader = new BufferedReader(frR);
            Coding.Delete(writeF,"Строка после декодера");
            frW = new FileWriter(fileW,true);
            br = new BufferedWriter(frW);
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {

                br.newLine();

                br.write( decode(tree,line));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                br.close();
                frW.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
