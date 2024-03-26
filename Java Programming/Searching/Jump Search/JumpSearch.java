package jump.search;

public class JumpSearch {

    public static int jumpSearch(int[] integers, int elementToSearch) {
        
        int arrayLength = integers.length;
        int jumpStep = (int) Math.sqrt(integers.length);
        int previousStep = 0;
        
        while (integers[Math.min(jumpStep, arrayLength) - 1] < elementToSearch) {
            
            previousStep = jumpStep;
            jumpStep += (int)(Math.sqrt(arrayLength));
            
            if (previousStep >= arrayLength){
                return -1;
            }
            
        }
        
        while (integers[previousStep] < elementToSearch) {
            
            previousStep++;
            
            if (previousStep == Math.min(jumpStep, arrayLength)){
                return -1;
            }
            
        }
        
        if (integers[previousStep] == elementToSearch){
            return previousStep;
        }
        
        return -1;
        
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        long waktuAwal;
        long waktuAkhir;
        
        int jump[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                      204, 108, 354, 123, 487, 563, 179, 698};
         
        int n = jump.length;
        QuickSort bin = new QuickSort();
        bin.sort(jump, 0, n-1);
        
        int nilai = 123;
        
        waktuAwal = System.nanoTime();
        
        if (jumpSearch(jump, nilai) == -1) {
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
