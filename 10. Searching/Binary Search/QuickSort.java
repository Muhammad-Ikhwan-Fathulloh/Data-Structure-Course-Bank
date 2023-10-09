package binary.search;

class QuickSort {
    
    int partition(int arr[], int kecil, int besar) {
        
        int pivot = arr[besar];
        int i = (kecil - 1);

        for (int j = kecil; j < besar; j++) {


            if (arr[j] < pivot) {

                i++;
                int temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;

            }

        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[besar];
        arr[besar] = temp;
        return i + 1;
    
    }
    
    void sort(int arr[], int kecil, int besar) {
        
        if (kecil < besar) {
        
            int pi = partition(arr, kecil, besar);

            sort(arr, kecil, pi-1);
            sort(arr, pi+1, besar);
        
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
