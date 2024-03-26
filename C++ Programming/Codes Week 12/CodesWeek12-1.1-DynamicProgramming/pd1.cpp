#include<iostream>
 
using namespace std;
 
int kadane(int a[], int n)
{
    int sum_semua=0;  //jumlah subarray maksimum keseluruhan
    int sum_baru=0;     //jumlah yang diperoleh dengan memasukkan elemen saat ini
 
    for(int i=0;i<n;i++)
    {
         //sum_baru adalah nilai maksimum dari elemen saat ini atau jumlah elemen saat ini
        //dan jumlah sebelumnya
        sum_baru=max(a[i], sum_baru+a[i]);
 
       //jika nilai yang dihitung dari new_sum lebih besar dari jumlah keseluruhan,
        //menggantikan nilai jumlah keseluruhan
        sum_semua=max(sum_semua, sum_baru);
    }
 
    return sum_semua;
 
}
 
int main()
{
    int i,n;
 
    cout<<"Masukkan jumlah elemen larik ";
    cin>>n;
 
    int a[n];
 
    //read the vector
    cout<<"masukkan elemen dalam array"<<endl;
    for(i=0;i<n;i++)
    {
        cin>>a[i];
    }
 
    //now,make a call to kadane function to calculate maximum subarray sum
    cout<<endl<<"Jumlah subarray maksimum untuk array yang diberikan adalah "<<kadane(a,n); 
 
    return 0;
}