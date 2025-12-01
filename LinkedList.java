public class LinkedList {
    LLNode head, tail;
    int totalJarak = 0;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }

    public void addLokasi(String lokasi, String jenis, int jarak){
        LLNode newNode = new LLNode(lokasi, jenis, jarak);
        if(head==null){
            head = tail = newNode;
            System.out.println("Berangkat dari " + lokasi + "...");
            return;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        
    }

    public void displayLinkedList(){
        LLNode current = head;
        if(current==null){
            System.out.println("List perjalanan kosong.");
            return;
        }
        
        System.out.println("===== History Perjalanan =====");
        while(current != null){
            System.out.println("- " + current.lokasi + " (" + current.jarak + " km");
            current = current.next;
        }
        System.out.println("Total jarak perjalanan: " + totalJarak + " km");
    }
}
