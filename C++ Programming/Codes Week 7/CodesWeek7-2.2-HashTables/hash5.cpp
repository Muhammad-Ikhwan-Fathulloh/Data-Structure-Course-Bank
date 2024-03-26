// Program CPP untuk mengimplementasikan hashing dengan chaining
#include<bitset>
#include<stdio.h>
#include<stdlib.h>
#include<ostream>
#include<iostream>
#include<list>
using namespace std;

class Hash
{
	int BUCKET; // No. of buckets

	// Pointer ke array berisi ember
	list<int> *table;
public:
	Hash(int V); // Constructor

	// memasukkan kunci ke tabel hash
	void insertItem(int x);

	// menghapus kunci dari tabel hash
	void deleteItem(int key);

	// fungsi hash untuk memetakan nilai ke kunci
	int hashFunction(int x) {
		return (x % BUCKET);
	}

	void displayHash();
};

Hash::Hash(int b)
{
	this->BUCKET = b;
	table = new list<int>[BUCKET];
}

void Hash::insertItem(int key)
{
	int index = hashFunction(key);
	table[index].push_back(key);
}

void Hash::deleteItem(int key)
{
// dapatkan indeks hash kunci
int index = hashFunction(key);

// temukan kuncinya di (indeks) daftar
list <int> :: iterator i;
for (i = table[index].begin();
		i != table[index].end(); i++) {
	if (*i == key)
	break;
}

// jika kunci ditemukan di tabel hash, hapus itu
if (i != table[index].end())
	table[index].erase(i);
}

// fungsi untuk menampilkan tabel hash
void Hash::displayHash() {
for (int i = 0; i < BUCKET; i++) {
	cout << i;
	for (auto x : table[i])
	cout << " --> " << x;
	cout << endl;
}
}

// Driver program
int main()
{
// array yang berisi kunci yang akan dipetakan
int a[] = {15, 11, 27, 8, 12};
int n = sizeof(a)/sizeof(a[0]);

// masukkan kunci ke dalam tabel hash
Hash h(7); // 7 adalah hitungan ember pada tabel hash
for (int i = 0; i < n; i++)
	h.insertItem(a[i]);

// hapus 12 dari tabel hash
h.deleteItem(12);

// menampilkan table hash
h.displayHash();

return 0;
}
