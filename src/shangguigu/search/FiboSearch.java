package shangguigu.search;

import java.util.Arrays;

/**
 * @author: Kate Fu
 * @create: 2021-12-23 20:21
 */
public class FiboSearch {
    public static int maxSize=20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};
        System.out.println(fibSearch(arr,1));
    }

    //get a fibonacci array
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0]=0;
        f[1]=1;
        for(int i=2; i<f.length; i++){
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }

    //fibonacci search (not recursion)
    public static int fibSearch(int[] a, int key){
        int low=0;
        int high = a.length-1;
        int k=0; //fibonacci split value's index
        int mid=0;
        int f[] = fib();
        while(high>f[k]-1){
            k++;
        }
        //since f[k] may larger than a.length
        //use Arrays to create a new array, point to a, set zero on f[k]>a
        int[] temp = Arrays.copyOf(a, f[k]);
        //in real practice, need to use a's last number to fill empty
        for(int i=high+1; i<temp.length; i++){
            temp[i]=a[high];
        }
        //use while for loop search, find key
        while(low<high){
            mid = low+f[k-1]-1;
            if(key<temp[mid]){ //find in the left part
                high =mid-1;
                //all elements = left elements+right elements
                //f[k](current)=f[k-1](left)+f[k-2](right)
                //left elements (f[k-1] elements) can be continuously split into f[k-1]=f[k-2]+f[k-3]
                k--;//next's loop's mid is f[k-1-1]-1
            }else if(key>temp[mid]){
                low = mid+1;
                //all elements = left elements+right elements
                //f[k](current)=f[k-1](left)+f[k-2](right)
                //right elements (f[k-2] elements) can be continuously split into f[k-2]=f[k-3]+f[k-4]
                k-=2;
            }else{
                //decide what index to return
                if(mid<=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
