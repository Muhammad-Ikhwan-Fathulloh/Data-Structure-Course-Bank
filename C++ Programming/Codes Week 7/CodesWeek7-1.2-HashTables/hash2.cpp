#include <bitset>
#include <functional>
#include <iostream>
#include <string>


using namespace std;

// String Hashing
void stringHashing()
{	// mendapatkan string
	// mendapatkan nilai hash
	string hashing1 = "Technology";
	// instansiasi objek
	hash<string> mystdhash;
	//menggunakan operator() untuk mendapat nilai hash
	cout << "Nilai hash dari string: "
		<< mystdhash(hashing1)
		<< endl;
}
// Driver Code
int main()
{
	stringHashing();
	}
