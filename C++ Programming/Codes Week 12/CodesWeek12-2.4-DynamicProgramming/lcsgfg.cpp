/* Implementasi DP Top-Down dari masalah LCS */
#include <stdio.h>
#include<vector>
#include<iostream>
#include<cstring>
using namespace std;

/* Mengembalikan panjang LCS untuk X[0..m-1], Y[0..n-1] */
int lcs(char* X, char* Y, int m, int n,
		vector<vector<int> >& dp)
{
	if (m == 0 || n == 0)
		return 0;
	if (X[m - 1] == Y[n - 1])
		return dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);

	if (dp[m][n] != -1) {
		return dp[m][n];
	}
	return dp[m][n] = max(lcs(X, Y, m, n - 1, dp),
						lcs(X, Y, m - 1, n, dp));
}


int main()
{
  char X[] = "ajdkajshakdydksla";
  char Y[] = "ajduajdysksuwjkao";

	int m = strlen(X);
	int n = strlen(Y);
	vector<vector<int> > dp(m + 1, vector<int>(n + 1, -1));
	cout << "Panjang dari LCS adalah " << lcs(X, Y, m, n, dp);

	return 0;
}