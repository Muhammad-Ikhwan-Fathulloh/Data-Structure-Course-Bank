#include <omp.h>
#include <stdio.h>


long long fib(long long n)
{
    if (n < 2) {
        return 1;
    }
    return fib(n - 2) + fib(n - 1);
}
/* Creates same amount of threads as number of CPUs, privatizes n,
   and lets each thread compute threads "round robin"-style, thus
   preventing one only thread executing the last and heaviest blocks. */
int main(int argc, char** argv)
{
    long long n = 0;

    omp_set_num_threads(omp_get_num_procs());

#pragma omp parallel private(n)
    {
#pragma omp for schedule(dynamic, 1)
        for (n = 0; n <= 45; n++) {
            printf("Fib(%lld): %lld\n", n, fib(n));
        }

    }
    return 0;
}