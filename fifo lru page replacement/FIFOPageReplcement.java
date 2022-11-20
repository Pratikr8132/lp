import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class FIFOPageReplcement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> doublyQueue = new LinkedList<>();
        System.out.print("Enter Page Slots: ");
        int capacity = sc.nextInt();
        int t_capacity = capacity;
        int element,page_fault=0,page_hit=0;
        System.out.print("Enter Number of Pages: ");
        int page_count = sc.nextInt();
        System.out.println("Enter Pages: ");
        while (capacity-->0){
            element = sc.nextInt();
            if(doublyQueue.contains(element)){
                page_hit+=1;
                System.out.println(doublyQueue);
                capacity++;
                t_capacity++;
            }else{
                doublyQueue.addFirst(element);
                page_fault+=1;
                System.out.println(doublyQueue);
            }
        }
        int total = page_count-t_capacity;
        while (total-->0){
            element = sc.nextInt();
            if(doublyQueue.contains(element)){
                page_hit+=1;
                System.out.println("PAGE HIT");
                System.out.println(doublyQueue);
            }else {
                doublyQueue.removeLast();
                doublyQueue.addFirst(element);
                //doublyQueue.addLast(element);
                page_fault+=1;
                System.out.println(doublyQueue);
            }
        }
        System.out.println("TOTAL PAGE FAULT: "+page_fault+"\nTOTAL PAGE HIT: "+page_hit);

    }
}
