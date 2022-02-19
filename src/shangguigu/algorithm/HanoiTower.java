package shangguigu.algorithm;

/**
 * @author: Kate Fu
 * @create: 2022-02-07 16:43
 */
public class HanoiTower {
    public static void main(String[] args) {
        hanoiTower(2  , 'A','B','C');

    }

  //汉诺塔移动方法
    //分治法
    public static void hanoiTower(int num, char a, char b, char c){
        if(num==1){
            System.out.println(a+"->"+c);
            return;
        }

        //如果我们有n>=2个盘，总是可以看作是两个盘（最下面的一个，其他的）
        //1.先把最上面的所有盘a->b,移动过程会用到c
        hanoiTower(num-1, a,c,b);
        //2. 把最下面的盘a->c
        System.out.println("No. "+num+" Plate move"+a+"->"+c);
        //3. 把b盘的所有盘b->c
        hanoiTower(num-1, b,a,c);

    }
}


