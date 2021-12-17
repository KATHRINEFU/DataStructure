package shangguigu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Kate Fu
 * @create: 2021-12-13 10:41
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String expr = "1+((2+3)*4)-5";
        List<String> listExpr = getListString(expr);
        List<String> postExpr = convert(listExpr);
        System.out.println("Postfix list is:"+postExpr);
    }

    public static List<String> getListString(String expr){
        List<String> list = new ArrayList<>();
        int i=0;
        String str; //stitch for multi digits
        char c;
        do{
            if((c=expr.charAt(i))<48 || (c=expr.charAt(i))>57){
                list.add(""+c);
                i++;
            }else{
                str="";
                while(i<expr.length() && (c=expr.charAt(i))>=48 && (c=expr.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                list.add(str);
            }
        }while(i<expr.length());
        return list;
    }
    public  static List<String> convert(List<String> list){
        Stack<String> s1 = new Stack<>();//operation stack
        //Stack<String> s2 = new Stack<>(); //intermediate result stack, not necessary
        List<String> s2 = new ArrayList<>();
        for(String item : list){
            if (item.matches("\\d+")) {
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            } else{
                while(s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while(s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

}
//return priority
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
            default:
                System.out.println("No such operation");
                break;
        }
        return result;
    }
}