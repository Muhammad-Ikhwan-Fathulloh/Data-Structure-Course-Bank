/* 
program untuk merepresentasikan symbol table dengan konsep hashing with separate chaining

	- separate chaining dilakukan untuk mengatasi collision (tabrakan) 
	yang mungkin terjadi pada hash table.
*/

#include <iostream>
using namespace std;

const int MAX = 200;


// awal sebuah class untuk representasi node
class Node {

	// deklarasi variabel-variabel
	string identifier, scope, tipe;
	int barisKe;

	Node *next;		// deklarasi pointer ke class Node

public:

	// constructor class Node dengan 0 argument
	Node()
	{
		next = NULL;
	}

	// constructor class Node dengan 3 argument
	/*
	- key dari suatu symbol adalah suatu identifier dalam program 
	*/
	Node(string key, string value, string tipe, int barisKe)
	{
		this->identifier = key;
		this->scope = value;
		this->tipe = tipe;
		this->barisKe = barisKe;
		next = NULL;
	}

	// fungsi untuk menampilkan hasil di console
	void show()
	{
		cout << "Nama identifier:" << identifier << endl;
		cout << "Scope:" << scope << endl;
		cout << "Tipe:" << tipe << endl;
		cout << "Baris ke:" << barisKe << endl;
	}

	/*
	--- Deklarasi friend class bernama SymbolTable --- 
	- Jika SymbolTable dideklarasikan sebagai friend class di dalam class Node, 
	maka program dapat mengakses seluruh anggota dari class Node dari dalam class SymbolTable
	*/ 
	friend class SymbolTable;

};
// akhir class Node



// awal class SymbolTable
class SymbolTable {


	Node* head[MAX];

public:

	// constructor class SymbolTable
	SymbolTable()
	{
		for (int i = 0; i < MAX; i++)
			head[i] = NULL;
	}
	
	// Deklarasi fungsi-fungsi yang merupakan operasi-operasi pada symbol table

	// hash function
	int hashFunc(string id); 

	// fungsi search
	string search(string id);

	// fungsi delete
	bool deleteItem(string id);
	
	// insert function
	bool insert(string id, string scope, string Tipe, int barisKe);

	// fungsi modify
	bool modify(string id, string scope, string Tipe, int barisKe);

};
// akhir class SymbolTable



// Definisi dari fungsi-fungsi pada class SymbolTable

// hash function untuk konversi indeks
int SymbolTable::hashFunc(string id)
{
	int ascii_sum = 0;

	for (int i = 0; i < id.length(); i++) {
		ascii_sum = ascii_sum + id[i];
	}

	return (ascii_sum % 100);
}


// Function to search an identifier
string SymbolTable::search(string id)
{
	// cari index dengan pass id ke hash function
	int index = hashFunc(id);
	Node* start = head[index];

	// jika start bernilai null
	if (start == NULL)
		return "-1";

	// jika start tidak null
	while (start != NULL) {

		if (start->identifier == id) {
			start->show();
			return start->scope;
		}

		start = start->next;
	}

	return "-1"; // jika tidak ditemukan
}


// Fungsi untuk menghapus identifier
bool SymbolTable::deleteItem(string id)
{
	// cari index dengan pass id ke hash function
	int index = hashFunc(id);
	Node* tmp = head[index];
	Node* par = head[index];

	// jika tidak ada identifier pada indeks tersebut
	if (tmp == NULL) {
		return false;
	}

	// jika hanya ada 1 identifier
	if (tmp -> identifier == id && tmp->next == NULL) {
		tmp -> next = NULL;
		delete tmp;

		return true;
	}

	while (tmp->identifier != id && tmp->next != NULL) {
		par = tmp;
		tmp = tmp->next;
	}

	if (tmp->identifier == id && tmp->next != NULL) {
		par->next = tmp->next;
		tmp->next = NULL;
		delete tmp;

		return true;
	}

	// delete at the end
	else {
		par->next = NULL;
		tmp->next = NULL;
		delete tmp;
		return true;
	}

	return false;
}



// Function to insert an identifier
bool SymbolTable::insert(string id, string scope, string tipe, int barisKe)
{
	// cari index dengan pass id ke hash function
	int index = hashFunc(id);
	Node* p = new Node(id, scope, tipe, barisKe);

	if (head[index] == NULL) {
		head[index] = p;
		cout << "\n" << id << " inserted";

		return true;

	}

	else {
		Node* start = head[index];
		while (start->next != NULL)
			start = start->next;

		start->next = p;
		cout << "\n"
			<< id << " inserted";

		return true;
	}

	return false;
}


// fungsi untuk memodifiaksi sebuah symbol/identifier
bool SymbolTable::modify(string id, string scope, string tipe, int barisKe)
{
	// cari index dengan pass id ke hash function
	int index = hashFunc(id);
	Node* start = head[index];

	if (start == NULL)
		return "-1";

	while (start != NULL) {
		if (start->identifier == id) {
			start->tipe = tipe;
			start->scope = scope;
			start->barisKe = barisKe;

			return true;
		}
		start = start->next;
	}

	return false; // id not found
}



/* main function berisi driver code 
berupa representasi operasi-operasi pada symbol table 
*/
int main()
{
	SymbolTable st;
	string check;

	// Jika keyword/identifier 'int' dimasukkan/di-insert
	if (st.insert("int", "local", "keyword", 4))
		cout << " -sukses";
	else
		cout << "\nGagal meng-insert.\n";

	// Jika keyword/identifier 'animal' dimasukkan/di-insert
	if (st.insert("animal", "global", "variable", 2))
		cout << " -sukses\n\n";
	else
		cout << "\nGagal meng-insert\n";

	// Jika keyword/identifier 'int' dicari/di-search
	check = st.search("int");
	if (check != "-1")
		cout << "\nIdentifier int masih ada\n";
	else
		cout << "\nIdentifier int sudah tidak ada\n";

	// Jika keyword/identifier 'int' dihapus/di-delete
	if (st.deleteItem("int"))
		cout << "\nIdentifier int dihapus\n";
	else
		cout << "\nGagal menghapus\n";

	// Jika keyword/identifier 'animal' dimodifikasi
	if (st.modify("animal", "global", "variable", 3))
		cout << "\nIdentifier animal telah di-update\n\n";

	// search dan print 'animal'
	// Jika keyword/identifier 'animal' dicari/di-search dan ditampilkan
	check = st.search("animal");
	if (check != "-1")
		cout << "\nIdentifier animal masih ada\n";
	else
		cout << "\nIdentifier animal sudah tidak ada";

	// Jika keyword/identifier 'countTax' dimasukkan/di-insert
	if (st.insert("countTax", "local", "function", 7))
		cout << " -sukses\n\n";
	else
		cout << "\nGagal meng-insert.\n";

	// search dan print 'countTax'
	// Jika keyword/identifier 'countTax' dicari/di-search dan ditampilkan
	check = st.search("countTax");
	if (check != "-1")
		cout << "\nIdentifier countTax masih ada\n";
	else
		cout << "\nIdentifier countTax sudah tidak ada";


	return 0;

}
