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
        Menu temp = head;
        System.out.println("Menu Algofood:");
        while (temp != null) {
            System.out.println("- " + temp.nama + " (Rp " + temp.harga + ")");
            temp = temp.next;
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
}
