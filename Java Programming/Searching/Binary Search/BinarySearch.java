package binary.search;

public class BinarySearch {

    // Iterative
    public static int iterativeBinarySearch(int arr[], int elementToSearch) {
        
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {

            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (arr[middleIndex] < elementToSearch) {
                firstIndex = middleIndex + 1;
            } else if (arr[middleIndex] > elementToSearch){
                lastIndex = middleIndex - 1;
            }

        }

        return -1;

    }
    
    // Recursive
    public static int recursiveBinarySearch(int arr[], int firstElement, int lastElement, int elementToSearch) {

        if (lastElement >= firstElement) {
        
            int mid = firstElement + (lastElement - firstElement) / 2;
            
            if (arr[mid] == elementToSearch){
                return mid;
            }
            
            if (arr[mid] > elementToSearch){
                return recursiveBinarySearch(arr, firstElement, mid - 1, elementToSearch);
            }
            
            return recursiveBinarySearch(arr, mid + 1, lastElement, elementToSearch);
            
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int iterative[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                               204, 108, 354, 123, 487, 563, 179, 698};
        
        int n = iterative.length;
        QuickSort bin = new QuickSort();
        bin.sort(iterative, 0, n-1);
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        System.out.println("[Iterative]");
        if (iterativeBinarySearch(iterative, nilai) == -1) {
            System.out.println("Nilai " + nilai + " Tidak Ditemukan");
        } else {
            System.out.println("Nilai " + nilai + " Ditemukan");
        }
        
        System.out.println("");
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
        
        System.out.println("");
        
        waktuAwal = System.nanoTime();
        
        System.out.println("[Recursive]");
        if (recursiveBinarySearch(iterative, 0, n - 1, nilai) == -1) {
            System.out.println("Nilai " + nilai + " Tidak Ditemukan");
        } else {
            System.out.println("Nilai " + nilai + " Ditemukan");
        }
        
        System.out.println("");
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
                
        System.out.println("");
        
    }
    
}
