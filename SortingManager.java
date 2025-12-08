public class SortingManager {
    
    public static void sortUlasanByRating(Stack stack, boolean tinggiKeLow) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("[X] Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        StackNode head = cloneStackToLinkedList(stack);
        head = bubbleSortByRating(head, tinggiKeLow);
        displaySorted(head, "RATING", tinggiKeLow ? "TERTINGGI -> TERENDAH" : "TERENDAH -> TERTINGGI");
    }
    
    public static void sortUlasanByIndeks(Stack stack, boolean pertamaKeLast) {
        if (stack == null || stack.isEmpty()) {
            System.out.println("[X] Tidak ada ulasan untuk di-sort.");
            return;
        }
        
        StackNode head = cloneStackToLinkedList(stack);
        head = bubbleSortByIndeks(head, pertamaKeLast);
        displaySorted(head, "URUTAN", pertamaKeLast ? "PERTAMA -> TERAKHIR" : "TERAKHIR -> PERTAMA");
    }
    
    private static StackNode cloneStackToLinkedList(Stack stack) {
        if (stack.isEmpty()) return null;
        
        StackNode head = null;
        StackNode tail = null;
        
        StackNode current = stack.top;
        while (current != null) {
            StackNode clone = new StackNode(
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
                    if (current.rating < current.next.rating) {
                        perluTukar = true;
                    }
                } else {
                    if (current.rating > current.next.rating) {
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
                    if (current.indeks > current.next.indeks) {
                        perluTukar = true;
                    }
                } else {
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
    
    private static void displaySorted(StackNode head, String kriteria, String urutan) {
        System.out.println("\n===========================================================");
        System.out.println("   ULASAN TERURUT BY " + kriteria);
        System.out.println("   (" + urutan + ")");
        System.out.println("===========================================================");
        
        StackNode current = head;
        while (current != null) {
            System.out.print("  [" + current.indeks + "] ");
            for (int i = 0; i < current.rating; i++) {
                System.out.print("*");
            }
            System.out.println(" - " + current.namaPengunjung + " (" + current.tanggal + ")");
            System.out.println("      \"" + current.komentar + "\"");
            System.out.println();
            current = current.next;
        }
        
        System.out.println("===========================================================");
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
}