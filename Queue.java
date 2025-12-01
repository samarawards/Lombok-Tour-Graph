public class Queue {
    QueueNode fisrt;
    QueueNode last;
    QueueNode temp;

    public void enqueue(String pengunjung){
        QueueNode newPengunjung = new QueueNode(pengunjung);
        if (fisrt == null) {
            fisrt = newPengunjung;
        }else{
            last.next = newPengunjung;
        }      
        last = newPengunjung;
    }

    public QueueNode dequeue(){
        if (fisrt == null) return null;
        temp = fisrt;
        fisrt = fisrt.next;
        temp.next = null;
        return temp;
    }
    public void displayQueue(){
        temp = fisrt;
        System.out.println("============= Antrian Lombok Tour Graph =============");
        while (temp != null) {
            int num = 1;
            System.out.println(num + ". " + temp.pengunjung);
            temp = temp.next;
        }
        System.out.println("=====================================================");
    }
}
