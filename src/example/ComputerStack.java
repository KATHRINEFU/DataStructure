package example;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-11 21:49
 * @description:
 * thoughts:
 * number stack + operation stack
 * if operation stack has operations,
 *     compare, if current operation's priority <= existed operation, calculate with 2 numbers
 *     popped from number stack and one operation popped from operation stack. Put the result into
 *     the number stack. If current operation's priority > existed operation, put current
 *     operation into operation stack.
 *
 * after scanning the expression, pop numbers and operations from stack and
 *     calculate. When the number stack has only one number, the number is the result.
 * @limitation:
 * only + - * /
 * infix expression
 */
public class ComputerStack {
    public static void main(String[] args) {
        char[] priority = {'+','-','*','/'};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input your expression:");
        String expr = scanner.nextLine();

        Stack numStack = new Stack(10);
        Stack opeStack = new Stack(10);

        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res=0;
        char ch=' ';
        String keepNum=""; //stitch multiple digits
        for(int i=0; i<expr.length(); i++){
            ch = expr.charAt(i);
            if(opeStack.isOper(ch)){
                if(opeStack.isEmpty()){
                    opeStack.push(ch);
                }else{
                    if(opeStack.priority(ch)<=opeStack.priority(opeStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = opeStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        opeStack.push(ch);
                    }else{
                        opeStack.push(ch);
                    }
                }
            }else{
                //numStack.push(ch-'0'); only single digit number
                //when adding numbers, check next char after index
                //define a String var to stitch
                keepNum+=ch;
                if(i==expr.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (opeStack.isOper(expr.charAt(i + 1))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            
        }
        while(true){
            //if operation stack is empty, get the final result
            if(opeStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = opeStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("The expression %s = %d",expr,res);
    }
}

class Stack{
    private int maxSize;
    private int[] stack;
    private int top=-1;

    public Stack(int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public int peek(){
        return stack[top];
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

    //return operation's priority, high number represents higher priority
    //determined by programmers
    public int priority(int oper){
        if(oper == '*'||oper=='/'){
            return 1;
        }else if(oper=='+' || oper=='-'){
            return 0;
        }else{
            return -1;
        }
    }

    //verify operation
    public boolean isOper(char val){
        return val=='+' || val=='-' || val=='*' || val=='/';
    }

    public int cal(int num1, int num2, int oper){
        int res=0;
        switch (oper){
            case '+':
                res = num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
        }
        return res;
    }
}
