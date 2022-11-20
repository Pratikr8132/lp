import java.lang.reflect.Array;
import java.util.*;

public class ringAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Nodes: ");
        int t_nodes = sc.nextInt();
        int[] nodesArray = new int[t_nodes];
        for (int i = 0; i < t_nodes; i++) {
            nodesArray[i] = sc.nextInt();
        }
        int MAX = nodesArray[t_nodes-1];
        Deque<Integer> DQ = new LinkedList<Integer>();
        Random random = new Random();
        int coordinator = random.nextInt(t_nodes);
        System.out.println("Coordinator "+coordinator+" is dead");
        System.out.print("Enter Initiator: ");
        int initiator = sc.nextInt();
        int init = initiator;
        while (t_nodes-->0){
            if(initiator == coordinator){
                initiator++;
                t_nodes--;
            } else if (initiator == MAX) {
                DQ.addLast(initiator);
                initiator = 0;
                DQ.addLast(initiator);
                initiator++;
                t_nodes--;
            }
            DQ.addLast(initiator);
            initiator++;
            t_nodes--;
            System.out.println(DQ);
        }
        coordinator = Collections.max(DQ);
        System.out.println("New Coordinator: "+coordinator);
        for (int i = 0; i < nodesArray.length; i++) {
            if(i == init){
                continue;
            }
            System.out.println("Initiator "+init+" send message to "+i+" ,new coordinator is: "+coordinator);
        }
    }
}
//java ringAlgorithm
//Enter No of Nodes: 6
//0
//1
//2
//3
//4
//5
//Coordinator 2 is dead
//Enter Initiator: 3
//[3]
//[3, 4]
//[3, 4, 5, 0, 1]
//New Coordinator: 5

