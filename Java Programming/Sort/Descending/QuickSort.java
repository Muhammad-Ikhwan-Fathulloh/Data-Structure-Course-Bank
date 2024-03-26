package quick.sort;

class QuickSort {
    
    int partition(int arr[], int kecil, int besar) {
        
        int x = arr[kecil];
        int i = kecil;
        int j = besar;

        while(true) {
        
            while (arr[i] > x) {
                i++;
            }

            while (arr[j] < x) {
                j--;
            }


            if (i < j) {
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                
            } else {
                return j;
            }
            
        }
    
    }
    
    void sort(int arr[], int kecil, int besar) {
        
        if (kecil < besar) {
        
            int pi = partition(arr, kecil, besar);

            sort(arr, kecil, pi);
            sort(arr, pi + 1, besar);
        
        }
        
    }
   
    static void printArray(int arr[]) {
        
        int n = arr.length;
        
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.println();
        
    }
    
    public static void main(String args[]) {
        
        long waktuAwal;
        long waktuAkhir;
        
        waktuAwal = System.nanoTime();
        
        System.out.println("");
        System.out.println("QUICK SORT\n");
        
        int arr[] = {10, 7, 8, 9, 1, 5};
        
        System.out.println("Array Urut");
        printArray(arr);
        System.out.println("");
        
        int n = arr.length;
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        System.out.println("Array Urut ");
        printArray(arr);
        System.out.println("");
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
        
        System.out.println("");
        
    }

}
