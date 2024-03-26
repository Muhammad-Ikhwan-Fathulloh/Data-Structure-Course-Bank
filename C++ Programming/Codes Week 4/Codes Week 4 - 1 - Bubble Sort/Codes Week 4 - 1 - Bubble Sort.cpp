#include<iostream>
using namespace std;

/*
pada program berikut dilakukan bubble sort tanpa menggunakan pemisahan dengan function
program ini bersifat procedural
*/

int main ()
{
    // variabel-variabel yang diperlukan

    // iterator dalam perulangan
    int i, j; 
    // variabel temp (temporary), untuk menyimpan nilai sementara saat melakukan swap elemen
    int temp;   
    //variabel pass, untuk menyimpan nilai pass yang dilakukan untuk mengurutkan array. initial value = 0
    int pass = 0;

    // list diimplementasikan dalam struktur data array berisi int yang belum urut
    int array[9] = {6,9,1,-7,55,46,39,2,99};

    // menampilkan array yang belum urut
    cout <<"Array input: " << endl;
    for(i = 0; i<9; i++) {
        cout <<array[i]<<"  ";
    }
    cout << endl;
    
    // bubble sort
    for(i = 0; i<9; i++) {
        for(j = i+1; j<9; j++)
        {   
            // jika kondisi terpenuhi, lakukan swap
            if(array[j] < array[i]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // tiap perulangan, nilai pass bertambah
        pass++;
    }

    // menampilkan array yang sudah urut
    cout <<"\nArray terurut: " << endl;
    for(i = 0; i<9; i++) {
        cout <<array[i]<<"  ";
    }

    // menampilkan jumlah pass pada bubble sort
    cout<<"\n\nJumlah pass yang dilakukan untuk mengurutkan array: "<< pass <<endl;

    return 0;
}