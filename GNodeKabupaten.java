public class GNodeKabupaten {
    String namaKabupaten;
    boolean visited; // Untuk Dijkstra
    float jarakDariStart; // Distance dari start node (untuk Dijkstra)
    
    GEdgeKabupaten firstEdgeKab; // Head linked list edges
    GNodeKabupaten prev; // Previous node dalam shortest path
    GNodeKabupaten next; // Next kabupaten dalam linked list graph
    
    // Nested graph wisata
    GraphWisata graphWisata;

    public GNodeKabupaten(String nama) {
        this.namaKabupaten = nama;
        this.visited = false;
        this.jarakDariStart = Float.MAX_VALUE; // Infinity
        this.firstEdgeKab = null;
        this.prev = null;
        this.next = null;
        this.graphWisata = new GraphWisata(nama); // Init GraphWisata dengan nama kabupaten
    }

    public void addEdgeKab(GNodeKabupaten to, float weight) {
        GEdgeKabupaten newEdge = new GEdgeKabupaten(this, to, weight);
        newEdge.next = firstEdgeKab;
        firstEdgeKab = newEdge;
    }
    
    public void resetDijkstra() {
        this.visited = false;
        this.jarakDariStart = Float.MAX_VALUE;
        this.prev = null;
    }
    
    // Getter & Setter
    public String getNamaKabupaten() {
        return namaKabupaten;
    }
    
    public GraphWisata getGraphWisata() {
        return graphWisata;
    }
    
    public GEdgeKabupaten getFirstEdge() {
        return firstEdgeKab;
    }
    
    public GNodeKabupaten getNext() {
        return next;
    }
    
    public void setNext(GNodeKabupaten next) {
        this.next = next;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public float getJarakDariStart() {
        return jarakDariStart;
    }
    
    public void setJarakDariStart(float jarakDariStart) {
        this.jarakDariStart = jarakDariStart;
    }
    
    public GNodeKabupaten getPrev() {
        return prev;
    }
    
    public void setPrev(GNodeKabupaten prev) {
        this.prev = prev;
    }
}