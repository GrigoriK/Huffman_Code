import java.io.*;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Grishany on 21.05.2017.
 */
public class Coding {
    //Сoding
    //Код Хаффмана
    public static String HufCode(String st,HashMap<String,String> Coded){
        String [] mas=st.split("");
        st="";
        for(int i=0;i<mas.length;i++){
            for(String stroc:Coded.keySet()){
                if(stroc.equals(mas[i])){
                    st=st+Coded.get(stroc);
                }
            }
        }
        return st;

    }
     static void Delete( String path,String stroc) {
        try {
            FileWriter fstream1 = new FileWriter(path);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(stroc); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
        } catch (Exception e)
        {System.err.println("Error in file cleaning: " + e.getMessage());
        }

    }
    public static void Write(HashMap<String,String> Coded,String writeF,String readF) {
        File fileW = new File(writeF);
        File file = new File(readF);
        FileWriter frW = null;
        FileReader frR=null;
        BufferedWriter br = null;
        try {
            frR = new FileReader(file);
            BufferedReader reader = new BufferedReader(frR);
            Delete(writeF,"Закодированная строка");
            frW = new FileWriter(fileW,true);
            br = new BufferedWriter(frW);
            String line = reader.readLine();
            while (line != null) {

                br.newLine();
                br.write(HufCode(line,Coded));
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
    //Вывод кодов
    public static void printCodes(HuffmanTree tree, String writeF,StringBuffer prefix,HashMap<String,String> Coded) {
        assert tree != null;
        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            Coded.put(leaf.value, prefix.toString());

            File fileW = new File(writeF);
            FileWriter frW = null;
            BufferedWriter br = null;
            try {

                frW = new FileWriter(fileW,true);
                br = new BufferedWriter(frW);
                    br.newLine();
                    br.write(leaf.value + "\t" + leaf.frequency + "\t" + prefix);

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


        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;


            prefix.append('0');
            printCodes(node.left,writeF, prefix,Coded);
            prefix.deleteCharAt(prefix.length()-1);


            prefix.append('1');
            printCodes(node.right,writeF, prefix,Coded);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }
    //Проверка на совпадения
    public  static Boolean mapP (String mean,HashMap<String,Integer> map1){
        int t= map1.size();
        if(t!=0){
            for(String st:map1.keySet()){
                if(st.equals(mean)){
                    return true;

                }
            }
        }


        return false;
    }
    //строиться дерево Хаффмана
    public static HuffmanTree buildTree(HashMap <String,Integer> map1) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        for(String stroc:map1.keySet())
            trees.offer(new HuffmanLeaf(map1.get(stroc), stroc));

        assert trees.size() > 0:"Error NullSize";

        while (trees.size() > 1) {

            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new HuffmanNode(a, b));

        }
        return trees.poll();
    }
    //Метод для заполнения счетчика символов
    public static void createMap(String st2,HashMap<String,Integer> map1){

        String [] st1 = st2.split("");

        for(int i=0;i<st1.length;i++){
            if(!Coding.mapP(st1[i],map1)){
                map1.put(st1[i], 1);
            }
            else{
                int k=map1.get(st1[i]);
                map1.remove(st1[i]);
                map1.put(st1[i], ++k);
            }
        }

    }

    //Считывание из файла
    public static void Read(HashMap<String,Integer> map1,String ReadF){
        try {
            File file = new File(ReadF);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                Coding.createMap(line, map1);
                line = reader.readLine();

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
