// C++ implementasi QuickSort
// menggunakan skema partisi Hoare

#include <cstdlib>
#include <iostream>
using namespace std;

// Fungsi ini mengambil elemen terakhir sebagai
// pivot, tempatkan elemen pivot pada
// posisinya yang benar di sortir
// array, dan tempatkan semuanya lebih kecil
// (lebih kecil dari pivot) ke kiri pivot
// dan semua elemen yang lebih besar ke kanan
int partition(int arr[], int low, int high)
{
	int pivot = arr[low];
	int i = low - 1, j = high + 1;

	while (true) {

		// Temukan elemen paling kiri yang lebih besar dari
        // atau sama dengan pivot
		do {
			i++;
		} while (arr[i] < pivot);

		// Temukan elemen paling kanan yang lebih kecil dari
        // atau sama dengan pivot
		do {
			j--;
		} while (arr[j] > pivot);

		// Jika dua pointer bertemu
		if (i >= j)
			return j;

		swap(arr[i], arr[j]);
	}
}

// Menghasilkan Pivot Acak, menukar pivot dengan
// akhiri elemen dan panggil fungsi partisi
// Di partisi Hoare, elemen rendah dipilih
// sebagai poros pertama
int partition_r(int arr[], int low, int high)
{
	// Hasilkan angka acak di antaranya
    // rendah .. tinggi
	srand(time(NULL));
	int random = low + rand() % (high - low);

	// Tukar A[acak] dengan A[tinggi]
	swap(arr[random], arr[low]);

	return partition(arr, low, high);
}

// Fungsi utama yang mengimplementasikan QuickSort
// arr[] --> Array yang akan diurutkan,
// rendah --> Mulai indeks,
// tinggi --> Indeks akhir
void quickSort(int arr[], int low, int high)
{
	if (low < high) {
		// pi adalah indeks partisi,
        // arr[p] sekarang berada di tempat yang tepat
		int pi = partition_r(arr, low, high);

		// Urutkan elemen secara terpisah sebelum
        // partisi dan setelah partisi
		quickSort(arr, low, pi);
		quickSort(arr, pi + 1, high);
	}
}

// Fungsi untuk mencetak array
void printArray(int arr[], int n)
{
	for (int i = 0; i < n; i++)
		printf("%d ", arr[i]);
	printf("\n");
}

// Driver Code
int main()
{
	int arr[] = { 10, 7, 8, 9, 1, 5 };
	int n = sizeof(arr) / sizeof(arr[0]);
	quickSort(arr, 0, n - 1);
	printf("Array yang diurutkan: \n");
	printArray(arr, n);
	return 0;
}
