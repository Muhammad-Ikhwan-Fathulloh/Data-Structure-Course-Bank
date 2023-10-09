package linear.search;

public class LinearSearch {

    public static int linearSearch(int arr[], int elementToSearch) {
        
        for (int index = 0; index < arr.length; index++) {
            
            if (arr[index] == elementToSearch) {
                return index;
            }
            
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int linear[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                        204, 108, 354, 123, 487, 563, 179, 698};
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        if (linearSearch(linear, nilai) == -1) {
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
