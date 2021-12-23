package bookpractice.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2021-12-18 19:09
 * @description: two lists' intersect and union
 */
public class Practice2 {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,34,56,2,654,67);
        List<Integer> list2 = Arrays.asList(7,67,8291,2,39);

        System.out.println(intersect(list1, list2));
        System.out.println(union(list1, list2));
    }

    public static List<Integer> intersect(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        Iterator ite1 = list1.iterator();

        while(ite1.hasNext()){
            Object value = ite1.next();
            if(list2.contains(value)){
                result.add((Integer) value);
            }
        }
        return result;
    }

    public static List<Integer> union(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();

        Iterator ite1 = list1.iterator();
        Iterator ite2 = list2.iterator();

        while(ite2.hasNext()){
            result.add((int) ite2.next());
        }
        while(ite1.hasNext()){
            Object value = ite1.next();
            if(!list2.contains(value)){
                result.add((Integer) value);
            }
            ite1.next();
        }
        return result;
    }
}
