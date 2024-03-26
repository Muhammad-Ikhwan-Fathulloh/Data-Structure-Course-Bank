#include <iostream>
#include <conio.h>
#include <stdlib.h>
using namespace std;

//Deklarasi stack dengan struct dan array
struct STACK
{
    int data [5];
    int top;
};

//deklarasi variabel tumpukan dari struct
STACK tumpukan;

//deklarasi fungsi operasi stack
void inisialisasi();
    int IsEmpty();
    int IsFull();

void push (int data);

void pop ();

//fungsi main program
main ()
{
    system("cls");
    int pilih, input, i;
    inisialisasi();
    do{
        cout<<"1. Push data"<<endl;
        cout<<"2. Pop Data"<<endl;
        cout<<"3. Print Data"<<endl;
        cout<<"4. Clear Data"<<endl;
        cout<<endl;
        cout<<"Pilih : ";cin>>pilih;
        switch(pilih)
        {
            case 1:
            {
                if(IsFull()==1)
                {
                    cout<<"Tumpukanan penuh !";
                }
                else
                {
                    cout<<"Data yang akan di push : ";cin>>input;
                    push(input);
                }
                cout<<endl;
                getch();
                break;
            }
            case 2:
            {
                if(IsEmpty()==1)
                {
                    cout<<"Tumpukanan Kosong !";
                }
                else
                {
                    cout<<"Data yang akan di Pop = "<<tumpukan.data[tumpukan.top]<<endl;
                    pop();
                }
                cout<<endl;
                getch();
                break;
            }
            case 3:
            {
                if(IsEmpty()==1)
                {
                    cout<<"Tumpukanan Kosong !"<<endl;
                }
                else
                {
                    cout<<"Data : "<<endl;
                    for(i=0; i<=tumpukan.top; i++)
                    {
                        cout<<tumpukan.data[i]<<" ";
                    }
                }
                cout<<endl;
                getch();
                break;
            }
            case 4:
            {
                inisialisasi();
                cout<<"Tumpukanan Kosong !"<<endl;
                cout<<endl;
                getch();
                break;
            }
            default:
            {
                cout<<"Tidak ada dalam pilih"<<endl;
            }
        }
    } while (pilih>=1 && pilih <=4);
    getch();
}

//fungsi inisialisasi stack = kosong
void inisialisasi()
{
    tumpukan.top=-1;
}

//fungsi mengecheck apakah stack kosong
int IsEmpty()
{
    if(tumpukan.top==-1)
    {
        return 1;

    }else
    {
        return 0;
    }
}

//fungsi mengecheck apakah stack penuh
int IsFull()
{
    if (tumpukan.top==5-1)
    {
        return 1;

    }else
     {
        return 0;

     }

}

//fungsi untuk menyisipkan data ke stack
void push(int data)
{
    tumpukan.top++;
    tumpukan.data[tumpukan.top]=data;
}

//fungsi untuk mengeluarkan data dari stack
void pop()
{
    tumpukan.top=tumpukan.top-1;
    if(tumpukan.top<0)
    {
        tumpukan.top=-1;
    }
}