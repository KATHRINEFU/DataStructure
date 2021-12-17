package shangguigu;

/**
 * @author: Kate Fu
 * @create: 2021-12-13 20:07
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int res=factorial(6);
        System.out.println("res = "+res);
    }
    public static void test(int n){
        if(n>2){
            test(n-1);
        }//else{
            System.out.println("n="+n);
        //}
    }

    public static int factorial(int n){
        if(n==1) return 1;
        else return factorial(n-1)*n;
    }
}


