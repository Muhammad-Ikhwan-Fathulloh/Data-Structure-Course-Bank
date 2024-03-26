package fibonacci.search;

public class FibonacciSearch {

    public static int fibonacciSearch(int[] integers, int elementToSearch) {
        
        int fibonacciMinus2 = 0;
        int fibonacciMinus1 = 1;
        int fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        int arrayLength = integers.length;
        
        while (fibonacciNumber < arrayLength) {
            fibonacciMinus2 = fibonacciMinus1;
            fibonacciMinus1 = fibonacciNumber;
            fibonacciNumber = fibonacciMinus2 + fibonacciMinus1;
        }
        
        int offset = -1;
        
        while (fibonacciNumber > 1) {
            
            int i = Math.min(offset+fibonacciMinus2, arrayLength-1);
            
            if (integers[i] < elementToSearch) {
                fibonacciNumber = fibonacciMinus1;
                fibonacciMinus1 = fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
                offset = i;
            } else if (integers[i] > elementToSearch) {
                fibonacciNumber = fibonacciMinus2;
                fibonacciMinus1 = fibonacciMinus1 - fibonacciMinus2;
                fibonacciMinus2 = fibonacciNumber - fibonacciMinus1;
            } else {
                return i;
            }
            
        }
        
        if (fibonacciMinus1 == 1 && integers[offset+1] == elementToSearch){
            return offset + 1;
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int fibonacci[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                               204, 108, 354, 123, 487, 563, 179, 698};
        
        int n = fibonacci.length;
        QuickSort bin = new QuickSort();
        bin.sort(fibonacci, 0, n-1);
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        if (fibonacciSearch(fibonacci, nilai) <= -1) {
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
