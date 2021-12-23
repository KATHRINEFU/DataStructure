package shangguigu.linear;

/**
 * @author: Kate Fu
 * @create: 2021-12-09 16:39
 * @description: sparsearray and 2d array conversion
 */
public class SparseArray {
  public static void main(String[] args) {
      //initiate original chessboard
      int[][] oriArr = new int[11][11];
      oriArr[1][2]=1;
      oriArr[2][3]=2;

      for(int i=0; i<oriArr.length; i++){
          for(int j=0; j<oriArr.length; j++){
              System.out.print(oriArr[i][j]);
          }
          System.out.println();
      }

      //how many effective numbers
      int sum=0;
      for(int i=0; i<oriArr.length; i++){
          for(int j=0; j<oriArr.length; j++){
              if(oriArr[i][j]!=0)
                  sum++;
          }
      }

      //2d to sparse
      int[][] sparseArr = new int[sum+1][3];
      sparseArr[0][0]=11;
      sparseArr[0][1]=11;
      sparseArr[0][2]=sum;
      int count=1;
      for(int i=0; i<oriArr.length; i++){
          for(int j=0; j<oriArr.length; j++){
              if(oriArr[i][j]!=0){
                  sparseArr[count][0]=i;
                  sparseArr[count][1]=j;
                  sparseArr[count][2]=oriArr[i][j];
                  count++;
              }
          }
      }
      System.out.println("**********************");
      for(int i=0; i<sparseArr.length; i++){
          for(int j=0; j<sparseArr.length; j++){
              System.out.print(sparseArr[i][j]);
          }
          System.out.println();
      }
      //sparse to 2d
      int[][] nextArr = new int[sparseArr[0][0]][sparseArr[0][1]];
      for(int i=1; i<sparseArr.length; i++){
          nextArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
      }

      System.out.println("**********************");
      for(int i=0; i<nextArr.length; i++){
          for(int j=0; j<nextArr.length; j++){
              System.out.print(nextArr[i][j]);
          }
          System.out.println();
      }
  }
}
