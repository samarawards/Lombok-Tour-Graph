public class PathResult {
    String jalur;       
    float totalJarak;   
    boolean found;      

    public PathResult(String jalur, float totalJarak, boolean found) {
        this.jalur = jalur;
        this.totalJarak = totalJarak;
        this.found = found;
    }

    public void displayPath() {
        if (found) {
            System.out.println("\n╔════════════════════════════════════════════╗");
            System.out.println("║        RUTE PERJALANAN                     ║");
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ " + jalur);
            System.out.println("╠════════════════════════════════════════════╣");
            System.out.println("║ Total Jarak: " + totalJarak + " km");
            System.out.println("╚════════════════════════════════════════════╝");
        } else {
            System.out.println("\n❌ Rute tidak ditemukan!");
        }
    }
    
    public void displaySimple() {
        if (found) {
            System.out.println("Rute: " + jalur);
            System.out.println("Total Jarak: " + totalJarak + " km");
        } else {
            System.out.println("❌ Rute tidak ditemukan!");
        }
    }
    
    // Getter methods
    public String getJalur() {
        return jalur;
    }
    
    public float getTotalJarak() {
        return totalJarak;
    }
    
    public boolean isFound() {
        return found;
    }
}

/*
class untuk menyimpan hasil pathfinding Dijkstra. Dipakai oleh GraphKabupaten dan GraphWisata.
Dipakai:
- GraphKabupaten.java (Dijkstra kabupaten)
- GraphWisata.java (Dijkstra wisata)
- Main.java (display rute)
*/