package insertion.sort;

import java.util.Arrays;

public class InsertionSort {
    
    void InsertionSort(int[] nums){
        
        for(int i = 1; i < nums.length; i++){
            
            int value = nums[i];
            int j = i - 1;
            
            while(j >= 0 && nums[j] > value){
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            
            nums[j + 1] = value;
            
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