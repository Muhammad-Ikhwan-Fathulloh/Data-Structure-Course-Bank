package doubly.linked.list;

public class DoublyLinkedList {
    
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        
        head = null;
        tail = null;
        size = 0;
        
    }

    // Menambahkan Elemen PAling Depan
    public void tambahDepan(int data){
        
        System.out.println("Menambahkan " + data + " di Paling Depan");
        
        Node node = new Node(data);
        if(head == null && tail == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
        size++;
        
    }

    // Menambahkan Elemen Paling Belakang
    public void tambahBelakang(int data) {
        
        System.out.println("Menambahkan " + data + " di Paling Belakang");
        
        Node node = new Node(data);
        if(tail == null && head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
            
    }

    // Menghapus Elemen Paling Depan
    public void hapusDepan() throws Exception {
        
        System.out.println("Menghapus Elemen Paling Depan");
        
        if(head == null && tail == null ){
            throw new Exception("List is empty!");
        }
        
        if(head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        head.next.prev = null;
        head = head.next;
        size--;
            
    }

    // Menghapus Elemen Paling Belakang
    public void hapusBelakang() throws Exception {
        
        System.out.println("Menghapus Elemen Paling Belakang");
        
        if(head == null && tail == null) {
            throw new Exception("List is empty!");
        }
        
        if(head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        
        tail.prev.next = null;
        tail = tail.prev;
        size--;
            
    }
    
    // Menghapus Elemen Tertentu pada List
    public void Hapus(int data) throws Exception {
        
        System.out.println("Hapus Data " + data);
        
        Node temp = head;
        Node prevNode = null;
        
        if(temp == null) {
            throw new Exception("List Kosong");
        }
        size--;

        if(temp == tail) {
            if(temp.key == data) {
                head = null;
                tail = null;
                return;
            } else {
                throw new Exception("Data Tidak Ditemukan");
            }
        }
        
        if(head.key == data) {
            head = head.next;
            head.prev = null;
            return;
        }
        
        while(temp != null && temp.key != data) {
            prevNode = temp;
            temp = temp.next;
        }
        
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        temp = null;
            
    }

    // Menampilkan Elemen Paling Depan
    public String tampilDepan() throws Exception {
        
        if(head == null) {
            throw new Exception("List Kosong");
        }
        
        return "Elemen Paling Depan adalah " + head.key;
        
    }

    // Menampilkan Elemen Paling Belakang
    public String tampilBelakang() throws Exception {
        
        if(tail == null) {
            throw new Exception("List Kosong");
        }
        
        return "Elemen Paling Belakang adalah " + tail.key;
        
    }

    // Mencari Elemen Tertentu dalam List
    public String cariElemen(int data) {
        
        Node temp = head;
        
        while(temp != null) {
            if(temp.key == data) {
                return "Elemen " + data + " Ditemukan";
            }
            temp = temp.next;
        }
        
        return "Elemen " + data + " Tidak Ditemukan";
        
    }

    // Menampilkan Ukuran List
    public String ukuranList() {
        
        return "Ukuran List adalah " + size;
        
    }

    // Mencetak List (Urutan Normal)
    public void cetakNormal() throws Exception {
        
        System.out.print("List Normal   : ");
        
        Node temp = head;
        
        if(temp == null) {
            throw new Exception("List Kosong");
        }
        
        while(temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        
        System.out.println();
        
    }

    // Mencetak List (Urutan Terbalik)
    public void cetakTerbalik() throws Exception {
        
        System.out.print("List Terbalik : ");
        
        Node temp = tail;
        
        if(temp == null) {
            throw new Exception("List Kosong");
        }
        
        while(temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.prev;
        }
        
        System.out.println();
            
    }
    
    // Mengganti Elemen Tertentu di List
    public void gantiElemen(int dataLama, int dataBaru) throws Exception {
        
        System.out.println("Mengganti Elemen " + dataLama 
                + " dengan " + dataBaru);
        
        Node current = head;
 
        // Dilooping sampai ketemu
        while (current != null && current.key != dataLama) {
            current = current.next;
        }
        
        if (current == null) {
            throw new Exception("\nElemen Tidak Ditemukan");
        }
        
        if (current != null) {
            current.key = dataBaru;
        }
            
    }
    
}