package binary.search.tree;

import java.util.*;

public class BinarySearchTree {
    
    int ukuran;
    Node root;
    int cari = 0;

    public BinarySearchTree() {
        
        this.ukuran = 0;
        this.root = null;
        
    }

    // Menambahkan Elemen ke dalam Tree
    public void tambahData(int data) {
        
        System.out.println("Memasukkan " + data);
        
        Node node = new Node(data);
        Node parent = cari(data);
        
        if(parent == null) {
            root = node;
            return;
        }
        
        node.parent = parent;
        node.height = node.parent.height + 1;
        ukuran++;

        if(data > parent.key) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        
    }
    
    // Menghapus Elemen dari Tree
    public void hapusData(int data) {
        
        Node temp = cari(data);
        
        if(temp.key != data) {
            System.out.println("Gagal Menghapus Data " + data);
            return;
        }
        
        System.out.println("Berhasil Menghapus Data " + data);
        
        if(temp.right == null) {
            
            if(temp.parent == null) {
                
                root = temp.left;
                
                if(root != null) {
                    root.parent = null;
                }
                
                temp = null;
                return;
                
            }
            
            if(temp.left != null) {
                temp.left.parent = temp.parent;	
            }
            
            if(temp.parent.right == temp) {
                temp.parent.right = temp.left;
                temp = null;
                return;
            } else {
                temp.parent.left = temp.left;
                temp = null;
                return;
            }
                
        }

        Node nextTemp = cariDataSelanjutnya(temp.key);
        
        if(nextTemp.right != null) {
            nextTemp.right.parent=nextTemp.parent;
        }
        
        if(nextTemp.parent == null) {
            root = nextTemp.right;
        }
        
        if(nextTemp.parent != null && nextTemp.parent.left == nextTemp) {
            nextTemp.parent.left = nextTemp.right;
        }
        
        if(nextTemp.parent != null && nextTemp.parent.right == nextTemp) {
            nextTemp.parent.right = nextTemp.right;
        }

        if(temp.left != null) {
            temp.left.parent = nextTemp;
        }
        
        if(temp.right != null) {
            temp.right.parent = nextTemp;
        }
        
        nextTemp.left = temp.left;
        nextTemp.right = temp.right;
        nextTemp.parent = temp.parent;

        if(temp.parent == null) {
            root = nextTemp;
            temp = null;
            return;
        }
        
        if(temp.parent.right == temp) {
            temp.parent.right = nextTemp;
            temp = null;
            return;
        }
        
        temp.parent.left = nextTemp;
        temp = null;
            
    }

    // Mencari Elemen Tertentu dalam Tree
    public Node cari(int data) {
        
        Node temp = root;
        Node prev = null;
        
        if(temp == null) {
            return temp;
        }

        while(temp != null) {
            
            if(temp.key == data) {
                return temp;
            }			

            if(data > temp.key) {
                prev = temp;
                temp = temp.right;
                continue;
            }
            
            if(data < temp.key) {
                prev = temp;
                temp = temp.left;
            }
            
        }
        
        cari = prev.key;
        
        return prev;
        
    }
    
    public void cariData(int data) {
        
        
        if(cari(data).key == cari) {
            System.out.println("Data " + data + " Tidak Ditemukan");
        } else {
            System.out.println("Data " + data + " Ditemukan");
        }
    
    }
    
    // Mencari hanya Big Node berikutnya dari Node yang diberikan
    // akan bekerja dengan benar ketika Node-nya terdapat di Tree
    // jika yang diberikan adalah Key Terbesar, maka akan
    // mengembalikan Node yang sama
    public Node cariDataSelanjutnya(int data) {
        
        Node temp = cari(data);
        
        if(temp.key != data) {
            System.out.println(data + " Tidak Ditemukan\n");
            return temp;
        }
        
        Node right = temp.right;
        Node parent = temp.parent;

        if(right != null) {
            
            while(right.left != null) {
                right = right.left;
            }
            
            return right;
            
        }

        while(parent != null) {
            
            if(parent.key > temp.key) {
                return parent;
            }
            
            parent = parent.parent;
            
        }
        
        return temp;
        
    }


    // Mengembalikan angka antara data1 dan data2
    // termasuk data1 dan data2 jika mereka ada di pohon
    public List<Node> cariInterval(int data1, int data2) {
        
        System.out.println("Data antara " + data1 + " dan " + data2 + " adalah");
        
        List<Node> list = new ArrayList<>();
        Node node1 = cari(data1);
        
        if(node1 == null) {
            return list;
        }

        while(node1.key <= data2) {
            
            if(node1.key >= data1) {
                list.add(node1);
            }
            
            Node temp = cariDataSelanjutnya(node1.key);
            
            if(temp == node1) {
                break;
            }
            
            node1 = temp;
                
        }
        
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).key + " ");
        }
        
        System.out.println("");
        
        return list;
            
    }
		
} 
