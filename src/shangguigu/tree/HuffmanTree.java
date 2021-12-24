package shangguigu.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2021-12-24 19:21
 */
public class HuffmanTree{
    public static void main(String[] args) {
        int arr[]={13,7,8,3,29,6,1};
        HNode root = createHuffmanTree(arr);
        root.preOrder();

    }
    public void preOrder(HNode root){
        if (root != null) root.preOrder();
        else System.out.println("The tree is empty");
    }
    public static HNode createHuffmanTree(int[] arr){
        List<HNode> nodes = new ArrayList<HNode>();
        for(int i=0; i<arr.length; i++){
            nodes.add(new HNode(arr[i]));
        }
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            HNode left = nodes.get(0);
            HNode right = nodes.get(1);
            HNode parent = new HNode(left.value + right.value);
            parent.left = left;
            parent.right = right;
            nodes.remove(left);
            nodes.remove(right);

            nodes.add(parent);
        }
        return nodes.get(0);
    }
}
class HNode implements Comparable<HNode>{
    int value;
    HNode left;
    HNode right;
    public HNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(HNode o) {
        return this.value -o.value;
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