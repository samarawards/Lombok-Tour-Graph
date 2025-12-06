public class SearchEngine {
  
    // ==================== SEARCH WISATA ====================
    
    /**
     * Cari wisata by nama (keyword matching)
     * Graph kabupaten utama
     *  Kata kunci pencarian (case insensitive)
     *  Head LinkedList wisata yang cocok (atau null jika tidak ada)
     */
    public GNodeWisata searchByNama(GraphKabupaten graph, String keyword) {
        // Implement linear search
        graph.resetGraph();
        GNodeKabupaten tempKab = graph.firstKab;
        while (tempKab != null) {
            tempKab.graphWisata.resetGraph();
            tempKab = tempKab.next;
        }
        tempKab = graph.firstKab;
        while (tempKab != null) {
            while ((!tempKab.visited)) {
                tempKab.visited = true;
                GNodeWisata tempWis = tempKab.graphWisata.firstWisata;
                while (tempWis != null) {
                    while (!tempWis.visited) {
                        tempWis.visited = true;
                        if (tempWis.namaWisata.equalsIgnoreCase(keyword)) {
                            return tempWis;
                        }
                    }
                    tempWis = tempWis.next;
                }
            }
            tempKab = tempKab.next;
        }
        return null;
    }
    
    /**
     * Cari wisata by jenis (pantai/air terjun/bukit/dll)
     * Graph kabupaten utama
     * Jenis wisata
     *  Head LinkedList wisata yang cocok
     */
    public void searchByJenis(GraphKabupaten graph, String jenis) {
        // Implement linear search
        // 1. Loop semua kabupaten
        // 2. Loop semua wisata dalam setiap kabupaten
        // 3. Jika wisata.jenis.equals(jenis) → tambah ke hasil
        // 4. Return head hasil
        int num = 1;
        graph.resetGraph();
        GNodeKabupaten tempKab = graph.firstKab;
        while (tempKab != null) {
            tempKab.graphWisata.resetGraph();
            tempKab = tempKab.next;
        }
        tempKab = graph.firstKab;
        while (tempKab != null) {
            while (!tempKab.visited) {
                tempKab.visited = true;
                GNodeWisata tempWis = tempKab.graphWisata.firstWisata;
                while (tempWis != null) {
                    while (!tempWis.visited) {
                        tempWis.visited = true;
                        if (tempWis.jenis.equalsIgnoreCase(jenis)) {
                            // tempWis.displayInfo();//ini atau
                            System.out.println(num + ". " + tempWis.namaWisata ); //+ " (" + tempWis.deskripsi + ")" ->kalau mau lebih detail
                            num++;
                        }
                    }
                    tempWis = tempWis.next;
                }
            }
            tempKab = tempKab.next;
        }
    }
    
    public void searchByRating(GraphKabupaten graph, float minRating) {
        // GNodeWisata resultHead = null;
        // GNodeWisata resultTail = null;
        
        // Loop semua kabupaten
        int num = 1;
        GNodeKabupaten currentKab = graph.getFirstKab();
        
        while (currentKab != null) {
            // Loop semua wisata dalam kabupaten ini
            GNodeWisata currentWis = currentKab.graphWisata.getFirstWisata();
            
            while (currentWis != null) {
                // Check rating
                if (currentWis.rating >= minRating) {
                    // currentWis.displayInfo();
                    System.out.println(num + ". " + currentWis.namaWisata + " (" + currentWis.formatRating(currentWis.rating) + ")"); //+ " (" + tempWis.deskripsi + ")" ->kalau mau lebih detail
                    num++;
                }
                
                currentWis = currentWis.getNext();
            }
            
            currentKab = currentKab.getNext();
        }
        
        return;
    }
    

    public void searchByKabupaten(GraphKabupaten graph, String namaKabupaten) {
        GNodeKabupaten kab = graph.getNode(namaKabupaten);
        if (namaKabupaten.equalsIgnoreCase("lombok barat")) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("\n" + namaKabupaten + " " + i);
                searchByKabupaten(graph, namaKabupaten + " " + i);
            } return;
            
        }else if (kab == null) {
            System.out.println("Tidak ada kabupaten bernama " + namaKabupaten + " di Pulau Lombok");
            return;
        }
        int num = 1;
        GNodeWisata currentWis = kab.graphWisata.getFirstWisata();
        while (currentWis != null) {
            System.out.println(num + ". " + currentWis.namaWisata);
            num++;
            currentWis = currentWis.next;
        }
        
        return;
    }
    
    // cari node wisata
    public GNodeWisata findWisataExact(GraphKabupaten graph, String namaWisata) {
        GNodeKabupaten currentKab = graph.getFirstKab();

        while(currentKab != null){
            GNodeWisata found = currentKab.graphWisata.getNode(namaWisata);
            if(found != null){
                return found;
            }
            currentKab = currentKab.getNext();
        }
        return null;
    }
    

    // return nama kabupaten dari wisata
    public String getKabupatenWisata(GraphKabupaten graph, String namaWisata){
        GNodeKabupaten currentKab = graph.getFirstKab();

        while(currentKab != null){
            GNodeWisata found = currentKab.graphWisata.getNode(namaWisata);
            if(found != null){
                return currentKab.namaKabupaten;
            }

            currentKab = currentKab.getNext();
        }
        return null;
    }

    public void displayHasilSearch(GNodeWisata head, GraphKabupaten graph) {
        if (head == null) {
            System.out.println("\n❌ Tidak ada wisata yang ditemukan.");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║               HASIL PENCARIAN WISATA                   ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        
        GNodeWisata current = head;
        int num = 1;
        
        while (current != null) {
            // Cari kabupaten wisata ini
            String kabupaten = getKabupatenWisata(graph, current.namaWisata);
            
            System.out.print("  " + num + ". " + current.namaWisata);
            System.out.print(" (" + current.jenis + ")");
            
            if (current.rating > 0) {
                System.out.print(" ");
                int fullStars = (int) current.rating;
                for (int i = 0; i < fullStars; i++) {
                    System.out.print("* ");
                }
                System.out.print(" " + current.rating);
            }
            
            if (kabupaten != null) {
                System.out.println(" - " + kabupaten);
            } else {
                System.out.println();
            }
            
            current = current.getNext();
            num++;
        }
        
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("Total: " + countResults(head) + " wisata ditemukan");
    }
    
    public int countResults(GNodeWisata head) {
        int count = 0;
        GNodeWisata current = head;
        
        while (current != null) {
            count++;
            current = current.getNext();
        }
        
        return count;
    }

    public void displayJenisWisata(GraphKabupaten graph) {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║            KATEGORI WISATA YANG TERSEDIA               ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
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
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}