import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class LRUCache {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Deque<Integer> doublyQueue = new LinkedList<>();
        System.out.print("Enter Frame Size: ");
        int capcity = sc.nextInt();
        System.out.println();
        int element,page_fault=0,page_hit=0;
        System.out.println("Enter Pages: ");
        while (capcity-->0){
            element =sc.nextInt();
            doublyQueue.addFirst(element);
            page_fault+=1;
            System.out.println(doublyQueue);
        }
        int size = 9;
        while (size-->0){
            element = sc.nextInt();
            if(doublyQueue.contains(element)){
                doublyQueue.removeLast();
                doublyQueue.addFirst(element);
                page_hit+=1;
                System.out.println("Page Hit Occurs");
                System.out.println(doublyQueue);
            }else {
                doublyQueue.removeLast();
                doublyQueue.addFirst(element);
                page_fault+=1;
                System.out.println(doublyQueue);
            }
        }
        System.out.println("Total Page Fault: "+page_fault+"\n"+"Total Page Hit: "+page_hit);

    }
}
