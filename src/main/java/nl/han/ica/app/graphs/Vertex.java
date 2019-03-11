package nl.han.ica.app.graphs;


import nl.han.ica.app.liststackqueue.MyLinkedList;

public class Vertex {

    private String name;

    private MyLinkedList<Edge> adjacentVertices;

    private double dist;

    private Vertex previous;

    private int scratch;

    public Vertex(String name) {
        this.name = name;
        adjacentVertices = new MyLinkedList<>();
        reset();
    }

    public void reset() {
        dist = Graph.INFINITY;
        previous = null;
        scratch = 0;
    }

    public void addEdge(Edge edge) {
        this.adjacentVertices.add(edge);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Edge edge : adjacentVertices) {
            stringBuilder.append(name);
            stringBuilder.append("\t");
            stringBuilder.append(edge.toString());
        }
        return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public double getDist() {
        return dist;
    }

    public MyLinkedList<Edge> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public int getScratch() {
        return scratch;
    }

    public void setScratch(int scratch) {
        this.scratch = scratch;
    }
}
