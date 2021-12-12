package shangguigu;

import java.util.Scanner;

/**
 * @author: Kate Fu
 * @create: 2021-12-09 18:18
 */
public class QueueCircleArray {
    public static void main(String[] args) {
        QueueCircle qc = new QueueCircle(3);
        char key= ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("s(show): show queue");
            System.out.println("e(exit): exit program");
            System.out.println("a(add): add element");
            System.out.println("g(get): get element");
            System.out.println("h(head): show head element");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    qc.showQueue();
                    break;
                case 'e':
                    System.exit(0);
                    break;
                case 'a':
                    System.out.println("input your number");
                    int num = scanner.nextInt();
                    qc.addQueue(num);
                    break;
                case 'g':
                    int num1 = qc.getQueue();
                    System.out.println(num1);
                    break;
                case 'h':
                    int num2 = qc.headQueue();
                    System.out.println(num2);
                    break;
            }
        }
    }
}

class QueueCircle{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public QueueCircle(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front=0;//pointer pointing to the position before the first element
        rear= 0; //pointer pointing to the last element
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
            System.out.println("The queue is full");
            return;
        }
        arr[rear]= n;
        rear = (rear+1)%maxSize;
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("The queue has no elements");
            return 0;
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //go through
    public void showQueue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }
        //thoughts: go through the array from the front,
        for(int i=front; i<front+size(); i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //find effective numbers in the array
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    public int headQueue(){
        if(isEmpty()){
            System.out.println("the queue is empty");
        }
        return arr[front+1];
    }
}
