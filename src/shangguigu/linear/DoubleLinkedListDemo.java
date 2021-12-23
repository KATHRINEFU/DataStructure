package shangguigu.linear;

/**
 * @author: Kate Fu
 * @create: 2021-12-10 19:10
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Node n1 = new Node(1,"gydus");
        Node n2 = new Node(2,"cdgywui");
        Node n3 = new Node(3,"cdhusiuio");

        list.addNode(n1);
        list.addNode(n2);
        list.addNode(n3);

        list.modifyNode(1,"iqqcdfe");

        list.deleteNode(2);

        list.showList();

    }
}
class DoubleLinkedList{
    //initiate head node
    Node head = new Node(0,"");

    public Node getHead(){
        return head;
    }
    public void addNode(Node node){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=node;
        node.pre=temp;
    }

    public void showList(){
        if(head.next==null){
            System.out.println("The list is empty");
            return;
        }
        Node temp = head.next;
        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void addByOrder(Node node){
        Node temp = head;
        boolean isAdd = true;
        while(temp.next!=null){
            if (node.no == temp.next.no){
                isAdd=false;
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }

        if(!isAdd){
            System.out.println("no has existed");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    public void modifyNode(int no, String name){
        Node temp = head;
        while(temp.next!=null){
            if(temp.no == no){
                temp.name= name;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(int no){
        if(head.next==null){
            System.out.println("The list is empty!");
            return;
        }
        Node temp = head;
        boolean isDelete = false;
        while(temp.next!=null){
            if(temp.no==no){
                isDelete=true;
                break;
            }
            temp = temp.next;
        }
        if(!isDelete){
            System.out.println("the no does not exist");
        }else{
            temp.pre.next = temp.next;
            if(temp.next!=null)
                temp.next.pre = temp.pre;
        }

    }
}

class Node {
    public int no;
    public String name;
    public Node next;
    public Node pre;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{"
        + "no="
        + no
        + ", name='"
        + name
        + '\''
        + '}';
    }
}


