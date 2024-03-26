#include <iostream>
#include <vector>
#include<stdio.h>
#include<cstring>
using namespace std;
// vektor capList[i]memuat daftar orang yang memiliki topi dengan id i
// id antara 1-100 sehingga arrai dari 101 vektor dideklarasi sebagai indexing
// dimulai dari 0
vector<int> caps[101];
// dp[2^10][101] .. pada dp[i][j], i menunjukkan mask memberi tahu
// berapa banyak dan siapa saja orang memakai topi, j menandai topi pertama j yang dipakai
// jadi dp[i][j] menunjukkan banyak cara menerapkan topi j ke mask i
//sedemikian rupa sehingga tidak ada dari mereka yang memakai topi yang sama
int dp[1025][101];
// Ini digunakan untuk kasus dasar, ia memiliki semua set N bit
// jadi, ini memberitahu apakah semua N orang memakai topi.
int allmask;
// Mask adalah himpunan orang, i adalah cap-id (ATAU the
// jumlah caps yang diproses mulai dari cap pertama).
long long int uniqueCaps(int mask, int i) {
    // Jika semua orang memakai topi maka kita selesai dan ini adalah salah satu cara
   if (mask == allmask) return 1;
    // Jika tidak semua orang memakai topi dan juga tidak ada lagi
    // caps yang tersisa untuk diproses, jadi tidak ada cara, jadi kembalikan 0
   if (i > 100) return 0;
   // Jika kita telah menyelesaikan submasalah ini, kembalikan jawabannya.
   if (dp[mask][i] != -1) return dp[mask][i];
    // Cara, ketika kami tidak menyertakan batas ini dalam pengaturan kami
    // atau kumpulan solusi
   long long int ways = uniqueCaps(mask, i+1);
   // ukuran adalah jumlah total orang yang memiliki topi dengan id i.
   int size = caps[i].size();
   // Jadi, tetapkan satu per satu dengan cap ke semua orang yang mungkin 
    // dan ulangi untuk cap yang tersisa.
   for (int j = 0; j < size; j++) {
        //jika orang capList[i][j] sudah memakai topi jadi lanjutkan sebagai
        // kita tidak bisa memberinya topi in
      if (mask & (1 << caps[i][j])) continue;
        // Jika tidak, berikan dia batas ini dan ulangi untuk sisa batas dengan
        // vektor mask baru yang diperbarui
    
         else ways += uniqueCaps(mask | (1 << caps[i][j]), i+1);
         ways %= (1000000007);
      }
      // Simpan hasilnya dan kembalikan.
      return dp[mask][i] = ways;
   }
int main() {
   int n = 3;
   // koleksi orang ke-1
   caps[4].push_back(0);
   caps[45].push_back(0);
   caps[10].push_back(0);
   // koleksi orang ke-2
   caps[25].push_back(1);
   // koleksi orang ke-3
   caps[45].push_back(2);
   caps[10].push_back(2);
   allmask = (1 << n) - 1;
   memset(dp, -1, sizeof dp);
   cout<<"Banyaknya cara seseorang dapat memakai topi unik dalam pesta adalah:\t"<<uniqueCaps(0, 1);
   return 0;
}