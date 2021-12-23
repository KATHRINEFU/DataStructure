package shangguigu.tree;

/**
 * @author: Kate Fu
 * @create: 2021-12-20 19:49
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder(0);
    }
}

class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }
    public void preOrder(int index){
        if(arr.length==0 || arr==null){
            System.out.println("The array is empty!");
        }
        System.out.println(arr[index]);
        if(index*2+1<arr.length){
            preOrder(2*index+1);
        }
        if(index*2+2<arr.length){
            preOrder(2*index+2);
        }
    }
}


