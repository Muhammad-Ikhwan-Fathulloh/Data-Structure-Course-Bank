// CPP Program to implement merge sort using
// multi-threading
#include <iostream>
#include <thread>
#include <time.h>

// jumlah elemen array
#define MAX 20

// jumlah threads
#define THREAD_MAX 4

using namespace std;

// array dari size MAX
int a[MAX];
int part = 0;

// fungsi untuk menggabungkan dua bagian
void merge(int low, int mid, int high)
{
	int* left = new int[mid - low + 1];
	int* right = new int[high - mid];

	// n1 ukuran bagian kiri dan n2 ukuran bagian kanan
	int n1 = mid - low + 1, n2 = high - mid, i, j;

	// menyimpan nilai di bagian kiri
	for (i = 0; i < n1; i++)
		left[i] = a[i + low];

	// menyimpan nilai di bagian kanan
	for (i = 0; i < n2; i++)
		right[i] = a[i + mid + 1];

	int k = low;
	i = j = 0;

	//menggabungkan kiri dan kanan  dalam urutan naik
	while (i < n1 && j < n2) {
		if (left[i] <= right[j])
			a[k++] = left[i++];
		else
			a[k++] = right[j++];
	}

	// masukkan nilai yang tersisa dari kiri
	while (i < n1) {
		a[k++] = left[i++];
	}

	// masukkan nilai yang tersisa dari kanan
	while (j < n2) {
		a[k++] = right[j++];
	}
}

//fungsi merge sort
void merge_sort(int low, int high)
{
	// menghitung titik tengah dari array
	int mid = low + (high - low) / 2;
	if (low < high) {

		// memanggil setengah pertama
		merge_sort(low, mid);

		// memanggil setengah kedua
		merge_sort(mid + 1, high);

		// menggabungkan keduanya
		merge(low, mid, high);
	}
}

// fungsi multithreading
void* merge_sort(void* arg)
{
	// bagian dari 4 bagian
	int thread_part = part++;

	// mengitung nilai terendah dan tertinggi
	int low = thread_part * (MAX / 4);
	int high = (thread_part + 1) * (MAX / 4) - 1;

	// mengevaluasi titik tengah
	int mid = low + (high - low) / 2;
	if (low < high) {
		merge_sort(low, mid);
		merge_sort(mid + 1, high);
		merge(low, mid, high);
	}
}

// Driver Code
int main()
{
	// menghasilkan nilai acak dalam array
	for (int i = 0; i < MAX; i++)
		a[i] = rand() % 100;

	// t1 and t2 untuk menghitung waktu
	clock_t t1, t2;

	t1 = clock();
	pthread_t threads[THREAD_MAX];

	// membuat 4 threads
	for (int i = 0; i < THREAD_MAX; i++)
		pthread_create(&threads[i], NULL, merge_sort,
										(void*)NULL);

	// menggabungkan  4 threads
	for (int i = 0; i < 4; i++)
		pthread_join(threads[i], NULL);

	// akhir daru gabungan 4 bagian
	merge(0, (MAX / 2 - 1) / 2, MAX / 2 - 1);
	merge(MAX / 2, MAX/2 + (MAX-1-MAX/2)/2, MAX - 1);
	merge(0, (MAX - 1)/2, MAX - 1);

	t2 = clock();

	// menampilkan array yang sudah diurutkan
	cout << "Urutan array: ";
	for (int i = 0; i < MAX; i++)
		cout << a[i] << " ";

	// time taken by merge sort in seconds
	cout << "Waktu yang dibutuhkan: " << (t2 - t1) /
			(double)CLOCKS_PER_SEC << endl;

	return 0;
}
