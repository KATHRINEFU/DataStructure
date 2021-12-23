package bookpractice.chapter4;

/**
 * @author: Kate Fu
 * @create: 2021-12-20 22:03
 */

//if the node type is a reference class, need to implement Comparable interface!
public class BinarySearchTree{
    private BinaryNode root;
    private static class BinaryNode{
        int no;
        BinaryNode left = null;
        BinaryNode right = null;
        BinaryNode(int no){
            this(no, null, null);
        }
        BinaryNode(int no, BinaryNode lt, BinaryNode rt){
            this.no = no;
            left = lt;
            right = rt;
        }
    }
    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root ==null;
    }

    public boolean contains(int x){
        return contains(x, root);
    }

    public int findMin(){
        if(isEmpty()){
            System.out.println("The tree is empty!");
            return 0;
        }
        return findMin(root).no;
    }

    public int findMax(){
        if(isEmpty()){
            System.out.println("The tree is empty!");
            return 0;
        }
        return findMax(root).no;
    }
    public void insert(int x){
        root = insert(x, root);
    }

    public void remove(int x){
        root = remove(x, root);
    }

    public void printTree(){
        if (isEmpty()) System.out.println("The tree is empty!");
        else printTree(root);
    }

    public boolean contains(int x, BinaryNode t){
        if(t==null) return false;
        if(x<t.no) return contains(x, t.left);
        else if(x>t.no) return contains(x, t.right);
        else return true;
    }

    public BinaryNode findMin(BinaryNode t){
        if(t==null) return null;
        else if(t.left==null) return t;
        return findMin(t.left);
    }

    public BinaryNode findMax(BinaryNode t){
        if(t!=null){
            while(t.right!=null){
                t = t.right;
            }
        }
        return t;
    }

    public BinaryNode insert(int x, BinaryNode t){
        if(t==null)
            return new BinaryNode(x, null, null);
        if(x<t.no) t.left = insert(x, t.left);
        else if(x>t.no) t.right = insert(x, t.right);
        else ;
        return t;
    }

    public BinaryNode remove(int x, BinaryNode t){
        if(t==null) return t;
        if(x<t.no) t.left = remove(x, t.left);
        else if(x>t.no) t.right = remove(x, t.right);
        else if(t.left!=null && t.right!=null){//two children
            t.no = findMin(t.right).no;
            t.right = remove(t.no, t.right);
        }
        //if only one child, use t.left to replace t
        //if t is a leaf, just make it null
        else t = (t.left!=null) ? t.left : t.right;

        return t;
    }

    public void printTree(BinaryNode t){
        if(t!=null){
            printTree(t.left);
            System.out.println(t.no);
            printTree(t.right);
        }
    }
}
