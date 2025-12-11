public class GEdgeKabupaten {
    GNodeKabupaten fromKab;
    GNodeKabupaten toKab;
    float weight;
    GEdgeKabupaten next;

    public GEdgeKabupaten(GNodeKabupaten from, GNodeKabupaten to, float weight) {
        this.fromKab = from;
        this.toKab = to;
        this.weight = weight;
    }
}