public class PathResult {
    String jalur;       
    float totalJarak;   
    boolean found;      

    public PathResult(String jalur, float totalJarak, boolean found) {
        this.jalur = jalur;
        this.totalJarak = totalJarak;
        this.found = found;
    }
}