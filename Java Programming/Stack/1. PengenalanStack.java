package PengenalanStack;

import java.util.Stack;

public class PengenalanStack {

    // Menambahkan Elemen di Posisi Paling Atas
    static void stack_push(Stack<Integer> stack) 
    { 
            for(int i = 0; i < 5; i++) 
            { 
                    stack.push(i);
            } 
    }

    // Menampilkan dan Menghapus Elemen yang Paling Atas 
    static void stack_pop(Stack<Integer> stack) 
    { 
            Integer y = stack.pop(); 
            System.out.println(y); 
    } 

    // Menampilkan Elemen Paling Atas
    static void stack_peek(Stack<Integer> stack) 
    { 
        Integer elemen = stack.peek(); 
        System.out.println("Elemen yang paling atas adalah " + elemen); 
    } 

    // Mencari Elemen dalam Stack
    static void stack_search(Stack<Integer> stack, int elemen) 
    { 
        Integer pos = (Integer) stack.search(elemen); 

        if(pos == -1) 
            System.out.println("Elemen " + elemen + " tidak ditemukan"); 
        else
            System.out.println("Elemen " + elemen + " ditemukan pada posisi " + pos); 
    } 
    
    //==========================================================================

    public static void main(String[] args) {
        
        System.out.println();  
        
        Stack<Integer> stack = new Stack<>();
            stack_push(stack);
            stack_peek(stack);
            stack_pop(stack);
            stack_pop(stack);
            stack_peek(stack);
            stack_search(stack, 0);
            stack_search(stack, 1);
            stack_search(stack, 2);
            stack_search(stack, 3); 
            stack_search(stack, 4); 
                
        System.out.println();  

    }
    
}