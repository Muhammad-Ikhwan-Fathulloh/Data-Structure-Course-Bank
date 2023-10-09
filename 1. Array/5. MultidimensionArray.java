package MultidimensionArray;

import java.util.Arrays;

public class MultidimensionArray {
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        //Array Satu Dimensi
        System.out.print("Array Satu Dimensi" + "\n" + "-> ");
        int[] array_1D = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(array_1D) + "\n");
        
        //======================================================================
        
        System.out.print("Array Dua Dimensi" + "\n" + "-> ");
        
        //Array Dua Dimensi
        int[][] array_2D = { 
            {1, 2, 3}, 
            {6, 7, 8} 
        };
        
        //Mencetak dengan DeepToString
        System.out.println(Arrays.deepToString(array_2D) + "\n");
        
        //======================================================================
        
        System.out.println("Deklarasi Array Dua Dimensi");
         
        //Deklarasi Array Dua Dimensi
        //jenis_data[][] nama_array = new jenis_data[baris][kolom]
        int[][] array_2D_Angka = new int[4][4];
        array_2D_Angka[0][0] = 2;
        array_2D_Angka[0][2] = 4;
        array_2D_Angka[1][0] = 7;
        array_2D_Angka[3][0] = 5;
        array_2D_Angka[1][3] = 8;
        array_2D_Angka[2][1] = 1;
        array_2D_Angka[0][3] = 0;
        array_2D_Angka[2][0] = 9;
        array_2D_Angka[1][1] = 3;
        
        //Mencetak dengan Looping
        for (int[] komponen : array_2D_Angka) {
            System.out.println(Arrays.toString(komponen));
        }
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping secara Manual");
        
        //Looping Manual
        for (int i = 0; i < array_2D_Angka.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array_2D_Angka[i].length - 1; j++) {
                System.out.print(array_2D_Angka[i][j] + ", ");
            }
            for (int j = 0; j < 1; j++) {
                System.out.print(array_2D_Angka[i][array_2D_Angka[i].length - 1]);
            }
            System.out.println("]");
        }
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping dengan ForEach");
        
        //Looping ForEach
        for (int[] baris : array_2D_Angka) {
            System.out.println(Arrays.toString(baris));
        }
        
        System.out.println("");
        
    }
    
}