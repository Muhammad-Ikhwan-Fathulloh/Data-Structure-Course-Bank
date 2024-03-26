/*
pada program berikut dilakukan quick sort dengan functional programming
*/

#include <iostream>
using namespace std;

// deklarasi fungsi-fungsi
void quickSort(int array[], int p, int r);
int partition(int array[], int p, int r);
void swap(int *x, int *y);
void cetak(int array[], int size);


// Main function yang berisi driver code
int main() {

    int data[] = {99, 0, 5, 76, 32, 21, -87, -21, 66};    // array belum terurut
    int size = sizeof(data) / sizeof(data[0]);            //hitung panjang array
    
    // tampilkan array yang belum urut
    cout << "Array belum terurut: \n";
    cetak(data, size);
    
    // call fungsi quickSort untuk melakukan pengurutan
    quickSort(data, 0, size - 1);
    
    // tampilkan hasil array yang sudah urut
    cout << "Array terurut: \n";
    cetak(data, size);

}


// fungsi untuk menukar (swap) posisi elemen
void swap(int *x, int *y) {
  int temp = *x;
  *x = *y;
  *y = temp;
}


// fungsi untuk menampilkan isi array
void cetak(int array[], int size) {

    for (int i = 0; i < size; i++)
        cout << array[i] << "\t";
    cout << endl;

}


// fungsi untuk menemukan titik partition 
int partition(int array[], int p, int r) {

    // NOTE:
    // p: elemen awal dari array
    // r: elemen akhir dari array
    
    // pada program ini, elemen paling kanan dipilih sebagai pivot
    // elemen pivot juga dapat dipilih dengan metode lainnya
    int pivot = array[r];
    
    // pointer untuk elemen yang lebih besar
    int i = (p - 1);

    // traverse tiap elemen dari array
    // bandingkan dengan elemen pivot
    for (int j = p; j < r; j++) {

        if (array[j] <= pivot) {
        /*
        Jika elemen tersebut < pivot, swap dengan elemen yang lebih besar 
        (yang ditunjuk oleh i)
        */
        i++;

        // swap elemen pada indeks i dengan elemen pada indeks j
        swap(&array[i], &array[j]);
        }
        
    }

    // swap pivot dengan elemen yang lebih besar pada indeks i
    swap(&array[i + 1], &array[r]);
    
    // return poin partition
    return (i + 1);

}


// fungsi untuk melakukan quick sort
void quickSort(int array[], int p, int r) {

  if (p < r) {
      
    /*
    temukan elemen pivot sehingga:
    - elemen yang < pivot berada di kiri pivot
    - elemen yang > pivot berada di kanan pivot
    */
    int q = partition(array, p, r);

    // call fungsi quickSort secara rekursif untuk bagian kiri pivot
    quickSort(array, p, q - 1);

    // call fungsi quickSort secara rekursif untuk bagian kanan pivot
    quickSort(array, q + 1, r);
    
  }

}

