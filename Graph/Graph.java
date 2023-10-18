package graph;

import java.util.*; 

class Graph<T> { 

    private final Map<T, List<T> > map = new HashMap<>(); 

    // Menambahkan Simpul pada Grafik
    public void tambahSimpul(T s) { 
        map.put(s, new LinkedList<>()); 
    } 

    // Menambahkan Tepian antara Asal dan Tujuan
    public void tambahGaris(T source, T destination, boolean bidirectional) { 

        if (!map.containsKey(source)){
            tambahSimpul(source);
        } 

        if (!map.containsKey(destination)){
            tambahSimpul(destination);
        } 

        map.get(source).add(destination); 
        
        if (bidirectional == true) { 
            map.get(destination).add(source); 
        } 
            
    } 

    // Menampilkan Jumlah Simpul
    public void jumlahSimpul() {
 
        System.out.println("Jumlah Simpul adalah " + map.keySet().size());
        
    } 

    // Menampilkan Jumlah Garis
    public void jumlahGaris(boolean bidirection) { 
        
        int count = 0; 
        
        for (T v : map.keySet()) { 
            count += map.get(v).size(); 
        } 
        
        if (bidirection == true) { 
            count = count / 2; 
        } 
        
        System.out.println("Jumlah Garis adalah " + count);
            
    } 

    // Mengecek Apakah Suatu Grafik Mempunyai Simpul atau Tidak 
    public void punyaSimpul(T s) { 
        
        if (map.containsKey(s)) { 
            System.out.println("Grafik Mempunyai Simpul di " + s); 
        } else { 
            System.out.println("Grafik Tidak Mempunyai Simpul di " + s); 
        } 

    } 

    // Mengecek Apakah Suatu Grafik Mempunyai Garis atau Tidak
    public void punyaGaris(T s, T d) {
        
        if (map.get(s).contains(d)) { 
            System.out.println("Ada Garis antara " + s + " dan " + d); 
        } else { 
            System.out.println("Tidak Ada Garis antara " + s + " dan " + d); 
        } 

    } 

    // Mencetak Grafik
    @Override
    public String toString() {
        
        StringBuilder builder = new StringBuilder(); 

        for (T v : map.keySet()) { 
        
            builder.append(v.toString()).append(" -> "); 
            
            for (T w : map.get(v)) { 
                builder.append(w.toString()).append(" "); 
            } 
            
            builder.append("\n"); 
        
        } 

        return (builder.toString()); 
            
    }
    
} 

// Program Utama
public class Main { 

    public static void main(String args[]) { 

        System.out.println("");
        
        // Deklarasi Grafik
        Graph<String> grafik = new Graph<>(); 

        grafik.tambahGaris("Bob", "Alice", true);
        grafik.tambahGaris("Bob", "Rob", true);
        grafik.tambahGaris("Alice", "Mark", true);
        grafik.tambahGaris("Rob", "Mark", true);
        grafik.tambahGaris("Alice", "Mariah", true);
        grafik.tambahGaris("Rob", "Mariah", true);
                
        System.out.println("Grafik :\n" + grafik.toString()); 
        grafik.jumlahSimpul(); 
        grafik.jumlahGaris(true);
        
        System.out.println("");
        
        grafik.punyaGaris("Rob", "Mariah");
        grafik.punyaGaris("Bob", "Mariah");
        
        System.out.println("");
        
        grafik.punyaSimpul("Rob");
        grafik.punyaSimpul("Bob");
        grafik.punyaSimpul("Mark");
        grafik.punyaSimpul("Alice");
        grafik.punyaSimpul("Mariah");
                  
        System.out.println("");
        
    } 
    
} 