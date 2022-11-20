import java.util.Scanner;

public class BankersAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of Process: ");
        int t_process = sc.nextInt();
        System.out.print("Enter no of Resources: ");
        int t_resources = sc.nextInt();
        int[][] allocateMatrix = new int[t_process][t_resources];
        int[][] maxAllocation = new int[t_process][t_resources];
        int[] availableMatrix = new int[t_resources];
        int[][] needMatrix = new int[t_process][t_resources];
        System.out.println("Enter Allocation Matrix");
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                allocateMatrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Allocation Matrix");
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                System.out.print(allocateMatrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Enter Maximum Allocation Matrix");
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                maxAllocation[i][j] = sc.nextInt();
            }
        }
        System.out.println("Max Allocation Matrix");
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                System.out.print(maxAllocation[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Enter Available Matrix");
        for (int i = 0; i < t_resources; i++) {
            availableMatrix[i] = sc.nextInt();
        }

        System.out.println("Available Matrix");
        for (int i = 0; i < t_resources; i++) {
            System.out.print(availableMatrix[i]+" ");
        }
        System.out.println();
        System.out.println("Need Matrix");
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                needMatrix[i][j] = maxAllocation[i][j] - allocateMatrix[i][j];
            }
        }
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                System.out.print(needMatrix[i][j]+" ");
            }
            System.out.println();
        }
        int[] safeSeq = new int[t_process];
        int[] unsafeSeq = new int[t_process];
        int count1 = 0, count2 = 0;
        boolean flag = true;
        for (int i = 0; i < t_process; i++) {
            safeSeq[i] = -1;
            unsafeSeq[i] = -1;
        }
        for (int i = 0; i < t_process; i++) {
            for (int j = 0; j < t_resources; j++) {
                if(needMatrix[i][j] > availableMatrix[j]){
                    unsafeSeq[count1++] = i;
                    flag = false;
                    break;
                } else if (needMatrix[i][j] <= availableMatrix[j]) {
                    safeSeq[count2++] = i;
                    flag = true;
                    break;
                }
            }
            if(flag){
                for (int j = 0; j < t_resources; j++) {
                    availableMatrix[j]+=allocateMatrix[i][j];
                }
            }
        }
        System.out.print("Safe Sequence: ");
        for (int i = 0; i < t_process; i++) {
            System.out.print(" P["+safeSeq[i]+"] ");
        }
    }
}

// Allocation Matrix
//1	2	2	1
//1	0	3	3
//1	2	1	0

//Ma/x Allocation

//3	3	2	2
//1	1	3	4
//1	3	5	0
//
//Available
//
//3	1	1	2
