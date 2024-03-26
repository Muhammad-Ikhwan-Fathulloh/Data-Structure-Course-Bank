#include <iostream>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>


using namespace std;

#define max_stak 15

struct stak{
    int top,data[15],urut[15];
}tumpuk;



void push(int d){
    tumpuk.top++;
    tumpuk.data[tumpuk.top]=d;
    cout<<"Data berhasil dimasukkan \n";
    getch();
}

void pop(){
    cout<<"Data "<<tumpuk.data[tumpuk.top]<<" terambil \n";
    tumpuk.top--;
    getch();
}

int isFull(){
    if(tumpuk.top==max_stak-1){
        return 1;
    }
    else{
        return 0;
    }
}

int isEmpty(){
    if(tumpuk.top==-1){
        return 1;
    }
    else{
        return 0;
    }
}

void clear(){
    tumpuk.top=-1;
    cout<<"Semua data terhapus. ";
}

void tukar(int a,int b)
{
    int t;
    t=tumpuk.urut[b];
    tumpuk.urut[b]=tumpuk.urut[a];
    tumpuk.urut[a]=t;
}

void print(){

    for(int i=0;i<=tumpuk.top;i++){
        tumpuk.urut[i]=tumpuk.data[i];
    }



    for(int i=0;i<=tumpuk.top;i++){
        for(int j=i+1;j<=tumpuk.top;j++){//mencari data terkecil
            if(tumpuk.urut[i]<tumpuk.urut[j]){
                tukar(i,j);
            }
        }
    }

        for (int i=tumpuk.top;i>=0;i--)
        cout<<tumpuk.urut[i]<<endl;
    getch();
}

int main()
{
    int a;
    int input;
    tumpuk.top=-1;
    do{
        system("cls");
        cout<<"            Menu Stack \n================================== \n1. PUSH (Input Data) \n2. POP (Ambil satu data) \n3. CLEAR (Hapus semua data) \n4. PRINT (Cetak data pada layar) \n5. TERMINATE (Keluar) \nPilihan anda  : ";
        cin>>a;

        cout<<"----------------------------------\n";
        switch(a)
        {
        case 1:
            if(isFull()==1){
                cout<<"Stack penuh. \n";
                getch();
            }
            else{
                cout<<"Masukkan data : ";
                //fflush(stdin);
                cin>>input;
                push(input);
            }
            break;
        case 2:
            if(isEmpty()==1){
                cout<<"Stack kosong.";
                getch();
            }
            else{
                pop();
            }
            break;
        case 3:
            clear();
            cout<<"Stack kosong. \n";
            getch();
            break;
        case 4:
            if(isEmpty()==1){
                cout<<"Stack kosong";
                getch();
            }
            else{
                print();
            }
        }
    }while(a!=5);

}