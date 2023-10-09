package linear.probing;

import java.io.*;

class LinearProbing {
        
    private final int iData;
    
    public LinearProbing(int ii) { 
        iData = ii; 
    }
    
    public int getKey() {
        return iData; 
    }
    
}

//==============================================================================

class HashTable {
    
    private final LinearProbing[] hashArray;
    private final int arraySize;
    private final LinearProbing nonItem;
    
    public HashTable(int size) {
        arraySize = size;
        hashArray = new LinearProbing[arraySize];
        nonItem = new LinearProbing(-1);
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
    
    // Fungsi Hash
    public int fungsiHash(int key) {
        return key % arraySize;
    }
    
    //==========================================================================
    
    // Menambahkan Data ke Hash
    public void tambahData(LinearProbing item) {
        
        int key = item.getKey();
        int hashVal = fungsiHash(key);
        
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            ++hashVal;
            hashVal %= arraySize;
        }
        
        hashArray[hashVal] = item;
        
    }
    
    //==========================================================================
    
    // Menghapus Data dari Hash
    public LinearProbing hapusData(int key) {
        
        int hashVal = fungsiHash(key);
        
        while(hashArray[hashVal] != null) {
            
            if(hashArray[hashVal].getKey() == key) {
                LinearProbing temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            
            ++hashVal;
            hashVal %= arraySize;
            
        }
        
        return null;
        
    }
    
    //==========================================================================
    
    // Mencari Data di Hash
    public LinearProbing cariData(int key) {
        
        int hashVal = fungsiHash(key);
        
        while(hashArray[hashVal] != null) {
            
            if(hashArray[hashVal].getKey() == key) {
                return hashArray[hashVal];
            }
            
            ++hashVal;
            hashVal %= arraySize;
            
        }
        
        return null;
        
    }
    
}

//==============================================================================

class HashTableApp {
    
    public static void main(String[] args) throws IOException {
        
        LinearProbing aDataItem;
        int aKey, size, n, keysPerCell;
        
        System.out.print("Ukuran Hash Table : ");
        size = getInt();
        
        System.out.print("Masukkan Data Awal: ");
        n = getInt();
        
        keysPerCell = 10;
        
        HashTable theHashTable = new HashTable(size);
        
        // Tambah Data
        for(int j = 0; j < n; j++) {
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);
            aDataItem = new LinearProbing(aKey);
            theHashTable.tambahData(aDataItem);
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
                    aDataItem = new LinearProbing(aKey);
                    theHashTable.tambahData(aDataItem);
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