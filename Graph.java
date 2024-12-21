class Graph {
    class Node {
        String namaKota;
        String jalan;
        int bobot; // Menambahkan bobot
        Node next;
    
        public Node(String namaKota, String jalan, int bobot) {
            this.namaKota = namaKota;
            this.jalan = jalan;
            this.bobot = bobot; // Inisialisasi bobot
            this.next = null;
        }
    }

    class AdjacencyList {
        String kota;
        Node head;

        public AdjacencyList(String kota) {
            this.kota = kota;
            this.head = null;
        }
    }

    AdjacencyList[] adjacencyLists;
    int size;

    public Graph(int size) {
        this.size = size;
        adjacencyLists = new AdjacencyList[size];
    }

    public void tambahKota(int index, String namaKota) {
        adjacencyLists[index] = new AdjacencyList(namaKota);
    }

    public void tambahJalan(int indexKota1, int indexKota2, String jalan, int bobot) {
        Node nodeBaru = new Node(adjacencyLists[indexKota2].kota, jalan, bobot);
        nodeBaru.next = adjacencyLists[indexKota1].head;
        adjacencyLists[indexKota1].head = nodeBaru;
    
        // Bidirectional
        Node nodeBaru2 = new Node(adjacencyLists[indexKota1].kota, jalan, bobot);
        nodeBaru2.next = adjacencyLists[indexKota2].head;
        adjacencyLists[indexKota2].head = nodeBaru2;
    }

    // Implementasi Dijkstra tanpa menggunakan PriorityQueue
    public void tampilkanRuteTercepat(int start) {
        int[] jarak = new int[size];
        boolean[] visited = new boolean[size];
        int[] prev = new int[size];
        String[] jalanTerbaik = new String[size];
    
        // Inisialisasi jarak dan prev
        for (int i = 0; i < size; i++) {
            jarak[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            visited[i] = false;
            jalanTerbaik[i] = "";
        }
    
        jarak[start] = 0;
    
        // Algoritma Dijkstra
        for (int i = 0; i < size; i++) {
            int u = -1;
            for (int j = 0; j < size; j++) {
                if (!visited[j] && (u == -1 || jarak[j] < jarak[u])) {
                    u = j;
                }
            }
    
            if (u == -1 || jarak[u] == Integer.MAX_VALUE) break;
    
            visited[u] = true;
    
            Node temp = adjacencyLists[u].head;
            while (temp != null) {
                int v = getIndex(temp.namaKota);
                if (!visited[v] && jarak[u] + temp.bobot < jarak[v]) {
                    jarak[v] = jarak[u] + temp.bobot;
                    prev[v] = u;
                    jalanTerbaik[v] = temp.jalan;
                }
                temp = temp.next;
            }
        }
    
        // Tampilkan rute dari start ke Algofood (indeks 0)
        System.out.println("\nRute tercepat menuju Algofood:");
        printRuteDenganDetail(start, 0, prev, jalanTerbaik);
        System.out.println();
    }
    
    private void printRuteDenganDetail(int start, int target, int[] prev, String[] jalanTerbaik) {
        if (target == start) {
            System.out.print(adjacencyLists[start].kota); // Cetak posisi awal
        } else if (prev[target] != -1) {
            printRuteDenganDetail(start, prev[target], prev, jalanTerbaik);
            System.out.print(" -> " + adjacencyLists[target].kota + " melalui " + jalanTerbaik[target]);
        }
    }
    // Mendapatkan index kota berdasarkan nama kota
    private int getIndex(String kota) {
        for (int i = 0; i < size; i++) {
            if (adjacencyLists[i].kota.equals(kota)) {
                return i;
            }
        }
        return -1;
    }
}