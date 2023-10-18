package binary.search.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public Node root;
    
    //==========================================================================

    // Menambahkan Elemen dalam Tree
    public void tambahData(int data) {
        
        System.out.println("Menambahkan Elemen " + data);
        root = tambahRekursif(root, data);

    }

    // Fungsi Rekursif untuk Menambahkan Elemen
    private Node tambahRekursif(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.value) {
            current.left = tambahRekursif(current.left, data);
        } else if (data > current.value) {
            current.right = tambahRekursif(current.right, data);
        }

        return current;

    }
    
    //==========================================================================

    // Fungsi Kosong
    private boolean kosong() {

        return root == null;

    }
    
    // Mengecek apakah Tree nya Kosong atau Tidak
    public void apakahKosong() {
        
        System.out.println("Apakah Tree nya Kosong?");
        
        if (kosong() == false) {
            System.out.println("-> Tree Tidak Kosong");
        } else {
            System.out.println("-> Tree Kosong");
        }
        
    }
    
    //==========================================================================
    
    // Fungsi Ukuran
    private int ukuran() {

        return ukuranRekursif(root);

    }

    // Fungsi Rekursif untuk Mengambil Ukuran
    private int ukuranRekursif(Node current) {

        return current == null ? 0 : ukuranRekursif(current.left) + 1 
                + ukuranRekursif(current.right);

    }
    
    // Mengambil Ukuran Tree
    public void ukuranTree() {
        
        System.out.println("Berapakah Ukuran Tree nya?");
        System.out.println("-> Ukuran Tree adalah " + ukuran());
        
    }
    
    //==========================================================================

    // Fungsi Pencarian
    private boolean cari(int data) {

        return cariRekursif(root, data);

    }

    // Fungsi Rekursif untuk Mencari Elemen
    private boolean cariRekursif(Node current, int data) {

        if (current == null) {
            return false;
        }

        if (data == current.value) {
            return true;
        }

        return data < current.value
          ? cariRekursif(current.left, data)
          : cariRekursif(current.right, data);

    }
    
    // Mencari Elemen dalam Tree
    public void cariData(int data) {
        
        System.out.println("Apakah Data " + data + " Ada dalam Tree?");
        
        boolean cari = cari(data);
        
        if(cari == true) {
            System.out.println("-> Ada");
        } else {
            System.out.println("-> Tidak Ada");
        }
        
    }

    //==========================================================================

    // Menghapus Elemen dalam Tree
    public void hapusData(int data) {

        System.out.println("Menghapus Data " + data);
        root = hapusRekursif(root, data);

    }

    // Fungsi Rekursif untuk Menghapus Elemen
    private Node hapusRekursif(Node current, int data) {

        if (current == null) {
            return null;
        }

        if (data == current.value) {

            // Kasus 1: Tidak Mempunyai Anak
            if (current.left == null && current.right == null) {
                return null;
            }

            // Kasus 2: Punya Satu Anak
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Kasus 3: Punya Dua Anak
            int nilaiTerkecil = cariNilaiTerkecil(current.right);
            current.value = nilaiTerkecil;
            current.right = hapusRekursif(current.right, nilaiTerkecil);
            return current;

        }

        if (data < current.value) {
            current.left = hapusRekursif(current.left, data);
            return current;

        }

        current.right = hapusRekursif(current.right, data);
        return current;

    }

    // Mencari Elemen dengan Nilai Terkecil
    private int cariNilaiTerkecil(Node root) {

        return root.left == null ? root.value : cariNilaiTerkecil(root.left);

    }

    //==========================================================================

    // Funsgi Transverse InOrder
    public void inOrder(Node node) {

        if (node != null) {
            inOrder(node.left);
            cetak(node.value);
            inOrder(node.right);
        }

    }
    
    // Melakukan Transverse InOrder
    public void traverseInOrder() {
        
        System.out.println("Transverse InOrder");
        System.out.print("-> ");
        inOrder(root);
        System.out.println("");
        
    }

    // Funsgi Transverse PreOrder
    public void preOrder(Node node) {

        if (node != null) {
            cetak(node.value);
            preOrder(node.left);
            preOrder(node.right);
        }

    }
    
    // Melakukan Transverse PreOrder
    public void traversePreOrder() {
        
        System.out.println("Transverse PreOrder");
        System.out.print("-> ");
        preOrder(root);
        System.out.println("");
        
    }

    // Funsgi Transverse PostOrder
    public void postOrder(Node node) {

        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            cetak(node.value);
        }

    }
    
    // Melakukan Transverse PostOrder
    public void traversePostOrder() {
        
        System.out.println("Transverse PostOrder");
        System.out.print("-> ");
        postOrder(root);
        System.out.println("");
        
    }

    // Melakukan Transverse LevelOrder
    public void traverseLevelOrder() {

        System.out.println("Transverse LevelOrder");
        System.out.print("-> ");
        
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        
        while (!nodes.isEmpty()) {
            
            Node node = nodes.remove();
            System.out.print(node.value + " ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }

        }
        
        System.out.println("");

    }
    
    // Melakukan Transverse InOrder tanpa Rekursif
    public void traverseInOrderTanpaRekursif() {

        System.out.println("Transverse InOrder tanpa Rekursif");
        System.out.print("-> ");
        
        Stack<Node> stack = new Stack<Node>();

        Node current = root;

        stack.push(root);
        
        while(! stack.isEmpty()) {

            while(current.left != null) {
                current = current.left;                
                stack.push(current);                
            }

            current = stack.pop();
            cetak(current.value);

            if(current.right != null) {
                current = current.right;                
                stack.push(current);
            }

        }
        
        System.out.println("");

    }

    // Melakukan Transverse PreOrder tanpa Rekursif
    public void traversePreOrderTanpaRekursif() {
        
        System.out.println("Transverse PreOrder tanpa Rekursif");
        System.out.print("-> ");

        Stack<Node> stack = new Stack<Node>();

        Node current = root;

        stack.push(root);
        
        while(! stack.isEmpty()) {

            current = stack.pop();
            cetak(current.value);

            if(current.right != null) {
                stack.push(current.right);
            }

            if(current.left != null) {
                stack.push(current.left);
            }

        }
        
        System.out.println("");

    }
   
    // Melakukan Transverse PostOrder tanpa Rekursif
    public void traversePostOrderTanpaRekursif() {
        
        System.out.println("Transverse PostOrder tanpa Rekursif");
        System.out.print("-> ");

        Stack<Node> stack = new Stack<Node>();

        Node prev = root;

        Node current = root;

        stack.push(root);

        while (!stack.isEmpty()) {

            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                
                current = stack.pop();
                cetak(current.value);
                prev = current;
                
            } else {

                if (current.right != null) {
                    stack.push(current.right);
                }

                if (current.left != null) {
                    stack.push(current.left);
                }

            }

        }
        
        System.out.println("");

    }
   
    // Mencetak Nilai
    private void cetak(int data) {

        System.out.print(data + " ");        

    }

}