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
        byte[] res = huffmanZip(bytes);
        System.out.println("the convert result is:"+Arrays.toString(res));
//        List<HCNode> nodes = getNodes(bytes);
//    // System.out.println("node="+nodes);
//        System.out.println("huffman tree: ");
//        HCNode root = createHuffmanTree(nodes);
//        root.preOrder();
//
//        //test huffman code generation
//        Map<Byte, String> HuffmanCodes = getCodes(root);
//        System.out.println("Huffman code Map");
//        System.out.println(huffmanCodes);
//
//        //test conversion
//        byte[] huffmanCodesBytes = zip(bytes, huffmanCodes);
//        System.out.println("huffman codes bytes"+Arrays.toString(huffmanCodesBytes));

//        byte[] sourceByte = decode(huffmanCodes, huffmanCodeBytes);
    }

    //decode

    /**
     *
     * @param huffmanCodes map
     * @param huffmanBytes compressed array
     * @return decoded array
     */
    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<huffmanBytes.length; i++){
            //decide whether last byte
            boolean flag = (i==huffmanBytes.length-1);
            builder.append(byteToBitString(!flag, huffmanBytes[i]));
        }
        
        Map<String, Byte> map = new HashMap<String, Byte>();
        for(Map.Entry<Byte, String> entry : huffmanCodes.entrySet()){
            map.put(entry.getValue(), entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for(int i=0; i<builder.length(); ){
            int count=1;
            boolean flag=true;
            Byte b = null;

            while(flag){
                //递增的取出key
                String key  = builder.substring(i, i+count);
                b = map.get(key);
                if(b==null){
                    count++;
                }else{
                    flag = false;
                }
            }

            list.add(b);
            i+=count;
        }

        //put list data into byte[]
        byte[] b = new byte[list.size()];
        for(int i=0; i<b.length; i++){
            b[i]=list.get(i);
        }
        return b;
    }
    /**
     * convert a byte into a bi string
     * @param b
     * @param flag 是否需要补高位
     * @return
     */
    private static String byteToBitString(boolean flag, byte b){
        int temp = b;//convert byte to int, integer has binary
        // if temp>0 需要补高位
        if (flag) {
            temp |= 256; // 按位或256 1 0000 0000
        }
        String str = Integer.toBinaryString(temp); //返回temp对应的二进制补码
        if(flag){
            return str.substring(str.length()-8);//get last 8 elements
        }else{
            return str;
        }
    }
    //use one method to capsulate all methods
    private static byte[] huffmanZip(byte[] bytes){
        List<HCNode> nodes= getNodes(bytes);
        HCNode huffmanTreeRoot = createHuffmanTree(nodes);
        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }
    //compress byte[]

    /**
     *
     * @param bytes original string -> bytes[]
     * @param huffmanCodes map
     * @return compressed byte[]
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes){
        //1 generate 01 string
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes){
            builder.append(huffmanCodes.get(b));
        }
        //2 convert 01 string to byte[]
        int len;
        if(builder.length()%8==0){
            len = builder.length()/8;
        }else{
            len = builder.length()/8+1;
        }
        byte[] huffmanCodesBytes = new byte[len];
        int index=0; //record number in byte[]
        for(int i=0; i<builder.length(); i+=8){ //every 8 digit -> a byte
            String strByte;
            if(i+8>builder.length()){
                strByte = builder.substring(i);
            }else{
                strByte = builder.substring(i, i+8);
            }
            //convert strByte to a byte[]
            huffmanCodesBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodesBytes;
    }

    //generate huffman code corresponding to the huffman tree
    //thoughts: store code in a Map<byte, string>
    //before generating, stitch path of every leaf node use String Builder
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    //overload
    private static Map<Byte, String> getCodes(HCNode root){
        if(root==null) return null;
        getCodes(root.left, "0", stringBuilder);
        getCodes(root.right,"1", stringBuilder);
        return huffmanCodes;
    }
    /**
     * @function convert a node's all children into a huffman code, put into huffmanCodes
     * @param node passing root node
     * @param code path: left child(0), right child(1)
     * @param builder stitch path
     */
    private static void getCodes(HCNode node, String code, StringBuilder builder){
        StringBuilder builder2 = new StringBuilder(builder);
        builder2.append(code);
        if(node!=null){
            //decide current is a leaf node or not
            if(node.data == null){ //non leaf node
                //recursion
                //leftward
                getCodes(node.left, "0", builder2);
                //rightward
                getCodes(node.right, "1", builder2);
            }else{//leaf node
                //found one
                huffmanCodes.put(node.data, builder2.toString());
            }
        }
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