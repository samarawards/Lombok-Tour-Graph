public class QueueNode {
    String pengunjung;

    QueueNode next;    

    LinkedList jalur = new LinkedList();

    public QueueNode (String pengunjung){
        this.pengunjung = pengunjung;
        this.next = null;
    }

}
