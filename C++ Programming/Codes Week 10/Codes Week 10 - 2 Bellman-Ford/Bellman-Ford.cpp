// Program C++ untuk single-source Bellman-Ford
// algoritme shortest path
#include <bits/stdc++.h>

// struktur untuk merepresentasikan weighted edge dalam graf
struct Edge {
	int src, dest, weight;
};

// sebuah struktur untuk mewakili hubungan, terarah dan
// grafik berbobot
struct Graph {
	// V-> Jumlah simpul, E-> Jumlah tepi
	int V, E;

	// merepresentasikan grafik sebagai larik sisi.
	struct Edge* edge;
};

// Membuat graf dengan simpul V dan tepi E
struct Graph* createGraph(int V, int E)
{
	struct Graph* graph = new Graph;
	graph->V = V;
	graph->E = E;
	graph->edge = new Edge[E];
	return graph;
}

// Fungsi utilitas yang digunakan untuk mencetak solusi
void printArr(int dist[], int n)
{
	printf("Jarak Vertex dari Sumber\n");
	for (int i = 0; i < n; ++i)
		printf("%d \t\t %d\n", i, dist[i]);
}

// Fungsi utama yang menemukan jarak terpendek dari sumber
// ke semua vertex lain menggunakan algoritma Bellman-Ford
// dan juga fungsi untuk mendeteksi siklus bobot negatif
void BellmanFord(struct Graph* graph, int src)
{
	int V = graph->V;
	int E = graph->E;
	int dist[V];

	// Langkah 1: Inisialisasi jarak dari src ke yang lainnya
    // dan inisiasi vertex sebagai INFINITE
	for (int i = 0; i < V; i++)
		dist[i] = INT_MAX;
	dist[src] = 0;

	// Langkah 2: Relaksasi semua sisi |V| - 1 kali
    // jalur terpendek serhana dari src ke simpul lain dapat memiliki
    // paling banyak |V| - 1 tepi
	for (int i = 1; i <= V - 1; i++) {
		for (int j = 0; j < E; j++) {
			int u = graph->edge[j].src;
			int v = graph->edge[j].dest;
			int weight = graph->edge[j].weight;
			if (dist[u] != INT_MAX
				&& dist[u] + weight < dist[v])
				dist[v] = dist[u] + weight;
		}
	}

	// Langkah 3: memeriksa siklus berbobot negatif. 
    // Di atas langkah menjamin jarak terpendek jika grafik tidak
    // berisi siklus bobot negatif. Jika kita mendapatkan yang lebih pendek
    // jalan, maka ada siklus.
	for (int i = 0; i < E; i++) {
		int u = graph->edge[i].src;
		int v = graph->edge[i].dest;
		int weight = graph->edge[i].weight;
		if (dist[u] != INT_MAX
			&& dist[u] + weight < dist[v]) {
			printf("Grafik mengandung siklus bobot negatif");
			return; // If negative cycle is detected, simply
					// return
		}
	}

	printArr(dist, V);

	return;
}

// Program utama untuk memanggil semua fungsi di atas
int main()
{
	/* Membuat grafik yang diberikan sesuai dengan contoh */
	int V = 5; // Banyaknya vertex dalam grafik
	int E = 8; // Banyaknya edge pada grafik
	struct Graph* graph = createGraph(V, E);

	// menambahkan tepi A-B yaitu 0-1 (sesuai gambar)
	graph->edge[0].src = 0;
	graph->edge[0].dest = 1;
	graph->edge[0].weight = -1;

    // menambahkan tepi A-C yaitu 0-2 (sesuai gambar)
	graph->edge[1].src = 0;
	graph->edge[1].dest = 2;
	graph->edge[1].weight = 4;

    // menambahkan tepi B-C yaitu 1-2 (sesuai gambar)
	graph->edge[2].src = 1;
	graph->edge[2].dest = 2;
	graph->edge[2].weight = 3;

    // menambahkan tepi B-D yaitu 1-3 (sesuai gambar)
	graph->edge[3].src = 1;
	graph->edge[3].dest = 3;
	graph->edge[3].weight = 2;

    // menambahkan tepi B-E yaitu 1-4 (sesuai gambar)
	// add edge 1-4 (or B-E in above figure)
	graph->edge[4].src = 1;
	graph->edge[4].dest = 4;
	graph->edge[4].weight = 2;

    // menambahkan tepi D-C yaitu 3-2 (sesuai gambar)
	// add edge 3-2 (or D-C in above figure)
	graph->edge[5].src = 3;
	graph->edge[5].dest = 2;
	graph->edge[5].weight = 5;

    // menambahkan tepi D-B yaitu 3-1 (sesuai gambar)
	// add edge 3-1 (or D-B in above figure)
	graph->edge[6].src = 3;
	graph->edge[6].dest = 1;
	graph->edge[6].weight = 1;

    // menambahkan tepi E-D yaitu 4-3 (sesuai gambar)
	// add edge 4-3 (or E-D in above figure)
	graph->edge[7].src = 4;
	graph->edge[7].dest = 3;
	graph->edge[7].weight = -3;

	BellmanFord(graph, 0);

	return 0;
}
