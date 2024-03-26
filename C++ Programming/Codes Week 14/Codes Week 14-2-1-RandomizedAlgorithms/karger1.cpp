// Algoritma Karger untuk mencari Potongan Minimum dalam sebuah
// graf tak berarah, tak berbobot dan terhubung.
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

// struktur untuk merepresentasikan sisi tak berbobot dalam graf
struct Edge
{
	int src, dest;
};

// sebuah struktur untuk mewakili yang terhubung, tidak terarah
// dan graf tak berbobot sebagai kumpulan sisi.
struct Graph
{
	// V-> Jumlah simpul, E-> Jumlah tepi
	int V, E;

// grafik direpresentasikan sebagai larik sisi.
// Karena graf tidak berarah, maka sisinya
// dari src ke dest juga edge dari dest ke src. 
// Keduanya dihitung sebagai 1 tepi di sini.
	Edge* edge;
};

// Sebuah struktur untuk mewakili subset untuk union-find
struct subset
{
	int parent;
	int rank;
};

// Prototipe fungsi untuk union-find (Fungsi ini didefinisikan
// setelah kargerMinCut() )
int find(struct subset subsets[], int i);
void Union(struct subset subsets[], int x, int y);

// Implementasi yang sangat mendasar dari pengacakan Karger
// algoritma untuk menemukan potongan minimum. Tolong dicatat
// bahwa algoritme Karger adalah algo Acak Monte Carlo
// dan potongan yang dikembalikan oleh algoritme mungkin tidak selalu minimal
int kargerMinCut(struct Graph* graph)
{
	// Dapatkan data dari grafik yang diberikan
	int V = graph->V, E = graph->E;
	Edge *edge = graph->edge;

	// Alokasikan memori untuk membuat subset V.
	struct subset *subsets = new subset[V];

	//Buat himpunan bagian V dengan elemen tunggal
	for (int v = 0; v < V; ++v)
	{
		subsets[v].parent = v;
		subsets[v].rank = 0;
	}

    // Awalnya ada V simpul di
    // grafik terkontrak
	int vertices = V;

	// Pertahankan simpul yang berkontraksi sampai ada 2 simpul.
	while (vertices > 2)
	{
	// Pilih sisi acak
	int i = rand() % E;

	// Temukan simpul (atau himpunan) dari dua sudut
    // dari tepi saat ini
	int subset1 = find(subsets, edge[i].src);
	int subset2 = find(subsets, edge[i].dest);

    // Jika dua sudut termasuk dalam subset yang sama,
    // maka tidak ada gunanya mempertimbangkan tepi ini
	if (subset1 == subset2)
		continue;

	// Jika tidak, kontrakkan tepinya (atau gabungkan
    // sudut-sudut tepi menjadi satu simpul)
	else
	{
		printf("menggabungkan sisi %d-%d\n",
				edge[i].src, edge[i].dest);
		vertices--;
		Union(subsets, subset1, subset2);
	}
	}

	// Sekarang kita memiliki dua simpul (atau himpunan bagian) yang tersisa di
    // graf berkontraksi, jadi hitung sisi antara
    // dua komponen dan mengembalikan hitungan.
	int cutedges = 0;
	for (int i=0; i<E; i++)
	{
		int subset1 = find(subsets, edge[i].src);
		int subset2 = find(subsets, edge[i].dest);
		if (subset1 != subset2)
		cutedges++;
	}

	return cutedges;
}

// Fungsi utilitas untuk menemukan himpunan elemen i
// (menggunakan teknik kompresi jalur)
int find(struct subset subsets[], int i)
{
	// temukan root dan jadikan root sebagai induk dari i
    // (kompresi jalur)
	if (subsets[i].parent != i)
	subsets[i].parent =
			find(subsets, subsets[i].parent);

	return subsets[i].parent;
}

// Fungsi yang melakukan penyatuan dua himpunan x dan y
// (menggunakan serikat berdasarkan peringkat)
void Union(struct subset subsets[], int x, int y)
{
	int xroot = find(subsets, x);
	int yroot = find(subsets, y);

	// Lampirkan pohon peringkat yang lebih kecil di bawah akar tinggi
    // pohon peringkat (Union by Rank)
	if (subsets[xroot].rank < subsets[yroot].rank)
		subsets[xroot].parent = yroot;
	else if (subsets[xroot].rank > subsets[yroot].rank)
		subsets[yroot].parent = xroot;

	// Jika peringkatnya sama, jadikan satu sebagai root dan
    // naikkan peringkatnya satu per satu
	else
	{
		subsets[yroot].parent = xroot;
		subsets[xroot].rank++;
	}
}

// Membuat grafik dengan simpul V dan tepi E
struct Graph* createGraph(int V, int E)
{
	Graph* graph = new Graph;
	graph->V = V;
	graph->E = E;
	graph->edge = new Edge[E];
	return graph;
}

//Program driver untuk menguji fungsi di atas
int main()
{
	/* Mari kita buat grafik tak berbobot berikut:
		0------1
		| \ |
		| \ |
		|	 \|
		2------3 */
	int V = 4; // Jumlah simpul dalam graf
	int E = 5; // Jumlah sisi dalam graf
	struct Graph* graph = createGraph(V, E);

	// tambahkan tepi 0-1
	graph->edge[0].src = 0;
	graph->edge[0].dest = 1;

	// tambahkan tepi 0-2
	graph->edge[1].src = 0;
	graph->edge[1].dest = 2;

	// tambahkan tepi 0-3
	graph->edge[2].src = 0;
	graph->edge[2].dest = 3;

	// tambahkan tepi 1-3
	graph->edge[3].src = 1;
	graph->edge[3].dest = 3;

	// tambahkan tepi 2-3
	graph->edge[4].src = 2;
	graph->edge[4].dest = 3;

	// Gunakan nilai seed yang berbeda untuk setiap proses.
	srand(time(NULL));

	printf("\nPotongan yang ditemukan oleh algoritma acak Karger adalah %d\n",
		kargerMinCut(graph));

	return 0;
}
