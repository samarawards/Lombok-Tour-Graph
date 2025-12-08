public class SearchEngine {
  
    public GNodeWisata searchByNama(GraphKabupaten graph, String keyword) {
        GNodeKabupaten tempKab = graph.firstKab;
        while (tempKab != null) {
            GNodeWisata tempWis = tempKab.graphWisata.firstWisata;
            while (tempWis != null) {
                if (tempWis.namaWisata.equalsIgnoreCase(keyword)) {
                    return tempWis;
                }
                tempWis = tempWis.next;
            }
            tempKab = tempKab.next;
        }        
        return null;
    }
    
    public void searchByJenis(GraphKabupaten graph, String jenis) {
        int num = 1;
        GNodeKabupaten tempKab = graph.firstKab;
        while (tempKab != null) {
            GNodeWisata tempWis = tempKab.graphWisata.firstWisata;
            while (tempWis != null) {
                if (tempWis.jenis.equalsIgnoreCase(jenis)) {
                    System.out.println("  " + num + ". " + tempWis.namaWisata);
                    num++;
                }
                tempWis = tempWis.next;
            }
            tempKab = tempKab.next;
        }        
        if (num == 1) {
            System.out.println("  [X] Tidak ada wisata dengan jenis \"" + jenis + "\"");
        }
    }
    
    public void searchByRating(GraphKabupaten graph, float minRating) {
        int num = 1;
        GNodeKabupaten currentKab = graph.firstKab;
        
        while (currentKab != null) {
            GNodeWisata currentWis = currentKab.graphWisata.firstWisata;
            
            while (currentWis != null) {
                if (currentWis.rating >= minRating) {
                    System.out.println("  " + num + ". " + currentWis.namaWisata + " (" + currentWis.formatRating(currentWis.rating) + ")");
                    num++;
                }
                currentWis = currentWis.next;
            }
            currentKab = currentKab.next;
        }
        if (num == 1) {
            System.out.println("  [X] Tidak ada wisata dengan rating >= " + minRating);
        }
    }
    

    public void searchByKabupaten(GraphKabupaten graph, String namaKabupaten) {
        GNodeKabupaten kab = graph.getNode(namaKabupaten);
        if (namaKabupaten.equalsIgnoreCase("lombok barat")) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("\n  " + namaKabupaten + " " + i);
                searchByKabupaten(graph, namaKabupaten + " " + i);
            } 
            return;
            
        } else if (kab == null) {
            System.out.println("  [X] Tidak ada kabupaten bernama \"" + namaKabupaten + "\" di Pulau Lombok");
            return;
        }
        
        int num = 1;
        GNodeWisata currentWis = kab.graphWisata.firstWisata;
        while (currentWis != null) {
            System.out.println("  " + num + ". " + currentWis.namaWisata);
            num++;
            currentWis = currentWis.next;
        }
        
        if (num == 1) {
            System.out.println("  [X] Tidak ada wisata di kabupaten ini");
        }
    }

    public void displayJenisWisata() {
        System.out.println("\n===========================================================");
        System.out.println("        KATEGORI WISATA YANG TERSEDIA");
        System.out.println("===========================================================");
        System.out.println("  1. Pantai");
        System.out.println("  2. Air Terjun");
        System.out.println("  3. Bukit");
        System.out.println("  4. Pulau");
        System.out.println("  5. Desa Wisata");
        System.out.println("  6. Taman");
        System.out.println("  7. Gunung");
        System.out.println("  8. Savana");
        System.out.println("  9. Hutan Wisata");
        System.out.println("  10. Sirkuit");
        System.out.println("  11. Kebun Wisata");
        System.out.println("  12. Kolam Renang");
        System.out.println("  13. Pemandian");
        System.out.println("===========================================================");
    }
}