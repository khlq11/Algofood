class NodeAntrian {
    String namaPemesan;
    String pesanan;
    int jumlah;
    NodeAntrian next;

    public NodeAntrian(String namaPemesan, String pesanan, int jumlah) {
        this.namaPemesan = namaPemesan;
        this.pesanan = pesanan;
        this.jumlah = jumlah;
        this.next = null;
    }
}

class Antrian {
    NodeAntrian front, rear;

    public void tambahAntrian(String namaPemesan, String pesanan, int jumlah) {
        NodeAntrian nodeBaru = new NodeAntrian(namaPemesan, pesanan + " (" + jumlah + ")", jumlah);
        if (rear == null) {
            front = rear = nodeBaru;
        } else {
            NodeAntrian temp = front;
            while (temp != null) {
                if (temp.namaPemesan.equalsIgnoreCase(namaPemesan)) {
                    // Gabungkan pesanan baru dengan pesanan sebelumnya
                    temp.pesanan += ", " + pesanan + " (" + jumlah + ")";
                    return;
                }
                temp = temp.next;
            }
            rear.next = nodeBaru;
            rear = nodeBaru;
        }
        System.out.println("Antrian ditambahkan: " + namaPemesan + " memesan " + pesanan + " (" + jumlah + ")");
    }

    public void tampilkanAntrian() {
        if (front == null) {
            System.out.println("Tidak ada antrian.");
            return;
        }
        System.out.println("Antrian saat ini:");
        NodeAntrian temp = front;
        while (temp != null) {
            System.out.println("- " + temp.namaPemesan + " memesan " + temp.pesanan);
            temp = temp.next;
        }
    }
}