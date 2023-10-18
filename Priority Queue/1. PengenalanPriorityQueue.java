package pengenalan.priority.queue;

import java.util.PriorityQueue;

public class PengenalanPriorityQueue {

    public static void main(String[] args) {
        
        System.out.println("");
        
        // Deklarasi Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        // Menambahkan Item di Priority Queue -> ADD
        numbers.add(750);
        numbers.add(500);
        numbers.add(900);
        numbers.add(100);

        // Mencetak dan Menghapus Item di Priority Queue -> REMOVE
        while (!numbers.isEmpty()) {
            System.out.println("Antrian:");
            System.out.println("-> " + numbers);
            System.out.println("Dihapus Item " + numbers.remove() + "\n");
        }
        
        System.out.println("");
        
    }
    
}
