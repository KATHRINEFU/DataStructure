package example;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-11 9:49
 */
public class JosephuProblem {
    public static void main(String[] args) {
        ChildList list = new ChildList();
        list.addNode(5);
        list.showList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("start from No ?");
        int k = scanner.nextInt();
        if (k <= 0 || k > 5)
            System.out.println("invalid No");
        System.out.println("calling number ?");
        int m = scanner.nextInt();
        if (m <= 0)
            System.out.println("invalid calling number");
        list.josephuProcess(k,m);
    }
}

//circled single direction linked list
class ChildList{
    private ChildNode first = new ChildNode(0);
    public void addNode(int num){
        //verify num
        if(num<1){
            System.out.println("invalid number");
            return;
        }
        //create list
        ChildNode temp=null;
        for(int i=1; i<=num; i++){
            ChildNode n1 = new ChildNode(i);
            if(i==1){
                first=n1;
                first.setNext(first);
                temp=first;
            }else{
                n1.setNext(first);
                temp.setNext(n1);
                temp=n1;
            }
        }
    }

    public void showList(){
        if(first==null){
            System.out.println("The list is empty!");
            return;
        }
        ChildNode temp=first;
        while(true){
            System.out.printf("The No of the child: %d \n",temp.getNo());
            if(temp.getNext()==first){
                break;
            }
            temp = temp.getNext();
        }
    }

    public void josephuProcess(int k, int m){
        if(first==null){
            System.out.println("The list is empty!");
            return;
        }

        ChildNode temp = first;
        while(true){
            if(temp.getNext()==first){
                break;
            }
            temp = temp.getNext();
        }
        for(int i=0; i<k-1; i++){
            temp = temp.getNext();
            first = first.getNext();
        }

        while (true){
            if(temp== first){
                break;
            }
            for(int j=0; j<m-1; j++){
                temp = temp.getNext();
                first = first.getNext();
            }
            System.out.printf("Child %d out\n",first.getNo());
            first=first.getNext();
            temp.setNext(first);
        }
        System.out.printf("The last child No is: %d \n",first.getNo());
    }
}
class ChildNode{
    private int no;
    private ChildNode next;

    public ChildNode(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public ChildNode getNext() {
        return next;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setNext(ChildNode next) {
        this.next = next;
    }
}