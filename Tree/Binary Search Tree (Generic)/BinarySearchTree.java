package binary.search.tree;

import java.util.*;

public class BinarySearchTree <Type extends Comparable<Type>> implements Iterable<Type> {
    
    // Class Program
    public static void main(String[] args) {
        
        System.out.println("");
        
        Integer[] data = { 1,  5,  2,  7,  4,
                          13, 23, 28, 34, 57,
                          61, 72, 88, 90, 103};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(Integer n : data) bst.tambahData(n);
        
        //=================================================================

            bst.cariData(1);
            bst.cariData(30);
            
            System.out.println("");
            
            //=============================================================
            
            System.out.println("[========= Cetak Tree (Urut) ==========]");
            for(Integer n : bst) System.out.print(n + " ");
            System.out.println("");

            System.out.println("[==== Cetak Tree - preOrder (Urut) ====]");
            bst.preOrderTraversal();
            System.out.println("\n");

            //=============================================================

            System.out.println("[=== Cetak Tree - inOrder (Normal) ====]");
            bst.inOrderTraversal();
            System.out.println("");

            bst = new BinarySearchTree<>(new MyComp1());
            for(Integer n : data) bst.tambahData(n);

            System.out.println("[== Cetak Tree - inOrder (Terbalik) ===]");
            bst.inOrderTraversal();
            System.out.println("\n");

            //=============================================================

            System.out.println("[======== Cetak Tree (Normal) =========]");
            for(Integer n : bst) System.out.print(n + " ");
            System.out.println("");

            System.out.println("[=== Cetak Tree - preOrder (Normal) ===]");
            bst.preOrderTraversal();
            System.out.println("\n");
            
            //=============================================================
            
            bst.cariData(23);
            bst.hapusData(23);
            bst.cariData(23);
            
            System.out.println("");
            
        //=================================================================
        
        System.out.println("");
        
        System.out.println("[ --- = = = = = REVERSE = = = = = --- ] \n");
            
        bst.kembalikanTree(new Integer[] {11,8,6,4,7,10,19,43,31,29,37,49},
                           new Integer[] {4,6,7,8,10,11,19,29,31,37,43,49});
        
        //=================================================================
        
            System.out.println("[======== Cetak Tree (Normal) =========]");
            System.out.print("     ");
            for(Integer n : bst) System.out.print(n + " ");
            System.out.println();
            
            System.out.println("[=== Cetak Tree - preOrder (Normal) ===]");
            System.out.print("     ");
            bst.preOrderTraversal();
            System.out.println("\n");
            
            //=============================================================
            
            System.out.println("[=== Cetak Tree - inOrder (Normal) ====]");
            System.out.print("     ");
            bst.inOrderTraversal();
            System.out.println("\n");
            
            //=============================================================
            
            bst.diameter();
            bst.lebarTree();
            bst.tinggiTree();
            bst.jumlahDaun();
            
            System.out.println("");
            
    }

    //=====================================================================

    // Class Binary Search Tree
    private Node<Type> root;
    private Comparator<Type> comparator;

    public BinarySearchTree() {
        root = null;
        comparator = null;
    }

    public BinarySearchTree(Comparator<Type> comp) {
        root = null;
        comparator = comp;
    }

    private int compare(Type x, Type y) {
        
        if(comparator == null) {
            return x.compareTo(y);
        } else {
            return comparator.compare(x,y);
        }
        
    }

    /*********************
    * FUNGSI TAMBAH DATA *
    *********************/

    public void tambahData(Type data) {
        root = tambah(root, data);
    }

    private Node<Type> tambah(Node<Type> p, Type dataTambah) {

        if (p == null) {
            return new Node<>(dataTambah);
        }

        if (compare(dataTambah, p.data) == 0) {
            return p;
        }

        if (compare(dataTambah, p.data) < 0) {
            p.left = tambah(p.left, dataTambah);
        } else {
            p.right = tambah(p.right, dataTambah);
        }

        return p;

    }

    /*******************
    * FUNGSI PENCARIAN *
    *******************/
    
    public void cariData(Type data) {
                
        System.out.print("Mencari Data " + data + " -> ");
        boolean cari = cari(root, data);
        
        if (cari == true) {
            System.out.println("Ditemukan");
        } else {
            System.out.println("Tidak Ditemukan");
        }
        
    }
    
    private boolean cari(Node<Type> p, Type dataCari) {
        
        if (p == null) {
            return false;
        } else {
            
            if (compare(dataCari, p.data) == 0) {
                return true;
            } else {
                
                if (compare(dataCari, p.data) < 0) {
                    return cari(p.left, dataCari);
                } else {
                    return cari(p.right, dataCari);
                }
        
            }
            
        }
        
    }

    /********************
    * FUNGSI HAPUS DATA *
    ********************/

    public void hapusData(Type data) {
        
        System.out.println("Menghapus Data " + data);
        root = hapus(root, data);
        
    }
    
    private Node<Type> hapus(Node<Type> p, Type dataHapus) {
        
        if (p == null) {
            throw new RuntimeException("Tidak Dapat Menghapus Data " + dataHapus);
        } else {

            if (compare(dataHapus, p.data) < 0) {
                p.left = hapus (p.left, dataHapus);
            } else {

                if (compare(dataHapus, p.data)  > 0) {
                    p.right = hapus (p.right, dataHapus);
                } else {
                    
                    if (p.left == null) {
                        return p.right;
                    } else if (p.right == null) {
                        return p.left;
                    } else {
                        // Mengambil Node yang Paling Kanan dari Subtree Kiri
                        p.data = mengambilData(p.left);
                        // Menghapus Node yang Paling Kanan dari Subtree Kiri
                        p.left =  hapus(p.left, p.data) ;
                    }
                    
                }
                
            }
            
        }
        
        return p;
       
    }
    
    private Type mengambilData(Node<Type> data) {
        
       while (data.right != null) data = data.right;
       return data.data;
       
    }

    /******************
    * FUNGSI TOSTRING *
    ******************/

    @Override
    public String toString() {
        
       StringBuilder sb = new StringBuilder();
       for(Type data : this) sb.append(data.toString());

       return sb.toString();
       
    }

    /*******************
    * FUNGSI TRAVERSAL *
    *******************/

    public void preOrderTraversal() {
        preOrderHelper(root);
    }
    
    private void preOrderHelper(Node r) {
        
        if (r != null) {
           System.out.print(r+" ");
           preOrderHelper(r.left);
           preOrderHelper(r.right);
        }
        
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }
    
    private void inOrderHelper(Node r) {
        
        if (r != null) {
           inOrderHelper(r.left);
           System.out.print(r+" ");
           inOrderHelper(r.right);
        }

    }

    /***************
    * FUNGSI CLONE *
    ***************/

    @Override
    public BinarySearchTree<Type> clone() {
        
       BinarySearchTree<Type> twin = null;

       if(comparator == null) {
           twin = new BinarySearchTree<>();
       } else {
           twin = new BinarySearchTree<>(comparator);
       }

       twin.root = cloneHelper(root);
       return twin;
       
    }
    
    private Node<Type> cloneHelper(Node<Type> p) {
        
       if(p == null) {
           return null;
       } else {
           return new Node<>(p.data, cloneHelper(p.left), cloneHelper(p.right));
       }
    
    }

    /**************
    * FUNGSI MISC *
    **************/

    private int tinggi() {
        return tinggiHelper(root);
    }
    
    public void tinggiTree() {
        
        System.out.println("Tinggi Tree adalah " + tinggi());
        
    }
    
    private int tinggiHelper(Node<Type> p) {
        
        if(p == null) {
            return -1;
        } else {
            return 1 + Math.max( tinggiHelper(p.left), tinggiHelper(p.right));
        }
       
    }

    public void jumlahDaun() {
        
        System.out.println("Jumlah Daunnya adalah " + jumlahDaunHelper(root));
        
    }
    
    private int jumlahDaunHelper(Node<Type> p) {
        
        if(p == null) {
            return 0;
        } else if(p.left == null && p.right == null) {
            return 1;
        } else {
            return jumlahDaunHelper(p.left) + jumlahDaunHelper(p.right);
        }
        
    }

    // Metode Berikut Mengembalikan BST preOrder and inOrder Traversals
    public void kembalikanTree(Type[] pre, Type[] in) {
        root = kembalikan(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    private Node<Type> kembalikan(Type[] pre, int preL, int preR, Type[] in, int inL, int inR) {
        
        if(preL <= preR) {
            
            int count = 0;

            // Mencari Root idalam Array yang Belum Terurut
            while(pre[preL] != in[inL + count]) count++;

            Node<Type> tmp = new Node<>(pre[preL]);
            tmp.left = kembalikan(pre, preL+1, preL + count, in, inL, inL +count-1);
            tmp.right = kembalikan(pre, preL+count+1, preR, in, inL+count+1, inR);
            return tmp;
           
        } else {
            return null;
        }
        
    }

    // Lebar dari BST adalah Angka Maksimum dari Elemen di Satu Level Tree
    public void lebarTree() {
                
        int max = 0;
        for(int k = 0; k <= tinggi(); k++) {
            
            int tmp = lebarHelper(root, k);
            if(tmp > max) {
                max = tmp;
            }
            
        }
        
        System.out.println("Lebar Tree adalah " + max);
       
    }
    
    // Mengembalikan Nilai Node pada Level yang Diberikan
    private int lebarHelper(Node<Type> p, int kedalaman) {
        
        if(p == null) {
            return 0;
        } else if(kedalaman == 0) {
            return 1;
        } else {
            return lebarHelper(p.left, kedalaman - 1) + lebarHelper(p.right, kedalaman - 1);
        }
       
    }

    // Diameter Tree adalah Jumlah Node pada Tree
    // di Jalur Terjauh antara Dua Daun di Tree
    public void diameter() {
        
        System.out.println("Diameter Tree adalah " + diameterHelper(root));
        
    }
    
    private int diameterHelper(Node<Type> p) {
        
        if(p == null) {
            return 0;
        }

        // Jalurnya Melewati Root
        int len1 = tinggiHelper(p.left) + tinggiHelper(p.right) + 3;

        // Jalurnya Tidak Melewati Root
        int len2 = Math.max(diameterHelper(p.left), diameterHelper(p.right));

        return Math.max(len1, len2);
       
    }


    /******************
    * FUNGSI ITERATOR *
    ******************/

    @Override
    public Iterator<Type> iterator() {
        return new MyIterator();
    }
    
    // preOrder
    private class MyIterator implements Iterator<Type> {
        
        Stack<Node<Type>> stk = new Stack<>();

        public MyIterator() {
            
            if(root != null) {
                stk.push(root);
            }
            
        }
        
        @Override
        public boolean hasNext() {
           return !stk.isEmpty();
        }

        @Override
        public Type next() {
            
            Node<Type> cur = stk.peek();

            if(cur.left != null) {
               stk.push(cur.left);
            } else {

                Node<Type> tmp = stk.pop();

                while( tmp.right == null) {

                    if(stk.isEmpty()) {
                        return cur.data;
                    }

                    tmp = stk.pop();

                }

                stk.push(tmp.right);

            }

            return cur.data;
           
        }   //end of next()

        @Override
        public void remove() {

        }
        
    }   //end of MyIterator

    //=====================================================================

    // Class Node
    private class Node<T> {

        private T data;
        private Node<T> left, right;

        public Node(T data, Node<T> l, Node<T> r) {
            left = l; right = r;
            this.data = data;
        }

        public Node(T data) {
            this(data, null, null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
       
    }   //end of Node
    
}   //end of BST

class MyComp1 implements Comparator<Integer> {
    
    @Override
    public int compare(Integer x, Integer y) {
        return y-x;
    }
   
}
