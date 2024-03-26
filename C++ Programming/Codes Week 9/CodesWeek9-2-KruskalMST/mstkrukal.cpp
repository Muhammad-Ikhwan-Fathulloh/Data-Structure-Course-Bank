#include<vector>
#include<iostream>
#include <algorithm>
using namespace std;
// DSU struktur data
// path compression + rank by union

class DSU {
	int* parent;
	int* rank;

public:
	DSU(int n)
	{
		parent = new int[n];
		rank = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = -1;
			rank[i] = 1;
		}
	}

	// fungsi Find
	int find(int i)
	{
		if (parent[i] == -1)
			return i;

		return parent[i] = find(parent[i]);
	}
	// fungsi union
	void unite(int x, int y)
	{
		int s1 = find(x);
		int s2 = find(y);

		if (s1 != s2) {
			if (rank[s1] < rank[s2]) {
				parent[s1] = s2;
				rank[s2] += rank[s1];
			}
			else {
				parent[s2] = s1;
				rank[s1] += rank[s2];
			}
		}
	}
};

class Graph {
	vector<vector<int> > edgelist;
	int V;

public:
	Graph(int V) { this->V = V; }

	void addEdge(int x, int y, int w)
	{
		edgelist.push_back({ w, x, y });
	}

	void kruskals_mst()
	{
		// 1. Sort all edges
		sort(edgelist.begin(), edgelist.end());

		// Initialize the DSU
		DSU s(V);
		int ans = 0;
		cout << "Berikut ini adalah tepi dari MST yang dibangun "
			<< endl;
		for (auto edge : edgelist) {
			int w = edge[0];
			int x = edge[1];
			int y = edge[2];

			// ambil tepi itu di MST jika itu membentuk siklus
			if (s.find(x) != s.find(y)) {
				s.unite(x, y);
				ans += w;
				cout << x << " -- " << y << " == " << w
					<< endl;
			}
		}
		cout << "Biaya Minimum Spanning Tree: " << ans;
	}
};
int main()
{
	/* Mari kita buat grafik berbobot berikut:
				10
			0--------1
			| \	 |
			6| 5\ |15
			|	 \ |
			2--------3
				4	 */
	Graph g(4);
	g.addEdge(0, 1, 10);
	g.addEdge(1, 3, 15);
	g.addEdge(2, 3, 4);
	g.addEdge(2, 0, 6);
	g.addEdge(0, 3, 5);

	// int n, m;
	// cin >> n >> m;

	// Graph g(n);
	// for (int i = 0; i < m; i++)
	// {
	//	 int x, y, w;
	//	 cin >> x >> y >> w;
	//	 g.addEdge(x, y, w);
	// }

	g.kruskals_mst();
	return 0;
}
