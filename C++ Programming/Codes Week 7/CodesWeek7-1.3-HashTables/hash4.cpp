#include<iostream>
#include<limits.h>

using namespace std;

void Insert(int ary[],int hFn, int Size){
    int element,pos,n=0;

cout<<"Masukkan elemen key untuk insert\n";
cin>>element;
pos = element%hFn;

while(ary[pos]!= INT_MIN) {
if(ary[pos]== INT_MAX)
     break;
pos = (pos+1)%hFn;
n++;
if(n==Size)
      break;
}

if(n==Size)
        cout<<"Tabel Hash penuh\nTidak ada tempat untuk memasukkan elemen ini\n\n";
else
        ary[pos] = element;    //Insert element
}

void Delete(int ary[],int hFn,int Size){
int element,n=0,pos;
cout<<"Masukkan element untuk dihapus\n";
cin>>element;
pos = element%hFn;

while(n++ != Size){
if(ary[pos]==INT_MIN){
cout<<"Elemen tidak ditemukan dalam tabel hash\n";
break;
}
else if(ary[pos]==element){
ary[pos]=INT_MAX;
cout<<"Elemen dihapus\n\n";
break;
}
else{
pos = (pos+1) % hFn;
}
}
if(--n==Size)
        cout<<"Elemen tidak ditemukan dalam tabel hash\n";
}

void Search(int ary[],int hFn,int Size){
int element,pos,n=0;

cout<<"Masukkan elemen yang ingin dicari\n";
cin>>element;
pos = element%hFn;

while(n++ != Size){
if(ary[pos]==element){
cout<<"Elemen ditemukan pada indeks "<<pos<<"\n";
break;
}
else
            if(ary[pos]==INT_MAX ||ary[pos]!=INT_MIN)
                pos = (pos+1) %hFn;
}
if(--n==Size)
        cout<<"Elemen tidak ditemukan dalam tabel hash\n";
}

void display(int ary[],int Size){
int i;

cout<<"Index\tValue\n";

for(i=0;i<Size;i++)
        cout<<i<<"\t"<<ary[i]<<"\n";
}

int main(){
int Size,hFn,i,choice;

cout<<"Masukkan ukuran tabel hash\n";
cin>>Size;

int ary[Size];

    cout<<"Masukkan fungsi hash [if mod 10 enter 10]\n";
cin>>hFn;

for(i=0;i<Size;i++)
        ary[i]=INT_MIN; // INT_MIN indicates that cell is empty

do{
cout<<"Masukkan pilihanmu\n";
cout<<" 1-> Insert\n 2-> Delete\n 3-> Display\n 4-> Searching\n 0-> Exit\n";
cin>>choice;

switch(choice){
case 1:
Insert(ary,hFn,Size);
break;
case 2:
Delete(ary,hFn,Size);
break;
case 3:
display(ary,Size);
break;
case 4:
Search(ary,hFn,Size);
break;
default:
cout<<"Masukkan pilihan yang bener\n";
break;
}
}while(choice);

return 0;
}
