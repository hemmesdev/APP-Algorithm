package nl.han.ica.app.graphs;

public class Edge {

    public Vertex dest;

    protected double cost;

    public Edge(Vertex dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public Vertex getDest() {
        return dest;
    }

    @Override
    public String toString() {
        return "\t" + dest.getName() + "\t\t" + dest.getDist() + "\t\t" + cost + "\n";
    }

    public double getCost() {
        return cost;
    }
}
