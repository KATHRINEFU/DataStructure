package bookpractice.chapter3;

import java.util.Stack;

/**
 * @author: Kate Fu
 * @create: 2021-12-18 22:02
 * @description: check symbols balance
 */
public class Practice3 {
    public static void main(String[] args) {
        String s = "[cde]{z(/*jois/)hnxj8#*/)";
        boolean isBalance = checkBalance(s);
        System.out.println(isBalance);
    }
    public static boolean checkBalance(String s){
        boolean result=true;
        Stack<String> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            String temp="";
            if((s.charAt(i)=='/' && s.charAt(i+1)=='*')|| (s.charAt(i)=='*'&&s.charAt(i+1)=='/')){
                temp=s.substring(i, i+2);
            }else{
                temp = s.substring(i, i+1);
            }

            if(isRightOper(temp)){
                stack.push(temp);
            }
            if(isLeftOper(temp)){
                if(stack.peek()!= findCorrOper(temp)){
                    result=false;
                }else{
                    stack.pop();
                }
            }
        }
        return result;
    }
    public static String findCorrOper(String s){
        switch (s){
            case "*/":
                return "/*";
            case ")":
                return "(";
            case "]":
                return "[";
            case "}":
                return "{";
            default:
                return "";
        }
    }

    public static boolean isRightOper(String s){
        return s=="/*" || s=="(" || s=="[" || s=="{";
    }

    public static boolean isLeftOper(String s){
        return s=="*/" || s==")" || s=="]" || s=="}";
    }


}
