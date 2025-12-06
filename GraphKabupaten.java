public class GraphKabupaten {
    GNodeKabupaten firstKab; // Head linked list kabupaten
    int size; // Jumlah kabupaten

    public GraphKabupaten() {
        this.firstKab = null;
        this.size = 0;
    }

    public GNodeKabupaten getNode(String name) {
        GNodeKabupaten current = firstKab;
        while (current != null) {
            if (current.namaKabupaten.equalsIgnoreCase(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private GNodeKabupaten addKabupaten(String namaKabupaten) {
        GNodeKabupaten existing = getNode(namaKabupaten);
        if (existing != null) return existing;

        GNodeKabupaten newKab = new GNodeKabupaten(namaKabupaten);
        newKab.next = firstKab;
        firstKab = newKab;
        size++;
        return newKab;
    }
    
    public void addJalurKab(String f, String t, float weight) {
        GNodeKabupaten from = addKabupaten(f);
        GNodeKabupaten to = addKabupaten(t);

        from.addEdgeKab(to, weight); 
        to.addEdgeKab(from, weight); 
    }

    public void addWisata(String kabupaten, String fromWisata, String toWisata, float weight) {
        GNodeKabupaten kab = getNode(kabupaten);
        if (kab == null) {
            System.out.println("Kabupaten " + kabupaten + " tidak ditemukan!");
            return;
        }
        
        // GraphWisata sudah auto-init di constructor GNodeKabupaten
        kab.graphWisata.addJalurWisata(fromWisata, toWisata, weight);
    }
    
    public void resetGraph() {
        GNodeKabupaten current = firstKab;
        while (current != null) {
            current.resetDijkstra();
            current = current.next;
        }
    }
    
    public PathResult dijkstra(String start, String goal) {
        // Reset graph
        resetGraph();
        
        // Cari node start dan goal
        GNodeKabupaten startNode = getNode(start);
        GNodeKabupaten goalNode = getNode(goal);
        
        if (startNode == null || goalNode == null) {
            return new PathResult("", 0, false);
        }
        
        // Jika start == goal
        if (startNode == goalNode) {
            return new PathResult(start, 0, true);
        }
        
        // Set distance start = 0
        startNode.setJarakDariStart(0);
        
        // Loop sampai semua node visited
        int visitedCount = 0;
        while (visitedCount < size) {
            // Cari node unvisited dengan distance terkecil
            GNodeKabupaten minNode = cariNodeJarakTerkecil();
            if (minNode == null) break; // Semua node sudah visited atau unreachable
            
            // Mark visited
            minNode.setVisited(true);
            visitedCount++;
            
            // Jika sudah sampai goal, bisa stop
            if (minNode == goalNode) break;
            
            // Update distance tetangga
            GEdgeKabupaten edge = minNode.getFirstEdge();
            while (edge != null) {
                GNodeKabupaten neighbor = edge.toKab;
                if (!neighbor.isVisited()) {
                    float newDist = minNode.getJarakDariStart() + edge.weight;
                    if (newDist < neighbor.getJarakDariStart()) {
                        neighbor.setJarakDariStart(newDist);
                        neighbor.setPrev(minNode);
                    }
                }
                edge = edge.next;
            }
        }
        
        // Reconstruct path dari goal ke start
        if (goalNode.getJarakDariStart() == Float.MAX_VALUE) {
            // Goal unreachable
            return new PathResult("", 0, false);
        }
        
        // Build path menggunakan string concatenation (TANPA ARRAY!)
        String jalur = "";
        float totalJarak = goalNode.getJarakDariStart();
        
        // Reconstruct dari goal ke start
        GNodeKabupaten current = goalNode;
        String pathReverse = current.getNamaKabupaten();
        
        while (current.getPrev() != null) {
            current = current.getPrev();
            pathReverse = current.getNamaKabupaten() + " → " + pathReverse;
        }
        
        jalur = pathReverse;
        
        return new PathResult(jalur, totalJarak, true);
    }

    private GNodeKabupaten cariNodeJarakTerkecil() {
        GNodeKabupaten current = firstKab;
        GNodeKabupaten minNode = null;
        float minDist = Float.MAX_VALUE;
        
        while (current != null) {
            if (!current.isVisited() && current.getJarakDariStart() < minDist) {
                minDist = current.getJarakDariStart();
                minNode = current;
            }
            current = current.next;
        }
        
        return minNode;
    }

    public int countKabupaten() {
        return size;
    }
    
    public boolean isEmpty() {
        return firstKab == null;
    }
    
    // Getter
    public GNodeKabupaten getFirstKab() {
        return firstKab;
    }
}