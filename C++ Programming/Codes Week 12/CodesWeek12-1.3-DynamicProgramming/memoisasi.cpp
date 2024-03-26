
                      #include <bits/stdc++.h>
                      using namespace std;
                      #define NIL -1 
                      #define MAX 100
                     
                      int lookup[MAX];
                     /* fungsi untuk menginisailusasi nilai NIL pada lookup table */
                     
                      void _initialize()
                     {
                     int i;
                     for (i = 0; i < MAX; i++)
                     lookup[i] = NIL;
                     }
                     
                      /* fungsi untuk fibonacci ke n */
                     int fib (int n)
                     {
                     if (lookup[n] == NIL) {
                     if(n <= 1)
                     lookup[n] = n;
                     else
                     lookup[n] = fib(n - 1) + fib(n - 2);
                     }
                     return lookup[n];
                     }
                     
                        //fungsi utama
                     int main()
                     {
                     int n = 40;
                     _initialize();
                     cout << "Fibonacci ke-40: "<< fib(n);
                     return 0;
                     }
                     

                      
                     

                      // This is code is contributed by rathbhupendra
                     
