public class SortingManager {
    
    /**
     * Sort ulasan by rating (Bubble Sort Manual pada LinkedList)
     * Stack ulasan yang mau di-sort
     * rue = rating tinggi ke rendah, false = sebaliknya
     */
    public static void sortUlasanByRating(Stack stack, boolean tinggiKeLow) {
        // Implement bubble sort manual pada LINKED LIST
        // 1. Convert Stack ke LinkedList temporary
        // 2. Bubble sort dengan swap data node
        // 3. Display hasil sorted
    }
    
    /**
     * Sort ulasan by indeks (komentar pertama/terakhir)
     * Stack ulasan yang mau di-sort
     * true = indeks 1→N, false = indeks N→1
     */
    public static void sortUlasanByIndeks(Stack stack, boolean pertamaKeLast) {
        // 1. Convert Stack ke LinkedList temporary
        // 2. Bubble sort by indeks
        // 3. Display hasil sorted
    }
    
    // ==================== SORTING WISATA ====================
    
    /**
     * Sort wisata by nama (A-Z) - Bubble Sort pada LinkedList
     * Head dari linked list GNodeWisata
     */
    public static void sortWisataByNama(GNodeWisata head) {
        // Implement bubble sort on linked list
        // Loop nested, compare & swap data node (nama)
    }
    
    /**
     * Sort wisata by rating - Bubble Sort pada LinkedList
     * Head dari linked list GNodeWisata
     * true = rating tinggi ke rendah, false = sebaliknya
     */
    public static void sortWisataByRating(GNodeWisata head, boolean tinggiKeLow) {
        // Implement bubble sort on linked list
        // Loop nested, compare & swap data node (rating)
    }
    
    // ==================== HELPER METHODS ====================
    
    /**
     * Convert Stack ke Temporary LinkedList (untuk sorting)
     * Stack yang mau diconvert
     * Head of temporary LinkedList
     */
    private static StackNode stackToLinkedList(Stack stack) {
        // Implement
        // 1. Buat LinkedList temporary (StackNode)
        // 2. Pop semua dari stack, add ke LinkedList
        // 3. Push balik semua ke stack (restore original)
        // 4. Return head LinkedList temporary
        return null;
    }
    
    /**
     * Display sorted LinkedList ulasan
     * Head of LinkedList
     */
    private static void displaySortedUlasan(StackNode head) {
        // Implement
        // Loop & print semua ulasan dalam LinkedList
    }
    
    /**
     * Swap data dua node (BUKAN swap pointer!)
     * Node pertama
     * Node kedua
     */
    private static void swapStackNodeData(StackNode a, StackNode b) {
        // Implement
        // Swap: nama, rating, komentar, tanggal, indeks
        // JANGAN swap pointer next!
    }
    
    /**
     * Swap data dua node wisata (BUKAN swap pointer!)
     * Node pertama
     * Node kedua
     */
    private static void swapWisataNodeData(GNodeWisata a, GNodeWisata b) {
        // Implement
        // Swap: nama, rating, deskripsi, dll
        // JANGAN swap pointer next, edges, stack!
    }
    
    /**
     * Hitung panjang LinkedList
     * head Head of LinkedList
     * Jumlah node
     */
    private static int getLength(StackNode head) {
        // Implement
        // Loop count sampai null
        return 0;
    }
}

/* Masih butuh method:
public static void sortWisataByJenis(GNodeWisata head, String jenis) - sort & filter by jenis (optional)
public static void filterUlasanByRating(Stack stack, int rating) - filter ulasan dengan rating tertentu (optional)
*/

/*
UNTUK SORTING ULASAN (Stack → LinkedList Temporary):

✅ sortUlasanByRating(Stack, boolean) - Sort by rating (bubble sort LinkedList)
✅ sortUlasanByIndeks(Stack, boolean) - Sort by indeks (bubble sort LinkedList)
⚠️ stackToLinkedList(Stack) - Helper: Convert Stack → LinkedList temporary
⚠️ displaySortedUlasan(StackNode) - Helper: Display LinkedList hasil sorting
⚠️ swapStackNodeData(StackNode, StackNode) - Helper: Swap data (BUKAN pointer)
⚠️ getLength(StackNode) - Helper: Hitung panjang LinkedList

UNTUK SORTING WISATA (LinkedList):

✅ sortWisataByNama(GNodeWisata) - Sort wisata A→Z (bubble sort LinkedList)
✅ sortWisataByRating(GNodeWisata, boolean) - Sort wisata by rating (bubble sort LinkedList)
⚠️ swapWisataNodeData(GNodeWisata, GNodeWisata) - Helper: Swap data node
*/