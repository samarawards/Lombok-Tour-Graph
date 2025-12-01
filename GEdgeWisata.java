public class GEdgeWisata {
    GNodeWisata fromWisata;
    GNodeWisata toWisata;
    float weight;

    GEdgeWisata next;

    public GEdgeWisata (GNodeWisata from, GNodeWisata to, float weight){
        this.fromWisata = from;
        this.toWisata = to;
        this.weight = weight;
    }
}
