#include <bits/stdc++.h>
using namespace std;

// Mendefinisikan jumlah vertex yang ada pada graf
#define V 5

// Fungsi untuk mencari vertex dengan nilai paling kecil dari keseluruhan vertex yang belum masuk pada MST
int minKey(int key[], bool mstSet[])
{
	// Inisialisas nilai terkecil
	// INT_MAX merupakan nilai integer paling tinggi yang dapat disimpan. 
	// Mengapa nilai 'min' justru diinisialisasi dengan nilai paling besar yang mungkin?
	int min = INT_MAX, min_index; 

	for (int v = 0; v < V; v++)
		if (mstSet[v] == false && key[v] < min)
			min = key[v], min_index = v;

	return min_index;
}

// Fungsi untuk mencetak MST yang terbentuk
void printMST(int parent[], int graph[V][V])
{
	cout<<"Edge \tWeight\n";
	for (int i = 1; i < V; i++)
		cout<<parent[i]<<" - "<<i<<" \t"<<graph[i][parent[i]]<<" \n";
}

// Fungsi untuk membentuk dan mencetak MST dari graf adjacency matrix
void primMST(int graph[V][V])
{
	// Array untuk menyimpan MST
	int parent[V];
	
	// Key values untuk memilih edge terkecil
	int key[V];
	
	// Kumpulan vertex pada MST
	bool mstSet[V];

	// Inisialisasi semua nilai awal dengan nilai infinite
	for (int i = 0; i < V; i++)
		key[i] = INT_MAX, mstSet[i] = false;

	// Memastikan bahwa vertex pertama ada pada MST dan index 0 dipilih sebagai vertex pertama
	key[0] = 0;
	parent[0] = -1; // First node is always root of MST

	// Looping untuk seluruh vertex
	for (int count = 0; count < V - 1; count++)
	{
		// Memilih vertex dengan nilai paling kecil dari kumpulan vertex yang belum ada pada MST
		int u = minKey(key, mstSet);

		// Memasukkan vertex pada index yang terpilih pada MST
		mstSet[u] = true;
		
		// Memperbaharui key value untuk vertex yang ada pada MST
		for (int v = 0; v < V; v++)

			// graph[u][v] bernilai tidka nol untuk vertex yang berdekatan dengan 'm'
			// mstSet[v] bernilai false untuk vertex yang belum ada pada MST
			// Memperbaharui nilai dari dari graph[u][v] ketika nilainya lebih kecil dari key[v]
			if (graph[u][v] && mstSet[v] == false && graph[u][v] < key[v])
				parent[v] = u, key[v] = graph[u][v];
	}

	// Cetak hasil graf yang terbentuk
	printMST(parent, graph);
}

// Driver code
int main()
{
	// Membentuk adjacency matrix
	int graph[V][V] = { { 0, 2, 0, 6, 0 },
						{ 2, 0, 3, 8, 5 },
						{ 0, 3, 0, 0, 7 },
						{ 6, 8, 0, 0, 9 },
						{ 0, 5, 7, 9, 0 } };

	// Cetak Hasil
	primMST(graph);

	return 0;
}
