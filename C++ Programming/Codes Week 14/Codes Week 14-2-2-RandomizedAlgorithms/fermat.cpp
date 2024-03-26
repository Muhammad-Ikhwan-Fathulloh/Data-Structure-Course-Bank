// Program C++ untuk menemukan kembaran terkecil dalam rentang yang diberikan
#include <iostream>
using namespace std;

/* fungsi iterasi untuk menghitung (a^n)%p dalam O(logy) */
int power(int a, unsigned int n, int p)
{
	int res = 1;	 // inisialisasi hasil
	a = a % p; // perbaharui a jika a>=p

	while (n > 0)
	{
		// jika n adalah ganjil, kalikan a dengan hasil
		if (n & 1)
			res = (res*a) % p;

		// n seharusnya genap sekarang
		n = n>>1; // n = n/2
		a = (a*a) % p;
	}
	return res;
}

/*Fungsi rekursif untuk menghitung gcd dari 2 bilangan*/
int gcd(int a, int b)
{
	if(a < b)
		return gcd(b, a);
	else if(a%b == 0)
		return b;
	else return gcd(b, a%b);
}

// jika n prima, selalu mengembalikan true
// jika n komposit maka mengembalikan false dengan probabilitas tinggi
// nilai k yang lebih tinggi meningkatkan probabilitas hasil yang benar
bool isPrime(unsigned int n, int k)
{
// kasus
if (n <= 1 || n == 4) return false;
if (n <= 3) return true;

// coba sebanyak k kali
while (k>0)
{
	// Pilih nomor acak di [2..n-2]	
	// kasus di atas pastikan bahwa n > 4
	int a = 2 + rand()%(n-4);

	// Memeriksa apakah a dan n adalah co-prima
	if (gcd(n, a) != 1)
		return false;

	// teorema fermat
	if (power(a, n-1, n) != 1)
		return false;

	k--;
	}

	return true;
}

// Driver Program untuk menguji fungsi
int main()
{
	int k = 3;
	isPrime(11, k)? cout << " true\n": cout << " false\n";
	isPrime(15, k)? cout << " true\n": cout << " false\n";
	return 0;
}
