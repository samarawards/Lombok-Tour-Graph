public class LinkedList {
    GNodeWisata head;
    GNodeWisata tail;
    float totalJarak;
    int size; 

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.totalJarak = 0;
        this.size = 0;
    }

    public void addTail(GNodeWisata newNode){
        if (head == null) {
            head = newNode;
        }else{
            tail.next = newNode;
        }
        tail = newNode;
    }

    // public void addLokasi(String lokasi, String jenis, float jarak) {
    //     GNodeWisata newNode = new GNodeWisata(lokasi, jenis, jarak);
        
    //     if (head == null) {
    //         head = tail = newNode;
    //         System.out.println("Berangkat dari " + lokasi + "...");
    //     } else {
    //         tail.next = newNode;
    //         tail = newNode;
    //         System.out.println("Melewati " + lokasi + " (" + jarak + " km)");
    //     }
        
    //     totalJarak += jarak;
    //     size++;
    // }

    public void displayLinkedList() {
        if (head == null) {
            System.out.println("List perjalanan kosong.");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        HISTORY PERJALANAN                  ║");
        System.out.println("╠════════════════════════════════════════════╣");
        
        GNodeWisata current = head;
        int num = 1;
        
        while (current != null) {
            System.out.println("  " + num + ". " + " (" + current.dist + " km) [" + current.jenis + "]");
            current = current.next;
            num++;
        }
        
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("║ Total Jarak: " + totalJarak + " km");
        System.out.println("║ Total Lokasi: " + size + " tempat");
        System.out.println("╚════════════════════════════════════════════╝");
    }

    public int countWisataOnly() {
        int count = 0;
        GNodeWisata current = head;
        
        while (current != null) {
            if (!current.jenis.equalsIgnoreCase("Kabupaten")) {
                count++;
            }
            current = current.next;
        }
        
        return count;
    }

    // public GNodeWisata getWisataOnly() {
    //     GNodeWisata wisataHead = null;
    //     GNodeWisata wisataTail = null;
        
    //     GNodeWisata current = head;
        
    //     while (current != null) {
    //         if (!current.jenis.equalsIgnoreCase("Kabupaten")) {
    //             // Clone node wisata
    //             GNodeWisata clone = new GNodeWisata(current.lokasi, current.jenis, current.jarak);
                
    //             if (wisataHead == null) {
    //                 wisataHead = clone;
    //                 wisataTail = clone;
    //             } else {
    //                 wisataTail.next = clone;
    //                 wisataTail = clone;
    //             }
    //         }
    //         current = current.next;
    //     }
        
    //     return wisataHead;
    // }

    public float getTotalJarak() {
        return totalJarak;
    }

    public GNodeWisata getHead() {
        return head;
    }
}