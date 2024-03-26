#include <bits/stdc++.h>
using namespace std;

// Prints a maximum set of activities that can be done by a single
// person, one at a time.
// n --> Total number of activities
// s[] --> An array that contains start time of all activities
// f[] --> An array that contains finish time of all activities

// Mencetak maksimum kegiatan yang dapat dilakukan oleh seseorang pada satu waktu
// n --> Jumlah kegiatan
// s[] --> Array yang menyimpan waktu mulai/start setiap aktivitas
// f[] --> Array yang menyimpan waktu selesai/finish setiap aktivitas
void printMaxActivities(int s[], int f[], int n)
{
	int i, j;

	cout <<"Following activities are selected "<< endl;

	// Aktivitas pertama selalu dipilih lebih dulu
	i = 0;
	cout <<" "<< i;

	// Mengulangi untuk keseluruhan aktivitas
	for (j = 1; j < n; j++)
	{
	// Jika aktivitas saat ini memiliki waktu mulai yang lebih atau sama dengan
	// waktu selesai aktivitas sebelumnya, maka aktivitas saat ini dipilih
	if (s[j] >= f[i])
	{
		cout <<" " << j;
		i = j;
	}
	}
}

int main()
{
	int s[] = {1, 3, 0, 5, 8, 5};
	int f[] = {2, 4, 6, 7, 9, 9};
	int n = sizeof(s)/sizeof(s[0]);
	printMaxActivities(s, f, n);
	return 0;
}
