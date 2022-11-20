import java.util.concurrent.Semaphore;

public class MyQueue {
    private int item;
    private Semaphore consumerSemaphore = new Semaphore(0);
    private Semaphore producerSemaphore = new Semaphore(1);

    public void get(){
       try {
           consumerSemaphore.acquire();
       }catch (InterruptedException exception){
           System.out.println("Interrupted Exception Occur");
       }
        System.out.println("Consumer Consume Item: "+item);
       producerSemaphore.release();
    }
    public void put(int item){
        try{
            producerSemaphore.acquire();
        }catch (InterruptedException exception){
            System.out.println("Interrupted Exception Occur");
        }
        this.item = item;
        System.out.println("Producer Produce Item: "+item);
        consumerSemaphore.release();
    }
}

