public class LLNode {
    String lokasi;
    String jenis;
    float jarak;
    LLNode next;

    public LLNode(String lokasi, String jenis, float jarak) {
        this.lokasi = lokasi;
        this.jenis = jenis;
        this.jarak = jarak;
        this.next = null;
    }

    public LLNode(String lokasi) {
        this.lokasi = lokasi;
        this.next = null;
    }

    
    String namaPengunjung;
    int rating;
    String komentar;
    String tanggal;
    int indeks;
    
    public LLNode(String nama, int rating, String komentar, String tanggal, int indeks) {
        this.namaPengunjung = nama;
        this.rating = rating;
        this.komentar = komentar;
        this.tanggal = tanggal;
        this.indeks = indeks;
        this.next = null;
    }
}
