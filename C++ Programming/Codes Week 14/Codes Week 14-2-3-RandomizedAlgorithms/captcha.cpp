// Program C++ untuk secara otomatis menghasilkan CAPTCHA dan verifikasi pengguna
#include <string>
#include <stdlib.h>
#include <iostream>
using namespace std;

// Mengembalikan nilai true jika diberikan dua string yang sama
bool checkCaptcha(string &captcha, string &user_captcha)
{
	return captcha.compare(user_captcha) == 0;
}

// Menghasilkan CAPTCHA dengan panjang tertentu
string generateCaptcha(int n)
{
	time_t t;
	srand((unsigned)time(&t));

	// Karakter yang akan disertakan
	char *chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHI"
				"JKLMNOPQRSTUVWXYZ0123456789";

	// Hasilkan n karakter dari set di atas dan
    // tambahkan karakter ini ke captcha.
	string captcha = "";
	while (n--)
		captcha.push_back(chrs[rand()%62]);

	return captcha;
}

// Driver code
int main()
{
	// Hasilkan CAPTCHA acak
	string captcha = generateCaptcha(9);
	cout << captcha;

	// Minta pengguna untuk memasukkan CAPTCHA
	string usr_captcha;
	cout << "\nMasukkan CAPTCHA: ";
	cin >> usr_captcha;

	// Beri tahu pengguna tentang status yang cocok
	if (checkCaptcha(captcha, usr_captcha))
		printf("\nCAPTCHA Sesuai");
	else
		printf("\nCAPTCHA tidak sesuai");

	return 0;
}
