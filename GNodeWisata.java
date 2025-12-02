public class GNodeWisata {
    String namaWisata;
    String deskripsi;
    String jenis; // pantai, air terjun, bukit, desa wisata, pulau, dll
    double rating; // Rata-rata rating dari Stack ulasan
    
    boolean visited; // Untuk Dijkstra
    float dist; // Distance dari start (untuk Dijkstra)
    GNodeWisata prev; // Previous node dalam shortest path
    
    GEdgeWisata firstEdgeWis; // Head linked list edges
    GNodeWisata next; // Next wisata dalam linked list graph
    
    Stack ulasan; // Nested stack untuk review pengunjung

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
        this.ulasan = new Stack(); // Init stack ulasan
    }
    
    // Constructor dengan deskripsi dan jenis
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

    /**
     * Tambah edge ke wisata lain
     */
    public void addEdgeWisata(GNodeWisata to, float weight) {
        GEdgeWisata newEdge = new GEdgeWisata(this, to, weight);
        newEdge.next = firstEdgeWis;
        firstEdgeWis = newEdge;
    }
    
    /**
     * Reset field Dijkstra untuk pathfinding baru
     */
    public void resetDijkstra() {
        this.visited = false;
        this.dist = Float.MAX_VALUE;
        this.prev = null;
    }
    
    /**
     * Update rating dari rata-rata Stack ulasan
     */
    public void updateRating() {
        if (ulasan != null && !ulasan.isEmpty()) {
            this.rating = ulasan.getAverageRating();
        }
    }
    
    /**
     * Tampilkan info wisata
     */
    public void displayInfo() {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           DETAIL WISATA                    ║");
        System.out.println("╠════════════════════════════════════════════╣");
        System.out.println("  Nama      : " + namaWisata);
        System.out.println("  Jenis     : " + jenis);
        System.out.println("  Rating    : " + formatRating(rating) + " (" + ulasan.getSize() + " ulasan)");
        System.out.println("  Deskripsi : " + deskripsi);
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    /**
     * Format rating dengan bintang
     */
    private String formatRating(double rating) {
        String result = "";
        int fullStars = (int) rating;
        for (int i = 0; i < fullStars; i++) {
            result += "⭐";
        }
        result += " " + rating;
        return result;
    }
    
    /**
     * Tampilkan semua koneksi (edges) wisata ini
     */
    public void displayEdges() {
        System.out.println("\nKoneksi dari " + namaWisata + ":");
        GEdgeWisata current = firstEdgeWis;
        if (current == null) {
            System.out.println("  Tidak ada koneksi.");
            return;
        }
        while (current != null) {
            System.out.println("  → " + current.toWisata.namaWisata + " (" + current.weight + " km)");
            current = current.next;
        }
    }
    
    // Getter & Setter
    public String getNamaWisata() {
        return namaWisata;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    public String getJenis() {
        return jenis;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    public double getRating() {
        return rating;
    }
    
    public Stack getUlasan() {
        return ulasan;
    }
    
    public GEdgeWisata getFirstEdge() {
        return firstEdgeWis;
    }
    
    public GNodeWisata getNext() {
        return next;
    }
    
    public void setNext(GNodeWisata next) {
        this.next = next;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    public float getDist() {
        return dist;
    }
    
    public void setDist(float dist) {
        this.dist = dist;
    }
    
    public GNodeWisata getPrev() {
        return prev;
    }
    
    public void setPrev(GNodeWisata prev) {
        this.prev = prev;
    }
}

/*
Node untuk merepresentasikan tempat wisata dalam graph.
Setiap node punya nested Stack untuk ulasan pengunjung.

Tersambung di: 
- GEdgeWisata.java (untuk linked list edges)
- Stack.java (nested stack ulasan)

Dipakai di:
- GraphWisata.java
- SearchEngine.java
- SortingManager.java
*/