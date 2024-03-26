public class LearnSearching {
    
    static void pencarian(int linear[], int nilai){
        int check = 0;
        for(int i = 0; i < linear.length; i++){
            String linears =Integer.toString(linear[i]);
                for(int j = 0; j < linears.length(); j++){
                    int value = Integer.parseInt(String.valueOf(linears.charAt(j)));
                    if (value == nilai) {
                        System.out.println(linear[i]);
                        check = 1;
                    }
                }   
        }
        if(check == 0){
           System.out.println("Tidak ditemukan");
        }
    }
    
    public static void main(String[] args) {
        int linear[] = {89, 57, 91, 47, 95, 3, 27, 22, 67, 99,
                        204, 108, 354, 123, 487, 563, 179, 698};   
        pencarian(linear, 9);
    }
}
