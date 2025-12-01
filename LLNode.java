public class LLNode {
    String lokasi;
    String jenis;
    int jarak;
    LLNode next;

    public LLNode(String lokasi, String jenis, int jarak){
        this.lokasi = lokasi;
        this.jenis = jenis;
        this.jarak = jarak;
        this.next = null;
    }
}
