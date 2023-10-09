package Matriks;

public class Matriks {

    private static void cetakMatriks(int[][] matriks) {
        int baris = matriks.length;
        int kolom = matriks[0].length;
        for (int i = 0; i < baris; i++ ){
            System.out.print("[");
            for (int j = 0; j < kolom; j++) {
                System.out.print(matriks[i][j]);
                if (j < (kolom - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("]");
                }   
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
    
    //==========================================================================
    
    private static void cetakMatriksInvers(double[][] matriks) {
        int baris = matriks.length;
        int kolom = matriks[0].length;
        for (int i = 0; i < baris; i++ ){
            System.out.print("[");
            for (int j = 0; j < kolom; j++) {
                System.out.printf("%.1f",matriks[i][j]);
                if (j < (kolom - 1)) {
                    System.out.print("  ");
                } else {
                    System.out.print("]");
                }   
            }
            System.out.print("\n");
        }
        System.out.println("");
    }
    
    //==========================================================================
    
    public static void main(String[] args) throws Exception {
        
        System.out.println("Matriks A");
        
        int[][] matriks_A = {
            {1, 3, 2, 4},
            {5, 3, 1, 2},
            {1, 1, 2, 4},
            {5, 3, 4, 2}
        };
        
        cetakMatriks(matriks_A);
        
        
        System.out.println("Matriks B");
        
        int[][] matriks_B = {
            {9, 5, 7, 6},
            {5, 6, 7, 8},
            {9, 8, 7, 6},
            {5, 6, 4, 8}
            
        };
        
        cetakMatriks(matriks_B);
        
        System.out.println("Matriks C");
        
        double[][] matriks_C = {
            {2, 2, 1, 1},
            {1, 3, 2, 1},
            {2, 3, 2, 1},
            {2, 1, 1, 1}
        };
        
        cetakMatriksInvers(matriks_C);
        
        //======================================================================
        
        System.out.println("Penjumlahan Matriks (A + B)");
        jumlahMatriks(matriks_A, matriks_B);
        
        //======================================================================
        
        System.out.println("Pengurangan Matriks (B - A)");
        kurangMatriks(matriks_B, matriks_A);
        
        //======================================================================
        
        System.out.println("Perkalian Matriks (B x A)");
        kaliMatriks(matriks_B, matriks_A);
        
        //======================================================================
        
        System.out.println("Invers Matriks C");
        inversMatriks(matriks_C);
        
    }
    
    //==========================================================================
    
    //Penjumlahan Matriks
    private static void jumlahMatriks(int[][] matriks_1, int[][] matriks_2) {
        int baris_1 = matriks_1.length;
        int kolom_1 = matriks_1[0].length;
        
        int baris_2 = matriks_2.length;
        int kolom_2 = matriks_2[0].length;
        
        int[][] jumlah = new int[baris_1][kolom_1];
        
        if (baris_1 == baris_2 && kolom_1 == kolom_2) {
            for (int i = 0; i < baris_1; i++) {
                for (int j = 0; j < kolom_1; j++) {
                    jumlah[i][j] = matriks_1[i][j] + matriks_2[i][j];
                }
            }
            cetakMatriks(jumlah);
        } else {
            System.out.println("Jumlah Baris dan Kolom");
            System.out.println("------Tidak Sama------");
            System.out.println("");
        }
    }
    
    //==========================================================================
    
    //Pengurangan Matriks
    private static void kurangMatriks(int[][] matriks_1, int[][] matriks_2) {
        int baris_1 = matriks_1.length;
        int kolom_1 = matriks_1[0].length;
        
        int baris_2 = matriks_2.length;
        int kolom_2 = matriks_2[0].length;
        
        int[][] kurang = new int[baris_1][kolom_1];
        
        if (baris_1 == baris_2 && kolom_1 == kolom_2) {
            for (int i = 0; i < baris_1; i++) {
                for (int j = 0; j < kolom_1; j++) {
                    kurang[i][j] = matriks_1[i][j] - matriks_2[i][j];
                }
            }
            cetakMatriks(kurang);
        } else {
            System.out.println("Jumlah Baris dan Kolom");
            System.out.println("------Tidak Sama------");
            System.out.println("");
        }
    }
    
    //==========================================================================
    
    //Perkalian Matriks
    private static void kaliMatriks(int[][] matriks_1, int[][] matriks_2) {
        int baris_1 = matriks_1.length;
        int kolom_1 = matriks_1[0].length;
        
        int baris_2 = matriks_2.length;
        int kolom_2 = matriks_2[0].length;
        
        int[][] kali = new int[baris_1][kolom_2];
        
        if (kolom_1 != baris_2) {
            System.out.println("Jumlah Kolom Matrik Pertama");
            System.out.println("  dan Baris Matriks Kedua  ");
            System.out.println("--------Tidak Sama---------");
            System.out.println("");
        } else {
            for (int i = 0; i < baris_1; i++) {
                for (int j = 0; j < kolom_2; j++) {
                    int kali_sementara = 0;
                    for (int k = 0; k < kolom_1; k++) {
                        kali_sementara += matriks_1[i][k] * matriks_2[k][j];
                    }
                    kali[i][j] = kali_sementara;
                }
            }
            cetakMatriks(kali);
        }
    }
    
    //==========================================================================
    
    //Invers Matriks -> Gauss-Jordan Elimination
    private static void inversMatriks(double[][] matriks) {
       
        double[][] matriks_awal = new double[matriks.length][2*matriks.length];
        
        //Matriks Awal
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                matriks_awal[i][j] = matriks[i][j];
            }
            matriks_awal[i][matriks.length+i] = 1;
        }

        //======================================================================
        
        //Matriks Proses
        for (int i = 0; i < matriks_awal.length; i++) {
            double matriks_proses = matriks_awal[i][i];
            for (int j = 0; j < matriks_awal[i].length; j++) {
                matriks_awal[i][j] /= matriks_proses;
            }
            for (int k = i + 1; k < matriks_awal.length; k++) {
                matriks_proses = matriks_awal[k][i];
                for (int j = 0; j < matriks_awal[i].length; j++) {
                    matriks_awal[k][j] -= matriks_proses*matriks_awal[i][j];
                }
            }
        }
        
        for (int i = matriks_awal.length - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                double matriks_proses = matriks_awal[k][i];
                for (int j = 0; j < matriks_awal[i].length; j++) {
                    matriks_awal[k][j] -= matriks_proses*matriks_awal[i][j];
                }
            }
        }
        
        double[][] matriks_akhir = new double[matriks.length][matriks.length];
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks.length; j++) {
                matriks_akhir[i][j] = matriks_awal[i][j+matriks.length];
            }
        }
        
        cetakMatriksInvers(matriks_akhir);
        
    }
    
}