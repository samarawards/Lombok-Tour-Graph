public class GraphWisata {
    GNodeWisata firstWisata; 
    String namaKabupaten;
    int size; 
    
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

    public GNodeWisata addWisata(String wisata) {
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
            existing.deskripsi = deskripsi;
            existing.jenis = jenis;
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
        
        System.out.println("\n===========================================================");
        System.out.println("  WISATA DI " + namaKabupaten.toUpperCase());
        System.out.println("===========================================================");
        
        GNodeWisata current = firstWisata;
        int num = 1;
        while (current != null) {
            String stars = current.formatRating(current.rating);
            
            System.out.println("  " + num + ". " + current.namaWisata + " (" + current.jenis + ") " + stars);
            current = current.next;
            num++;
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Total: " + size + " wisata");
        System.out.println("===========================================================");
    }
    
    public PathResult dijkstra(String start, String goal) {
        resetGraph();
        
        GNodeWisata startNode = getNode(start);
        GNodeWisata goalNode = getNode(goal);
        
        if (startNode == null || goalNode == null) {
            return new PathResult("", 0, false);
        }
        
        if (startNode == goalNode) {
            return new PathResult(start, 0, true);
        }
        
        startNode.dist = 0;
        
        int visitedCount = 0;
        while (visitedCount < size) {
            GNodeWisata minNode = findMinDistanceNode();
            if (minNode == null) break;
            
            minNode.visited = true;
            visitedCount++;
            
            if (minNode == goalNode) break;
            
            GEdgeWisata edge = minNode.firstEdgeWis;
            while (edge != null) {
                GNodeWisata neighbor = edge.toWisata;
                if (!neighbor.visited) {
                    float newDist = minNode.dist + edge.weight;
                    if (newDist < neighbor.dist) {
                        neighbor.dist = newDist;
                        neighbor.prev = minNode;
                    }
                }
                edge = edge.next;
            }
        }
        
        if (goalNode.dist == Float.MAX_VALUE) {
            return new PathResult("", 0, false);
        }
        
        String jalur = "";
        float totalJarak = goalNode.dist;
        
        GNodeWisata current = goalNode;
        String pathReverse = current.namaWisata;
        
        while (current.prev != null) {
            current = current.prev;
            pathReverse = current.namaWisata + " -> " + pathReverse;
        }
        
        jalur = pathReverse;
        
        return new PathResult(jalur, totalJarak, true);
    }
    
    public GNodeWisata findMinDistanceNode() {
        GNodeWisata current = firstWisata;
        GNodeWisata minNode = null;
        float minDist = Float.MAX_VALUE;
        
        while (current != null) {
            if (!current.visited && current.dist < minDist) {
                minDist = current.dist;
                minNode = current;
            }
            current = current.next;
        }
        
        return minNode;
    }
    
    public boolean isEmpty() {
        return firstWisata == null;
    }
}