public class Stack {
    StackNode top;
    int size;
    int indeksCounter; // Auto increment untuk setiap push

    public Stack() {
        this.top = null;
        this.size = 0;
        this.indeksCounter = 0;
    }

    public void push(String nama, int rating, String komentar, String tanggal) {
        indeksCounter++;
        StackNode newNode = new StackNode(nama, rating, komentar, tanggal, indeksCounter);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public StackNode pop() {
        if (top == null) return null;
        StackNode temp = top;
        top = top.next;
        size--;
        return temp;
    }

    public StackNode peek() {
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void displayAll() {
        StackNode current = top;
        if (current == null) {
            System.out.println("Belum ada ulasan.");
            return;
        }

        System.out.println("========== ULASAN ==========");
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
        System.out.println("============================");
    }

    // ✅ Hitung rata-rata rating
    public float getRataRata() {
        if (top == null) return 0.0f;

        StackNode current = top;
        float sum = 0;
        int count = 0;

        while (current != null) {
            sum += current.rating;
            count++;
            current = current.next;
        }

        return sum / count;
    }

    public int getSize() {
        return size;
    }
}

/* Masih butuh method:
public void displayByRating(int rating) - tampilkan ulasan dengan rating tertentu
public StackNode ... - buat untuk sorting
*/