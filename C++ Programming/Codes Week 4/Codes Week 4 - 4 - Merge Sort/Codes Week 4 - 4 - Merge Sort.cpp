/*
pada program berikut dilakukan merge sort dengan functional programming
*/

#include <iostream>
using namespace std;

void merge(int array[], int p, int q, int r);
void mergeSort(int array[], int p, int r);
void cetak(int array[], int size);


// Main function berisi driver dari program
int main() {

    int array[] = {6, 1, -9, 87, 32, 24, 16, 0, 101};           // array belum terurut
    int size = sizeof(array) / sizeof(array[0]);    //hitung panjang array

    mergeSort(array, 0, size - 1);      // call fungsi mergeSort

    // cetak hasil array yang urut
    cout << "Array terurut:" << endl;         
    cetak(array, size);

    return 0;
}


// fungsi mergeSort
// bagi array menjadi 2 sub-array, lakukan sorting (pengurutan), lalu merge (gabungkan)
void mergeSort(int array[], int p, int r) {

  if (p < r) {

    // q adalah titik dimana array dibagi menajdi 2 sub-array (titik tengah/middle)
    int q = p + (r - p) / 2;

    // call fungsi mergeSort (rekursif)
    mergeSort(array, p, q);
    mergeSort(array, q + 1, r);

    // merge sub-array yang sudah terurut dengan call fungsi merge
    merge(array, p, q, r);

  }
}


/*
fungsi merge untuk menggabungkan 2 sub-array L dan R ke dalam variabel array
*/
void merge(int array[], int p, int q, int r) {
  
    // L (Left): array dari indeks p (awal) sampai q (tengah)
    // R (Right): array dari indeks q+1 (tengah) sampai r (akhir)

    int n1 = q - p + 1;     // n1: jumlah elemen array L
    int n2 = r - q;         // n2: jumlah elemen array R

    int L[n1], R[n2];       // deklarasikan array L dan R dengan ukuran n1 dan n2

    // isi array L dan R
    for (int i = 0; i < n1; i++)
        L[i] = array[p + i];
    for (int j = 0; j < n2; j++)
        R[j] = array[q + 1 + j];

    // Maintain indeks terkini dari kedua sub-array dan array utama
    int i = 0, 
        j = 0, 
        k = p;


    /*
    sampai menyentuh akhir dari array L atau R, ambil elemen terbesar di antara array L dan R.
    letakkan di posisi yang benar dalam array utama.
    */
    while (i < n1 && j < n2) {

        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        } 
        else {
            array[k] = R[j];
            j++;
        }

        k++;
    }

    /*
    Saat elemen di salah satu array L atau R sudah habis, 
    ambil sisa elemen di array yang masih berisi,
    lalu, letakkan di dalam array utama.
    *note: array utama = variabel array[]
    */
    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }
}

// fungsi untuk mencetak array
void cetak(int array[], int size) {
    for (int i = 0; i < size; i++)
        cout << array[i] << "\t";
    cout << endl;
}