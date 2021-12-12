package shangguigu;

/**
 * @author: Kate Fu
 * @create: 2021-12-09 19:25
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //initiate head node
        HeroNode head = new HeroNode(0,"","");
        HeroNode n1 = new HeroNode(1,"宋江","及时雨");
        HeroNode n2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode n3 = new HeroNode(3,"吴用","智多星");
        SingleLinkedList list = new SingleLinkedList();
        list.addByOrder(n1);

        list.addByOrder(n2);
        list.addByOrder(n3);

        list.modifyNode(1,"付宇","及时雨");

        list.deleteNode(2);

        list.showList();
    }
}

class SingleLinkedList{
    //initiate head node
    HeroNode head = new HeroNode(0,"","");

    public void addNode(HeroNode node){
        HeroNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=node;
    }

    public void showList(){
        if(head.next==null){
            System.out.println("The list is empty");
            return;
        }
        HeroNode temp = head.next;
        while(temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
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

    public void modifyNode(int no, String name, String nickname){
        HeroNode temp = head;
        while(temp.next!=null){
            if(temp.no == no){
                temp.name= name;
                temp.nickname = nickname;
            }
            temp = temp.next;
        }
    }

    public void deleteNode(int no){
        HeroNode temp = head;
        boolean isDelete = false;
        while(temp.next!=null){
            if(temp.no==no){
                isDelete=true;
                break;
            }
            temp = temp.next;
        }
        if(!isDelete){
            System.out.println("The no does not exist");
        }else{
            temp.next = temp.next.next;
        }
    }
}

class HeroNode {
  public int no;
  public String name;
  public String nickname;
  public HeroNode next;

  public HeroNode(int no, String name, String nickname) {
    this.no = no;
    this.name = name;
    this.nickname = nickname;
  }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

}