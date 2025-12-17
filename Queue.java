public class Queue {
    QueueNode first;
    QueueNode last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void enqueueCondi(String pengunjung, String tanggalTour){
        if (first == null) {
            enqueue(pengunjung, tanggalTour);
            return;
        }

        Queue tempQueue = new Queue();
        boolean inserted = false;
        
        while (first != null) {
            QueueNode node = dequeue();

            if (!inserted && compare(tanggalTour, node.tanggalTour)) {
                tempQueue.enqueue(pengunjung, tanggalTour);
                inserted = true;
            }

            tempQueue.enqueue(node.pengunjung, node.tanggalTour);
        }
        if (!inserted) {
            tempQueue.enqueue(pengunjung, tanggalTour);
        }
        //kembalikan
        while (tempQueue.first != null) {
            QueueNode node = tempQueue.dequeue();
            enqueue(node.pengunjung, node.tanggalTour);
        }
    }

    private void enqueue(String pengunjung, String tanggalTour) {
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

    private boolean compare(String a, String b){ //a > b == true, a < b == false
        int dateA = getYear(a);
        int dateB = getYear(b);
        if (dateA < dateB) return true;
        else if (dateA > dateB)  return false;
        else if (dateA == dateB){
            dateA = getMonth(a);
            dateB = getMonth(b);
            if (dateA < dateB) return true;
            else if (dateA > dateB) return false;
            else if (dateA == dateB){
                dateA = getDate(a);
                dateB = getDate(b);
                if (dateA < dateB) return true;
                else if (dateA > dateB) return false;
                else return false;
            }else return false;
        }else return false;
    }

    private int getYear(String take){
        String year = "";
        for (int i = 6; i < 10; i++) {
            year += take.charAt(i);
        }
        return Integer.valueOf(year);
    }

    private int getMonth(String take){
        String month = "";
        for (int i = 3; i < 5; i++) {
            month += take.charAt(i);
        }
        return Integer.valueOf(month);
    }
    private int getDate(String take){
        String date = "";
        for (int i = 0; i < 2; i++) {
            date += take.charAt(i);
        }
        return Integer.valueOf(date);
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