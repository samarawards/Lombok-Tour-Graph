public class StackNode {
    String namaPengunjung;
    int rating;          // Rating 1-5
    String komentar;
    String tanggal;      // Format: "DD-MM-YYYY"
    int indeks;          // Urutan komentar (1, 2, 3, ...)
    
    StackNode next;      // Pointer ke node berikutnya dalam stack

    public StackNode(String nama, int rating, String komentar, String tanggal, int indeks) {
        this.namaPengunjung = nama;
        this.rating = rating;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.indeks = indeks;
        this.next = null;
    }

    public void display() {
        System.out.print("[" + indeks + "] ");
        for (int i = 0; i < rating; i++) {
            System.out.print("⭐");
        }
        System.out.println(" - " + namaPengunjung + " (" + tanggal + ")");
        System.out.println("    \"" + komentar + "\"");
    }
}