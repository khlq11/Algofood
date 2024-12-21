import java.util.Scanner;

public class Algofood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data awal
        MenuList menuList = new MenuList();
        menuList.tambahMenu("Nasi Goreng", 25000);
        menuList.tambahMenu("Mie Ayam", 20000);
        menuList.tambahMenu("Bakso", 22000);
        menuList.tambahMenu("Sate Ayam", 30000);
        menuList.tambahMenu("Ayam Geprek", 27000);
        menuList.tambahMenu("Es Teh", 5000);
        menuList.tambahMenu("Es Jeruk", 7000);

        Antrian antrian = new Antrian();

        Graph graph = new Graph(7);
        graph.tambahKota(0, "Algofood");
        graph.tambahKota(1, "Ampenan"); 
        graph.tambahKota(2, "Udayana");  
        graph.tambahKota(3, "Monjok");   
        graph.tambahKota(4, "Rembiga");  
        graph.tambahKota(5, "Cemare");   
        graph.tambahKota(6, "Karang Baru"); 

        graph.tambahJalan(0, 2, "Jalan Lestari",1);
        graph.tambahJalan(0, 1, "Jalan Adi Sucipto",2);
        graph.tambahJalan(1, 4, "Jalan Dr. Wahidin",3);
        graph.tambahJalan(4, 6, "Jalan Dr. Soetomo",4);
        graph.tambahJalan(6, 5, "Jalan Hos Cokroaminoto",5);
        graph.tambahJalan(5, 2, "Jalan Gili Trawangan",6);
        graph.tambahJalan(2, 1, "Jalan Dasan Agung",7);
        graph.tambahJalan(2, 3, "Jalan Taman Indah",8);
        graph.tambahJalan(2, 6, "Jalan Majapahit",9);
        graph.tambahJalan(0, 5, "Jalan Jendral Sudirman",10);
        graph.tambahJalan(0, 3, "Jalan Pendidikan",11);
        graph.tambahJalan(0, 4, "Jalan Langko",12);
        graph.tambahJalan(1, 3, "Jalan Sriwijaya",13);
        graph.tambahJalan(1, 6, "Jalan Swasembada",14);
        graph.tambahJalan(4, 3, "Jalan Swakarya",15);
        graph.tambahJalan(4, 5, "Jalan Gili Air",16);
        graph.tambahJalan(6, 3, "Jalan Gili Meno",17);
        graph.tambahJalan(5, 3, "Jalan Pattimura",18);

        // Menu utama
        while (true) {
            System.out.println("\n=== ALGOFOOD ===");
            System.out.println("1. Lihat Menu");
            System.out.println("2. Pesan Makanan");
            System.out.println("3. Lihat Antrian");
            System.out.println("4. Rute Tercepat Menuju Algofood");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    menuList.tampilkanMenu();
                    break;
                case 2:
                    System.out.print("Masukkan nama pemesan: ");
                    String namaPemesan = scanner.nextLine();
                    while (true) {
                        System.out.print("Masukkan nama makanan (atau ketik 'selesai' untuk selesai): ");
                        String makanan = scanner.nextLine();
                        if (makanan.equalsIgnoreCase("selesai")) break;

                        Menu menu = menuList.cariMenu(makanan);
                        if (menu != null) {
                            System.out.print("Masukkan jumlah: ");
                            int jumlah = scanner.nextInt();
                            scanner.nextLine();
                            antrian.tambahAntrian(namaPemesan, makanan, jumlah);
                        } else {
                            System.out.println("Menu tidak ditemukan.");
                        }
                    }
                    break;
                case 3:
                    antrian.tampilkanAntrian();
                    break;
                case 4:
                    System.out.println("Masukkan indeks kota awal (1: Ampenan, 2: Udayana, 3: Monjok, 4: Rembiga, 5: Cemare, 6: Karang Baru):");
                    int start = scanner.nextInt(); // Konversi indeks input dari 1 ke 0
                    graph.tampilkanRuteTercepat(start);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Algofood!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}