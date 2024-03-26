#include <stdio.h>
#include <omp.h>

int main()
{
    omp_set_dynamic(1);
    omp_set_num_threads(10);
#pragma omp parallel        // daerah paralel 1
    {
#pragma omp single
        printf("Jumlah utas di wilayah dinamis adalah = %d\n",
            omp_get_num_threads());
    }
    printf("\n");
    omp_set_dynamic(0);
    omp_set_num_threads(10);
#pragma omp parallel         // daerah paralel 2
    {
#pragma omp single
        printf("Jumlah utas di wilayah non-dinamis adalah = = %d\n",
            omp_get_num_threads());
    }
    printf("\n");
    omp_set_dynamic(1);
    omp_set_num_threads(10);
#pragma omp parallel        // daerah paralel 3
    {
#pragma omp parallel 
        {
#pragma omp single
            printf("Jumlah utas di wilayah yang dinonaktifkan bersarang adalah = %d\n",
                omp_get_num_threads());
        }
    }
    printf("\n");
    omp_set_nested(1);
#pragma omp parallel        // daerah paralel 4
    {
#pragma omp parallel 
        {
#pragma omp single
            printf("Jumlah utas di wilayah bersarang adalah = %d\n",
                omp_get_num_threads());
        }
    }
}