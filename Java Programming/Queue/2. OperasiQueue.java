package OperasiQueue;

public class OperasiQueue {

    //Variabel ANtrian
    private final String arr[];
    private final int front;
    private int rear;
    private final int nKapasitas;
    private int nElemen;
    
    //Konstruktor untuk Menginisiasi Antrian
    OperasiQueue(int panjang) {
        arr = new String[panjang];
        front = 0;
        rear = -1;
        nKapasitas = panjang;
        nElemen = 0;
    }
    
    //Fungsi untuk Memperoleh Ukuran dari Antrian
    public int size() {
        return nElemen;
    }
    
    //Fungsi untuk Mengecek Apakah Antriannya masih Kosong
    public Boolean isEmpty() {
        return (size() == 0);
    }
    
    //Fungsi untuk Mengecek Apakah Antriannya sudah Penuh
    public Boolean isFull() {
        return (size() == nKapasitas);
    }
    
    //Fungsi untuk Menambah Elemen pada Antrian
    public void enQueue(String elemen) {
        //Menecek Apakah Antrian sudah OverFlow
        if (isFull()) {
            System.out.println("[ ANTRIAN  PENUH ]");
            System.out.println("Prigram Dihentikan");
        }
        System.out.println("-> Menambahkan " + elemen);
        
        //Operasi Modulus untuk Menyimpan Sisa dari nElemen
        rear = (rear + 1) % nKapasitas;
        arr[rear] = elemen;
        nElemen++;
    }
    
    //Fungsi untuk Menghapus Elemen Pertama Antian
    public void deQueue() {
        //Mengecek Apakah Antriannya UnderFlow
        if (isEmpty()) {
            System.out.println("[ ANTRIAN KOSONG ]");
            System.out.println("Program Dihentikan");
        }
        System.out.println("-> Menghapus " + arr[front]);
        
        for (int i = 0; i < size(); i++) {
            arr[i] = arr[i + 1];
        }
        nElemen--;
    }
    
    //Fungsi untuk Mengambil Elemen Paling Depan pada Antrian
    public String peek() {
        if (isEmpty()) {
            System.out.println("  ANTRIAN KOSONG  ");
            System.out.println("Program Dihentikan");
        }
        return arr[front];
    }
    
    public void cetakAntrian() {
        System.out.print("[");
            for (int i = 0; i < size(); i++) {
                if (i < size() - 1) {
                    System.out.print(arr[i] + ", ");
                } else {
                    System.out.print(arr[i]);
                }
            }
            System.out.println("]\n");
    }
    
    public static void main(String[] args) {
        
        System.out.println("");
        
        //Deklarasi Antrian
        OperasiQueue Antrian = new OperasiQueue(6);
        
        //Memasukkan Elemen ke dalam Antrian
        System.out.println("Memasukkan Elemen");
        Antrian.enQueue("E1");
        Antrian.enQueue("E2");
        Antrian.enQueue("E3");
        Antrian.enQueue("E4");
        Antrian.enQueue("E5");
        System.out.println("");
        
        //Mencetak Antrian
        System.out.println("  Antrian");
        System.out.print("  -> ");
        Antrian.cetakAntrian();
        
        //Mencetak Elemen Antrian
        System.out.println("  Elemen Terdepan");
        System.out.println("  -> " + Antrian.peek() + "\n");
        
        //Menampilkan Ukuran Antrian
        System.out.println("  Ukuran Antrian");
        System.out.println("  -> " + Antrian.size() + "\n");
        
        //Menghapus Elemen Antrian
        System.out.println("Menghapus Antrian");
        Antrian.deQueue();
        Antrian.deQueue();
        System.out.println("");
        
        //Mencetak Sisa Antrian
        System.out.println("  Sisa Antrian");
        System.out.print("  -> ");
        Antrian.cetakAntrian();
        
        //Menampilkan Ukuran Antrian
        System.out.println("  Ukuran Antrian");
        System.out.println("  -> " + Antrian.size() + "\n");
        
        //Mengecek Keadaan Antrian (Kosong atau Tidak)
        System.out.println("Bagaimana Antriannya?");
        if (Antrian.isEmpty()) {
            System.out.println("-> Kosong");
        } else {
            System.out.println("-> Tidak Kosong");
        }
        System.out.println("");
        
    }
    
}
