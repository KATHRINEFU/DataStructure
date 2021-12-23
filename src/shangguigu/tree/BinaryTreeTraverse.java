package shangguigu.tree;

/**
 * @author: Kate Fu
 * @create: 2021-12-19 20:17
 */
public class BinaryTreeTraverse {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "peter");
        HeroNode node2 = new HeroNode(2, "kyle");
        HeroNode node3 = new HeroNode(3, "william");
        HeroNode node4 = new HeroNode(4, "kevin");
        HeroNode node5 = new HeroNode(5, "thomas");

        //manually create, later use recursion
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node5);
        node3.setLeft(node4);

        binaryTree.setRoot(node1);
        System.out.println("pre-order");
        binaryTree.preOrder();
        System.out.println("infix-order");
        binaryTree.infixOrder();
        System.out.println("post-order");
        binaryTree.PostOrder();

        System.out.println("***********************");
        HeroNode preOrderSearch = binaryTree.preOrderSearch(5);
        System.out.println(preOrderSearch);
        System.out.println("***********************");
        HeroNode infixOrderSearch = binaryTree.infixOrderSearch(5);
        System.out.println(infixOrderSearch);
        System.out.println("***********************");
        HeroNode postOrderSearch = binaryTree.postOrderSearch(5);
        System.out.println(postOrderSearch);


    }
}
class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void preOrder(){
        if (this.root != null) this.root.preOrder();
        else System.out.println("The tree is empty");
    }

    public void infixOrder(){
        if (this.root != null) this.root.infixOrder();
        else System.out.println("The tree is empty");
    }

    public void PostOrder(){
        if (this.root != null) this.root.postOrder();
        else System.out.println("The tree is empty");
    }
    public HeroNode preOrderSearch(int no){
        if(root!=null){
            return root.preOrderSearch(no);
        }else{
            return null;
        }
    }
    public HeroNode infixOrderSearch(int no){
        if(root!=null){
            return root.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    public HeroNode postOrderSearch(int no){
        if(root!=null){
            return root.postOrderSearch(no);
        }else{
            return null;
        }
    }

    public void delNode(int no){
        if(root==null){
            System.out.println("The tree is empty");
            return;
        }
        if(root.getNo()==no) root=null;
        else root.delNode(no);
    }


}
class  HeroNode{
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name){
        this.no=no;
        this.name=name;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //pre-order traversal
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //infix-order traversal
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    //post-order traversal
    public void postOrder(){
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
        System.out.println(this);
    }

    //pre-order search
    public HeroNode preOrderSearch(int no){
        if(this.no==no){
            return this;
        }
        HeroNode resNode = null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode resNode=null;
        if(this.left!=null){
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.right!=null){
            resNode = this.right.preOrderSearch(no);
        }
        if(resNode!=null){
            return resNode;
        }
        if(this.no==no){
            return this;
        }
        return resNode;
    }

    //recursion for deleting node
    //if the node is a leaf, just delete it
    //if the node is not a leaf, delete the subtree

    public void delNode(int no){
        /*
        as our binary tree is single-directional, we need to check if the sub node of current node needs deleting (not current node!)
        1. if the left subnode is not null, and is the target one, make this.left=null, return
        2. if the right subnode is not null, and is the target one, make this.right=null, return
        3. if (1)(2) do not return, recursion on the left subtree
        4. if (3) do not return, recursion on the right subtree
         */
        if(this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right!=null && this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null)  this.left.delNode(no);
        if(this.right!=null)  this.right.delNode(no);
    }
}
