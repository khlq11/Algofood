import java.util.Scanner;

class Menu {
    String nama;
    int harga;
    Menu next;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.next = null;
    }
}
class MenuList {
    Menu head;

    public void tambahMenu(String nama, int harga) {
        Menu menuBaru = new Menu(nama, harga);
        if (head == null) {
            head = menuBaru;
        } else {
            Menu temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = menuBaru;
        }
    }

    public void tampilkanMenu() {
        if (head == null) {
            System.out.println("Menu kosong.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Menu Algofood:");
        Menu temp = head;
        while (temp != null) {
            System.out.println("- " + temp.nama + " (Rp " + temp.harga + ")");
            temp = temp.next;
        }

        System.out.print("Apakah Anda ingin mengurutkan menu berdasarkan harga? (ya/tidak): ");
        String konfirmasi = scanner.nextLine();
        if (konfirmasi.equalsIgnoreCase("ya")) {
            urutkanMenu();
            temp = head;
            System.out.println("Menu Algofood (Setelah diurutkan):");
            while (temp != null) {
                System.out.println("- " + temp.nama + " (Rp " + temp.harga + ")");
                temp = temp.next;
            }
        }
    }

    public Menu cariMenu(String nama) {
        Menu temp = head;
        while (temp != null) {
            if (temp.nama.equalsIgnoreCase(nama)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void urutkanMenu() {
        if (head == null || head.next == null) {
            System.out.println("Menu sudah terurut atau hanya satu item.");
            return;
        }

        Menu current = head;
        boolean swapped;

        do {
            swapped = false;
            current = head;

            while (current.next != null) {
                if (current.harga > current.next.harga) {
                    // Tukar data
                    String tempNama = current.nama;
                    int tempHarga = current.harga;

                    current.nama = current.next.nama;
                    current.harga = current.next.harga;

                    current.next.nama = tempNama;
                    current.next.harga = tempHarga;

                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("Menu telah diurutkan berdasarkan harga dari terendah ke tertinggi.");
    }
}
