import java.util.LinkedList;
import java.util.Scanner;

public class DataStructureRecord {

    public record Person(String name, int age, String[] hobbies) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jumlah orang yang ingin dimasukkan: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        LinkedList<Person> peopleList = new LinkedList<>();

        for (int i = 0; i < numPeople; i++) {
            System.out.print("Masukkan nama orang ke-" + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Masukkan umur orang ke-" + (i + 1) + ": ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            System.out.print("Masukkan hobi orang ke-" + (i + 1) + " (pisahkan dengan koma jika lebih dari satu): ");
            String hobbiesInput = scanner.nextLine();
            String[] hobbies = hobbiesInput.split(", ");

            Person person = new Person(name, age, hobbies);
            peopleList.add(person);
        }

        // Menampilkan Hobi dengan Menggabungkan String
        System.out.println("People in the list:");
        for (Person person : peopleList) {
            System.out.println("Name: " + person.name() + ", Age: " + person.age() +
                    ", Hobbies: " + String.join(", ", person.hobbies()));
        }

        // Menampilkan Hobi dengan Index
        System.out.println("People in the list:");
        for (Person person : peopleList) {
            System.out.println("Name: " + person.name() + ", Age: " + person.age());
            System.out.println("Hobbies:");
            for (int i = 0; i < person.hobbies().length; i++) {
                System.out.println((i + 1) + ". " + person.hobbies()[i]);
            }
        }

        scanner.close();
    }
}
