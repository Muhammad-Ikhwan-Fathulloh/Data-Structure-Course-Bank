public class FindMaximumValueWithoutFunction {
    public static void main(String[] args) {
        int[] array = {78, 95, 62, 105, 87, 91, 72, 88, 64, 90};

        int max = array[0]; // Inisialisasi nilai maksimum dengan elemen pertama.

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; // Jika elemen saat ini lebih besar dari nilai maksimum yang disimpan, perbarui nilai maksimum.
            }
        }

        System.out.println("Nilai maksimum dalam array adalah: " + max);
    }
}
