public class IfElseExample {
    public static void main(String[] args) {
        int nilai = 75;

        if (nilai >= 80) {
            System.out.println("Nilai Anda A");
        } else if (nilai >= 70) {
            System.out.println("Nilai Anda B");
        } else if (nilai >= 60) {
            System.out.println("Nilai Anda C");
        } else {
            System.out.println("Nilai Anda D");
        }
    }
}

public class SwitchCaseExample {
    public static void main(String[] args) {
        int pilihan = 2;

        switch (pilihan) {
            case 1:
                System.out.println("Anda memilih opsi 1");
                break;
            case 2:
                System.out.println("Anda memilih opsi 2");
                break;
            case 3:
                System.out.println("Anda memilih opsi 3");
                break;
            default:
                System.out.println("Pilihan tidak valid");
        }
    }
}