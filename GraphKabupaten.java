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

    private GNodeKabupaten addWisata (String wisata){
        GNodeKabupaten existing = getNode(wisata);
        if (existing != null) return existing;

        GNodeKabupaten newWisata = new GNodeKabupaten(wisata);
        newWisata.next = firstKab;
        firstKab = newWisata;
        return newWisata;

    }
    
    public void addJalurKab (String f, String t, float weight){
        GNodeKabupaten from = addWisata(f);
        GNodeKabupaten to = addWisata(t);

        from.addEdgeKab(to, weight); 
        to.addEdgeKab(from, weight); 
    }

    //fungsi nested wisata
    public void addWisata (String di, String fromWisata, String toWisata, float weight){
        //cari NodeKab 'di'
        GNodeKabupaten disini = getNode(di);
        if (disini == null) {
            System.out.println("Node "+ di + " tidak ditemukan");
            return;
        }

        disini.graphWisata.addJalurWisata(fromWisata, toWisata, weight);
    }










}
