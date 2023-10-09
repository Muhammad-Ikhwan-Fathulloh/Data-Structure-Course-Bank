package insertion.sort;

import java.util.Arrays;

public class InsertionSort {
    
    void InsertionSort(int[] nums){
        
        for (int j = 1; j < nums.length; j++) {

            int value = nums[j];
            int i = j - 1;
            
            while (i >= 0 && nums[i] < value) {
                nums[i + 1] = nums[i];
                i = i - 1;
                nums[i + 1] = value;
            }
        }
        
    }
    
    public static void main(String args[]) {
        
        long waktuAwal;
        long waktuAkhir;
        
        waktuAwal = System.nanoTime();
        
        System.out.println("");
        System.out.println("INSERTION SORT\n");
        
        InsertionSort ob = new InsertionSort();
        int nums[] = {7, -5, 3, 2, 1, 0, 45};
        
        System.out.println("Array Awal ");
        System.out.println(Arrays.toString(nums));
        System.out.println("");
                
        ob.InsertionSort(nums);
        System.out.println("Array Urut ");
        System.out.println(Arrays.toString(nums));
        System.out.println("");
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
        
        System.out.println("");
        
    }
    
}