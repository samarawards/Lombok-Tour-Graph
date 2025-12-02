public class StackNode {
    String namaPengunjung;
    int rating;           // 1-5
    String komentar;
    String tanggal;
    int indeks;          // Untuk sorting (1 = pertama, 2 = kedua, dst)
    StackNode next;

    public StackNode(String nama, int rating, String komentar, String tanggal, int indeks) {
        this.namaPengunjung = nama;
        this.rating = rating;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.indeks = indeks;
        this.next = null;
    }
}