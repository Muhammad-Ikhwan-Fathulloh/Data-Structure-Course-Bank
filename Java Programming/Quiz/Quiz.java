package com.mycompany.quiz;

import java.util.Scanner;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Iterator;

public class Quiz {
    
    public static void main(String[] args) {
        record Mahasiswa(String nama, String nim, String prodi, int prioritasKartu) {}
        record Buku(String kode, String judul, String penulis, int tahunTerbit) {}
        record PeminjamBuku(String nim, String[] kodeBuku) {}

        Scanner input = new Scanner(System.in);
        
        Mahasiswa[] listMahasiswa = new Mahasiswa[5];
        listMahasiswa[0] = new Mahasiswa("Tekna", "19552011024", "TIF", 2);
        listMahasiswa[1] = new Mahasiswa("Tekni", "19443011025", "DKV", 1);
        listMahasiswa[2] = new Mahasiswa("Teknu", "19332011026", "BD", 2);
        listMahasiswa[3] = new Mahasiswa("Tekne", "19226011027", "TI", 3);
        listMahasiswa[4] = new Mahasiswa("Tekno", "19552011028", "TIF", 1);
        
        Buku[] listBuku = new Buku[5];
        listBuku[0] = new Buku("B01", "Life Code", "A", 1998);
        listBuku[1] = new Buku("B02", "Habit", "B", 2002);
        listBuku[2] = new Buku("B03", "Hello World", "C", 1978);
        listBuku[3] = new Buku("B04", "Lorem Ipsum", "D", 1995);
        listBuku[4] = new Buku("B05", "Generative", "E", 2012);
        
        for (Buku buku : listBuku) {
            System.out.println("Kode: " + buku.kode + ", Judul: " + buku.judul +
                    ", Penulis: " + buku.penulis + ", Tahun Terbit: " + buku.tahunTerbit);
        }
        System.out.println("");
        
        Stack<Buku> rakBuku = new Stack<>();
        for(int i = 0; i < listBuku.length; i++){
            rakBuku.push(listBuku[i]);
        }
        
        PriorityQueue<Mahasiswa> antrianPengunjung = new PriorityQueue<>(Comparator.comparingInt(Mahasiswa::prioritasKartu));
        for(int i = 0; i < listMahasiswa.length; i++){
            antrianPengunjung.add(listMahasiswa[i]);
        }
        
        LinkedList<PeminjamBuku> listPeminjamanBuku = new LinkedList<>(); 
        
         while (!antrianPengunjung.isEmpty()) {
            Mahasiswa mahasiswa = antrianPengunjung.poll();
            System.out.println("Name: " + mahasiswa.nama() + ", NIM: " + mahasiswa.nim());
            System.out.print("Pinjam buku (Y/T): ");
            String pilih = input.nextLine();
            if ("Y".equals(pilih)) {
                System.out.print("Masukkan Kode Buku (pisahkan dengan koma jika lebih dari satu): ");
                String kode = input.nextLine();
                String[] listKode = kode.split(", ");
                LinkedList<String> listKodeValid = new LinkedList<>();
                
                for (String currentKode : listKode) {
                    boolean bukuDitemukan = false;
                    int jumlahBuku = rakBuku.size();
                    Stack<Buku> temporaryStack = new Stack<>();

                    for (int i = 0; i < jumlahBuku; i++) {
                        Buku buku = rakBuku.pop();
                        System.out.println(buku);

                        if (buku.kode.equals(currentKode)) {
                            System.out.println("Buku dengan kode " + currentKode + " ditemukan:");
                            System.out.println("Judul: " + buku.judul);
                            System.out.println("Penulis: " + buku.penulis);
                            System.out.println("Tahun Terbit: " + buku.tahunTerbit);
                            bukuDitemukan = true;
                            listKodeValid.add(currentKode);
                            break;  // Keluar dari loop jika buku sudah ditemukan
                        } else {
                            temporaryStack.add(buku);  // Tambahkan buku ke dalam stack sementara
                        }
                    }

                    // Mengembalikan buku-buku ke dalam rak
                    while (!temporaryStack.isEmpty()) {
                        rakBuku.add(temporaryStack.pop());
                    }

                    if (!bukuDitemukan) {
                        System.out.println("Buku dengan kode " + currentKode + " tidak ditemukan.");
                    }
                }
                String[] listKodeDitemukan = listKodeValid.toArray(new String[0]);
                if (listKodeDitemukan.length > 0) {
                    PeminjamBuku peminjamBuku = new PeminjamBuku(mahasiswa.nim(), listKodeDitemukan);
                    listPeminjamanBuku.add(peminjamBuku);
                } else {
                    System.out.println("Tidak ada buku yang ditemukan untuk dipinjam.");
                }
            }
        }
         
        System.out.println("");
        System.out.println("Mahasiswa yang meminjam buku:");
        for (PeminjamBuku peminjam : listPeminjamanBuku) {
            Mahasiswa mahasiswa = null;
            for (Mahasiswa mhs : listMahasiswa) {
                if (mhs.nim().equals(peminjam.nim())) {
                    mahasiswa = mhs;
                    break;
                }
            }

            if (mahasiswa != null) {
                System.out.println("NIM: " + mahasiswa.nim());
                System.out.println("Nama: " + mahasiswa.nama());
                System.out.println("Jurusan: " + mahasiswa.prodi());
                System.out.println("Kode Buku: " + Arrays.toString(peminjam.kodeBuku()));
                System.out.println("Detail Buku:");

                for (int i = 0; i < peminjam.kodeBuku().length; i++) {
                    String currentKode = peminjam.kodeBuku()[i];

                    Buku buku = null;
                    for (Buku bk : listBuku) {
                        if (bk.kode.equals(currentKode)) {
                            buku = bk;
                            break;
                        }
                    }

                    if (buku != null) {
                        System.out.println((i + 1) + ". Kode: " + buku.kode);
                        System.out.println("   Judul: " + buku.judul);
                        System.out.println("   Penulis: " + buku.penulis);
                        System.out.println("   Tahun Terbit: " + buku.tahunTerbit);
                    } else {
                        System.out.println("Buku dengan kode " + currentKode + " tidak ditemukan.");
                    }
                }
                System.out.println();
            }
        }
        
        System.out.println("");
        System.out.println("Mahasiswa yang mengembalikan buku:");
        Iterator<PeminjamBuku> iterator = listPeminjamanBuku.iterator();
        while (iterator.hasNext()) {
            PeminjamBuku peminjam = iterator.next();
            Mahasiswa mahasiswa = null;

            for (Mahasiswa mhs : listMahasiswa) {
                if (mhs.nim().equals(peminjam.nim())) {
                    mahasiswa = mhs;
                    break;
                }
            }

            if (mahasiswa != null) {
                System.out.println("NIM: " + mahasiswa.nim());
                System.out.println("Nama: " + mahasiswa.nama());
                System.out.println("Jurusan: " + mahasiswa.prodi());
                System.out.println("Kode Buku: " + Arrays.toString(peminjam.kodeBuku()));
                System.out.print("Kembalikan buku (Y/T): ");
                String pilih = input.nextLine();

                if ("Y".equals(pilih)) {
                    System.out.println("Buku yang dikembalikan:");

                    for (int i = 0; i < peminjam.kodeBuku().length; i++) {
                        String currentKode = peminjam.kodeBuku()[i];
                        Buku buku = null;

                        for (Buku bk : listBuku) {
                            if (bk.kode.equals(currentKode)) {
                                buku = bk;
                                break;
                            }
                        }

                        if (buku != null) {
                            System.out.println((i + 1) + ". Kode: " + buku.kode);
                            System.out.println("   Judul: " + buku.judul);
                            System.out.println("   Penulis: " + buku.penulis);
                            System.out.println("   Tahun Terbit: " + buku.tahunTerbit);
                            rakBuku.add(buku);
                        } else {
                            System.out.println("Buku dengan kode " + currentKode + " tidak ditemukan.");
                        }
                    }
                    System.out.println();
                    iterator.remove(); // Hapus peminjaman dari listPeminjamanBuku menggunakan iterator
                }
            }
        }
        
        input.close();
        
    }
}
