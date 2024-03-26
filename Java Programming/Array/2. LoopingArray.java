package LoopingArray;

public class LoopingArray {

    public static void main(String[] args) {
        
        System.out.println("");
        
        System.out.println("Array");
        System.out.print("-> ");
        
        //Deklarasi Array
        int[] array_integer = {1, 2, 3, 4, 5, 6, 7};
        
        //Cetak Komponen Array
        System.out.print(array_integer[0] + ", ");
        System.out.print(array_integer[1] + ", ");
        System.out.print(array_integer[2] + ", ");
        System.out.print(array_integer[3] + ", ");
        System.out.print(array_integer[4] + ", ");
        System.out.print(array_integer[5] + ", ");
        System.out.print(array_integer[6] + "\n");  
        
        System.out.println("");
        
        //======================================================================

        System.out.println("Looping Standar");
        
        //Looping Standar -> Menuliskan Jumlah Array secara Manual
        for (int i = 0; i < 7; i++) {
            System.out.println("-> Indeks ke - " + i + " adalah " + array_integer[i]);
        }
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping dengan Properti Array");
        
        //Looping dengan Properti Array -> nama_array.lenght
        System.out.println("Jumlah Komponen Array adalah " + array_integer.length);
        for (int i = 0; i < array_integer.length; i++) {
            System.out.println("-> Indeks ke - " + i + " adalah " + array_integer[i]);
        }
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping tanpa Indeks");
        
        //Looping tanpa Indeks -> for ( tipe_data nama_indeks : nama_array )
        for (int i : array_integer) {
            System.out.println("-> Angka pada looping ini adalah " + i);
        }
        
        System.out.println("");
        
    }
    
}