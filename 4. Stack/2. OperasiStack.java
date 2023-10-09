package OperasiStack;

import java.util.Stack;

public class OperasiStack {

    public static void main(String[] args) {
        
        System.out.println("");
        
        //Deklarasi Stack
        Stack<String> Kartu = new Stack<>();
        
        //Memasukkan Item Baru ke Posisi Paling Atas di Stack
        Kartu.push("Jack");
        Kartu.push("Queen");
        Kartu.push("King");
        Kartu.push("Ace");
        
        //======================================================================
        
        //Mencetak Isi Stack
        System.out.println("Stack");
        System.out.println("-> " + Kartu);
        
        System.out.println();
        
            //Menampilkan dan Menghapus Isi Stack yang Paling Atas
            String cardAtTop = Kartu.pop();  
            
            System.out.println(" Stack.pop()" );
            System.out.println(" -> " + cardAtTop + "\n");
            System.out.println(" Sisa Stack");
            System.out.println(" -> " + Kartu);

            System.out.println();
            
            //==================================================================

            //Menampilkan Isi Stack yang Paling Atas
            cardAtTop = Kartu.peek();
            
            System.out.println(" Stack.peek()" );
            System.out.println(" -> " + cardAtTop + "\n");
            System.out.println(" Sisa Stack");
            System.out.println(" -> " + Kartu);
            
            System.out.println();
            
            //==================================================================

            Kartu.push("Ace");
            
            System.out.println(" Stack.push(\"Ace\")\n");
            System.out.println(" Sisa Stack");
            System.out.println(" -> " + Kartu);
            
            System.out.println("");
            
        //======================================================================
                        
        //Mengecek Apakah Stack dalam Keadaan Kosong
        System.out.print("Apakah Stack-nya Kosong? ");

        if(Kartu.isEmpty()) {
            System.out.println("Ya");
        } else {
            System.out.println("Tidak");
        }

        System.out.println("");

        //==================================================================

        //Menampilkan Ukuran Stack
        System.out.println("Berapa Ukuran Stack-nya? " + Kartu.size());

        System.out.println("");

        //==================================================================

        //Mencari Elemen dari Stack
        int position = Kartu.search("Queen");

        if(position != -1) {
            System.out.println("\"Queen\" Berada di Posisi " + position);
        } else {
            System.out.println("Elemen Tidak Ditemukan");
        }

        System.out.println();
        
    }
    
}