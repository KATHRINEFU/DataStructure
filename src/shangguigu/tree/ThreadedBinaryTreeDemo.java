
package shangguigu.tree;

/**
 * @author: Kate Fu
 * @create: 2021-12-20 20:34
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedHeroNode n1 = new ThreadedHeroNode(1, "tom");
        ThreadedHeroNode n2 = new ThreadedHeroNode(3, "sarah");
        ThreadedHeroNode n3 = new ThreadedHeroNode(6, "sophia");
        ThreadedHeroNode n4 = new ThreadedHeroNode(8, "anna");
        ThreadedHeroNode n5 = new ThreadedHeroNode(10, "blair");
        ThreadedHeroNode n6 = new ThreadedHeroNode(14, "Ivy");

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);

        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        tree.setRoot(n1);
        tree.threadedNodes();

        System.out.println("No10's node's left node:");
        System.out.println(n5.getLeft());//3
        System.out.println("No10's node's right node:");
        System.out.println(n5.getRight());//1

        System.out.println("**********************");
        //after threading the binary tree, the original traverse method fails to run
        //tree.infixOrder();
        tree.threadedInfixOrder();
    }
}

class ThreadedBinaryTree extends BinaryTree{
    //create a HeroNode reference pointing to the previous node of current node
    private ThreadedHeroNode pre = null;
    private ThreadedHeroNode root = null;
    public void threadedNodes(){
        this.threadedNodes(root);
    }
    //threaded the tree in infix order
    public void threadedNodes(ThreadedHeroNode node){
        if(node==null){
            return;
        }
        threadedNodes(node.getLeft());
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        threadedNodes( node.getRight());

    }

    //traverse the threaded binary tree using infix-order
    public void threadedInfixOrder(){
        ThreadedHeroNode node = root;
        while(node!=null){
            //loop to find a node which leftType==1
            //find the first node of infix threaded tree
            while(node.getLeftType()==0){
                node = node.getLeft();
            }
            //print this first node
            System.out.println(node);
            //if current node's right pointer is pointing to the next node of threaded tree
            while(node.getRightType()==1){
                //get this next node
                node = node.getRight();
                //print
                System.out.println(node);
            }
            //when current node's right pointer is pointing to a subtree
            //do not print, just move to its right node
            node = node.getRight();
        }
    }
    public void setRoot(ThreadedHeroNode root) {
        this.root = root;
    }


}

class ThreadedHeroNode extends HeroNode{
    private ThreadedHeroNode left;
    private ThreadedHeroNode right;

    public ThreadedHeroNode(int no, String name) {
        super(no, name);
    }
    //for threaded binary tree use,
    //if leftType==0, point to the left subtree, 1: previous node
    //if rightType==0, point to the right subtree, 1: next node
    private int leftType;
    private int rightType;

    @Override
    public ThreadedHeroNode getLeft() {
        return left;
    }

    @Override
    public ThreadedHeroNode getRight() {
        return right;
    }

    public int getLeftType() {
        return leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setLeft(ThreadedHeroNode left) {
        this.left = left;
    }

    public void setRight(ThreadedHeroNode right) {
        this.right = right;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }


}