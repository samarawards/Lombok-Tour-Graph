import org.w3c.dom.Node; //Jangan pake ini yaa

public class GraphWisata {
    GNodeWisata firstWisata;

    public GNodeWisata getNode(String name) {
        GNodeWisata current = firstWisata;
        while (current != null) {
            if (current.namaWisata.equals(name)) return current;
            current = current.next;
        }
        return null;
    }

    private GNodeWisata addWisata (String wisata){
        GNodeWisata existing = getNode(wisata);
        if (existing != null) return existing;

        GNodeWisata newWisata = new GNodeWisata(wisata);
        newWisata.next = firstWisata;
        firstWisata = newWisata;
        return newWisata;

    }
    
    public void addJalurWisata (String f, String t, float weight){
        GNodeWisata from = addWisata(f);
        GNodeWisata to = addWisata(t);

        from.addEdgeWisata(to, weight); 
        to.addEdgeWisata(from, weight); 
    }

}
