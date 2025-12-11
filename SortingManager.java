public class SortingManager {
    
    public static void sortUlasanByRating(Stack stack, boolean tinggiKeLow) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("[X] Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        LLNode head = cloneStackToLLNode(stack);
        head = bubbleSortByRating(head, tinggiKeLow);
        displaySorted(head, "RATING", tinggiKeLow ? "TERTINGGI -> TERENDAH" : "TERENDAH -> TERTINGGI");
    }
    
    public static void sortUlasanByIndeks(Stack stack, boolean pertamaKeLast) {
        if (stack == null || stack.isEmpty()) {
            
            System.out.println("[X] Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        LLNode head = cloneStackToLLNode(stack);
        head = bubbleSortByIndeks(head, pertamaKeLast);
        displaySorted(head, "URUTAN", pertamaKeLast ? "PERTAMA -> TERAKHIR" : "TERAKHIR -> PERTAMA");
    }
    
    public static LLNode cloneStackToLLNode(Stack stack) {
        if (stack.isEmpty()) return null;
        
        LLNode head = null;
        LLNode tail = null;
        
        StackNode current = stack.top;
        while (current != null) {
            LLNode clone = new LLNode(
                current.namaPengunjung,
                current.rating,
                current.komentar,
                current.tanggal,
                current.indeks
            );
            
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
    
    public static LLNode bubbleSortByRating(LLNode head, boolean tinggiKeLow) {
        if (head == null || head.next == null) return head;
        
        int panjang = hitungPanjang(head);
        
        for (int i = 0; i < panjang - 1; i++) {
            LLNode current = head;
            LLNode prev = null;
            
            for (int j = 0; j < panjang - i - 1; j++) {
                if (current.next == null) break;
                
                boolean perluTukar = false;
                if (tinggiKeLow) {
                    if (current.rating < current.next.rating) {
                        perluTukar = true;
                    }
                } else {
                    if (current.rating > current.next.rating) {
                        perluTukar = true;
                    }
                }
                
                if (perluTukar) {
                    LLNode nextNode = current.next;
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
    
    public static LLNode bubbleSortByIndeks(LLNode head, boolean pertamaKeLast) {
        if (head == null || head.next == null) return head;
        
        int panjang = hitungPanjang(head);
        
        for (int i = 0; i < panjang - 1; i++) {
            LLNode current = head;
            LLNode prev = null;
            
            for (int j = 0; j < panjang - i - 1; j++) {
                if (current.next == null) break;
                
                boolean perluTukar = false;
                if (pertamaKeLast) {
                    if (current.indeks > current.next.indeks) {
                        perluTukar = true;
                    }
                } else {
                    if (current.indeks < current.next.indeks) {
                        perluTukar = true;
                    }
                }
                
                if (perluTukar) {
                    LLNode nextNode = current.next;
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
    
    public static void displaySorted(LLNode head, String kriteria, String urutan) {
        System.out.println("\n===========================================================");
        System.out.println("   ULASAN TERURUT BY " + kriteria);
        System.out.println("   (" + urutan + ")");
        System.out.println("===========================================================");
        
        LLNode current = head;
        while (current != null) {
            System.out.print("  [" + current.indeks + "] ");
            for (int i = 0; i < current.rating; i++) {
                System.out.print("⭐");
            }
            System.out.println(" - " + current.namaPengunjung + " (" + current.tanggal + ")");
            System.out.println("      \"" + current.komentar + "\"");
            System.out.println();
            current = current.next;
        }
        
        System.out.println("===========================================================");
    }
    
    public static int hitungPanjang(LLNode head) {
        int jumlah = 0;
        LLNode current = head;
        
        while (current != null) {
            jumlah++;
            current = current.next;
        }
        
        return jumlah;
    }
}