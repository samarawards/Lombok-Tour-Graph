public class Queue {
    QueueNode first;
    QueueNode last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void enqueue(String pengunjung, String tanggalTour) {
        QueueNode newPengunjung = new QueueNode(pengunjung, tanggalTour);
        if (first == null) {
            first = newPengunjung;
            last = newPengunjung;
        } else {
            last.next = newPengunjung;
            last = newPengunjung;
        }
        size++;
    }

    public QueueNode dequeue() {
        if (first == null) {
            System.out.println("[X] Antrian kosong!");
            return null;
        }
        
        QueueNode temp = first;
        first = first.next;
        
        if (first == null) {
            last = null; 
        }
        
        temp.next = null; 
        size--;
        return temp;
    }

    public void displayQueue() {
        if (first == null) {
            System.out.println("\n===========================================================");
            System.out.println("              ANTRIAN KOSONG");
            System.out.println("===========================================================");
            return;
        }
        
        System.out.println("\n===========================================================");
        System.out.println("          ANTRIAN PENGUNJUNG TOUR");
        System.out.println("===========================================================");
        
        QueueNode temp = first;
        int num = 1; 
        
        while (temp != null) {
            System.out.println("  " + num + ". " + temp.pengunjung + " (Tour: " + temp.tanggalTour + ")");
            temp = temp.next;
            num++; 
        }
        
        System.out.println("-----------------------------------------------------------");
        System.out.println("  Total antrian: " + size + " orang");
        System.out.println("===========================================================");
    }
}