#include <iostream>
 
using namespace std;
 
int main()
{
  cout << "##  Program C++ Cari Nilai Terbesar  ##" << endl;
  cout << "=======================================" << endl;
  cout << endl;
 
  int input[100], arr_count, i, max_num;
 
  cout << "Input jumlah element Array: ";
  cin >> arr_count;
 
  cout << "Input "<< arr_count << " angka (dipisah dengan enter): " ;
  cout << endl;
 
  // simpan setiap angka yang diinput ke dalam array
  for(i = 0; i < arr_count; i++){
    cin >> input[i];
  }
 
  cout << endl;
 
  max_num = input[0];
  // proses mencari nilai terbesar
  for(i = 0; i < arr_count; i++){
    if(input[i] > max_num){
      max_num = input[i];
    }
  }
 
  cout  << "Angka terbesar adalah: " << max_num;
 
  cout << endl;
  return 0;
}