for (int i = 0; i < 5; i++) {
    System.out.println("Perulangan ke-" + i);
}

int i = 0;
while (i < 5) {
    System.out.println("Perulangan ke-" + i);
    i++;
}

int i = 0;
do {
    System.out.println("Perulangan ke-" + i);
    i++;
} while (i < 5);

int[] angka = {1, 2, 3, 4, 5};
for (int num : angka) {
    System.out.println(num);
}