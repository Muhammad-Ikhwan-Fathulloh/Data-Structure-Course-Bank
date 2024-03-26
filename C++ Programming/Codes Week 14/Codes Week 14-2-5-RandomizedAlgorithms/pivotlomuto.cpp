// Quicksort Skema Lomuto's partition 
#include <cstdlib>
#include <time.h>
#include <iostream>
using namespace std;

// Fungsi ini mengambil elemen terakhir sebagai poros
// elemen pivot pada posisi yang benar
// posisi dalam array yang diurutkan, dan
// menempatkan semua lebih kecil (lebih kecil dari pivot)
// ke kiri pivot dan semuanya lebih besar
// elemen di sebelah kanan pivot
int partition(int arr[], int low, int high)
{
	// pivot
	int pivot = arr[high];

	// Index elemen lebih kecil
	int i = (low - 1);

	for (int j = low; j <= high - 1; j++)
	{
		// jika elemen saat ini lebih kecil atau sama dengan pivot
		
		if (arr[j] <= pivot) {

			// increment indeks elemen lebih kecil
			i++;
			swap(arr[i], arr[j]);
		}
	}
	swap(arr[i + 1], arr[high]);
	return (i + 1);
}

// Menghasilkan Pivot Acak, menukar pivot dengan
// akhiri elemen dan panggil fungsi partisi
int partition_r(int arr[], int low, int high)
{
	//Hasilkan nomor acak di antara rendah... tinggi
	srand(time(NULL));
	int random = low + rand() % (high - low);

	// Tukar A[acak] dengan A[tinggi]
	swap(arr[random], arr[high]);

	return partition(arr, low, high);
}

/* Fungsi utama yang mengimplementasikan
Sortir Cepat
arr[] --> Array yang akan diurutkan,
rendah -> Mulai indeks,
tinggi --> Indeks akhir */
void quickSort(int arr[], int low, int high)
{
	if (low < high) {

		/* pi adalah indeks partisi,
        arr[p] sekarang
        di tempat yang tepat */
		int pi = partition_r(arr, low, high);

		// Urutkan elemen secara terpisah sebelum
        // partisi dan setelah partisi
		quickSort(arr, low, pi - 1);
		quickSort(arr, pi + 1, high);
	}
}

/* fungsi untuk mencetak array */
void printArray(int arr[], int size)
{
	int i;
	for (i = 0; i < size; i++)
		cout<<arr[i]<<" ";
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
