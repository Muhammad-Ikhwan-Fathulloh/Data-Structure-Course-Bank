package OperasiArrayLanjutan;

import java.util.Arrays;

public class OperasiArrayLanjutan {
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        int[] array_1 = {9, 11, 13, 17, 19, 1, 3, 5, 7, 15};
        int[] array_2 = {8, 18, 20, 10, 12, 14, 2, 4, 6, 16};
        
        System.out.println("Data Awal");
        System.out.println("1 -> " + Arrays.toString(array_1));
        System.out.println("2 -> " + Arrays.toString(array_2));
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Penjumlahan Array");
        int[] array_jumlah = new int[array_1.length];
        
            //Penjumlahan Array
            for (int i = 0; i < array_1.length; i++) {
                array_jumlah[i] = array_1[i] + array_2[i];
            }
            System.out.println("-> " + Arrays.toString(array_jumlah));
            
            System.out.println("");
        
        //======================================================================
        
        System.out.println("Penggabungan Array");
        int[] array_gabung = new int[array_1.length + array_2.length];
        
            //Penggabungan Array
            for (int i = 0; i < array_1.length; i++) {
                array_gabung[i] = array_1[i];
            }
            for (int i = 0; i < array_2.length; i++) {
                array_gabung[i + array_1.length] = array_2[i];
            }
            System.out.println("-> " + Arrays.toString(array_gabung));
            
            System.out.println("");
        
        //======================================================================
        
        System.out.println("Pengurutan Array Terbalik");
                
            System.out.println("");
            
            //Pengurutan Array Biasa
            System.out.println("  Data Diurutkan Biasa");
            Arrays.sort(array_2);
            Arrays.sort(array_1);
            System.out.println("  1 -> " + Arrays.toString(array_2));
            System.out.println("  2 -> " + Arrays.toString(array_1));
            System.out.println("");
            
            //==================================================================
            
            //Pengurutan Array Terbalik 1
            int[] array_turu_1 = Arrays.copyOf(array_1, array_1.length);
            
            System.out.println("  Data Diurutkan Terbalik (Cara 1)");
            for (int i = 0; i < array_1.length; i++) {
                array_1[i] = array_turu_1[(array_turu_1.length - 1) - i];
            }
            
            System.out.print("  ");
            System.out.println("-> " + Arrays.toString(array_1));
            
            System.out.println("");
        
            //==================================================================
            
            //Pengurutan Array Terbalik 2
            int array_turu_2;
            
            System.out.println("  Data Diurutkan Terbalik (Cara 2)");
            for (int i = 0; i < array_2.length/2; i++) {
                array_turu_2 = array_2[i];
                array_2[i] = array_2[(array_2.length - 1) - i];
                array_2[(array_2.length - 1) - i] = array_turu_2;
            }
            
            System.out.print("  ");
            System.out.println("-> " + Arrays.toString(array_2));
            
            System.out.println("");
            
    }
    
}