public class LinkedList {
    LLNode head, tail;
    float totalJarak = 0; // ✅ FIX: Ganti ke float (konsisten dengan weight)

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLokasi(String lokasi, String jenis, float jarak) { // ✅ FIX: Parameter jarak jadi float
        LLNode newNode = new LLNode(lokasi, jenis, jarak);
        if (head == null) {
            head = tail = newNode;
            System.out.println("🚗 Berangkat dari " + lokasi + "...");
        } else {
            tail.next = newNode;
            tail = newNode;
            System.out.println("🚗 Melewati " + lokasi + " (" + jarak + " km)");
        }
        totalJarak += jarak; // ✅ FIX: Update totalJarak!
    }

    public void displayLinkedList() {
        LLNode current = head;
        if (current == null) {
            System.out.println("List perjalanan kosong.");
            return;
        }
        
        System.out.println("========== History Perjalanan ==========");
        while (current != null) {
            System.out.println("- " + current.lokasi + " (" + current.jarak + " km)");
            current = current.next;
        }
        System.out.println("=========================================");
        System.out.println("Total jarak perjalanan: " + totalJarak + " km");
    }
    
    // ✅ Method untuk clear jalur (untuk pengunjung baru)
    public void clear() {
        head = null;
        tail = null;
        totalJarak = 0;
    }
}

/* Masih butuh method:
public boolean isEmpty() - cek apakah jalur kosong
public int countLokasi() - hitung jumlah lokasi yang dikunjungi
public LLNode getWisataOnly() - return linked list wisata saja (tanpa kabupaten)
*/