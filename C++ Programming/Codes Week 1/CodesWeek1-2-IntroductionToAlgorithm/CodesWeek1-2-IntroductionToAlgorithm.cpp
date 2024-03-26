#include <iostream>
 
using namespace std;
 
int main()
{
  cout << "##  Program C++ Menghitung Luas Persegi Panjang  ##" << endl;
  cout << "===================================================" << endl;
  cout << endl;
 
  float p, l, luas;
 
  cout << "Input panjang persegi: ";
  cin >> p;
  cout << "Input lebar persegi: ";
  cin >> l;
  cout << endl;
 
  luas = p * l;
 
  cout << "Luas persegi panjang = "<< luas << endl;
 
  return 0;
}