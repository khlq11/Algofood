class Graph {
    class Node {
        String namaKota;
        String jalan;
        Node next;

        public Node(String namaKota, String jalan) {
            this.namaKota = namaKota;
            this.jalan = jalan;
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

    public void tambahJalan(int indexKota1, int indexKota2, String jalan) {
        Node nodeBaru = new Node(adjacencyLists[indexKota2].kota, jalan);
        nodeBaru.next = adjacencyLists[indexKota1].head;
        adjacencyLists[indexKota1].head = nodeBaru;

        // Bidirectional
        Node nodeBaru2 = new Node(adjacencyLists[indexKota1].kota, jalan);
        nodeBaru2.next = adjacencyLists[indexKota2].head;
        adjacencyLists[indexKota2].head = nodeBaru2;
    }

    public void tampilkanRute(int indexKota) {
        Node temp = adjacencyLists[indexKota].head;
        System.out.println("Rute dari " + adjacencyLists[indexKota].kota + " menuju Algofood:");
        while (temp != null) {
            System.out.println("- Melalui " + temp.jalan + " ke " + temp.namaKota);
            temp = temp.next;
        }
    }
}
