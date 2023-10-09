package PengenalanLinkedList;

import java.util.LinkedList;

public class PengenalanLinkedList {

    public static void main(String[] args) {
        
        System.out.println("");
        
        System.out.println("Linked List");
        
        System.out.println(
            "-> Link list adalah desain tempat \n" +
            "   penyimpanan data yang terdiri dari \n" +
            "   node-node (simpul-simpul) yang \n" +
            "   saling terhubung. Link list dapat \n" +
            "   diilustrasikan seperti kereta api, \n" +
            "   dimana kereta api terdiri dari \n" +
            "   gerbong-gerbong yang saling \n" +
            "   terhubung yang dapat mengangkut \n" +
            "   penumpang. Gerbong disini setara \n" +
            "   dengan node dalam link list yang \n" +
            "   berfungsi untuk menyimpan data. \n"
        );
        
        //======================================================================
        
        System.out.println("Deklarasi Linked List");
        System.out.print("-> ");
        
        //Import java.util.LinkedList
        
        //Deklarasi Linked List -> LinkedList<tipe_data> nama_list = new LinkedList<>()
        LinkedList<String> list = new LinkedList<>();
        
        //Mengisi Linked List -> nama_list.add(isi)
        list.add(0, "A");
        list.add(1, "B");
        list.add(2, "C");
        
        //Mencetak Komponen Linked List
        System.out.println(list);
        
        System.out.println("");

        //======================================================================
        
        System.out.println("Cetak Linked List dengan Looping");
        System.out.print("-> ");
        
        //Cetak List
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < (list.size() - 1)) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
        
        System.out.println("\n");
        
    }
    
}
