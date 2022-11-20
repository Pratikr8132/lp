import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bullyAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Nodes: ");
        int t_nodes = sc.nextInt();
        int[] nodesArray = new int[t_nodes];
        for (int i = 0; i < t_nodes; i++) {
            nodesArray[i] = sc.nextInt();
        }
        System.out.print("Enter Coordinator: ");
        int coordinator = sc.nextInt();
        System.out.println("Coordinator "+coordinator+" is dead");
        System.out.print("Now initiator is: ");
        int initiator = sc.nextInt();
        int init = initiator;
        int count = t_nodes-init;
        System.out.println(count);
        Deque<Integer> DQ = new LinkedList<Integer>();
        while (count>0){
            if(initiator==coordinator){
                System.out.println(DQ);
                initiator++;
                count--;
            }else {
                DQ.addLast(initiator);
                System.out.println(DQ);
                initiator++;
                count--;
            }
        }
        int MAX = Collections.max(DQ);
        for (int i = 0; i < t_nodes; i++) {
            if(i == coordinator){
                continue;
            }else {
                System.out.println("New Coordinator "+MAX+" ACK to "+i);
            }
        }
    }
}
