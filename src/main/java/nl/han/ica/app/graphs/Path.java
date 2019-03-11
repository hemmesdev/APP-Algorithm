package nl.han.ica.app.graphs;

public class Path extends Edge implements Comparable<Path> {


    public Path(Vertex dest, double cost) {
        super(dest, cost);
    }

    @Override
    public int compareTo(Path rhs) {
        return Double.compare(cost, rhs.cost);
    }
}
