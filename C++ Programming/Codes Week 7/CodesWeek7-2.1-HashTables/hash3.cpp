// Quadratic Probing
#include <bitset>
#include <iostream>

using namespace std;

//Fungsi untuk mencetak array
void printArray(int arr[], int n)
{
	// Iterasi dan cetak array
	for (int i = 0; i < n; i++)
	{
		cout << arr[i] << " ";
	}
}

// fungsi implementasi quadratic probing
void hashing(int table[], int tsize,
			int arr[], int N)
{
	// Iterasi melalui array
	for (int i = 0; i < N; i++)
	{
		// Menghitung nilai hash
		int hv = arr[i] % tsize;

		// Masukkan ke dalam tabel jika tidak ada tabrakan
		if (table[hv] == -1)
			table[hv] = arr[i];
		else
		{
			// jika ada tabrakan
			// iterasi melalui semua
			// kemungkinan nilai kuadrat
			for (int j = 0; j < tsize; j++)
			{
				// menghitung nilai hash yang baru
				int t = (hv + j * j) % tsize;
				if (table[t] == -1)
				{
					// Putuskan loop setelah
					// memasukkan nilai
					// di tabel
					table[t] = arr[i];
					break;
				}
			}
		}
	}
	printArray(table, N);
}

// Driver code
int main()
{
	int arr[] = {50, 700, 76,
				85, 92, 73, 101};
	int N = 7;

	// ukuran hash table
	int L = 7;
	int hash_table[7];

	// inisialisasi hash table
	for (int i = 0; i < L; i++)
	{
		hash_table[i] = -1;
	}

	// Quadratic probing
	hashing(hash_table, L, arr, N);
	return 0;
}
