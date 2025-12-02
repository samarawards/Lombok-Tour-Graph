public class GraphKabupaten {
    GNodeKabupaten firstKab;

    public GNodeKabupaten getNode(String name) {
        GNodeKabupaten current = firstKab;
        while (current != null) {
            if (current.namaKabupaten.equals(name)) return current;
            current = current.next;
        }
        return null;
    }

    // ✅ FIX: Rename dari addWisata → addKabupaten
    private GNodeKabupaten addKabupaten(String namaKabupaten) {
        GNodeKabupaten existing = getNode(namaKabupaten);
        if (existing != null) return existing;

        GNodeKabupaten newKab = new GNodeKabupaten(namaKabupaten);
        newKab.next = firstKab;
        firstKab = newKab;
        return newKab;
    }
    
    // ✅ FIX: Pakai addKabupaten, bukan addWisata
    public void addJalurKab(String f, String t, float weight) {
        GNodeKabupaten from = addKabupaten(f);
        GNodeKabupaten to = addKabupaten(t);

        from.addEdgeKab(to, weight); 
        to.addEdgeKab(from, weight); 
    }

    // Fungsi nested wisata
    public void addWisata(String di, String fromWisata, String toWisata, float weight) {
        // Cari NodeKab 'di'
        GNodeKabupaten disini = getNode(di);
        if (disini == null) {
            System.out.println("Node " + di + " tidak ditemukan");
            return;
        }

        // ✅ GraphWisata sudah auto-init di constructor GNodeKabupaten
        disini.graphWisata.addJalurWisata(fromWisata, toWisata, weight);
    }
    
    // ✅ Method untuk reset semua node sebelum Dijkstra
    public void resetGraph() {
        GNodeKabupaten current = firstKab;
        while (current != null) {
            current.resetDijkstra();
            current = current.next;
        }
    }
}

/* Masih butuh method:
public void displayGraph() - untuk tampilkan semua kabupaten & jalurnya
public PathResult dijkstra(String start, String goal) - untuk shortest path
public GNodeKabupaten findMinDistanceNode() - helper untuk Dijkstra
public void displayAllWisata() - tampilkan semua wisata dari semua kabupaten
*/