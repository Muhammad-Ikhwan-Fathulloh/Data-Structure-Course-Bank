public record Student(String name, String nim, String programStudy, double ipk) {
    public static void void main(String[] args) {
        Student student1 = new Student("John Doe", "12345", "Informatika", 3.8);
        Student student2 = new Student("Jane Smith", "67890", "Ekonomi", 3.5);

        System.out.println("Student 1: " + student1);
        System.out.println("Student 2: " + student2);
    }
}
