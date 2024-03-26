// Program C++ untuk Mengkloning Grafik Tidak Berarah
#include<vector>
#include<string>
#include<iostream>
#include<map>
#include<queue>
using namespace std;

struct GraphNode
{
	int val;

	//Vektor tetangga yang berisi alamat untuk
    //semua tetangga dari GraphNode
	vector<GraphNode*> neighbours;
};

// Fungsi yang mengkloning Grafik dan
// mengembalikan alamat ke kloning
// simpul src
GraphNode *cloneGraph(GraphNode *src)
{
	//Peta untuk melacak semua
    //node yang sudah dibuat
	map<GraphNode*, GraphNode*> m;
	queue<GraphNode*> q;

	// Masukkan simpul src
	q.push(src);
	GraphNode *node;

	// Buat simpul klon
	node = new GraphNode();
	node->val = src->val;

	// Masukkan simpul klon ke dalam Peta
	m[src] = node;
	while (!q.empty())
	{
		//Dapatkan node depan dari antrian
        //dan kemudian mengunjungi semua tetangganya
		GraphNode *u = q.front();
		q.pop();
		vector<GraphNode *> v = u->neighbours;
		int n = v.size();
		for (int i = 0; i < n; i++)
		{
			// Periksa apakah simpul ini telah dibuat
			if (m[v[i]] == NULL)
			{
				// Jika tidak maka buat Node baru dan
                // dimasukkan ke dalam HashMap
				node = new GraphNode();
				node->val = v[i]->val;
				m[v[i]] = node;
				q.push(v[i]);
			}

			// tambahkan tetangga ini ke simpul grafik kloning
			m[u]->neighbours.push_back(m[v[i]]);
		}
	}

	// Mengembalikan alamat dari simpul src yang dikloning
	return m[src];
}

// Bangun grafik yang diinginkan
GraphNode *buildGraph()
{
	/*
		Catatan: Semua tepinya Tidak Berarah
        Diberikan Grafik:
		1--2
		| |
		4--3
	*/
	GraphNode *node1 = new GraphNode();
	node1->val = 1;
	GraphNode *node2 = new GraphNode();
	node2->val = 2;
	GraphNode *node3 = new GraphNode();
	node3->val = 3;
	GraphNode *node4 = new GraphNode();
	node4->val = 4;
	vector<GraphNode *> v;
	v.push_back(node2);
	v.push_back(node4);
	node1->neighbours = v;
	v.clear();
	v.push_back(node1);
	v.push_back(node3);
	node2->neighbours = v;
	v.clear();
	v.push_back(node2);
	v.push_back(node4);
	node3->neighbours = v;
	v.clear();
	v.push_back(node3);
	v.push_back(node1);
	node4->neighbours = v;
	return node1;
}

// Sebuah traversal bfs sederhana dari sebuah graf ke
// periksa kloning grafik yang tepat
void bfs(GraphNode *src)
{
	map<GraphNode*, bool> visit;
	queue<GraphNode*> q;
	q.push(src);
	visit[src] = true;
	while (!q.empty())
	{
		GraphNode *u = q.front();
		cout << "Nilai simpul " << u->val << "\n";
		cout << "Alamat simpul " <<u << "\n";
		q.pop();
		vector<GraphNode *> v = u->neighbours;
		int n = v.size();
		for (int i = 0; i < n; i++)
		{
			if (!visit[v[i]])
			{
				visit[v[i]] = true;
				q.push(v[i]);
			}
		}
	}
	cout << endl;
}

// Program driver untuk menguji fungsi di atas
int main()
{
	GraphNode *src = buildGraph();
	cout << "BFS Traversal sebelum kloning\n";
	bfs(src);
	GraphNode *newsrc = cloneGraph(src);
	cout << "BFS Traversal sesudah kloning\n";
	bfs(newsrc);
	return 0;
}
