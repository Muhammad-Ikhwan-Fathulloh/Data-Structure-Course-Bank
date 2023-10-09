package LoopingStack;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class LoopingStack {

    public static void main(String[] args) {
        
        System.out.println("");
        
        //Deklarasi Stack
        Stack<String> MatKul = new Stack<>();

        MatKul.add("KomStat");
        MatKul.add("StrukDat");
        MatKul.add("DatMin");
        MatKul.add("PranCis");

        //======================================================================
        
        System.out.println("Looping dengan forEach\n");
        
        MatKul.forEach(System.out::println);
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping dengan Iterator()\n");
        
        Iterator<String> matkulIterator = MatKul.iterator();
        
        while(matkulIterator.hasNext()) {
            String loop = matkulIterator.next();
            System.out.println(loop);
        }
        
        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping dengan Iterator()");
        System.out.println("dan forEachRemaining()\n");
        
        matkulIterator = MatKul.iterator();
        
        while(matkulIterator.hasNext()) {
            String plate = matkulIterator.next();
            System.out.println(plate);
        }

        System.out.println("");
        
        //======================================================================
        
        System.out.println("Looping dari Atas ke Bawah");
        System.out.println("dengan listIterator()\n");
        
        ListIterator<String> matkulListIterator = MatKul.listIterator(MatKul.size());
        
        while(matkulListIterator.hasPrevious()) {
            String plate = matkulListIterator.previous();
            System.out.println(plate);
        }
        
        System.out.println("");
        
    }
    
}
