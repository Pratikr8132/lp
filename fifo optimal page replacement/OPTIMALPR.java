import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class OPTIMALPR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No of Slots: ");
        int slots = sc.nextInt();
        int[] frameSlot = new int[slots];
        System.out.print("Enter No of Pages: ");
        int t_pages = sc.nextInt();
        int[] PAGES = new int[t_pages];
        for (int i = 0; i < t_pages; i++) {
            PAGES[i] = sc.nextInt();
        }
        int page_fault = 0,page_hit = 0,j=0;
        for (int i = 0; i < slots; i++) {
            if(searchElement(frameSlot,PAGES[j])){
                i--;
                j++;
                page_hit+=1;
                System.out.println("PAGE HIT");
            }else {
                frameSlot[i] = PAGES[j];
                j++;
                page_fault+=1;
                System.out.println("PAGE FAULT");
            }
        }
        for (int i = 0; i < slots; i++) {
            System.out.println(frameSlot[i]);
        }

        for (int i = j; i < t_pages; i++) {
            if(searchElement(frameSlot,PAGES[i])){
                page_hit+=1;
                System.out.println("PAGE HIT");
            }else {
                int index = indexOF(frameSlot,PAGES,i+1);
                if(index != -1){
                    for (int k = 0; k < slots; k++) {
                        if(frameSlot[k] == index){
                            frameSlot[k] = PAGES[i];
                        }
                    }
                    page_fault+=1;
                    System.out.println("PAGE FAULT");
                }else if(index == -1){
                    frameSlot[0] = PAGES[i];
                    page_fault+=1;
                    System.out.println("PAGE FAULT");
                }

            }
        }

        System.out.println("PAGE FAULT: "+page_fault+"\nPAGE HIT: "+page_hit);

    }

    private static int indexOF(int[] frameSlot, int[] pages, int i) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int j = 0; j < frameSlot.length; j++) {
            for (int k = i; k < pages.length ; k++) {
                if(frameSlot[j] == pages[k]){
                    vector.add(k);
                    break;
                }
            }
        }
        if(vector.isEmpty()){
           return -1;
        }else {
            int MAX = Collections.max(vector);
            return pages[MAX];
        }
    }

    private static boolean searchElement(int[] frameSlot, int page) {
        for (int i = 0; i < frameSlot.length; i++) {
            if(page == frameSlot[i]){
                return true;
            }
        }
        return false;
    }

}
