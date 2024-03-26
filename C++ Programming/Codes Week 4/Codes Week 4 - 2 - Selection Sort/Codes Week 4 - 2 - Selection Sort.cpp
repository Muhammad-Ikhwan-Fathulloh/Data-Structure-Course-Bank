/*
Program berikut merupakan program selection sort 
dengan menerapkan functional programming
*/

#include<iostream>
using namespace std;

// deklarasi fungsi-fungsi 
void swap(int &x, int &y);
void cetak(int *array, int size);
void selectionSort(int *array, int size);


// fungsi main
int main() {

   // num: variabel untuk menyimpan jumlah elemen array
   int num;
   cout << "Masukkan jumlah elemen yang akan diurutkan: ";
   cin >> num;

   // definisikan array untuk menyimpan elemen sebanyak num
   int array[num];  

   // proses input elemen
   cout << "Masukkan elemen:" << endl;
   for(int i = 0; i < num; i++) {
      cin >> array[i];
   }

   // tampilkan array sebelum diurutkan
   cout << "Array sebelum diurutkan: ";
   cetak(array, num);

   // lakukan selection sort dengan memanggil fungsinya
   selectionSort(array, num);

   // tampilkan array setelah diurutkan
   cout << "Array setelah diurutkan: ";
   cetak(array, num);
}


// fungsi untuk Selection Sorting
void selectionSort(int *array, int size) {

   int i, j;   // i dan j adalah iterator
   int i_min;  // i_min adalah indeks i terkecil

   for(i = 0; i < size-1; i++) {
      // dapatkan indeks dari data yang minimum
      i_min = i;   

      for(j = i+1; j < size; j++)
         if(array[j] < array[i_min])
            i_min = j;
         // letakkan di posisi yang tepat dengan swapping
         swap(array[i], array[i_min]);
   }
}

// fungsi unutk menampilkan array
void cetak(int *array, int size) {
    
   for(int i = 0; i<size; i++)
      cout << array[i] << " ";
   cout << endl;

}

//fungsi untuk melakukan swap atau pertukaran nilai variabel x dan y
void swap(int &x, int &y) {      
   int temp;
   temp = x;
   x = y;
   y = temp;
}