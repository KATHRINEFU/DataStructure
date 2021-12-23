package shangguigu.tree;

/**
 * @author: Kate Fu
 * @create: 2021-12-21 21:22
 */
public class AVLDemo {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        int[] arr = {4,3,6,5,7,8};
        for(int i=0; i<arr.length; i++){
            tree.add(new Node(arr[i]));
        }
        System.out.println("infix of the tree");
        tree.infixOrder();

        System.out.println("before rotate");
        System.out.println("the height of tree: "+tree.getRoot().height());//4
        System.out.println("the height of left subtree: "+tree.getRoot().leftHeight());//1
        System.out.println("the height of right subtree: "+tree.getRoot().leftHeight());//3
    }
}

class AVLTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return null;//root.search(value);
        }
    }
    public Node searchParent(int value){
        if (root == null) {
            return null;
        }else {
            return null;// root.searchParent(value);
        }
    }

    public void add(Node node){
        if (root == null) {
            root=node;
        }else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (this.root != null) this.root.infixOrder();
        else System.out.println("The tree is empty");
    }

    public void delNode(int value) {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }

        Node targetNode = search(value);
        if(targetNode==null){
            System.out.println("No such value");
            return;
        }
        //if the tree has only one node
        if(root.left==null && root.right==null){
            root=null;
            return;
        }
        Node parent = searchParent(value);
        //if the target node is a leaf
        if(targetNode.left==null && targetNode.right==null){
            //check target node is the parent node's left or right son
            if(parent.left!=null && parent.left.value==value){
                parent.left=null;
            }else if(parent.right!=null && parent.right.value==value){
                parent.right=null;
            }
        }else if(targetNode.left!=null && targetNode.right!=null){ //if the target node has two subtrees
            int minVal = delRightTreeMin(targetNode.right);
            targetNode.value=minVal;
        }else{//if the target node has one subtrees
            if(targetNode.left!=null){
                if(parent!=null){
                    if(parent.left.value==value){
                        parent.left=targetNode.left;
                    }else{
                        parent.right=targetNode.left;
                    }
                }else{
                    root = targetNode.left;
                }
            }else{
                if(parent!=null){
                    if(parent.left.value==value){
                        parent.left=targetNode.right;
                    }else{
                        parent.right=targetNode.right;
                    }
                }else{
                    root = targetNode.right;
                }
            }
        }
  }

    private int delRightTreeMin(Node node) {
        Node target = node;
        while(target.left!=null){
            target = target.left;
        }
        delNode(target.value);
        return target.value;
    }
}


class Node {
    int value;
    Node left;
    Node right;
    public Node(int value){
        this.value = value;
    }

    //return the height of current node
    public int height(){
        return Math.max(left==null? 0: left.height(), right==null ? 0: right.height())+1;
    }

    //return the height of left subtree
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }

    //return the height of right subtree
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }

//    public Node search(int value) {
//    }
//
//    public Node searchParent(int value) {
//    }

    public void infixOrder() {
    }

    public Node add(Node node) {
        return node;
    }
}
