/*
pada program berikut dilakukan Insertion Sort dengan functional programming
*/

#include<iostream>
using namespace std;

// deklarasi fungsi-fungsi
void insertionSort(int array[], int size);
void cetak(int array[], int size);


// main function berisi driver code
int main()
{
    // array yang belum urut
	int array[] = { 9, 16, -8, 0, 146, -87, 96 };

    //hitung jumlah elemen array
	int num = sizeof(array) / sizeof(array[0]);

    // call fungsi insertionSort untuk mengurutkan array
	insertionSort(array, num);

    // tampilkan array terurut
	cetak(array, num);

	return 0;
}

// fungsi untuk melakukan insertions sort
void insertionSort(int array[], int size)
{
	int i, j;   // i dan j adalah iterator
    int key;    // variabel yang digunakan sebagai key

	for (i = 1; i < size; i++)
	{
		key = array[i];
		j = i - 1;

		/*
		pindahkan elemen array dari indeks 0 sampai i-1 jika lebih besar dari key
		pindahkan 1 posisi ke depan dari posisi sekarang
		*/
		while (j >= 0 && array[j] > key)
		{
			array[j+1] = array[j];
			j = j - 1;
		}
		array[j + 1] = key;
		
	}
}

// fungsi untuk menampilkan array yang sudah urut
void cetak(int array[], int size)
{
	for (int i = 0; i < size; i++)
		cout << array[i] << "\t";
	cout << endl;
}

