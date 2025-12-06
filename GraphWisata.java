public class GraphWisata {
    GNodeWisata firstWisata; 
    String namaKabupaten; // Kabupaten pemilik graph ini
    int size; 

    public GraphWisata() {
        this.firstWisata = null;
        this.namaKabupaten = "";
        this.size = 0;
    }
    
    public GraphWisata(String namaKabupaten) {
        this.firstWisata = null;
        this.namaKabupaten = namaKabupaten;
        this.size = 0;
    }

    public GNodeWisata getNode(String name) {
        GNodeWisata current = firstWisata;
        while (current != null) {
            if (current.namaWisata.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private GNodeWisata addWisata(String wisata) {
        GNodeWisata existing = getNode(wisata);
        if (existing != null) return existing;

        GNodeWisata newWisata = new GNodeWisata(wisata);
        newWisata.next = firstWisata;
        firstWisata = newWisata;
        size++;
        return newWisata;
    }
    
    public GNodeWisata addWisataWithInfo(String nama, String deskripsi, String jenis) {
        GNodeWisata existing = getNode(nama);
        if (existing != null) {
            // Update info jika sudah ada
            existing.setDeskripsi(deskripsi);
            existing.setJenis(jenis);
            return existing;
        }

        GNodeWisata newWisata = new GNodeWisata(nama, deskripsi, jenis);
        newWisata.next = firstWisata;
        firstWisata = newWisata;
        size++;
        return newWisata;
    }
    
    public void addJalurWisata(String f, String t, float weight) {
        GNodeWisata from = addWisata(f);
        GNodeWisata to = addWisata(t);

        from.addEdgeWisata(to, weight); 
        to.addEdgeWisata(from, weight); 
    }
    
    public void resetGraph() {
        GNodeWisata current = firstWisata;
        while (current != null) {
            current.resetDijkstra();
            current = current.next;
        }
    }
    
    public void displayWisata() {
        if (firstWisata == null) {
            System.out.println("Tidak ada wisata di " + namaKabupaten);
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║  WISATA DI " + namaKabupaten.toUpperCase());
        System.out.println("╠════════════════════════════════════════════╣");
        
        GNodeWisata current = firstWisata;
        int num = 1;
        while (current != null) {
            String stars = "";
            int fullStars = (int) current.rating;
            for (int i = 0; i < fullStars; i++) {
                stars += "*";
            }
            
            System.out.println(num + ". " + current.namaWisata + " (" + current.jenis + ") " + stars + " " + current.rating);
            current = current.next;
            num++;
        }
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Total: " + size + " wisata");
    }
    
    public PathResult dijkstra(String start, String goal) {
        // Reset graph
        resetGraph();
        
        // Cari node start dan goal
        GNodeWisata startNode = getNode(start);
        GNodeWisata goalNode = getNode(goal);
        
        if (startNode == null || goalNode == null) {
            return new PathResult("", 0, false);
        }
        
        // Set distance start = 0
        startNode.setDist(0);
        
        // Loop sampai semua node visited
        int visitedCount = 0;
        while (visitedCount < size) {
            // Cari node unvisited dengan distance terkecil
            GNodeWisata minNode = findMinDistanceNode();
            if (minNode == null) break; // Semua node sudah visited atau unreachable
            
            // Mark visited
            minNode.setVisited(true);
            visitedCount++;
            
            // Jika sudah sampai goal, bisa stop
            if (minNode == goalNode) break;
            
            // Update distance tetangga
            GEdgeWisata edge = minNode.getFirstEdge();
            while (edge != null) {
                GNodeWisata neighbor = edge.getDestination();
                if (!neighbor.isVisited()) {
                    float newDist = minNode.getDist() + edge.getWeight();
                    if (newDist < neighbor.getDist()) {
                        neighbor.setDist(newDist);
                        neighbor.setPrev(minNode);
                    }
                }
                edge = edge.getNext();
            }
        }
        
        // Reconstruct path dari goal ke start
        if (goalNode.getDist() == Float.MAX_VALUE) {
            // Goal unreachable
            return new PathResult("", 0, false);
        }
        
        // Build path menggunakan linked list manual (TANPA ARRAY!)
        String jalur = "";
        float totalJarak = goalNode.getDist();
        
        // Reconstruct dari goal ke start
        GNodeWisata current = goalNode;
        String pathReverse = current.getNamaWisata();
        
        while (current.getPrev() != null) {
            current = current.getPrev();
            pathReverse = current.getNamaWisata() + " → " + pathReverse;
        }
        
        jalur = pathReverse;
        
        return new PathResult(jalur, totalJarak, true);
    }
    
    private GNodeWisata findMinDistanceNode() {
        GNodeWisata current = firstWisata;
        GNodeWisata minNode = null;
        float minDist = Float.MAX_VALUE;
        
        while (current != null) {
            if (!current.isVisited() && current.getDist() < minDist) {
                minDist = current.getDist();
                minNode = current;
            }
            current = current.next;
        }
        
        return minNode;
    }
    
    public int countWisata() {
        return size;
    }
    
    public boolean isEmpty() {
        return firstWisata == null;
    }
    
    public GNodeWisata getFirstWisata() {
        return firstWisata;
    }
    
    public String getNamaKabupaten() {
        return namaKabupaten;
    }
    
    public void setNamaKabupaten(String namaKabupaten) {
        this.namaKabupaten = namaKabupaten;
    }
}