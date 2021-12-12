package shangguigu;

/**
 * @author: Kate Fu
 * @create: 2021-12-09 17:10
 * @description: line queue in array
 */
public class QueueArray {
    public static void main(String[] args) {
        Queue q = new Queue(10);

        q.addQueue(10);
        q.addQueue(8);
        q.addQueue(99);
    }
}

class Queue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front=-1;//pointer pointing to the position before the first element
        rear=-1; //pointer pointing to the last element
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }

    public boolean isEmpty(){
        return rear==front;
    }

    public void addQueue(int n){
        if(isFull()){
          System.out.println("The queue is full");
          return;
        }
        rear++;
        arr[rear]= n;
    }

    public int getQueue(){
        if(isEmpty()){
            System.out.println("The queue has no elements");
            return 0;
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }
        for(int i=0; i<arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    public int headQueue(){
        if(isEmpty()){
            System.out.println("the queue is empty");
        }
        return arr[front+1];
    }
}