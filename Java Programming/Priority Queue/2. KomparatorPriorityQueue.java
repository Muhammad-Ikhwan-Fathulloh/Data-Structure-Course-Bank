package komparator.priority.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KomparatorPriorityQueue {

    public static void main(String[] args) {
        
        System.out.println("");
        
        // Komparator  yang membandingkan String berdasarkan panjang karakternya
        Comparator<String> stringKomparatorPanjang = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        
        //======================================================================

            //Script di atas bisa diganti dengan lambda expression di bawah ini
            Comparator<String> komparatorLambdaExpression = (s1, s2) -> {
                return s1.length() - s2.length();
            };

            //Atau bisa lebih diperpendek menjadi seperti berikut
            Comparator<String> komparatorSimple = 
                    Comparator.comparingInt(String::length);

        //======================================================================
            
        // Deklarasi Priority Queue menggunakan Komparator
        PriorityQueue<String> komparatorPriorityQueue = 
                new PriorityQueue<>(stringKomparatorPanjang);

        // Menambahkan Item di Priority Queue -> ADD
        komparatorPriorityQueue.add("Robert");
        komparatorPriorityQueue.add("Waris");
        komparatorPriorityQueue.add("Marsisno");
        komparatorPriorityQueue.add("Setiabudi");
        komparatorPriorityQueue.add("Budi");
        komparatorPriorityQueue.add("Lia");

        // Mencetak dan Menghapus Item di Priority Queue -> REMOVE
        while (!komparatorPriorityQueue.isEmpty()) {
            System.out.println(komparatorPriorityQueue.remove());
        }
        
        System.out.println("");
        
    }
    
}
