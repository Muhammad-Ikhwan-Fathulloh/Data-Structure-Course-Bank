//C++ code for the above approach:

#include <iostream>
#include<iomanip>
using namespace std;

// Function to find minimum selections
double minSelections(int& n){
double ans = 0;
for(int i = 1; i <= n; i++)
	ans += 1.0 * n / i;
		
return ans;
}

// Driver's code
int main() {
int N = 3;
cout << fixed << setprecision(8) << minSelections(N);
return 0;
}
