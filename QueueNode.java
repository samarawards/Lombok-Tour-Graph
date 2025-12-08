public class QueueNode {
    String pengunjung;
    String tanggalTour;
    QueueNode next;    
    LinkedList jalur;

    public QueueNode(String pengunjung, String tanggalTour) {
        this.pengunjung = pengunjung;
        this.tanggalTour = tanggalTour;
        this.next = null;
        this.jalur = new LinkedList();
    }
}