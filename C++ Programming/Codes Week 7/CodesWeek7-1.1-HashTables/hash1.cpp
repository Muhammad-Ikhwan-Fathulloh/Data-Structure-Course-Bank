#include <iostream>
#include <list>

using namespace std;

class HashTable{
private:
  list<int> *table;
  int total_elements;

  // Fungsi hash untuk menghitung hash untuk suatu nilai:
  int getHash(int key){
    return key % total_elements;
  }

public:
  // Konstruktor untuk membuat tabel hash dengan indeks 'n':
  HashTable(int n){
    total_elements = n;
    table = new list<int>[total_elements];
  }

  // Masukkan data dalam tabel hash:
  void insertElement(int key){
    table[getHash(key)].push_back(key);
  }

  // Menghapus data dalam tabel hash:
  void removeElement(int key){
    int x = getHash(key);

    list<int>::iterator i; 
    for (i = table[x].begin(); i != table[x].end(); i++) { 
      // Periksa apakah iterator menunjuk ke item yang diperlukan:
      if (*i == key) 
        break;
    }

    //Jika item ditemukan dalam daftar, maka hapus:
    if (i != table[x].end()) 
      table[x].erase(i);
  }

  void printAll(){
    // Lintasi setiap indeks:
    for(int i = 0; i < total_elements; i++){
      cout << "Index " << i << ": ";
      // Lintasi daftar pada indeks saat ini:
      for(int j : table[i])
        cout << j << " => ";

      cout << endl;
    }
  }
};

int main() {
  // Buat tabel hash dengan 3 indeks:
  HashTable ht(3);

  // Deklarasikan data yang akan disimpan dalam tabel hash:
  int arr[] = {2, 4, 6, 8, 10};

  // Masukkan seluruh data ke dalam tabel hash:
  for(int i = 0; i < 5; i++)
    ht.insertElement(arr[i]);

  cout << "..:: Tabel Hash ::.." << endl;
  ht.printAll();
  
  ht.removeElement(4);
  cout << endl << "..:: Setelah menghapus 4 ::.." << endl;
  ht.printAll();

  return 0;
}