public class Stack {
    StackNode top;
    int size;

    public Stack() {
        this.top = null;
        this.size = 0;
    }

    public void push(Ulasan ulasan) {
        StackNode newNode = new StackNode(ulasan);
        newNode.next = top;
        top = newNode;
        size++;
    }

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
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}

class ulasan {
    
}