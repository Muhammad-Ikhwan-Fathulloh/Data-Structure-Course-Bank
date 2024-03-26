#include<iostream>
#include<cmath>
using namespace std;
 
//fungsi ini menghitung jumlah digit angka dari 1 hingga 10^digit -1
//jika angka=2, jumlahkan 1 sampai 99
int sumXminusOne(int digits)
{
    int sum=0;
 
    for(int i=1;i<=digits;i++)
    {
        //45 adalah jumlah digit angka dari 1...9
        sum=sum*10 + 45*pow(10,i-1);
    }
 
    return sum;
}
 
 
//fungsi untuk mengembalikan jumlah digit semua bilangan dari 1 sampai n
int sumDigits(int n)
{
    if(n<10)
        return n*(n+1)/2;
 
    //digit sama dengan jumlah digit dalam n dikurangi satu
    int digits;
    digits=log10(n);
 
    int X=pow(10,digits);
 
    //digit paling kiri dari bilangan tersebut
    int left=n/X;
 
    //jumlah angka semua bilangan dari 1 sampai n
    int sum=left*sumXminusOne(digits) +  
            ((left*(left-1))/2)*X +
            left*(n%X +1) +
            sumDigits(n%X);
 
    return sum;
 
}
 
int main()
{
    int n;
 
    cout<<"Masukkan jumlah (n) bilangan yang diinginkan "<<endl;
    cin>>n;
 
    cout<<"Jumlah angka semua bilangan dari 1 sampai "<<n<<" adalah "<<endl;
    cout<<sumDigits(n);
 
    cout<<endl;
    return 0;
}