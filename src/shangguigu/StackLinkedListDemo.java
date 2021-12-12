package shangguigu;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-11 20:35
 */
public class StackLinkedListDemo {
    public static void main(String[] args) {
        StackList test = new StackList();
        String key="";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("show: show stack");
            System.out.println("exit: exit program");
            System.out.println("push: add to stack");
            System.out.println("pop: get from stack");
            System.out.println("input your choice: ");
            key = scanner.next();
            switch (key){
                case "show":
                    test.show();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("input your value");
                    int value = scanner.nextInt();
                    StackNode n1 = new StackNode(value);
                    test.push(n1);
                    break;
                case "pop":
                    StackNode n2 = test.pop();
                    System.out.println(n2);
                    break;
            }
        }
    }
}

class StackList{
    StackNode head = new StackNode(0);

    public void push(StackNode node){
        StackNode temp = head;
        while (temp.next!=null){
            temp= temp.next;
        }
        temp.next = node;
        temp = temp.next;
    }

    public StackNode pop(){
        StackNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return  temp;
    }

    public void show(){
        if(head.next==null){
            System.out.println("The stack is empty");
        }
        StackNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
            System.out.println(temp);
        }
    }
}

class StackNode{
    public int no;
    public StackNode next;

    public StackNode(int no){
        this.no =  no;
    }

    @Override
    public String toString() {
        return "StackNode{" + "no=" + no +'}';
    }
}
