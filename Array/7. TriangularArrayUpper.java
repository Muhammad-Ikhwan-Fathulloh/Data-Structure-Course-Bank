package TriangularArrayUpper;

public class TriangularArrayUpper {
    public static void main(String[] args) {
        int n = 4;  // Ukuran matriks segitiga atas

        int[][] upperTriangle = new int[n][n];

        // Inisialisasi matriks segitiga atas
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                upperTriangle[i][j] = i * n + j + 1;
            }
        }

        // Cetak matriks segitiga atas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(upperTriangle[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

