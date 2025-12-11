public class Stack {
    StackNode top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(String nama, int rating, String komentar, String tanggal) {
        if (rating < 1 || rating > 5) {
            System.out.println("[X] Rating harus antara 1-5!");
            return;
        }
        
        StackNode newNode = new StackNode(nama, rating, komentar, tanggal, size + 1);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public void displayAll() {
        if (top == null) {
            System.out.println("Belum ada ulasan.");
            return;
        }
        
        System.out.println("\n===========================================================");
        System.out.println("       SEMUA ULASAN (Terbaru-Terlama)");
        System.out.println("===========================================================");
        
        StackNode current = top;
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
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Total: " + size + " ulasan");
        System.out.println("===========================================================");
    }

    public double roundTo(double value, int digits) {
        double factor = 1;

        // Kalikan 10 sesuai jumlah digit
        for (int i = 0; i < digits; i++) {
            factor *= 10;
        }

        // Proses pembulatan manual
        int temp = (int) (value * factor + 0.5);

        return (double) temp / factor;
    }


    public double getAverageRating() {
        if (top == null) {
            return 0.0;
        }
        
        int totalRating = 0;
        StackNode current = top;
        
        while (current != null) {
            totalRating += current.rating;
            current = current.next;
        }
        
        double avg = (double) totalRating / size;
        return roundTo(avg, 2); // 2 = jumlah angka di belakang koma
    }


    public boolean isEmpty() {
        return top == null;
    }
}