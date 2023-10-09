package user.define.priority.queue;

import java.util.Objects;
import java.util.PriorityQueue;

class Karyawan implements Comparable<Karyawan> {

    private String nama;
    private double gaji;

    public Karyawan(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Karyawan karyawan = (Karyawan) o;
        return Double.compare(karyawan.gaji, gaji) == 0 &&
                Objects.equals(nama, karyawan.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nama, gaji);
    }

    @Override
    public String toString() {
        return "Karyawan " + nama 
                + "\nGaji = " + gaji + "\n";
    }

    // Membandingkan dua Objek "Employee" berdasarkan Salary nya
    @Override
    public int compareTo(Karyawan karyawan) {
        if(this.getGaji() > karyawan.getGaji()) {
            return 1;
        } else if (this.getGaji() < karyawan.getGaji()) {
            return -1;
        } else {
            return 0;
        }
    }
    
}

public class PriorityQueueUserDefinedObjectExample {

    public static void main(String[] args) {
        
        System.out.println("");
        
        /*
        
        Persyaratan untuk membuat User Defined PriorityQueue antara lain

        1. Kelas mana pun harus mengimplementasikan antarmuka yang sebanding 
           dan menyediakan implementasi untuk fungsi compareTo(), atau
        2. Harus disediakan pembanding khusus saat membuat PriorityQueue
        
        */

        // Deklarasi PriorityQueue
        PriorityQueue<Karyawan> userdefinedPriorityQueue = 
                new PriorityQueue<>();

        // Menambahkan Item di Priority Queue -> ADD
        userdefinedPriorityQueue.add(new Karyawan("Rajeev", 100000.00));
        userdefinedPriorityQueue.add(new Karyawan("Chris", 145000.00));
        userdefinedPriorityQueue.add(new Karyawan("Andrea", 115000.00));
        userdefinedPriorityQueue.add(new Karyawan("Jack", 167000.00));

        /*
        
        Metode compareTo() pada class Employee digunakan untuk menentukan
        dalam urutan apa benda-benda harus di-DEQUEUE atau dihapus
        
        */
        
        // Mencetak dan Menghapus Item di Priority Queue -> REMOVE
        while (!userdefinedPriorityQueue.isEmpty()) {
            System.out.println(userdefinedPriorityQueue.remove());
        }
        
    }
    
}
