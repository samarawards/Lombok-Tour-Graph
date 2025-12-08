public class GNodeKabupaten {
    String namaKabupaten;
    boolean visited;
    float jarakDariStart;
    
    GEdgeKabupaten firstEdgeKab;
    GNodeKabupaten prev;
    GNodeKabupaten next;
    
    GraphWisata graphWisata;

    public GNodeKabupaten(String nama) {
        this.namaKabupaten = nama;
        this.visited = false;
        this.jarakDariStart = Float.MAX_VALUE;
        this.firstEdgeKab = null;
        this.prev = null;
        this.next = null;
        this.graphWisata = new GraphWisata(nama);
    }

    public void addEdgeKab(GNodeKabupaten to, float weight) {
        GEdgeKabupaten newEdge = new GEdgeKabupaten(this, to, weight);
        newEdge.next = firstEdgeKab;
        firstEdgeKab = newEdge;
    }
}