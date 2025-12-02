public class StackNode {
<<<<<<< HEAD
    Ulasan ulasan;
    StackNode next;

    public StackNode(Ulasan ulasan) {
        this.ulasan = ulasan;
=======
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
>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64
        this.next = null;
    }
}