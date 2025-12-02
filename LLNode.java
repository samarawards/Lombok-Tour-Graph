public class LLNode {
    String lokasi;
    String jenis;
    float jarak; // ✅ FIX: Ganti ke float
    LLNode next;

    public LLNode(String lokasi, String jenis, float jarak) {
        this.lokasi = lokasi;
        this.jenis = jenis;
        this.jarak = jarak;
        this.next = null;
    }
}
