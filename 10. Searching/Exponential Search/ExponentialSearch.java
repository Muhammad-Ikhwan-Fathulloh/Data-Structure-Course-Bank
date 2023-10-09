package exponential.search;

import java.util.Arrays;

public class ExponentialSearch {

    public static int exponentialSearch(int[] integers, int elementToSearch) {
        
        if (integers[0] == elementToSearch){
            return 0;
        }
        
        if (integers[integers.length - 1] == elementToSearch){
            return integers.length;
        }
        
        int range = 1;
        
        while (range < integers.length && integers[range] <= elementToSearch) {
            range = range * 2;
        }
        
        return Arrays.binarySearch(integers, range / 2, Math.min(range, integers.length), elementToSearch);
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int exponential[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                               204, 108, 354, 123, 487, 563, 179, 698};
        
        int n = exponential.length;
        QuickSort bin = new QuickSort();
        bin.sort(exponential, 0, n-1);
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        if (exponentialSearch(exponential, nilai) <= -1) {
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
