#include <stdlib.h>
#include<iostream>
#include <bitset>
#include <stdio.h>
using namespace std;

// templat tipe generic
template <typename K, typename V>

// Hashnode class
class HashNode {
public:
	V value;
	K key;

	// Constructor hashnode
	HashNode(K key, V value)
	{
		this->value = value;
		this->key = key;
	}
};

// templat tipe generic
template <typename K, typename V>

// Hashmap class
class HashMap {
	// array elemen hash 
	HashNode<K, V>** arr;
	int capacity;
	// ukuran saat ini
	int size;
	// dummy node
	HashNode<K, V>* dummy;

public:
	HashMap()
	{
		// inisial kapasitas array hash
		capacity = 20;
		size = 0;
		arr = new HashNode<K, V>*[capacity];

		// inisialisasi semua element array sebagai NULL
		for (int i = 0; i < capacity; i++)
			arr[i] = NULL;

		// dummy node dengan value dan key -1
		dummy = new HashNode<K, V>(-1, -1);
	}
	// mengimplementasi fungsi hash untuk menemukan index sebuah kunci
	int hashCode(K key)
	{
		return key % capacity;
	}

	// fungsi untuk menambah nilai pasangan kunci
	void insertNode(K key, V value)
	{
		HashNode<K, V>* temp = new HashNode<K, V>(key, value);

		// aplikasi fungsi hash untuk menemukan indeks dari kunci yang diberikan
		int hashIndex = hashCode(key);

		// menemukan ruang kosong berikutnya
		while (arr[hashIndex] != NULL
			&& arr[hashIndex]->key != key
			&& arr[hashIndex]->key != -1) {
			hashIndex++;
			hashIndex %= capacity;
		}

		// jika kode baru dimasukkan
		// tingkatkan ukuran saat ini 
		if (arr[hashIndex] == NULL
			|| arr[hashIndex]->key == -1)
			size++;
		arr[hashIndex] = temp;
	}

	// fungsi untuk menghapus pasangan nilai kunci
	V deleteNode(int key)
	{
		// aplikasikan fungsi hash
		// menemukan indeks untuk kunci yang diberikan
		int hashIndex = hashCode(key);

		// menemukan node dengan kunci yang diberikan
		while (arr[hashIndex] != NULL) {
			// jika node ditemukan
			if (arr[hashIndex]->key == key) {
				HashNode<K, V>* temp = arr[hashIndex];

				// masukkan dummy node disini untuk digunakan lagi
				arr[hashIndex] = dummy;

				// kurangi ukuran
				size--;
				return temp->value;
			}
			hashIndex++;
			hashIndex %= capacity;
		}

		// jika tidak ditemukan mengembalikan null
		return NULL;
	}

	// fungsi untuk mencari nilai dari kunci yang diberikan
	V get(int key)
	{
		// Terapkan fungsi hash untuk menemukan indeks untuk kunci yang diberikan
		int hashIndex = hashCode(key);
		int counter = 0;

		// fmenemukan simpul dengan kunci yang diberikan
		while (arr[hashIndex] != NULL) { // int counter =0; // BUG!

			if (counter++ > capacity) // untuk menghindari infinite loop
				return NULL;

			// jika simpul ditemukan kembalikan nilainya
			if (arr[hashIndex]->key == key)
				return arr[hashIndex]->value;
			hashIndex++;
			hashIndex %= capacity;
		}

		// jika tidak ditemukan kembali null
		return NULL;
	}

	// Kembalikan ukuran saat ini
	int sizeofMap()
	{
		return size;
	}

	// kembali true jika ukuran = 0
	bool isEmpty()
	{
		return size == 0;
	}

	// Berfungsi untuk menampilkan pasangan nilai kunci yang disimpan
	void display()
	{
		for (int i = 0; i < capacity; i++) {
			if (arr[i] != NULL && arr[i]->key != -1)
				cout << "key = " << arr[i]->key
					<< " value = "
					<< arr[i]->value << endl;
		}
	}
};

// Driver 
int main()
{
	HashMap<int, int>* h = new HashMap<int, int>;
	h->insertNode(1, 1);
	h->insertNode(2, 2);
	h->insertNode(2, 3);
	h->display();
	cout << h->sizeofMap() << endl;
	cout << h->deleteNode(2) << endl;
	cout << h->sizeofMap() << endl;
	cout << h->isEmpty() << endl;
	cout << h->get(2);

	return 0;
}
