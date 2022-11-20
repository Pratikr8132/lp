import java.util.Arrays;
import java.util.Scanner;

public class BESTFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter No Process: ");
        int t_process = sc.nextInt();
        int[] PROCESS = new int[t_process];
        System.out.println("Enter Process Size: ");
        for (int i = 0; i < t_process; i++) {
            PROCESS[i] = sc.nextInt();
        }
        int[] BLOCK = new int[t_process];
        System.out.println("Enter Block Size: ");
        for (int i = 0; i < t_process; i++) {
            BLOCK[i] = sc.nextInt();
        }

        Arrays.sort(PROCESS);
        Arrays.sort(BLOCK);

        for (int i = 0; i < t_process; i++) {
            for (int j = i; j < t_process; j++) {
                if(PROCESS[i] <= BLOCK[j]){
                    System.out.println("P["+PROCESS[i]+"] -> B["+BLOCK[j]+"]");
                    break;
                }
            }
        }
    }
}
/*Enter No Process: 
4
Enter Process Size: 
30
20
700
200
Enter Block Size: 
4
50
500
100
P[20] -> B[50]
P[30] -> B[50]
P[200] -> B[500]
*/
