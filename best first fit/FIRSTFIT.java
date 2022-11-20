import java.util.Scanner;

public class FIRSTFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Process: ");
        int t_process = sc.nextInt();;
        int[] PROCESS = new int[t_process];
        int[] BLOCK = new int[t_process];
        System.out.println("Enter Process Size");
        for (int i = 0; i < t_process; i++) {
            PROCESS[i] = sc.nextInt();
        }
        System.out.println("Enter Block Size");
        for (int i = 0; i < t_process; i++) {
            BLOCK[i] = sc.nextInt();
        }

        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_process; j++) {
                if(PROCESS[i]<=BLOCK[j]){
                    System.out.println("P["+PROCESS[i]+"] -> B["+BLOCK[j]+"]");
                    BLOCK[j] = -1;
                    break;
                }
            }
        }
    }
}
