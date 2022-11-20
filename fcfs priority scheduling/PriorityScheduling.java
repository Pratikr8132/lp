import java.util.*;

public class PriorityScheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Processes: ");
        int t_process = sc.nextInt();
        int[] PID = new int[t_process];
        int[] PRI = new int[t_process];
        int[] AT = new int[t_process];
        int[] BT = new int[t_process];
        int[] CT = new int[t_process];
        int[] TAT = new int[t_process];
        int[] WT = new int[t_process];
        Deque<Integer> DQ = new LinkedList<Integer>();
        DQ.addFirst(-1);
        Vector<Integer> vector = new Vector<Integer>();
        //vector.add(-1);
        System.out.println("PID PRI AT BT ");
        double ATAT=0.0, AWT=0.0;
        for (int i = 0; i < t_process; i++) {
            PID[i] = sc.nextInt();
            PRI[i] = sc.nextInt();
            AT[i] = sc.nextInt();
            BT[i] = sc.nextInt();
        }

        for (int i = 0; i < t_process-1; i++) {
            for (int j = 0; j < t_process-i-1; j++) {
                if(AT[j] > AT[j+1]){
                    int temp = AT[j];
                    AT[j] = AT[j+1];
                    AT[j+1] = temp;

                    int temp1 = PID[j];
                    PID[j] = PID[j+1];
                    PID[j+1] = temp1;

                    int temp2 = BT[j];
                    BT[j] = BT[j+1];
                    BT[j+1] = temp2;

                    int temp3 = PRI[j];
                    PRI[j] = PRI[j+1];
                    PRI[j+1] = temp3;
                }
            }
        }
        System.out.println(" PID PRI AT BT");
        for (int i = 0; i < t_process; i++) {
            System.out.println(" "+PID[i]+"\t"+PRI[i]+"\t"+AT[i]+"\t"+BT[i]);
        }
        int completed = 0,cur_time=0;
        while(true){
            if(AT[0] == 0){
                cur_time += BT[0];
                CT[0] = AT[0] + BT[0];
                TAT[0] = CT[0] - AT[0];
                WT[0] = TAT[0] - BT[0];
                AWT+=WT[0];
                ATAT+=TAT[0];
                AT[0] = 100;
                completed++;
            }
            vector.add(-1);
            for (int i = 0; i < t_process; i++) {
                if(AT[i] <= cur_time){
                    vector.add(PRI[i]);
                }
            }
            int MAX = Collections.max(vector);
            System.out.println("Vector: "+vector);
            System.out.println("MAX: "+MAX);
            int index = findIndex(MAX,PRI);
            System.out.println("INDEX: "+index);
            cur_time+=BT[index];
            CT[index] = cur_time;
            TAT[index] = CT[index] - AT[index];
            WT[index] = TAT[index] - BT[index];
            AWT+=WT[index];
            ATAT+=TAT[index];
            AT[index] = 100;
            //vector.remove(MAX);
            //vector.removeElement(MAX);
            vector.removeAllElements();
            completed++;
            if(completed == t_process){
                break;
            }
        }

        System.out.println(" PID PRI AT BT   CT TAT WT");
        for (int i = 0; i < t_process; i++) {
            System.out.println(" "+PID[i]+"\t"+PRI[i]+"\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        System.out.println("Average TAT: "+(ATAT/t_process)+"\n Average WT: "+(AWT/t_process));
    }

    private static int findIndex(int max, int[] pri) {
        int key = -1;
        for (int i = 0; i < 4; i++) {
            if(pri[i] == max){
                key = i;
                break;
            }
        }
        return key;
    }
}
/*
Enter No of Processes: 4
PID PRI AT BT 
2
1 
0
10
4
3
5
5
3
2
8
4
1
4
10
2
 PID PRI AT BT
 2	1	0	10
 4	3	5	5
 3	2	8	4
 1	4	10	2
Vector: [-1, 3, 2, 4]
MAX: 4
INDEX: 3
Vector: [-1, 3, 2]
MAX: 3
INDEX: 1
Vector: [-1, 2]
MAX: 2
INDEX: 2
 PID PRI AT BT   CT TAT WT
 2	1	100	10	10	10	0
 4	3	100	5	17	12	7
 3	2	100	4	21	13	9
 1	4	100	2	12	2	0
Average TAT: 9.25
 Average WT: 4.0
*/

