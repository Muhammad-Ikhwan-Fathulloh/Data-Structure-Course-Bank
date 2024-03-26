#include <stdio.h>
#include <conio.h>

int a[100];
int max, min;
void maxmin(int i, int j) {
     int max1, min1, mid;
     if(i==j) {
          max=min=a[i];   }
     else if(i==j-1) {
           if(a[i]>a[j]) {
                max=a[i];
                min=a[j];  }
           else {
                max=a[j];
                min=a[i];  }
     }

     else {
           mid=(i+j)/2;
           maxmin(i, mid);
           max1=max;
           min1=min;
           maxmin(mid+1, j);
           if(max<max1)
                max=max1;
           if(min>min1)
                min=min1;  }
}

void main() {
     int i, num;
     clrscr();
     printf("\n\t\t\t   Maximum & Minimum \n\n");
     printf("\nMasukkan banyak angka: ");
     scanf("%d",&num);
     printf("\nMasukkan angkanya: \n");
     for(i=0;i<num;i++) {
           scanf("%d",&a[i]); }
     max=a[0];
     min=a[0];
     maxmin(0,num-1);
     printf("\nMaximum angka: %d\n", max);
     printf("Minimum angka: %d\n", min);
     getch();
}