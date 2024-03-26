package TriangularArrayLower;

public class TriangularArrayLower {
    public static void main(String[] args) {
        int n = 4;  // Ukuran matriks segitiga bawah

        int[][] lowerTriangle = new int[n][n];

        // Inisialisasi matriks segitiga bawah
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                lowerTriangle[i][j] = i * n + j + 1;
            }
        }

        // Cetak matriks segitiga bawah
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(lowerTriangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
