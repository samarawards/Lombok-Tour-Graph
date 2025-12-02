public class Stack {
    StackNode top;
    int size;
<<<<<<< HEAD
=======
    int indeksCounter; // Auto increment untuk setiap push
>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64

    public Stack() {
        this.top = null;
        this.size = 0;
<<<<<<< HEAD
    }

    public void push(Ulasan ulasan) {
        StackNode newNode = new StackNode(ulasan);
=======
        this.indeksCounter = 0;
    }

    public void push(String nama, int rating, String komentar, String tanggal) {
        indeksCounter++;
        StackNode newNode = new StackNode(nama, rating, komentar, tanggal, indeksCounter);
>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64
        newNode.next = top;
        top = newNode;
        size++;
    }

<<<<<<< HEAD
    public Ulasan pop() {
        if (top == null) {
            System.out.println("Stack kosong!");
            return null;
        }
        Ulasan data = top.ulasan;
        top = top.next;
        size--;
        return data;
    }

    public void displayAll() {
        if (top == null) {
            System.out.println("Belum ada ulasan.");
            return;
        }
        
        System.out.println("========== Semua Ulasan ==========");
        StackNode current = top;
        int index = 1;
        while (current != null) {
            System.out.println("Ulasan #" + index);
            System.out.println(current.ulasan);
            System.out.println("----------------------------------");
            current = current.next;
            index++;
        }
    }

    public void displayByRating(int minRating) {
        if (top == null) {
            System.out.println("Belum ada ulasan.");
            return;
        }
        
        System.out.println("========== Ulasan Rating >= " + minRating + " ==========");
        StackNode current = top;
        int count = 0;
        while (current != null) {
            if (current.ulasan.rating >= minRating) {
                System.out.println(current.ulasan);
                System.out.println("----------------------------------");
                count++;
            }
            current = current.next;
        }
        
        if (count == 0) {
            System.out.println("Tidak ada ulasan dengan rating >= " + minRating);
        }
    }

    public double getAverageRating() {
        if (top == null) {
            return 0.0;
        }
        
        int totalRating = 0;
        int count = 0;
        StackNode current = top;
        
        while (current != null) {
            totalRating += current.ulasan.rating;
            count++;
            current = current.next;
        }
        
        return (double) totalRating / count;
=======
    public StackNode pop() {
        if (top == null) return null;
        StackNode temp = top;
        top = top.next;
        size--;
        return temp;
    }

    public StackNode peek() {
        return top;
>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64
    }

    public boolean isEmpty() {
        return top == null;
    }

<<<<<<< HEAD
=======
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

>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64
    public int getSize() {
        return size;
    }
}

<<<<<<< HEAD
class ulasan {
    
}
=======
/* Masih butuh method:
public void displayByRating(int rating) - tampilkan ulasan dengan rating tertentu
public StackNode ... - buat untuk sorting
*/
>>>>>>> 62442c972c66fa0c2f94b95be0b1d5f881414c64
