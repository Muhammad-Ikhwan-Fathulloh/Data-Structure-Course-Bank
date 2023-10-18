package OperasiLinkedList;

import java.util.LinkedList;

public class OperasiLinkedList {

    private static void cetakList(LinkedList<String> list) {
        System.out.print("[");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < (list.size() - 1)) {
                System.out.print(", ");
            } else {
                System.out.print("]");
            }
        }
    }
    
    //==========================================================================
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        System.out.println("Linked List");
        System.out.print("-> ");
        
        //Deklarasi Linked List
        LinkedList<String> list = new LinkedList<>();
        
        //Mengisi Linked List -> nama_list.add(isi)
        list.add(0, "A");
        list.add(1, "B");
        
        cetakList(list);
        
        System.out.println("\n");
        
        //======================================================================
        
        System.out.println("Menambahkan Elemen pada List");
        System.out.println("");
        
            System.out.println("  Menambahkan dengan ADD");
            System.out.print("  -> ");
            
            //Menempatkan Data Sesuai Urutan -> ADD
            
            //Sesuai Urutan
            //Di Posisi Terakhir
            list.add("Sendiri");
            cetakList(list);
            
            System.out.println("");
            
            System.out.print("  -> ");
            
            //Menyisipkan List pada Urutan Tertentu
            //List yang Disisipkan menjadi Urutan Selanjutnya
            list.add(2, "Aku");
            
            cetakList(list);
            
            System.out.println("\n");
            
            //==================================================================
            
            System.out.println("  Menambahkan dengan ADDFIRST");
            System.out.print("  -> ");
            
            //Menempatkan List pada Urutan Pertama -> ADDFIRST
            list.addFirst("Mengapa");
            cetakList(list);
            
            System.out.println("\n");
            
            //==================================================================
            
            System.out.println("  Menambahkan dengan ADDLAST");
            System.out.print("  -> ");
            
            //Menempatkan List pada Urutan Terakhir -> ADDLAST
            list.addLast("di Sini");
            cetakList(list);
            
            System.out.println("\n");
            
            //==================================================================
            
            System.out.println("  Mengganti Elemen List dengan SET");
            System.out.print("  -> ");
            
            //Mengganti List -> SET
            list.set(5, "?");
            cetakList(list);
            
            System.out.println("\n");
            
        //======================================================================
            
        System.out.println("Menghapus Elemen pada List");
        System.out.println("");
        
            System.out.println("  Menghapus dengan REMOVE");
            System.out.print("  -> ");
            
            //Menghapus List Sesuai Isi atau Urutan -> REMOVE
            
            //Sesuai Isi
            list.remove("A");
            cetakList(list);
            
            System.out.println("");
            
            //Sesuai Urutan
            list.remove(1);
            System.out.print("  -> ");
            cetakList(list);
            
            System.out.println("\n");
            
            //==================================================================
            
            System.out.println("  Menghapus dengan REMOVEFIRST");
            System.out.print("  -> ");
            
            //Menghapus List pada Urutan Pertama -> REMOVEFIRST
            list.removeFirst();
            cetakList(list);
            
            System.out.println("\n");
            
            //==================================================================
            
            System.out.println("  Menghapus dengan REMOVELAST");
            System.out.print("  -> ");
            
            //Menempatkan Data pada Urutan Terakhir -> REMOVELAST
            list.removeLast();
            cetakList(list);
            
            System.out.println("\n");
            
        //======================================================================
            
        System.out.println("Mengecek Elemen pada List");
        System.out.println("");
        
            System.out.println("  Mengecek Ada Tidaknya List");
            
            //Mengecek Ketersediaan List -> CONTAINS dan ISEMPTY
            System.out.print("  -> ");
            if (list.contains("Aku")) {
                System.out.println("Aku memang Sendiri");
            } else {
                System.out.println("Aku tidak Sendiri");
            }
            System.out.print("  -> ");
            if (list.contains("Dia")) {
                System.out.println("Dia memang Sendiri");
            } else {
                System.out.println("Dia tidak Sendiri");
            }
            System.out.print("  -> ");
            if (list.isEmpty()) {
                System.out.println("List Kosong");
            } else {
                System.out.println("Aku masih Sendiri");
            }
            
            System.out.println("");
        
            //==================================================================
            
            System.out.println("  Mengecek Ukuran Linked List");
            
            //Mengecek Ukuran Linked List -> SIZE
            System.out.print("  -> ");
            cetakList(list);
            System.out.println(" ada " + list.size() + " karakter");
            
            System.out.println("");
            
        //==================================================================
            
        System.out.println("Mencetak Linked List");
        System.out.println("");

            System.out.println("  Mencetak dengan GET");
            
            //Mencetak Menggunakan Indeks -> GET
            System.out.println("  -> Aku masih ... " + list.get(1));
            System.out.println("  -> " + list.get(0) + " ... masih Sendiri");

            System.out.println("");
        
            //==================================================================
            
            System.out.println("  Mencetak dengan GETFIRST");
            
            //Mencetak List pada Urutan Pertama -> GETFIRST
            System.out.println("  -> " + list.getFirst() + " ... masih Sendiri");
            
            System.out.println("");
        
            //==================================================================
            
            System.out.println("  Mencetak dengan GETLAST");
            
            //Mencetak List pada Urutan Terakhir -> GETLAST
            System.out.println("  -> Aku masih ... " + list.getLast());
            
            System.out.println("");
            
    }
    
}
