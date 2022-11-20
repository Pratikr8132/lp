import java.util.Scanner;

public class FIFOCPUSheduling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Processes: ");
        int t_process = sc.nextInt();
        int[] PID = new int[t_process];
        int[] AT = new int[t_process];
        int[] BT = new int[t_process];
        int[] CT = new int[t_process];
        int[] TAT = new int[t_process];
        int[] WT = new int[t_process];
        float ATAT = 0,AWT=0;
        System.out.println("Enter PID AT BT of  Processes");
        System.out.println("PID AT BT ");
        for (int i = 0; i < t_process; i++) {
            PID[i] = sc.nextInt();
            AT[i] = sc.nextInt();
            BT[i] = sc.nextInt();
        }

        for (int i = 0; i < t_process-1; i++) {
            for (int j = 0; j < t_process - i - 1; j++) {
                if (AT[j] > AT[j + 1])
                {
                    int temp = AT[j];
                    AT[j] = AT[j + 1];
                    AT[j + 1] = temp;

                    int temp1 = PID[j];
                    PID[j] = PID[j + 1];
                    PID[j + 1] = temp1;

                    int temp2 = BT[j];
                    BT[j] = BT[j + 1];
                    BT[j + 1] = temp2;
                }
            }
        }
        System.out.println("PID AT BT ");
        for (int i = 0; i < t_process; i++) {
            System.out.println(" "+PID[i]+"\t"+AT[i]+"\t"+BT[i]+" ");
        }

        for (int i = 0; i < t_process; i++) {
            if(i==0){
                CT[i] = AT[i] + BT[i];
            }else {
                if(AT[i] > CT[i-1]){
                    CT[i] = AT[i] + BT[i];
                }else {
                    CT[i] = BT[i] + CT[i-1];
                }
            }
            TAT[i] = CT[i] - AT[i];
            WT[i] = TAT[i] - BT[i];
            ATAT+=TAT[i];
            AWT+=WT[i];
        }
        System.out.println("PID AT  BT  CT  TAT WT");
        for (int i = 0; i < t_process; i++) {
            System.out.println(" "+PID[i]+"\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        System.out.println("Average TAT is: "+(ATAT/t_process)+"\n"+"Average WT is: "+(AWT/t_process));

    }
}
