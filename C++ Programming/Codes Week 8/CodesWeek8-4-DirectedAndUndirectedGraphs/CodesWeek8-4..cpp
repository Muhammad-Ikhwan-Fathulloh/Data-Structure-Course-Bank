// Program C++ untuk mencetak traversal DFS dari
// titik tertentu dalam graf tertentu
#include<map>
#include<iostream>
#include<list>
using namespace std;

// Kelas graf mewakili graf berarah
// menggunakan representasi adjacency list 
class Graph {
public:
	map<int, bool> visited;
	map<int, list<int> > adj;

	// fungsi untuk menambahkan tepi ke grafik
	void addEdge(int v, int w);

	// DFS traversal dari simpul
    // dapat dijangkau dari v
	void DFS(int v);
};

void Graph::addEdge(int v, int w)
{
	adj[v].push_back(w); // menambahkan w ke daftar v
}

void Graph::DFS(int v)
{
	// Tandai simpul saat ini sebagai dikunjungi dan
    // cetak ini
	visited[v] = true;
	cout << v << " ";

	// Berulang untuk semua simpul yang berdekatan
    // ke simpul ini
	list<int>::iterator i;
	for (i = adj[v].begin(); i != adj[v].end(); ++i)
		if (!visited[*i])
			DFS(*i);
}

// Driver code
int main()
{
	// Buat grafik yang diberikan dalam diagram di atas
	Graph g;
	g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(3, 3);

	cout << "Berikut ini adalah Depth First Traversal"
			" (mulai dari simpul 2) \n";
	g.DFS(2);

	return 0;
}


