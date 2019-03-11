package nl.han.ica.app;

import nl.han.ica.app.graphs.Graph;

public class Graphs {


    public static void main(String[] args) {

        Graph graph = new Graph();

        graph.addEdge("V0", "V1", 2);
        graph.addEdge("V0", "V3", 1);
        graph.addEdge("V1", "V3", 3);
        graph.addEdge("V1", "V4", 10);
        graph.addEdge("V3", "V2", 2);
        graph.addEdge("V3", "V4", 2);
        graph.addEdge("V3", "V6", 4);
        graph.addEdge("V3", "V5", 8);
        graph.addEdge("V2", "V0", 4);
        graph.addEdge("V2", "V5", 5);
        graph.addEdge("V4", "V6", 6);
        graph.addEdge("V6", "V5", 1);

        System.out.println("Unweighted V0");
        graph.unweightedPath("V0");
        System.out.println(graph.distToString());
        System.out.println("Unweighted V1");
        graph.unweightedPath("V1");
        System.out.println(graph.distToString());
        System.out.println("Unweighted V2");
        graph.unweightedPath("V2");
        System.out.println(graph.distToString());
        System.out.println("Unweighted V3");
        graph.unweightedPath("V3");
        System.out.println(graph.distToString());

        System.out.println("Dijksta V0");
        graph.dijkstra("V0");
        System.out.println(graph.distToString());
        System.out.println("Dijksta V1");
        graph.dijkstra("V1");
        System.out.println(graph.distToString());
        System.out.println("Dijksta V2");
        graph.dijkstra("V2");
        System.out.println(graph.distToString());
        System.out.println("Dijksta V3");
        graph.dijkstra("V3");
        System.out.println(graph.distToString());

        System.out.println(graph.isConnected());

        Graph connectedGraph = new Graph();
        connectedGraph.addEdge("V0", "V1", 0);
        connectedGraph.addEdge("V1", "V0", 0);
        connectedGraph.addEdge("V2", "V1", 0);
        connectedGraph.addEdge("V1", "V2", 0);

        System.out.println(connectedGraph.isConnected());


    }

}
