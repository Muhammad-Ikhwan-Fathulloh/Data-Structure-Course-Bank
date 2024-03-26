package pkgdouble.hashing;

import java.io.*;

class DoubleHashing {
    
    private final int iData;

    public DoubleHashing(int ii) { 
        iData = ii; 
    }
    
    public int getKey() { 
        return iData; 
    }

}

//==============================================================================

class HashTable {
    
    private final DoubleHashing[] hashArray;
    private final int arraySize;
    private final DoubleHashing nonItem;

    HashTable(int size) {
        arraySize = size;
        hashArray = new DoubleHashing[arraySize];
        nonItem = new DoubleHashing(-1);
    }
    
    //==========================================================================
    
    // Fungsi Mencetak
        public void cetakTabel() {

            System.out.print("Tabel: ");

            for(int j = 0; j < arraySize; j++) {

                if(hashArray[j] != null) {
                    System.out.print(hashArray[j].getKey() + " ");
                } else {
                    System.out.print("** ");
                }

            }

            System.out.println("");

        }

    //==========================================================================
    
    // Fungsi Hash 1
    public int fungsiHash1(int key) {
        return key % arraySize;
    }
    
    //==========================================================================
    
    // Fungsi Hash 1
    public int fungsiHash2(int key) {
        return 5 - key % 5;
    }
    
    //==========================================================================

    // Menambahkan Data ke Hash
    public void tambahData(int key, DoubleHashing item) {
        
        int hashVal = fungsiHash1(key);
        int stepSize = fungsiHash2(key);
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        
        hashArray[hashVal] = item;
        
    }
    
    //==========================================================================
    
    // Menghapus Data dari Hash
    public DoubleHashing hapusData(int key) {
        
        int hashVal = fungsiHash1(key); 
        int stepSize = fungsiHash2(key); 
        
        while(hashArray[hashVal] != null) {
            
            if(hashArray[hashVal].getKey() == key) {
                DoubleHashing temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            
            hashVal += stepSize;
            hashVal %= arraySize;
            
        }
        
        return null;
        
    }
    
    //==========================================================================
    
    // Mencari Data di Hash
    public DoubleHashing cariData(int key) {
        
        int hashVal = fungsiHash1(key);
        int stepSize = fungsiHash2(key);
        
        while(hashArray[hashVal] != null) {
            
            if(hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            
            hashVal += stepSize; // add the step
            hashVal %= arraySize;
            
        }
        
        return null;
        
    }

}

//==============================================================================

class HashDoubleApp {
    
    public static void main(String[] args) throws IOException {
        
        DoubleHashing aDataItem;
        int aKey, size, n;
        
        System.out.print("Ukuran Hash Table : ");
        size = getInt();
        
        System.out.print("Masukkan Data Awal: ");
        n = getInt();
        
        HashTable theHashTable = new HashTable(size);
        
        // Tambah Data
        for(int j = 0; j < n; j++) {
            aKey = (int)(java.lang.Math.random() * 2 * size);
            aDataItem = new DoubleHashing(aKey);
            theHashTable.tambahData(aKey, aDataItem);
        }
        
        // Kasus
        L01: while(true) {
            
            System.out.println("");
            System.out.println("== Show - Insert - Delete - Find - Quit ==");
            System.out.println("Masukkan Huruf Pertama dari Fungsi di Atas");
            System.out.println("");
            
            char choice = getChar();
            
            switch(choice) {
                
                case 'S':    
                    theHashTable.cetakTabel();
                break;
                    
                case 'I':
                    System.out.print("Tambah Data: ");
                    aKey = getInt();
                    aDataItem = new DoubleHashing(aKey);
                    theHashTable.tambahData(aKey, aDataItem);
                break;
                
                case 'D':
                    System.out.print("Hapus Data: ");
                    aKey = getInt();
                    theHashTable.hapusData(aKey);
                break;
                    
                case 'F':
                    
                    System.out.print("Cari Data: ");
                    aKey = getInt();
                    aDataItem = theHashTable.cariData(aKey);
                    
                    if(aDataItem != null) {
                        System.out.println("Berhasil Menemukan Data " + aKey);
                    } else {
                        System.out.println("Tidak Dapat Menemukan Data " + aKey);
                    }
                    
                break;
                    
                case 'Q':
                    System.out.println("Keluar Program");
                    System.out.println("");
                break L01;
                    
                default:
                    System.out.println("");
                    System.out.print("Masukkan Huruf Pertama dengan Benar\n");
                    
            }
            
        }
        
    }

    //==========================================================================
    
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    
    //==========================================================================
    
    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
    
    //==========================================================================
    
    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
    
}