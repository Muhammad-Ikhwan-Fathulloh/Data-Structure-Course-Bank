#include

#include

int max,min;

int a[100];

void maxmin(int i, int j)

{

int max1,min1,mid;

if (i==j)

max=min=a[i];

else

if (i==j-1)

{

if (a[i]

{

max=a[j];

min=a[i];

}

else

{

max=a[i];

min=a[j];

}

}

else

{

mid=(i+j)/2;

maxmin(i,mid);

max1=max;

min1=min;

maxmin(mid+1,j);

if(max

max=max1;

if(min>min1)

min=min1;

}

}


void main()

{

int i,num;

clrscr();

printf("\n\t\t\tMAXIMUM & MINIMUM\n\n");

printf("\n Masukkan Banyak Angka:");

scanf("%d",&num);

printf("Masukkan Angkanya:\n");

for (i=1;i<=num;i++)

{

scanf("%d",&a[i]);

}

max=a[0];

min=a[0];

maxmin(1,num);

printf("Maximum Angka: %d\n",max);

printf("Minimum Angka: %d\n",min);

getch();

}