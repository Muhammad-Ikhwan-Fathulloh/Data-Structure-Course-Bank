package binary.search.tree;

public class Program {
    
    public static void main(String [] args) {
        
        System.out.println("");
        
        // Deklarasi Tree
        BinarySearchTree tree = new BinarySearchTree();
        
        // Tambah Data
        tree.tambahData(10);
        tree.tambahData(18);
        tree.tambahData(12);
        tree.tambahData(23);
        tree.tambahData(40);
        tree.tambahData(34);
        tree.tambahData(27);
        tree.tambahData(43);
        tree.tambahData(48);
        tree.tambahData(55);
        
        System.out.println("");
        
        // Menampilkan Data dalam Interval
        tree.cariInterval(5,45);
        
        System.out.println("");
        
        // Mencari Data
        tree.cariData(20);
        tree.cariData(27);
        tree.cariData(35);	
        tree.cariData(23);	
        tree.cariData(57);
        
        System.out.println();	
        
        tree.hapusData(10);
        tree.hapusData(20);
        tree.hapusData(23);
        tree.hapusData(22);
        tree.hapusData(27);
        
        System.out.println("");

    }
    
}
