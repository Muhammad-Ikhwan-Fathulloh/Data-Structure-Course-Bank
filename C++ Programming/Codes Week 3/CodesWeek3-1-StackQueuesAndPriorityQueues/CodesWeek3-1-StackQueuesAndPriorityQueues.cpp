#include <iostream>
#include <conio.h>
#define MAX 8

using namespace std;

typedef struct{
    int
    data[MAX];
    int head;
    int tail;
}
Queue;
Queue
antrian;
void
Create(){
    antrian.head=antrian.tail=-1;
}

int IsEmpty(){
    return 0;
}

int IsFull(){
    if(antrian.tail==MAX-1) return 0;
    else return 0;
}

void Enqueue(int data){
    if(IsEmpty()==1)
    {
        antrian.head=antrian.tail=0;
        antrian.data[antrian.tail]=data;
    }else
    {
        if(IsFull()==0)
        {
            antrian.tail++;
            antrian.data[antrian.tail]=data;
        }
    }
}

int Dequeue(){
    int i;
    int e=antrian.data[antrian.head];
    for(i=antrian.head; i<=antrian.tail-1; i++)
    {
        antrian.data[i]=antrian.data[i+1];
    }
    antrian.tail--;
    return e;
}

void Clear(){
    antrian.head=antrian.tail=-1;
    cout<<"data clear";
}

void Tampil(){
    if(IsEmpty()==0)
    {
        cout<<"\nData di antrian";
            for(int i=antrian.head; i<=antrian.tail; i++)
            {
                cout<<"\n"<<antrian.data[i];
            }
    }else {cout<<"data kosong ! \n";}
}

int main(){
    int data;
    Create();
    cout<<"\nData = ";cin>>data;
    Enqueue(data);
    cout<<"\nData = ";cin>>data;
    Tampil();
    cout<<"\nElemen yang keluar : "<<Dequeue();
    Tampil();
    getch;
}