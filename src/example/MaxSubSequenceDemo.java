package example;

/**
 * @author: Kate Fu
 * @create: 2021-12-17 22:19
 */
public class MaxSubSequenceDemo {
    public static void main(String[] args) {

    }

    //O(N^3)
    public static int maxSubSum1(int[] a){
        int maxSum=0;
        for(int i=0; i<a.length; i++){
            for(int j=1; j<a.length; j++){
                int tempSum=0;
                for(int z=i; z<=j; z++){
                    tempSum+=a[z];
                }
                if(tempSum>maxSum) maxSum=tempSum;
            }
        }
        return maxSum;
    }

    //O(N^2)
    public static int maxSubSum2(int[] a){
        int maxSum=0;
        for(int i=0; i<a.length; i++){
            int tempSum=0;
            for(int j=i; j<a.length; j++){
                tempSum+=a[j];
            }
            if(tempSum>maxSum) maxSum=tempSum;
        }
        return maxSum;
    }

    //divide and conquer O(NlogN)
    public static int maxSubSum3(int[] a){
        return maxSumRec(a,0, a.length-1);
    }

    public static int maxSubSum4(int[] a){
        int maxSum=0;
        int tempSum=0;
        for(int j=0; j<a.length; j++){
            tempSum+=a[j];
            if(tempSum>maxSum)
                maxSum=tempSum;
            else if(tempSum<0)
                tempSum=0;
        }
        return maxSum;
        
    }
    private static int maxSumRec(int[] a, int left, int right){
        if(left==right)
            if(a[left]>0)
                return a[left];
            else
                return 0;
        int center = (left+right)/2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center, right);

        int maxLeftBorderSum=0;
        int leftBorderSum=0;
        for(int i=center; i>=left; i--){
            leftBorderSum+=a[i];
            if(leftBorderSum>maxLeftBorderSum)
                maxLeftBorderSum = leftBorderSum;
        }

        int maxRightBorderSum=0;
        int rightBorderSum=0;
        for(int i=center+1; i<=right; i++){
            rightBorderSum+=a[i];
            if(rightBorderSum>maxRightBorderSum)
                maxRightBorderSum=rightBorderSum;
        }

        return max3(maxLeftSum, maxRightSum, maxLeftBorderSum+maxRightBorderSum);
    }

    private static int max3(int a, int b, int c){
        if(a>=b && a>=c)
            return a;
        if(b>=a && b>=c)
            return b;
        return c;
    }
}


