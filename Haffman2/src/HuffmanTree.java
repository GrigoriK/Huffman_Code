public class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frequency;
    public int entropia;
    public HuffmanTree(int freq) { frequency = freq; }
    public void Entropia (int ent) {entropia = ent; }
    
    public int compareTo(HuffmanTree tree) {
        return frequency - tree.frequency;
    }
}
 
class HuffmanLeaf extends HuffmanTree {
    public final String value; 
 
    public HuffmanLeaf(int freq, String val) {
        super(freq);
        value = val;
    }
}
 
class HuffmanNode extends HuffmanTree {
    public final HuffmanTree left, right; 
 
    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }
}
