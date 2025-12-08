public class LinkedList {
    LLNode head;
    LLNode tail;
    float totalJarak;
    int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.totalJarak = 0;
        this.size = 0;
    }

    public void addTujuanOnly(String lokasi){
        LLNode newNode = new LLNode(lokasi);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addLokasi(String lokasi, String jenis, float jarak) {
        LLNode newNode = new LLNode(lokasi, jenis, jarak);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        
        totalJarak += jarak;
        size++;
    }

    public void displayJalur() {
        if (head == null) {
            System.out.println("Belum ada perjalanan.");
            return;
        }
        
        System.out.println("\n===========================================================");
        System.out.println("        RINGKASAN PERJALANAN LENGKAP");
        System.out.println("===========================================================");
        
        LLNode current = head;
        int num = 1;
        
        while (current != null) {
            if (current.jenis.equalsIgnoreCase("Kabupaten")) {
                System.out.println("  " + num + ". " + current.lokasi + " (" + current.jarak + " km)");
            } else {
                System.out.println("  " + num + ". " + current.lokasi + " [" + current.jenis + "] (" + current.jarak + " km)");
            }
            
            current = current.next;
            num++;
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Total Jarak Tempuh: " + totalJarak + " km");
        System.out.println("  Total Lokasi Dikunjungi: " + size + " tempat");
        System.out.println("===========================================================");
    }

    public int countWisataOnly() {
        int count = 0;
        LLNode current = head;
        
        while (current != null) {
            if (!current.jenis.equalsIgnoreCase("Kabupaten")) {
                count++;
            }
            current = current.next;
        }
        
        return count;
    }

    public LLNode getWisataOnly() {
        LLNode wisataHead = null;
        LLNode wisataTail = null;
        
        LLNode current = head;
        
        while (current != null) {
            if (!current.jenis.equalsIgnoreCase("Kabupaten")) {
                LLNode clone = new LLNode(current.lokasi, current.jenis, current.jarak);
                
                if (wisataHead == null) {
                    wisataHead = clone;
                    wisataTail = clone;
                } else {
                    wisataTail.next = clone;
                    wisataTail = clone;
                }
            }
            current = current.next;
        }
        
        return wisataHead;
    }
}