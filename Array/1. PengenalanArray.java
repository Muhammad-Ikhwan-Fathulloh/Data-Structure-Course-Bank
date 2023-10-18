package PengenalanArray;

import java.util.Arrays;

public class PengenalanArray {

    public static void main(String[] args) {
        
        System.out.println("");
        
        System.out.println("Array");
        
        System.out.println(
            "-> Array merupakan kumpulan data \n" +
            "   yang memiliki tipe data yang sama.\n" +
            "   tiap data tersebut di bedakan \n" +
            "   dengan index dalam array tersebut, \n" +
            "   index dari tiap array dimulai \n" +
            "   dari [0]. Jadi jika kita memiliki \n" +
            "   10 data dalam sebuah array, \n" +
            "   maka jumlah array maksimalnya 9 \n" +
            "   (itu karena index array \n" +
            "   di hitung dari 0). Kenapa Array ?\n" +
            "   Array digunakan untuk mengurangi \n" +
            "   jumlah penggunaan variabel dalam \n" +
            "   aplikasi kita. dan array terdiri \n" +
            "   dari satu dimensi, dua, tiga \n" +
            "   dimensi dan seterusnya tergantung \n" +
            "   kebutuhan.\n"
        );
        
        //======================================================================
        
        System.out.println("Contoh Array");
        System.out.print("-> ");
        
        //Array -> tipe_data[] nama_array = {komponen_array, komponen_array, ...}
        int[] array_integer = {1, 2, 3, 4};
        
        //Indeks Array ------> 0  1  2  3
        
        //Cetak Komponen Array -> nama_array[indeks]           
        System.out.print(array_integer[0] + ",");
        System.out.print(array_integer[1] + ",");
        System.out.print(array_integer[2] + ",");
        System.out.print(array_integer[3] + "\n");   
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Deklarasi Array");
        System.out.print("-> ");
        
        //Deklarasi Array -> tipe_data[] nama_array = new tipe_data[jumlah_array]
        float[] array_float = new float[4];
        
        //Mengisi Komponen Array -> nama_array[indeks] = komponen_array
        array_float[0] = 4;
        array_float[1] = 5;
        array_float[2] = 6;
        array_float[3] = 7;
        
        //Cetak Komponen Array -> nama_array[indeks]           
        System.out.print(array_float[0] + ",");
        System.out.print(array_float[1] + ",");
        System.out.print(array_float[2] + ",");
        System.out.print(array_float[3] + "\n");
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Cetak Array dengan java.util");
        
        //Import java.util.Arrays
        
        //Cara Mencetak Komponen Array ke String -> Arrays.toString(nama_array)
        System.out.println("-> " + Arrays.toString(array_integer));
        System.out.println("-> " + Arrays.toString(array_float));
        
        System.out.println("");
        
    }
    
}