package binary.search.tree;

public class Program {

    public static void main(String[] args) {
        
        System.out.println("");
        
        BinaryTree bt = new BinaryTree();

        bt.tambahData(6);
        bt.tambahData(4);
        bt.tambahData(8);
        bt.tambahData(3);
        bt.tambahData(5);
        bt.tambahData(7);
        bt.tambahData(9);
        
        System.out.println("");
        
        bt.apakahKosong();
        
        System.out.println("");
        
        bt.ukuranTree();
        
        System.out.println("");
        
        bt.cariData(8);
        bt.cariData(1);
        
        System.out.println("");
        
        bt.hapusData(8);
        bt.cariData(8);
        
        System.out.println("");
        
        bt.traverseInOrder();
        bt.traverseInOrderTanpaRekursif();
        bt.traversePreOrder();
        bt.traversePreOrderTanpaRekursif();
        bt.traversePostOrder();
        bt.traversePostOrderTanpaRekursif();
        bt.traverseLevelOrder();
        
        System.out.println("");
        
    }
    
}
