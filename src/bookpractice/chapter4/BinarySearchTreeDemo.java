package bookpractice.chapter4;

/**
 * @author: Kate Fu
 * @create: 2021-12-20 22:43
 */
public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(8);

        tree.printTree();

    }
}
