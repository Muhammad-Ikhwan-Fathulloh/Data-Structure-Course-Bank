// Program C++ rotasi node dan menampilkan AVL Tree
#include<bits/stdc++.h>
using namespace std;

//Sebuah AVL Tree
class Node
{
	public:
	int kunci;
	Node *kiri;
	Node *kanan;
	int tinggi;
};

// Fungsi untuk membandingkan kedua bilangan
// Dan mendapatkan bilangan yang memiliki nilai maksimum
int max(int a, int b);

// Fungsi untuk membaca
// Tinggi dari sebuah pohon
int tinggi(Node *N)
{
	if (N == NULL)
		return 0;
	return N->tinggi;
}

// Fungsi untuk mendapatkan nilai maksimum
// dari dua integer
int max(int a, int b)
{
	return (a > b)? a : b;
}

/* Fungsi pembantu yang mengalokasikan a
simpul baru dengan kunci yang diberikan dan
NULL pointer kiri dan kanan. */
Node* newNode(int kunci)
{
	Node* node = new Node();
	node->kunci = kunci;
	node->kiri = NULL;
	node->kanan = NULL;
	node->tinggi = 1; // pengawalan dari node baru
					  // dimasukkan ke dalam anak pohon
	return(node);
}

// Fungsi utilitas ke kanan
// putar subpohon yang di-root dengan y
// dari diagram yang diberikan di atas.
Node *rotasiKanan(Node *y)
{
	Node *x = y->kiri;
	Node *T2 = x->kanan;

	// Kode untuk rotasi
	x->kanan = y;
	y->kiri = T2;

	// Update tinggi
	y->tinggi = max(tinggi(y->kiri),
					tinggi(y->kanan)) + 1;
	x->tinggi = max(tinggi(x->kiri),
					tinggi(x->kanan)) + 1;

	// Mengembalikan root yang baru
	return x;
}

// Fungsi utilitas ke kiri
// putar subpohon yang di-root dengan x
// dari diagram yang diberikan di atas.
Node *rotasiKiri(Node *x)
{
	Node *y = x->kanan;
	Node *T2 = y->kiri;

	// Kode untuk rotasi
	y->kiri = x;
	x->kanan = T2;

	// Update tinggi
	x->tinggi = max(tinggi(x->kiri),
					tinggi(x->kanan)) + 1;
	y->tinggi = max(tinggi(y->kiri),
					tinggi(y->kanan)) + 1;

	// Mengembalikan root yang baru
	return y;
}

// Mendapatkan faktor keseimbangan dari node N
int getBalance(Node *N)
{
	if (N == NULL)
		return 0;
	return tinggi(N->kiri) - tinggi(N->kanan);
}

// Fungsi rekursif untuk menyisipkan kunci
// di subpohon yang di-root dengan simpul dan
// mengembalikan akar baru dari subpohon.
Node* insert(Node* node, int kunci)
{
	/* 1. Melakukan penyisipan BST normal */
	if (node == NULL)
		return(newNode(kunci));

	if (kunci < node-> kunci)
		node->kiri = insert(node->kiri, kunci);
	else if (kunci > node->kunci)
		node->kanan = insert(node->kanan, kunci);
	else // Kunci yang sama tidak diperbolehkan di BST
		return node;

	/* 2. Memperbarui ketinggian dari node utama (root) */
	node->tinggi = 1 + max(tinggi(node->kiri),
						tinggi(node->kanan));

	/* 3.  Mendapatkan faktor keseimbangan dari root
	untuk memeriksa apakah node root menjadi
	tidak seimbang  */
	int balance = getBalance(node);

	// Jika simpul ini menjadi tidak seimbang, maka
	// ada 4 kasus yang terjadi

	// Left Left Case
	if (balance > 1 && kunci < node->kiri->kunci)
		return rotasiKanan(node);

	// Right Right Case
	if (balance < -1 && kunci > node->kanan->kunci)
		return rotasiKiri(node);

	// Left Right Case
	if (balance > 1 && kunci > node->kiri->kunci)
	{
		node->kiri = rotasiKiri(node->kiri);
		return rotasiKanan(node);
	}

	// Right Left Case
	if (balance < -1 && kunci < node->kanan->kunci)
	{
		node->kanan = rotasiKanan(node->kanan);
		return rotasiKiri(node);
	}

	/* mengembalikan penunjuk node (tidak berubah) */
	return node;
}

// Fungsi utilitas untuk mencetak preorder
// traversal pohon.
// Fungsi ini juga mencetak tinggi
// dari setiap node
void preOrder(Node *root)
{
	if(root != NULL)
	{
		cout << root->kunci << " ";
		preOrder(root->kiri);
		preOrder(root->kanan);
	}
}

// Kode utama yang memanggil fungsi
int main()
{
	Node *root = NULL;
	
	/* Insiasi nodes dari pohon */
	
	root = insert(root, 10);
	root = insert(root, 20);
	root = insert(root, 30);
	root = insert(root, 40);
	root = insert(root, 50);
	root = insert(root, 25);
	
	/* Pohon AVL yang seharusnya tergambarkan
			30
			/ \
			20 40
			/ \  \
		   10 25 50
	*/
	cout << "Lintasan praorder dari "
			"pohon AVL yang dibangun adalah \n";
	preOrder(root);
	
	return 0;
}

// This code is contributed by
// rathbhupendra
