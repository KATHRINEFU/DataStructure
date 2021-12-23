package bookpractice.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Kate Fu
 * @create: 2021-12-18 18:34
 * @description: print L according to P
 */
public class Practice1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("chduis");
        list.add("gydcuisac");
        list.add("cyuidwhui");
        list.add("qeduiehuw");
        list.add("cdysuia");
        list.add("zfhvuio");

        List<Integer> indexes = Arrays.asList(1,3,4,5);
        printLots(list, indexes);
    }

    public static void printLots(List<String> l, List<Integer> p){
        Iterator ite = p.iterator();
        int count=0;
        while(ite.hasNext()){
            int index = (int) ite.next();
            System.out.println(l.get(index));
        }
    }
}
