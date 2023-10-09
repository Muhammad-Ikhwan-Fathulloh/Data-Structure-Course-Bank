package PengenalanQueue;

import java.util.LinkedList;
import java.util.Queue;

public class PengenalanQueue {

    public static void main(String[] args) {
        
        System.out.println("");
        
        //Deklarasi Antrian
        Queue<String> Antri = new LinkedList<>();
        
        //Menambah Elemen ke dalam Antrian -> add()
        Antri.add("A1");
        Antri.add("A2");
        Antri.add("A3");
        Antri.add("A4");
        Antri.add("A5");
        
        //Mencetak Antrian
        System.out.println("Antrian");
        System.out.println("-> " + Antri);
        System.out.println("");
        
        //Menghapus Elemen Pertama Antrian -> remove()
        String nama = Antri.remove();
        System.out.println("Hapus \"" + nama + "\"");
        System.out.println("-> " + Antri);
        System.out.println("");
        
        //Menghapus Elemen Pertama Antrian -> poll()
        nama =  Antri.poll();
        System.out.println("Hapus \"" + nama + "\"");
        System.out.println("-> " + Antri);
        System.out.println("");
        
    }
    
}