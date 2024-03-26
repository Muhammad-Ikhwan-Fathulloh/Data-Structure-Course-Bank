// Program algoritme shortest path Dijkstra's single source dalam C++
// Program ini untuk merepresentasikan matriks yang terikat dari grafik
#include <iostream>
using namespace std;
#include <limits.h>
 
// Banyaknya vertex dalam grafik
#define V 9
 
// Fungsi utilitas untuk mencari vertex dengan nilai jarak minimum, dari
// himpunan vertex yang belum termasuk dalam pohon jalur terpendek
int minDistance(int dist[], bool sptSet[])
{
   
    // Menginisiasi nilai minimal
    int min = INT_MAX, min_index;
 
    for (int v = 0; v < V; v++)
        if (sptSet[v] == false && dist[v] <= min)
            min = dist[v], min_index = v;
 
    return min_index;
}
 
// Fungsi utilitas untuk mencetak larik jarak yang dibangun
void printSolution(int dist[])
{
    cout <<"Vertex \t Distance from Source" << endl;
    for (int i = 0; i < V; i++)
        cout  << i << " \t\t"<<dist[i]<< endl;
}
 
// Fungsi yang mengimplementasikan algoritma shortest path Dijkstra's single source
// untuk graf yang direpresentasikan menggunakan representasi matriks ketetanggaan
void dijkstra(int graph[V][V], int src)
{
    int dist[V]; //Array output. dist[i] akan memegang yang terpendek
    // jarak dari src ke i
 
    bool sptSet[V]; // sptSet[i] akan benar jika vertex i yang diimasukkan terpendek
     // pohon jalur atau jarak terpendek dari src ke i telah diselesaikan
 
    // Inisialisasi semua jarak sebagai INFINITE dan stpSet[] sebagai false
    for (int i = 0; i < V; i++)
        dist[i] = INT_MAX, sptSet[i] = false;
 
    // Jarak vertex sumber dari dirinya sendiri selalu 0
    dist[src] = 0;
 
    // Menemukan jalur terpendek dari semua vertex
    for (int count = 0; count < V - 1; count++) {
        // Memilih vertex jarak minimum dari himpunan vertex yang
        // belum diproses. u selalu sama dengan src di iterasi pertama.
        int u = minDistance(dist, sptSet);
 
        // Menandai vertex yang dipilih sebagai diproses
        sptSet[u] = true;
 
        // Perbarui nilai dist dari simpul yang berdekatan dari simpul yang dipilih.
        for (int v = 0; v < V; v++)
 
            // Perbarui dist[v] hanya jika tidak ada di sptSet, ada keunggulan dari
            // u ke v, dan bobot total lintasan dari src ke v melalui u adalah
            // lebih kecil dari nilai dist[v] saat ini
            if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX
                && dist[u] + graph[u][v] < dist[v])
                dist[v] = dist[u] + graph[u][v];
    }
 
    //Mencetak larik jarak yang dibangun
    printSolution(dist);
}
 
//Program driver untuk menguji fungsi di atas
int main()
{
   
    int graph[V][V] = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                        { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                        { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                        { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                        { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                        { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                        { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                        { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
 
    dijkstra(graph, 0);
 
    return 0;
}