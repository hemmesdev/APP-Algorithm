package nl.han.ica.app.graphs;

import nl.han.ica.app.liststackqueue.ArrayListBasedQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

public class Graph {

    public static final double INFINITY = Double.MAX_VALUE;

    private Map<String, Vertex> vertexMap = new HashMap<>();

    public void addEdge(String sourceName, String destName, double cost) {
        Vertex source = getVertex(sourceName);
        Vertex dest = getVertex(destName);
        source.addEdge(new Edge(dest, cost));
    }

    private Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    public void unweightedPath(String startName) {
        clearAll();
        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NoSuchElementException("Start not found");
        }

        ArrayListBasedQueue<Vertex> queue = new ArrayListBasedQueue<>();
        queue.enqueue(start);
        start.setDist(0);

        while(queue.getSize() > 0) {
            Vertex vertex = queue.dequeue();
            for(Edge edge : vertex.getAdjacentVertices()){
                Vertex edgeVertex = edge.getDest();
                if(edgeVertex.getDist() == INFINITY) {
                    edgeVertex.setDist(vertex.getDist() + 1);
                    edgeVertex.setPrevious(vertex);
                    queue.enqueue(edgeVertex);
                }
            }
        }
    }

    public void dijkstra(String startName) {
        clearAll();
        PriorityQueue<Path> pathPriorityQueue = new PriorityQueue<>();
        Vertex start = vertexMap.get(startName);
        if(start == null) {
            throw new NoSuchElementException("Start not found");
        }

        pathPriorityQueue.add(new Path(start, 0));
        start.setDist(0);

        int nodeSeen = 0;
        while(!pathPriorityQueue.isEmpty() && nodeSeen < vertexMap.size()) {

            Path vrec = pathPriorityQueue.remove();
            Vertex vertex = vrec.dest;
            if(vertex.getScratch() != 0) {
                continue;
            }

            vertex.setScratch(1);
            nodeSeen++;

            for(Edge edge : vertex.getAdjacentVertices()) {
                Vertex w = edge.getDest();
                double cvw = edge.getCost();
                if(w.getDist() > vertex.getDist() + cvw) {
                    w.setDist(vertex.getDist() + cvw);
                    w.setPrevious(vertex);
                    pathPriorityQueue.add(new Path(w, w.getDist()));
                }
            }
        }
    }

    private void clearAll() {
        for(Vertex vertex : vertexMap.values()) {
            vertex.reset();
        }
    }

    public String distToString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name\tDist\n");
        stringBuilder.append("-------------\n");
        for(Vertex vertex : vertexMap.values()) {
            stringBuilder.append(vertex.getName());
            stringBuilder.append("\t\t");
            stringBuilder.append(vertex.getDist());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("From\tTo\t\tCost\n");
        stringBuilder.append("----------------------\n");
        for(Vertex vertex : vertexMap.values()) {
            stringBuilder.append(vertex.toString());
        }
        return stringBuilder.toString();
    }

    private void visit(Vertex vertex) {
        vertex.setScratch(1);
        for(Edge edge : vertex.getAdjacentVertices()) {
            Vertex adjacent = edge.getDest();
            if(adjacent.getScratch() == 0) {
                visit(edge.getDest());
            }
        }
    }

    public boolean isConnected() {
        clearAll();
        if(vertexMap.size() > 0) {
            visit(vertexMap.values().iterator().next());
        }

        for(Vertex vertex : vertexMap.values()) {
            if(vertex.getScratch() == 0) {
                return false;
            }
        }
        return true;
    }

}
