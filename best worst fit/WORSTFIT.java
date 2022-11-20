import java.util.Arrays;
import java.util.Scanner;

public class WORSTFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Processes: ");
        int t_process = sc.nextInt();
        int[] PROCESS = new int[t_process];
        int[] BLOCK = new int[t_process];
        System.out.println("Enter Size of Process");
        for (int i = 0; i < t_process; i++) {
            PROCESS[i] = sc.nextInt();
        }
        System.out.println("Enter Size of Block");
        for (int i = 0; i < t_process; i++) {
            BLOCK[i] = sc.nextInt();
        }

        Arrays.sort(PROCESS);
        Arrays.sort(BLOCK);
        boolean flag = true;
        int i =0;
        int j =t_process-1;
        while (flag){
            if (PROCESS[i] <= BLOCK[j]){
                System.out.println("P["+PROCESS[i]+"] -> B["+BLOCK[j]+"]");
                i++;
                j--;
                flag = true;
            }else {
                flag = false;
            }
        }
    }
}
