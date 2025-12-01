public class GNodeKabupaten {
    String namaKabupaten;
    boolean visited;
    GEdgeKabupaten firstEdgeKab;
    GEdgeWisata adj;
    
    int jarakDariStart = Integer.MAX_VALUE; //== dist
    
    //nested graph
    GraphWisata graphWisata;
    
    GNodeKabupaten prev;
    GNodeKabupaten next;

    public GNodeKabupaten (String nama){
        this.namaKabupaten = nama;    
    }

    public void addEdgeKab(GNodeKabupaten to, float weight){
        GEdgeKabupaten newEdge = new GEdgeKabupaten(this, to, weight);
        //add first di kumpulan edgenya
        newEdge.next = firstEdgeKab;
        firstEdgeKab = newEdge;
    }
}