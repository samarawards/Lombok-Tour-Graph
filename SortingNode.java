public class SortingNode{
    String nama;
    String kabupaten;
    String jenis;
    int rating;
    String deskripsi;
    SortingNode next;

    public SortingNode(String nama, String kabupaten, String jenis, int rating, String deskripsi){
        this.nama = nama;
        this.kabupaten = kabupaten;
        this.jenis = jenis;
        this.rating = rating;
        this.deskripsi = deskripsi;
        this.next = null;
    }
}