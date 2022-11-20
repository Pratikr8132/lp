import java.lang.reflect.Array;
import java.util.*;

public class xyz{

    public static void ring(){
    Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Nodes: ");
        int t_nodes = sc.nextInt();
        int[] nodesArray = new int[t_nodes];
        for (int i = 0; i < t_nodes; i++) {
            nodesArray[i] = sc.nextInt();
        }
        int MAX = nodesArray[t_nodes-1];
        Deque<Integer> DQ = new LinkedList<Integer>();
        //Random random = new Random();
        System.out.print("enter coordinator ");
        int coordinator = sc.nextInt();
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
    public static void bully(){
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
        
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        System.out.print("which one u want 1.FIFO 2.OPTIMAL ");
    int a=sc.nextInt();
    switch (a) {
    	case 1: 
    		fifo();
    		break;
    	case 2: 
    		optimal();
    		break;
    	}
    
    
    
    
    
    }
    }
