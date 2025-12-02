public class GEdgeWisata {
    GNodeWisata fromWisata;
    GNodeWisata toWisata;
    float weight; // Jarak dalam km
    
    GEdgeWisata next; // Pointer ke edge berikutnya dalam linked list

    public GEdgeWisata(GNodeWisata from, GNodeWisata to, float weight) {
        this.fromWisata = from;
        this.toWisata = to;
        this.weight = weight;
        this.next = null;
    }
    
    // Getter methods
    public GNodeWisata getDestination() {
        return toWisata;
    }
    
    public float getWeight() {
        return weight;
    }
    
    public GEdgeWisata getNext() {
        return next;
    }
    
    public void setNext(GEdgeWisata next) {
        this.next = next;
    }
}

/**
 * LOMBOK TOUR GRAPH PROJECT
 * 
 * 
 * Description: Edge (koneksi/jalur) antar wisata dalam satu kabupaten.
 *              Menyimpan wisata tujuan, jarak (km), dan pointer ke edge berikutnya.
 * 
 * Dependencies: 
 * - GNodeWisata.java (destination node)
 * 
 * Used by:
 * - GNodeWisata.java (untuk linked list edges)
 * - GraphWisata.java (untuk membuat koneksi)
 */