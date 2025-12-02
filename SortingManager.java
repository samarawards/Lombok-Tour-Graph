public class SortingManager {
    // Sort ulasan by rating (tinggi ke rendah atau sebaliknya)
    public static void sortUlasanByRating(Stack stack, boolean tinggiKeLow) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("❌ Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        // 1. Convert Stack ke LinkedList (tanpa merusak stack original)
        StackNode head = cloneStackToLinkedList(stack);
        
        // 2. Bubble sort by rating
        head = bubbleSortByRating(head, tinggiKeLow);
        
        // 3. Display hasil sorted
        displaySorted(head, "RATING", tinggiKeLow ? "TERTINGGI → TERENDAH" : "TERENDAH → TERTINGGI");
    }
    
    // Sort ulasan by indeks/urutan (pertama ke terakhir atau sebaliknya)
    public static void sortUlasanByIndeks(Stack stack, boolean pertamaKeLast) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("❌ Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        StackNode head = cloneStackToLinkedList(stack);
        head = bubbleSortByIndeks(head, pertamaKeLast);
        displaySorted(head, "URUTAN", pertamaKeLast ? "PERTAMA → TERAKHIR" : "TERAKHIR → PERTAMA");
    }
    
    // Sort ulasan by tanggal (terlama ke terbaru atau sebaliknya)
    public static void sortUlasanByTanggal(Stack stack, boolean terlamaKeTerbaru) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("❌ Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        StackNode head = cloneStackToLinkedList(stack);
        head = bubbleSortByTanggal(head, terlamaKeTerbaru);
        displaySorted(head, "TANGGAL", terlamaKeTerbaru ? "TERLAMA → TERBARU" : "TERBARU → TERLAMA");
    }
    
    // Filter ulasan by rating tertentu (1-5)
    public static void filterUlasanByRating(Stack stack, int rating) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("❌ Tidak ada ulasan.");
            return;
        }
        
        if (rating < 1 || rating > 5) {
            System.out.println("❌ Rating harus antara 1-5!");
            return;
        }
        
        StackNode head = cloneStackToLinkedList(stack);
        
        // Hitung jumlah yang match
        int jumlah = 0;
        StackNode current = head;
        while (current != null) {
            if (current.rating == rating) {
                jumlah++;
            }
            current = current.next;
        }
        
        if (jumlah == 0) {
            System.out.println("\n❌ Tidak ada ulasan dengan rating " + rating + " bintang.");
            return;
        }
        
        // Display yang match
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ULASAN DENGAN RATING " + rating + " BINTANG           ║");
        System.out.println("╠════════════════════════════════════════════╣");
        
        current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.print("[" + current.indeks + "] ");
                for (int i = 0; i < current.rating; i++) {
                    System.out.print("⭐");
                }
                System.out.println(" - " + current.namaPengunjung + " (" + current.tanggal + ")");
                System.out.println("    \"" + current.komentar + "\"");
                System.out.println();
            }
            current = current.next;
        }
        
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Total: " + jumlah + " ulasan");
    }
    
    // Stack ke LinkedList
    private static StackNode cloneStackToLinkedList(Stack stack) {
        if (stack.isEmpty()) return null;
        
        StackNode head = null;
        StackNode tail = null;
        
        // Traverse dari top ke bottom
        StackNode current = stack.getTop();
        while (current != null) {
            // Clone node (jangan reference langsung!)
            StackNode clone = new StackNode(
                current.namaPengunjung,
                current.rating,
                current.komentar,
                current.tanggal,
                current.indeks
            );
            
            // Add ke linked list
            if (head == null) {
                head = clone;
                tail = clone;
            } else {
                tail.next = clone;
                tail = clone;
            }
            
            current = current.next;
        }
        
        return head;
    }
    
    private static StackNode bubbleSortByRating(StackNode head, boolean tinggiKeLow) {
        if (head == null || head.next == null) return head;
        
        int panjang = hitungPanjang(head);
        
        for (int i = 0; i < panjang - 1; i++) {
            StackNode current = head;
            StackNode prev = null;
            
            for (int j = 0; j < panjang - i - 1; j++) {
                if (current.next == null) break;
                
                boolean perluTukar = false;
                if (tinggiKeLow) {
                    // Rating tinggi ke rendah (5 → 1)
                    if (current.rating < current.next.rating) {
                        perluTukar = true;
                    }
                } else {
                    // Rating rendah ke tinggi (1 → 5)
                    if (current.rating > current.next.rating) {
                        perluTukar = true;
                    }
                }
                
                if (perluTukar) {
                    // Swap nodes
                    StackNode nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    
                    if (prev == null) {
                        head = nextNode;
                    } else {
                        prev.next = nextNode;
                    }
                    
                    prev = nextNode;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        
        return head;
    }
    
    private static StackNode bubbleSortByIndeks(StackNode head, boolean pertamaKeLast) {
        if (head == null || head.next == null) return head;
        
        int panjang = hitungPanjang(head);
        
        for (int i = 0; i < panjang - 1; i++) {
            StackNode current = head;
            StackNode prev = null;
            
            for (int j = 0; j < panjang - i - 1; j++) {
                if (current.next == null) break;
                
                boolean perluTukar = false;
                if (pertamaKeLast) {
                    // Indeks kecil ke besar (1 → N)
                    if (current.indeks > current.next.indeks) {
                        perluTukar = true;
                    }
                } else {
                    // Indeks besar ke kecil (N → 1)
                    if (current.indeks < current.next.indeks) {
                        perluTukar = true;
                    }
                }
                
                if (perluTukar) {
                    StackNode nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    
                    if (prev == null) {
                        head = nextNode;
                    } else {
                        prev.next = nextNode;
                    }
                    
                    prev = nextNode;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        
        return head;
    }
    
    private static StackNode bubbleSortByTanggal(StackNode head, boolean terlamaKeTerbaru) {
        if (head == null || head.next == null) return head;
        
        int panjang = hitungPanjang(head);
        
        for (int i = 0; i < panjang - 1; i++) {
            StackNode current = head;
            StackNode prev = null;
            
            for (int j = 0; j < panjang - i - 1; j++) {
                if (current.next == null) break;
                
                // Compare tanggal (format: "DD-MM-YYYY")
                int hasilBanding = bandingkanTanggal(current.tanggal, current.next.tanggal);
                
                boolean perluTukar = false;
                if (terlamaKeTerbaru) {
                    // Terlama dulu (tanggal lebih kecil)
                    if (hasilBanding > 0) {
                        perluTukar = true;
                    }
                } else {
                    // Terbaru dulu (tanggal lebih besar)
                    if (hasilBanding < 0) {
                        perluTukar = true;
                    }
                }
                
                if (perluTukar) {
                    StackNode nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    
                    if (prev == null) {
                        head = nextNode;
                    } else {
                        prev.next = nextNode;
                    }
                    
                    prev = nextNode;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
        }
        
        return head;
    }
    
    private static void displaySorted(StackNode head, String kriteria, String urutan) {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   ULASAN TERURUT BY " + kriteria);
        System.out.println("║   (" + urutan + ")");
        System.out.println("╠════════════════════════════════════════════╣");
        
        StackNode current = head;
        while (current != null) {
            System.out.print("[" + current.indeks + "] ");
            for (int i = 0; i < current.rating; i++) {
                System.out.print("⭐");
            }
            System.out.println(" - " + current.namaPengunjung + " (" + current.tanggal + ")");
            System.out.println("    \"" + current.komentar + "\"");
            System.out.println();
            current = current.next;
        }
        
        System.out.println("╚════════════════════════════════════════════╝");
    }
    
    private static int hitungPanjang(StackNode head) {
        int jumlah = 0;
        StackNode current = head;
        
        while (current != null) {
            jumlah++;
            current = current.next;
        }
        
        return jumlah;
    }
    
    
    // Bandingkan 2 tanggal (format: "DD-MM-YYYY")
    // return -1 jika tanggal1 < tanggal2, 0 jika sama, 1 jika tanggal1 > tanggal2
    private static int bandingkanTanggal(String tanggal1, String tanggal2) {
        int hari1 = ambilBagianTanggal(tanggal1, 0);
        int bulan1 = ambilBagianTanggal(tanggal1, 1);
        int tahun1 = ambilBagianTanggal(tanggal1, 2);
        
        int hari2 = ambilBagianTanggal(tanggal2, 0);
        int bulan2 = ambilBagianTanggal(tanggal2, 1);
        int tahun2 = ambilBagianTanggal(tanggal2, 2);
        
        // Bandingkan tahun dulu
        if (tahun1 < tahun2) return -1;
        if (tahun1 > tahun2) return 1;
        
        // Kalau tahun sama, bandingkan bulan
        if (bulan1 < bulan2) return -1;
        if (bulan1 > bulan2) return 1;
        
        // Kalau bulan sama, bandingkan hari
        if (hari1 < hari2) return -1;
        if (hari1 > hari2) return 1;
        
        return 0; // Sama persis
    }
    
    private static int ambilBagianTanggal(String tanggal, int bagian) {
        int jumlahStrip = 0;
        int indexMulai = 0;
        
        for (int i = 0; i < tanggal.length(); i++) {
            if (tanggal.charAt(i) == '-') {
                if (jumlahStrip == bagian) {
                    return ubahStringKeAngka(tanggal.substring(indexMulai, i));
                }
                jumlahStrip++;
                indexMulai = i + 1;
            }
        }
        
        // Bagian terakhir (tahun)
        if (jumlahStrip == bagian) {
            return ubahStringKeAngka(tanggal.substring(indexMulai));
        }
        
        return 0;
    }
    
    
    // Ubah string ke angka manual (tanpa Integer.parseInt)
    
    private static int ubahStringKeAngka(String teks) {
        int hasil = 0;
        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);
            if (karakter >= '0' && karakter <= '9') {
                hasil = hasil * 10 + (karakter - '0');
            }
        }
        return hasil;
    }
}