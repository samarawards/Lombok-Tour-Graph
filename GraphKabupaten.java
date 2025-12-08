public class GraphKabupaten {
    GNodeKabupaten firstKab;
    int size;

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

    public GNodeKabupaten addKabupaten(String namaKabupaten) {
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
    
    public void resetGraph() {
        GNodeKabupaten current = firstKab;
        while (current != null) {
            current.visited = false;
            current.jarakDariStart = Float.MAX_VALUE;
            current.prev = null;
            current = current.next;
        }
    }
    
    public PathResult dijkstra(String start, String goal) {
        resetGraph();
        
        GNodeKabupaten startNode = getNode(start);
        GNodeKabupaten goalNode = getNode(goal);
        
        if (startNode == null || goalNode == null) {
            return new PathResult("", 0, false);
        }
        
        if (startNode == goalNode) {
            return new PathResult(start, 0, true);
        }
        
        startNode.jarakDariStart = 0;
        
        int visitedCount = 0;
        while (visitedCount < size) {
            GNodeKabupaten minNode = cariNodeJarakTerkecil();
            if (minNode == null) break;
            
            minNode.visited = true;
            visitedCount++;
            
            if (minNode == goalNode) break;
            
            GEdgeKabupaten edge = minNode.firstEdgeKab;
            while (edge != null) {
                GNodeKabupaten neighbor = edge.toKab;
                if (!neighbor.visited) {
                    float newDist = minNode.jarakDariStart + edge.weight;
                    if (newDist < neighbor.jarakDariStart) {
                        neighbor.jarakDariStart = newDist;
                        neighbor.prev = minNode;
                    }
                }
                edge = edge.next;
            }
        }
        
        if (goalNode.jarakDariStart == Float.MAX_VALUE) {
            return new PathResult("", 0, false);
        }
        
        String jalur = "";
        float totalJarak = goalNode.jarakDariStart;
        
        GNodeKabupaten current = goalNode;
        String pathReverse = current.namaKabupaten;
        
        while (current.prev != null) {
            current = current.prev;
            pathReverse = current.namaKabupaten + " -> " + pathReverse;
        }
        
        jalur = pathReverse;
        
        return new PathResult(jalur, totalJarak, true);
    }

    public GNodeKabupaten cariNodeJarakTerkecil() {
        GNodeKabupaten current = firstKab;
        GNodeKabupaten minNode = null;
        float minDist = Float.MAX_VALUE;
        
        while (current != null) {
            if (!current.visited && current.jarakDariStart < minDist) {
                minDist = current.jarakDariStart;
                minNode = current;
            }
            current = current.next;
        }
        
        return minNode;
    }
}