#include <iostream>
#include <vector>
#include <bitset>
using namespace std;
#define MAX_SIZE 10000001ll

class doubleHash {

	int TABLE_SIZE, keysPresent, PRIME;
	vector<int> hashTable;
	bitset<MAX_SIZE> isPrime;

	/* Fpengurapan untuk mengatur saringan Eratosthenes. */
	void __setSieve(){
		isPrime[0] = isPrime[1] = 1;
		for(long long i = 2; i*i <= MAX_SIZE; i++)
			if(isPrime[i] == 0)
				for(long long j = i*i; j <= MAX_SIZE; j += i)
					isPrime[j] = 1;

	}

	int inline hash1(int value){
		return value%TABLE_SIZE;
	}
	
	int inline hash2(int value){	
		return PRIME - (value%PRIME);
	}

	bool inline isFull(){
		return (TABLE_SIZE == keysPresent);
	}

	public:

	doubleHash(int n){
		__setSieve();
		TABLE_SIZE = n;

		/* Temukan bilangan prima terbesar yang lebih kecil dari ukuran tabel hash. */
		PRIME = TABLE_SIZE - 1;
		while(isPrime[PRIME] == 1)
			PRIME--;

		keysPresent = 0;

		/* Isi tabel hash dengan -1 (entri kosong). */
		for(int i = 0; i < TABLE_SIZE; i++)
			hashTable.push_back(-1);
	}

	void __printPrime(long long n){
		for(long long i = 0; i <= n; i++)
			if(isPrime[i] == 0)
				cout<<i<<", ";
		cout<<endl;
	}

	/* Berfungsi untuk memasukkan nilai dalam tabel hash*/
	void insert(int value){

		if(value == -1 || value == -2){
			cout<<("ERROR : -1 and -2 can't be inserted in the table\n");
		}

		if(isFull()){
			cout<<("ERROR : Hash Table Full\n");
			return;
		}
		
		int probe = hash1(value), offset = hash2(value); // in linear probing offset = 1;
		
		while(hashTable[probe] != -1){
			if(-2 == hashTable[probe])				
				break;								 //masukkan di lokasi elemen yang dihapus
			probe = (probe+offset) % TABLE_SIZE;
		}

		hashTable[probe] = value;
		keysPresent += 1;
	}

	void erase(int value){
		/* Kembalikan jika elemen tidak ada */
		if(!search(value))
			return;	
		
		int probe = hash1(value), offset = hash2(value);

		while(hashTable[probe] != -1)
			if(hashTable[probe] == value){
				hashTable[probe] = -2;		 // tandai elemen sebagai dihapus (bukan belum dikunjungi (-1)).
				keysPresent--;
				return;
			}
			else
				probe = (probe + offset) % TABLE_SIZE;

	}

	bool search(int value){
		int probe = hash1(value), offset = hash2(value), initialPos = probe;
		bool firstItr = true;

		while(1){
			if(hashTable[probe] == -1)				 // Hentikan pencarian jika -1 ditemukan.
				break;
			else if(hashTable[probe] == value)		 // Hentikan pencarian setelah menemukan elemen
				return true;
			else if(probe == initialPos && !firstItr) // Hentikan pencarian jika satu traversal lengkap tabel hash selesai.
				return false;
			else
				probe = ((probe + offset) % TABLE_SIZE); // jika tidak ada kasus di atas yang terjadi maka perbarui indeks dan periksa.

			firstItr = false;
		}
		return false;
	}

	/* Berfungsi untuk menampilkan tabel hash. */
	void print(){
		for(int i = 0; i < TABLE_SIZE; i++)
			cout<<hashTable[i]<<", ";
		cout<<"\n";
	}

};

int main(){
	doubleHash myHash(13); // membuat tabel hash kosong berukuran 13

	/* Menyisipkan elemen acak di tabel hash */
	
	int insertions[] = {115, 12, 87, 66, 123},
		n1 = sizeof(insertions)/sizeof(insertions[0]);
	
	for(int i = 0; i < n1; i++)
		myHash.insert(insertions[i]);
	
	cout<< "Status tabel hash setelah penyisipan awal : "; myHash.print();
	

	/*
	** Mencari elemen acak di tabel hash,
** dan mencetaknya jika ditemukan.
	*/
	
	int queries[] = {1, 12, 2, 3, 69, 88, 115},
		n2 = sizeof(queries)/sizeof(queries[0]);
	
	cout<<"\n"<<"Operasi pencarian setelah penyisipan : \n";

	for(int i = 0; i < n2; i++)
		if(myHash.search(queries[i]))
			cout<<queries[i]<<" Sekarang\n";
	

	/* Menghapus elemen acak dari tabel hash. */
	
	int deletions[] = {123, 87, 66},
		n3 = sizeof(deletions)/sizeof(deletions[0]);
	
	for(int i = 0; i < n3; i++)
		myHash.erase(deletions[i]);

	cout<< "Status tabel hash setelah menghapus elemen : "; myHash.print();
	
	return 0;
}
