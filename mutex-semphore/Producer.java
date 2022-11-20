import java.util.Random;

public class Producer implements Runnable {
    private MyQueue myQueue;
    public Producer(MyQueue myQueue){
        this.myQueue = myQueue;
    }
    @Override
    public void run() {
        while (true){
            Random random = new Random();
            int data = random.nextInt(100);
            myQueue.put(data);
            try {
                Thread.sleep(2000);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }
}
