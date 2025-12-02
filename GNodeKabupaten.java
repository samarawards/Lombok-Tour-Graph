public class GNodeKabupaten {
    String namaKabupaten;
    boolean visited;
    GEdgeKabupaten firstEdgeKab;
    
    float jarakDariStart = Float.MAX_VALUE; // Ganti int jadi float (karena weight float)
    
    // Nested graph
    GraphWisata graphWisata;
    
    GNodeKabupaten prev;
    GNodeKabupaten next;

    public GNodeKabupaten(String nama) {
        this.namaKabupaten = nama;
        this.graphWisata = new GraphWisata(); 
        this.visited = false;
    }

    public void addEdgeKab(GNodeKabupaten to, float weight) {
        GEdgeKabupaten newEdge = new GEdgeKabupaten(this, to, weight);
        // Add first di kumpulan edgenya
        newEdge.next = firstEdgeKab;
        firstEdgeKab = newEdge;
    }
    
    // Method untuk reset Dijkstra
    public void resetDijkstra() {
        this.visited = false;
        this.jarakDariStart = Float.MAX_VALUE;
        this.prev = null;
    }
}