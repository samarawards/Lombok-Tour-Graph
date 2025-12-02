public class SearchEngine {
    
    // ==================== SEARCH WISATA ====================
    
    /**
     * Cari wisata by nama (keyword matching)
     * Graph kabupaten utama
     *  Kata kunci pencarian (case insensitive)
     *  Head LinkedList wisata yang cocok (atau null jika tidak ada)
     */
    public static GNodeWisata searchByNama(GraphKabupaten graph, String keyword) {
        // Implement linear search
        // 1. Loop semua kabupaten
        // 2. Loop semua wisata dalam setiap kabupaten
        // 3. Jika nama.contains(keyword) → tambah ke hasil LinkedList
        // 4. Return head hasil
        return null;
    }
    
    /**
     * Cari wisata by jenis (pantai/air terjun/bukit/dll)
     * Graph kabupaten utama
     * Jenis wisata
     *  Head LinkedList wisata yang cocok
     */
    public static GNodeWisata searchByJenis(GraphKabupaten graph, String jenis) {
        // Implement linear search
        // 1. Loop semua kabupaten
        // 2. Loop semua wisata dalam setiap kabupaten
        // 3. Jika wisata.jenis.equals(jenis) → tambah ke hasil
        // 4. Return head hasil
        return null;
    }
    
    /**
     * Cari wisata by rating minimal
     * Graph kabupaten utama
     * \Rating minimal (contoh: 4.0)
     *  Head LinkedList wisata dengan rating >= minRating
     */
    public static GNodeWisata searchByRating(GraphKabupaten graph, float minRating) {
        // Implement linear search
        // 1. Loop semua kabupaten
        // 2. Loop semua wisata dalam setiap kabupaten
        // 3. Jika wisata.rating >= minRating → tambah ke hasil
        // 4. Return head hasil
        return null;
    }
    
    /**
     * Cari semua wisata dalam kabupaten tertentu
     * Graph kabupaten utama
     * Nama kabupaten
     *  Head LinkedList wisata dalam kabupaten tersebut
     */
    public static GNodeWisata searchByKabupaten(GraphKabupaten graph, String namaKabupaten) {
        // Implement
        // 1. Cari NodeKabupaten by nama
        // 2. Return graphWisata.firstWisata
        return null;
    }
    
    /**
     * Cari wisata spesifik by nama EXACT (untuk Dijkstra)
     * Graph kabupaten utama
     * Nama wisata EXACT
     *  NodeWisata yang dicari (atau null jika tidak ada)
     */
    public static GNodeWisata findWisataExact(GraphKabupaten graph, String namaWisata) {
        // Implement
        // 1. Loop semua kabupaten
        // 2. Loop semua wisata dalam setiap kabupaten
        // 3. Jika nama.equals(namaWisata) → return node
        // 4. Return null jika tidak ditemukan
        return null;
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Display hasil search (LinkedList wisata)
     * Head dari hasil search
     */
    public static void displayHasilSearch(GNodeWisata head) {
        // Implement
        // Loop & print: nama, kabupaten, jenis, rating
        if (head == null) {
            System.out.println("Tidak ada wisata yang ditemukan.");
            return;
        }
        
        System.out.println("========== HASIL PENCARIAN ==========");
        // Loop & display
        System.out.println("=====================================");
    }
    
    /**
     * Tambah node wisata ke hasil LinkedList (clone node, bukan referensi!)
     * Head hasil LinkedList
     * Node wisata yang mau ditambah
     *  Head baru (jika head null)
     */
    private static GNodeWisata addToResult(GNodeWisata head, GNodeWisata wisata) {
        // Implement
        // 1. Clone data wisata (JANGAN reference langsung!)
        // 2. Add ke tail LinkedList hasil
        // 3. Return head
        return null;
    }
    
    /**
     * Hitung jumlah hasil search
     * Head LinkedList hasil
     *  Jumlah wisata
     */
    public static int countResults(GNodeWisata head) {
        // Implement
        // Loop count sampai null
        return 0;
    }
}

/* Masih butuh method:
public static GNodeWisata searchMultiCriteria(GraphKabupaten graph, String keyword, String jenis, float minRating) - search kombinasi (optional)
public static String getKabupatenWisata(GraphKabupaten graph, String namaWisata) - return kabupaten dari wisata tertentu (untuk Dijkstra)
*/

/*
SEARCH METHODS:

✅ searchByNama(GraphKabupaten, String) - Cari by nama/keyword
✅ searchByJenis(GraphKabupaten, String) - Cari by jenis (pantai/air terjun/dll)
✅ searchByRating(GraphKabupaten, float) - Cari by rating minimal
✅ searchByKabupaten(GraphKabupaten, String) - Cari semua wisata di kabupaten
✅ findWisataExact(GraphKabupaten, String) - Cari wisata EXACT (untuk Dijkstra)

HELPER METHODS:

⚠️ displayHasilSearch(GNodeWisata) - Display hasil search
⚠️ addToResult(GNodeWisata, GNodeWisata) - Tambah node ke hasil (clone data!)
⚠️ countResults(GNodeWisata) - Hitung jumlah hasil

OPTIONAL:

🆕 searchMultiCriteria(...) - Search kombinasi (nama + jenis + rating)
🆕 getKabupatenWisata(GraphKabupaten, String) - Return nama kabupaten dari wisata
*/