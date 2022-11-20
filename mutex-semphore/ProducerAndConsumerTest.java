public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Producer producer = new Producer(myQueue);
        Consumer consumer = new Consumer(myQueue);

        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
}
