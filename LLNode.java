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
}
