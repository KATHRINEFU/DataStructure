package shangguigu.linear;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-11 20:00
 * @description: stack application:
 * 1) binary tree
 * 2) DFS
 * 3) expression conversion
 * 4) recursion
 * 5) sub-program call
 */
public class StackArrayDemo {
    public static void main(String[] args) {
        ArrayStack test = new ArrayStack(10);
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
                    test.showStack();
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
                case "push":
                    System.out.println("input your value");
                    int value = scanner.nextInt();
                    test.push(value);
                    break;
                case "pop":
                    int value1 = test.pop();
                    System.out.printf("data out of stack is %d \n", value1);
                    break;
            }
        }
    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int value){
        if(isFull()){
            System.out.println("The stack is empty");
            return;
        }
        top++;
        stack[top]=value;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return 0;
        }
        return stack[top--];
    }

    public void showStack(){
        if(isEmpty()){
            System.out.println("The stack is empty");
            return;
        }
        for(int i=top; i>=0; i--){
            System.out.print(stack[i]+" ");
        }
    }
}
