#include <iostream>
#define MAX 200
using namespace std;

//bobot
int weight[] = {10, 0, 20, 10, 30};
//nilai
int value[] =  {10, 31, 22, 17, 34};
//batasan bobot knapsack 
int knapsack_weight = 50;
//jumlah item
int n = 4;

class KnapsackDP{
public:
  int **memoTable;

  KnapsackDP(){
    // tabel memoisasi
    this->memoTable = new int*[n+1]; 
    //inisialisasi tiap sel = 0
    for(int i=0; i<n+1; i++){
        this->memoTable[i]= new int[knapsack_weight+1] {0};
    }
  }

  int solve(){
    //Hitung dan isi tabel memo
    for(int i=1; i< (n + 1); i++){
      for(int j=1; j<(knapsack_weight + 1); j++){
        //ketika tidak termasuk item
        int not_taking_item = memoTable[i-1][j];
        //ketika termasuk item
        int taking_item = 0;
        if(weight[i] <= knapsack_weight){
          if(j-weight[i] < 0)
              taking_item = memoTable[i-1][j];
          else
              taking_item = value[i] + memoTable[i-1][j-weight[i]];
        }

        //menyimpan nilai yang lebih besar dalam tabel
        memoTable[i][j] = max(not_taking_item, taking_item);
      }
    }
    //kembalikan nilai maksimal untuk bobot knapsack yang diberikan
    return memoTable[n][knapsack_weight];
  }

  //Fungsi output item yang disertakan
  void selected_items(){
    for(int i=n, j= knapsack_weight; i>0; i--){
      if(memoTable[i][j] != memoTable[i-1][j]){
        cout << "Item: "<<i <<" dipilih \n";
        j = j- weight[i];
      }
    }
  }
};
 
int main()
{
  KnapsackDP kdp;
  cout << "Total Benefit: "<< kdp.solve() <<endl;

  //mencetak item mana yang disertakan
  kdp.selected_items();
  return 0;
}