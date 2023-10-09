package iterpolation.search;

public class IterpolationSearch {

    public static int interpolationSearch(int[] integers, int elementToSearch) {
        
        int startIndex = 0;
        int lastIndex = (integers.length - 1);
        
        while ((startIndex <= lastIndex) && 
                (elementToSearch >= integers[startIndex]) &&
                (elementToSearch <= integers[lastIndex])) {
        
            int pos = startIndex + (((lastIndex-startIndex) /
                    (integers[lastIndex]-integers[startIndex]))*
                    (elementToSearch - integers[startIndex]));

            if (integers[pos] == elementToSearch){
                return pos;
            }

            if (integers[pos] < elementToSearch){
                startIndex = pos + 1;
            } else{
                lastIndex = pos - 1;
            }
            
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int interpolation[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                               204, 108, 354, 123, 487, 563, 179, 698};
        
        int n = interpolation.length;
        QuickSort bin = new QuickSort();
        bin.sort(interpolation, 0, n-1);
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        if (interpolationSearch(interpolation, nilai) <= -1) {
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
