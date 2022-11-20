public class Consumer implements Runnable {
    private MyQueue myQueue;

    public Consumer(MyQueue myQueue){
        this.myQueue= myQueue;
    }
    @Override
    public void run() {
        while (true){
            myQueue.get();
            try {
                Thread.sleep(2000);
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
    }
}

