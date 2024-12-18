class NodeAntrian {
    String namaPemesan;
    String pesanan;
    NodeAntrian next;

    public NodeAntrian(String namaPemesan, String pesanan) {
        this.namaPemesan = namaPemesan;
        this.pesanan = pesanan;
        this.next = null;
    }
}

class Antrian {
    NodeAntrian front, rear;

    public void tambahAntrian(String namaPemesan, String pesanan) {
        NodeAntrian nodeBaru = new NodeAntrian(namaPemesan, pesanan);
        if (rear == null) {
            front = rear = nodeBaru;
        } else {
            rear.next = nodeBaru;
            rear = nodeBaru;
        }
        System.out.println("Antrian ditambahkan: " + namaPemesan + " memesan " + pesanan);
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
