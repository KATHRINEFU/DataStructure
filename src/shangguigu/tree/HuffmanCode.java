package shangguigu.tree;

import java.util.*;

/**
 * @author: Kate Fu
 * @create: 2021-12-24 22:25
 *
 * @description: convert a String into bytes, into Huffman code
 */
public class HuffmanCode {
    public static void main(String[] args) {
        String str = "i like like like java do you like a java";
        byte[] bytes = str.getBytes();
        List<HCNode> nodes = getNodes(bytes);
    // System.out.println("node="+nodes);
    System.out.println("huffman tree: ");
    HCNode root = createHuffmanTree(nodes);
    root.preOrder();
    }

    private static List<HCNode> getNodes(byte[] bytes){
        List<HCNode> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        for(byte b: bytes){
            Integer count = counts.get(b);
            if(count==null){
                //map does not have this data
                counts.put(b, 1);
            }else{
                counts.put(b, count+1);
            }
        }
        for(Map.Entry<Byte, Integer> entry: counts.entrySet()){
            nodes.add(new HCNode(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static HCNode createHuffmanTree(List<HCNode> nodes){
        while(nodes.size()>1){
            Collections.sort(nodes);
            HCNode left = nodes.get(0);
            HCNode right = nodes.get(1);
            //create a new huffman tree, the root node has no data, but a weight
            HCNode parent = new HCNode(null ,left.weight+right.weight);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
class HCNode implements Comparable<HCNode>{
    Byte data;
    int weight;
    HCNode left;
    HCNode right;

    public HCNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }


    @Override
    public int compareTo(HCNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HCNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
}