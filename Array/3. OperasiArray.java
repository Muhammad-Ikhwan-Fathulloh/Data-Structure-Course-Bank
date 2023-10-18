package OperasiArray;

import java.util.Arrays;

public class OperasiArray {

    //Fungsi untuk Mencetak Komponen Array
    private static void cetakArray(int[] namaArray) {
        System.out.println("-> " + Arrays.toString(namaArray));
        System.out.println("");
    }
    
    //==========================================================================
    
    //Fungsi untuk Menyetel Ulang Komponen Array
    private static int[] resetArray(int[] namaArray, int panjang) {
        int[] array_reset = new int[panjang];
        namaArray = Arrays.copyOfRange(array_reset, 0, array_reset.length);
        return namaArray;
    }
    
    //==========================================================================
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        System.out.println("Array");
        
        //Deklarasi Array
        int[] array_integer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int panjang = array_integer.length;
        
        cetakArray(array_integer);
        
        //======================================================================

        System.out.println("Menyalin Array");
        
        int[] array_salin = new int[10];
        
            System.out.println("");
        
            System.out.println("  Array Sebelum Disalin");
            System.out.print("  "); 
            cetakArray(array_salin);
            
            //==================================================================
        
            System.out.println("  Menyalin dengan Loop Standar");
            
            //Looping Standar -> Dengan Iterasi
            for (int i = 0; i < array_integer.length; i++) {
                array_salin[i] = array_integer[i];
            }
            System.out.print("  ");
            cetakArray(array_salin);
            
            resetArray(array_salin, panjang);
            
            //==================================================================
            
            System.out.println("  Menyalin dengan CopyOf");
            
            //CopyOf -> Arrays.CopyOf(nama_array, panjang_baru)
            array_salin = Arrays.copyOf(array_integer, 4);
            System.out.print("  ");
            cetakArray(array_salin);
            
            array_salin = Arrays.copyOf(array_integer, 7);
            System.out.print("  ");
            cetakArray(array_salin);
            
            array_salin = Arrays.copyOf(array_integer, array_integer.length);
            System.out.print("  ");
            cetakArray(array_salin);
            
            resetArray(array_salin, panjang);
            
            //==================================================================
        
            System.out.println("  Menyalin dengan CopyOfRange");
            
            //CopyOfRange -> Arrays.copyOfRange(nama_array, titik awal, titik akhir)
            array_salin = Arrays.copyOfRange(array_integer, 0, array_integer.length);
            System.out.print("  ");
            cetakArray(array_salin);
            
            array_salin = Arrays.copyOfRange(array_integer, 2, 8);
            System.out.print("  ");
            cetakArray(array_salin);
            
            array_salin = Arrays.copyOfRange(array_integer, 5, 7);
            System.out.print("  ");
            cetakArray(array_salin);
           
            resetArray(array_salin, panjang);
            
            //==================================================================
            
            System.out.println("  Menyalin dengan Fill Array");
            
            //Fill Array -> Untuk Komponen yang Banyak dan Sama Semua
            System.out.print("  ");
            Arrays.fill(array_salin, 2);
            cetakArray(array_salin);
            
            System.out.print("  ");
            Arrays.fill(array_salin, 5);
            cetakArray(array_salin);
            
            System.out.print("  ");
            Arrays.fill(array_salin, 7);
            cetakArray(array_salin);
            
            resetArray(array_salin, panjang);
            
        //======================================================================
            
        System.out.println("Perbandingan Array");
            
        int[] array_banding = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        System.out.println("");

            System.out.println("  Array yang Akan Dibandingkan");

            System.out.print("  1 ");
            cetakArray(array_integer);

            System.out.print("  2 ");
            cetakArray(array_salin);

            System.out.print("  3 ");
            cetakArray(array_banding);
            
            //==================================================================
        
            System.out.println("  Membandingkan Kesamaan Array");
            
            //Kesamaan Array -> Arrays.equals(nama_array1, nama_array2)
            System.out.print("  1 dan 3");
            if (Arrays.equals(array_integer, array_banding)) {
                System.out.println(" -> Kedua Array Sama");
            } else {
                System.out.println(" -> Kedua Array Berbeda");
            }
            
            System.out.print("  2 dan 3");
            if (Arrays.equals(array_salin, array_banding)) {
                System.out.println(" -> Kedua Array Sama");
            } else {
                System.out.println(" -> Kedua Array Berbeda");
            }
        
            System.out.println("");
            
        //======================================================================
        
        System.out.println("Pengurutan Array");
        
        int[] array_acak = {4, 6, 34, 12, 56, 34, 89, 35};
        
            System.out.println("");
            
            System.out.println("  Array yang Belum Urut");
            System.out.print("  "); 
            cetakArray(array_acak);
            
            //==================================================================
            
            System.out.println("  Array yang Sudah Urut");
            
            System.out.print("  ");
            
            //Pengurutan Array -> Arrays.sort(nama_array)
            Arrays.sort(array_acak);
            int[] array_urut = array_acak;
            cetakArray(array_urut);
            
        //======================================================================
            
        System.out.println("Pencarian Array");
            
        int[] array_cari = array_urut;
            
            System.out.println("");
            
            System.out.println("  Array yang Akan Dicari Komponennya");
            System.out.print("  "); 
            Arrays.sort(array_cari);
            cetakArray(array_cari);
            
            int komponen = 34;
            int letak = Arrays.binarySearch(array_cari, komponen);
            
            System.out.println("  Data " + komponen + " terlerak di indeks ke " + letak);
            
            System.out.println("");
            
    }
    
}