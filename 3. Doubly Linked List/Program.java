package doubly.linked.list;

public class Program {

    public static void main(String [] args) {
        
        System.out.println("");
        
        DoublyLinkedList list = new DoublyLinkedList();
        
        try {
            
            list.tambahBelakang(10);
            list.tambahBelakang(20);
            list.tambahDepan(8);
            System.out.println(list.ukuranList());
            list.tambahDepan(6);
            list.tambahBelakang(22);
            list.tambahBelakang(16);
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");

            System.out.println(list.tampilBelakang());
            System.out.println(list.tampilDepan());
            System.out.println(list.cariElemen(9));
            System.out.println(list.ukuranList());
            System.out.println(list.cariElemen(6));

            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");
            
            list.Hapus(6);
            System.out.println( list.ukuranList());
            list.hapusDepan();
            list.hapusBelakang();
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");
            
            list.gantiElemen(10, 37);
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");
            
            list.gantiElemen(22, 40);
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");
            
            list.tambahDepan(8);
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
            System.out.println("");
            
            list.gantiElemen(20, 7);
            
            System.out.println("");
            
            list.cetakNormal();
            list.cetakTerbalik();
            
        } catch(Exception e) {
            
            System.out.println(e);
                
        }
        
        System.out.println("");
		
    }

}