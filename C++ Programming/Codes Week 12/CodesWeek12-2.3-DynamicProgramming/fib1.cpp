#include <iostream>
#include <vector>
 
using namespace std;
 
int fibonacci(vector <int> &dp, int n)
{
        // kasus dasar
        if(n == 0)
                return 0;
 
        if(dp[n] != 0)
                return dp[n];
 
        // sebaliknya
        // hitungsolusinya dan simpan
        dp[n] = fibonacci(dp, n - 1) + fibonacci(dp, n - 2);
 
        // akhirnya kembalikan solusinya
        return dp[n];
}
 
int main()
{
        cout << "Masukkan nilai n" << endl;
        int n;
        cin >> n;
 
        // declare the dynamic programming vector
        vector <int> dp(n, 0);
        dp[1] = 1;
 
        cout << "Urutan ke- " << n << " dari deret fibonacci adalah " << fibonacci(dp, n - 1) << endl;
}