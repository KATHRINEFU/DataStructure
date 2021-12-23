package shangguigu.search;

/**
 * @author: Kate Fu
 * @create: 2021-12-22 20:08
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
        int index = seqSearch(arr,11);
        if(index==-1){
            System.out.println("Not found---");
        }else{
            System.out.println("Found!, the index is: "+index);
        }
    }

    //linear search
    //find one satisfying index
    public static int seqSearch(int[] arr, int value){
        //compare each, find the value
        for(int i=0; i<arr.length; i++){
            if(arr[i]==value){
                return i;
            }
        }
        return -1;
    }
}
