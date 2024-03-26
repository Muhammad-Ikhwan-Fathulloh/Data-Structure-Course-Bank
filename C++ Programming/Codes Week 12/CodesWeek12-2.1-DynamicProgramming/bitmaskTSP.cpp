#include<iostream>
#include<vector>
#include<stdio.h>
#include<cstring>
#include<queue>
using namespace std;

#define INF 99999999
#define MAXR 12
#define MAXC 12
#define MAXMASK 2048
#define MAXHOUSE 12

// menyimpan sumber pengambilan jarak
// sebagai setiap dirty tile
int dist[MAXR][MAXC][MAXHOUSE];
// memoisasi untuk status dp 
int dp[MAXHOUSE][MAXMASK];
// menyimpan koordinat untuk dirty tiles
vector < pair <int,int> > dirty;
// arah
int X[] = {-1, 0, 0, 1};
int Y[] = {0, 1, -1, 0};
char arr[21][21];
// len : jumlah dirty tiles + 1
// limit : 2 ^ len -1
// r, c : jumlah baris dan kolom
int len, limit, r, c;
// mengembalikan true jika posisi saat ini aman untuk didatangi
// jika tidak maka mengembalikan false
// kompleksistas waktu : O(1)
bool safe(int x,int y)
{if (x >= r | y>= c | x<0 | y<0)
	return false;
        if (arr[x][y] == '#')
           return false;
           return true;
 }
                     
// menjalankan traversal BFS di tile idx
// menghitung jarak ke setiap sel dalam kisi
// Kompleksitas Waktu : O(r*c)
void getDist(int idx){
	// array yang dikunjungi untuk melacak sel yang dikunjungi
	bool vis[21][21];
        memset(vis,false, sizeof(vis));
        // mendapatkan posisi saat ini
        int cx = dirty[idx].first;
        int cy = dirty[idx].second;
        // inisialisasi antrian untuk bfs
        queue < pair < int, int > > pq;
        pq.push({cx, cy});
        // menginisialisasi dist ke max
	// karena beberapa sel tidak dapat dikunjungi
	// dengan mengambil sel sumber sebagai idx
        for (int i = 0;i<= r;i++)
        	for (int j = 0;j<= c;j++)
                 dist[i][j][idx] = INF;
                 // kondisi dasar
                 vis[cx][cy] = true;
                 dist[cx][cy][idx] = 0;
                 while (! pq.empty())
                 {
			auto x = pq.front();
                   	pq.pop();
                   	for (int i = 0;i<4;i++)	
                        {cx = x.first + X[i];
                     	 cy = x.second + Y[i];
                     	 if (safe(cx, cy))
                     	 { if(vis[cx][cy])continue;
                     		vis[cx][cy] = true;
                     	        dist[cx][cy][idx] = dist[x.first][x.second][idx] + 1;
                                pq.push({cx, cy}); }
 }}}

// Rekursi transisi status PD dengan memoisasi.
//  Kompleksitas Waktu: O(n*n*2 ^ n)
int solve(int idx,int mask){
 // status tujuan
 if (mask == limit)
  return dist[0][0][idx];
 // jika status sudah didatangi
 if (dp[idx][mask] != -1)
  return dp[idx][mask];
 int ret = INT_MAX;
 // relasi transisi keadaan
 for (int i = 0;i<len;i++)
  { if ((mask & (1<<i)) == 0){
    int newMask = mask | (1<<i);
    ret = min( ret, solve(i, newMask)+ dist[dirty[i].first][dirty[i].second][idx]);
 }}
    //menambahkan memoisasi dan mengembalikan
    return dp[idx][mask] = ret;}
                     
void init(){
 // menginisialisasi kontainer
 memset (dp, -1,sizeof(dp));
 dirty.clear();
 // mengisi posisi tiles kotor
 for(int i = 0;i<r;i++)
  for(int j = 0;j<c;j++){
   if(arr[i][j] =='*')
     dirty.push_back({i, j});
     }	
 // menyisipkan lokasi ronot diawal tile kotor
 dirty.insert(dirty.begin(), {0, 0});
 len = dirty.size();
 // menghitung LIMIT_MASK
 limit = (1<<len) - 1;
 // menghitung jarak dari semua
 // ubin kotor untuk setiap sel di grid
 for(int i = 0;i<len;i++)
  getDist(i); }
                     

int main(int argc, char const *argv[])                     
{// Tes case #1:
 //	 .....*.
 //	 ...#...
 //	 .*.#.*.
 //	 .......
  char A[4][7] = { {'.','.','.','.','.','*','.'},{'.','.','.','#','.','.','.'},
                   {'.','*','.','#','.','*','.'},{'.','.','.','.','.','.','.'}};
                     
  r = 4; c = 7;
  cout << "Grid yang diberikan : " << endl;
  for(int i = 0;i<r;i++)
  { for(int j = 0;j<c;j++)  
   { cout << A[i][j] <<" ";
     arr[i][j] = A[i][j];}
    cout << endl;}
                     
// - inisialisasi
// - perhitungan awal
init();                    
int ans = solve(0, 1);
cout <<"Jarak minimum untuk grid yang diberikan : ";
cout << ans << endl;

// Test Case #2
//	 ...#...
//	 ...#.*.
//	 ...#...
//	 .*.#.*.
//	 ...#...
char Arr[5][7] = { {'.','.','.','#','.','.','.'},{'.','.','.','#','.','*','.'},
		   {'.','.','.','#','.','.', '.'},{'.','*','.','#','.','*','.'},
                   {'.','.','.','#','.','.','.'}};
r = 5; c = 7;
cout << "Grid yang diberikan : " << endl;
for(int i = 0;i<r;i++){
 for (int j = 0;j<c;j++){
    cout << Arr[i][j] << " ";
    arr[i][j] = Arr[i][j];}
 cout << endl;}
                   
// - inisialisasi
// - perhitungan awal
init();
ans = solve(0, 1);
cout << "Jarak minimum untuk grid yang diberikan: ";
if(ans >= INF)
   cout <<"tidak memungkinkan"<< endl;
else
   cout << ans << endl;
return 0;}
                     
