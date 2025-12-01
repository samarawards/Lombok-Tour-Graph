public class GNodeWisata {
    String namaWisata;
    boolean visited;
    int dist = Integer.MAX_VALUE;
    float rating;

    //akses edgenya
    GEdgeWisata firstEdgeWis;

    GNodeWisata next;

    //nested stack
    Stack ulasan = new Stack();

    public GNodeWisata (String namaWString){
        this.namaWisata = namaWString;
        this.visited = false;
    }

    public void addEdgeWisata(GNodeWisata to, float weight) {
        GEdgeWisata newEdge = new GEdgeWisata(this, to, weight);
        newEdge.next = firstEdgeWis;
        firstEdgeWis = newEdge;
    }  
}
