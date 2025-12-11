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
}