import java.io.*;
import java.util.Scanner;


public class combine{

	

	public static void SRTF(){ 
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n;
      System.out.println("Please enter the number of Processes: ");
       n = Integer.parseInt(br.nextInt());
       int proc[][] = new int[n + 1][4];//proc[][0] is the AT array,[][1] - RT,[][2] - WT,[][3] - TT
       for(int i = 1; i <= n; i++)
       {
      System.out.println("Please enter the Arrival Time for Process " + i + ": ");
      proc[i][0] = Integer.parseInt(br.nextInt());
      System.out.println("Please enter the Burst Time for Process " + i + ": ");
      proc[i][1] = Integer.parseInt(br.nextInt());
     }
       System.out.println();
     
       //Calculation of Total Time and Initialization of Time Chart array
     int total_time = 0;
     for(int i = 1; i <= n; i++)
     {
      total_time += proc[i][1];
     }
     int time_chart[] = new int[total_time];
     
     for(int i = 0; i < total_time; i++)
     {
      //Selection of shortest process which has arrived
      int sel_proc = 0;
      int min = 99999;
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)//Condition to check if Process has arrived
       {
        if(proc[j][1] < min && proc[j][1] != 0)
        {
         min = proc[j][1];
         sel_proc = j;
        }
       }
      }
      
      //Assign selected process to current time in the Chart
      time_chart[i] = sel_proc;
      
      //Decrement Remaining Time of selected process by 1 since it has been assigned the CPU for 1 unit of time
      proc[sel_proc][1]--;
      
      //WT and TT Calculation
      for(int j = 1; j <= n; j++)
      {
       if(proc[j][0] <= i)
       {
        if(proc[j][1] != 0)
        {
         proc[j][3]++;//If process has arrived and it has not already completed execution its TT is incremented by 1
            if(j != sel_proc)//If the process has not been currently assigned the CPU and has arrived its WT is incremented by 1
             proc[j][2]++;
        }
        else if(j == sel_proc)//This is a special case in which the process has been assigned CPU and has completed its execution
         proc[j][3]++;
       }
      }
      
      //Printing the Time Chart
      if(i != 0)
      {
       if(sel_proc != time_chart[i - 1])
        //If the CPU has been assigned to a different Process we need to print the current value of time and the name of 
        //the new Process
       {
        System.out.print("--" + i + "--P" + sel_proc);
       }
      }
      else//If the current time is 0 i.e the printing has just started we need to print the name of the First selected Process
       System.out.print(i + "--P" + sel_proc);
      if(i == total_time - 1)//All the process names have been printed now we have to print the time at which execution ends
       System.out.print("--" + (i + 1));
      
     }
     System.out.println();
     System.out.println();
     
     //Printing the WT and TT for each Process
     System.out.println("P\t WT \t TT ");
     for(int i = 1; i <= n; i++)
     {
      System.out.printf("%d\t%2dms\t%2dms",i,proc[i][2],proc[i][3]);
      System.out.println();
     }
     
     System.out.println();
     
     //Printing the average WT & TT
     float WT = 0,TT = 0;
     for(int i = 1; i <= n; i++)
     {
      WT += proc[i][2];
      TT += proc[i][3];
     }
     WT /= n;
     TT /= n;
     System.out.println("The Average WT is: " + WT + "ms");
     System.out.println("The Average TT is: " + TT + "ms");
	
	}









	public static void FCFS(){
	
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








	public static void main(String args[]) throws IOException{
	
	Scanner sc = new Scanner(System.in);
        System.out.print("which one u want 1.FCFS 2.SRTF ");
        int KL=sc.nextInt();
        switch (KL) {
    		case 1: 
    			FCFS();
    			break;
    		case 2: 
    			SRTF();
    			break;
    		    }
    
    
    
    
    
    }
    }
