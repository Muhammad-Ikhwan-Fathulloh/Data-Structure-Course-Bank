package bubble.sort;

import java.util.Arrays;

class BubbleSort {
    
    void bubbleSort(int arr[]) {
        
        int n = arr.length;
        
        for(int i = 0; i < n; i++){
            
            for(int j = 1; j < (n - i); j++){

                if(arr[j - 1] < arr[j]){
                    
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    
                }

            }
            
        }
        
    }

    void printArray(int arr[]) {

        int n = arr.length;
        
        System.out.print("[");
        for (int i = 0; i < n; ++i){
            
            if (i < n - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
        
        System.out.println();

    }

    public static void main(String args[]) {
        
        long waktuAwal;
        long waktuAkhir;
        
        waktuAwal = System.nanoTime();
        
        System.out.println("");
        System.out.println("BUBBLE SORT\n");
        
        BubbleSort ob = new BubbleSort();
        int arr[] = {84, 44, 35, 22, 12, 10, 90};
        
        System.out.println("Array Awal ");
        System.out.println(Arrays.toString(arr));
        System.out.println("");
        
        ob.bubbleSort(arr);
        System.out.println("Array Urut ");
        ob.printArray(arr);
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
        
        System.out.println("");
    
    }
    
}