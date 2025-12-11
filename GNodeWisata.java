public class GNodeWisata {
    String namaWisata;
    String deskripsi;
    String jenis;
    double rating;
    
    boolean visited;
    float dist;
    GNodeWisata prev;
    
    GEdgeWisata firstEdgeWis;
    GNodeWisata next;
    
    Stack ulasan;

    public GNodeWisata(String namaWisata) {
        this.namaWisata = namaWisata;
        this.deskripsi = "";
        this.jenis = "";
        this.rating = 0.0f;
        this.visited = false;
        this.dist = Float.MAX_VALUE;
        this.prev = null;
        this.firstEdgeWis = null;
        this.next = null;
        this.ulasan = new Stack();
    }
    
    public GNodeWisata(String namaWisata, String deskripsi, String jenis) {
        this.namaWisata = namaWisata;
        this.deskripsi = deskripsi;
        this.jenis = jenis;
        this.rating = 0.0f;
        this.visited = false;
        this.dist = Float.MAX_VALUE;
        this.prev = null;
        this.firstEdgeWis = null;
        this.next = null;
        this.ulasan = new Stack();
    }

    public void addEdgeWisata(GNodeWisata to, float weight) {
        GEdgeWisata newEdge = new GEdgeWisata(this, to, weight);
        newEdge.next = firstEdgeWis;
        firstEdgeWis = newEdge;
    }
    
    public void resetDijkstra() {
        this.visited = false;
        this.dist = Float.MAX_VALUE;
        this.prev = null;
    }
    
    public void updateRating() {
        if (ulasan != null && !ulasan.isEmpty()) {
            this.rating = ulasan.getAverageRating();
        }
    }
    
    public void displayInfo() {
        System.out.println("===========================================================");
        System.out.println("           DETAIL WISATA");
        System.out.println("===========================================================");
        System.out.println("  Nama      : " + namaWisata);
        System.out.println("  Jenis     : " + jenis);
        System.out.println("  Rating    : " + formatRating(rating) + " (" + ulasan.size + " ulasan)");
        System.out.println("  Deskripsi : " + deskripsi);
        System.out.println("===========================================================");
    }
    
    public String formatRating(double rating) {
        String result = "";
        int fullStars = (int) rating;
        for (int i = 0; i < fullStars; i++) {
            result += "⭐";
        }
        result += " " + rating;
        return result;
    }
}