package shangguigu.search;

import java.util.ArrayList;

/**
 * @author: Kate Fu
 * @create: 2021-12-22 21:09
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        ArrayList resList = biSearchAll(arr,0,arr.length-1, 11);
        System.out.println(resList);
    }

    public static int biSearch(int[] arr, int left, int right, int finalVal){
        if(left>right){
            return -1;
        }
        int mid = (left+right)/2;
        int midVar = arr[mid];
        if(finalVal>midVar){
            return biSearch(arr,mid+1,right, finalVal);
        }else if(finalVal<midVar){
            return biSearch(arr, left, mid-1, finalVal);
        }else{
            return mid;
        }
    }

    public static ArrayList<Integer> biSearchAll(int[] arr, int left, int right, int finalVal){
        if(left>right){
            return new ArrayList<Integer>();
        }
        int mid = (left+right)/2;
        int midVar = arr[mid];
        if(finalVal>midVar){
            return biSearchAll(arr,mid+1,right, finalVal);
        }else if(finalVal<midVar){
            return biSearchAll(arr, left, mid-1, finalVal);
        }else{
            ArrayList<Integer> reslist = new ArrayList<>();

            //scan leftwards
            int temp=mid-1;
            while(true){
                if(temp<0 || arr[temp]!=finalVal){
                    break;
                }else{
                    reslist.add(temp);
                    temp-=1;
                }
            }
            reslist.add(mid);

            //scan rightwards
            temp=mid-1;
            while(true){
                if(temp>arr.length-1 || arr[temp]!=finalVal){
                    break;
                }else{
                    reslist.add(temp);
                    temp+=1;
                }
            }
            return reslist;
        }
    }
}
