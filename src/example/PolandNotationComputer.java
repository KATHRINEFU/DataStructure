package example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2021-12-12 21:39
 * @description:
 * thought:
 * 1) put expression into an arraylist
 * 2) put arraylist in a function, which scan the list and calculate using stack
 */
public class PolandNotationComputer {
    public static void main(String[] args) {
        String suffixExpr = "30 4 + 5 * 6 -";
        List<String> rpnList = getListString(suffixExpr);
        int res = calculate(rpnList);
        System.out.println("the result is: "+res);
    }

    public static List<String> getListString(String expr){
        String[] split = expr.split(" ");
        List<String> list = new ArrayList<>();
        for(String s:split){
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        java.util.Stack<String> stack = new java.util.Stack();
        for(String item:ls){
            if(item.matches("\\d+")){
                stack.push(item);
            }else{
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res=0;
                if(item.equals("+")){
                    res = num1+num2;
                }else if(item.equals("-")){
                    res = num1-num2;
                }else if(item.equals("*")){
                    res = num1*num2;
                }else if(item.equals("/")){
                    res = num1/num2;
                }else{
                    throw new RuntimeException("invalid operation!");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
