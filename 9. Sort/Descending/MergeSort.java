package merge.sort;

class MergeSort {
 
    private static int[] a;
 
    public static void urut() {
        
        int[] t = new int[a.length];
        sort(t, 0, a.length - 1);
        
    }
 
    public static void sort(int []t,int l,int u){ 
        
        if(l == u) {
            
            return;
            
        } else {
            
            int m = (l + u)/2;
            
            sort(t, l, m);
            sort(t, m + 1, u);
            merge(t, l, m + 1, u);
            
        }
        
    }
 
    public static void merge(int[] temp, int lower, int higher, int upper) {
        
        int t = 0;
        int l = lower;
        int m = higher - 1;
        int u = upper - l + 1;
        
        while(l <= m && higher <= upper) {
            
            if(a[l] > a[higher]) {
                temp[t++] = a[l++];
            } else {
                temp[t++] = a[higher++];
            }
            
        }
 
        while(l <= m) {
            temp[t++] = a[l++];
        }
 
        while(higher <= upper){ 
            temp[t++] = a[higher++];
        }
 
        for(int i = 0; i < u; i++) {
            a[lower + i] = temp[i];
        }
        
    }
 
    static void printArray(int arr[]) {

        int n = arr.length;
        
        System.out.print("[");
        for (int i = 0; i < n; ++i){
            
            if (i < n - 1) {
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println("]");
        
        System.out.println();

    }
    
    public static int[] getArray() {
        
        int size = 6;
        int []array = new int[size];
        int item = 0;
        for(int i = 0; i < size; i++) {
            item = (int)(Math.random()*100); 
            array[i] = item;
        }
        
        return array;
        
    }
    
    public static void main(String[] args) {
        
        long waktuAwal;
        long waktuAkhir;
        
        waktuAwal = System.nanoTime();
        
        System.out.println("");
        System.out.println("MERGE SORT\n");
        
        a = getArray();
        
        System.out.println("Array Awal");
        printArray(a);
        
        MergeSort.urut();
        System.out.println("Array Urut");
        printArray(a);
        
        waktuAkhir = System.nanoTime();
        
        System.out.println("Waktu yang Dihabiskan");
        System.out.println("[ " + (waktuAkhir - waktuAwal) + " ]");
        
        System.out.println("");
    }
    
}