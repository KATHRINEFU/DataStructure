package example;

/**
 * @author: Kate Fu
 * @create: 2021-12-13 21:26
 */
public class MazeShortestRouteRecursion {
    public static void main(String[] args) {
        int[][] map = new int[8][7];

        //set wall value to be 1
        for(int i=0; i<7; i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        for(int i=0; i<8; i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        map[3][1]=1;
        map[3][2]=1;

        setWay(map,1,1);
        for(int i=0;i<8; i++){
            for(int j=0; j<7; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    /**
     *
     * @param map:maze
     * @param i: start point row
     * @param j: start point column
     * @return: pathway
     *
     * map[i][j]=0:the point is not passed
     * map[i][j]=1: wall
     * map[i][j]=2: passable
     * map[i][j]=3: passed but not passable
     *
     */
    public static boolean setWay(int[][] map, int i, int j){
        if(map[6][5]==2){
            return true;
        }else{
            if(map[i][j]==0){// if the point is never passed
                map[i][j]=2; //assume the point is passable
                if(setWay(map,i+1,j)){//move downward
                   return true;
                }else if(setWay(map, i, j+1)){//move rightward
                    return true;
                }else if(setWay(map, i-1, j)){//move upward
                    return true;
                }else if(setWay(map, i, j-1)){//move leftward
                    return true;
                }else{
                    map[i][j]=3; //the point is not passable
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
