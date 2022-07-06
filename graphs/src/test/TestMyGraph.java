package test;

import graphs.DirectedWeightedGraph;
import graphs.WeightedEdge;

public class TestMyGraph {

    public static void main(String[] args) {

        // this actor graph rates how much
        DirectedWeightedGraph<String> actors = new DirectedWeightedGraph<>();

        actors.addVertices("Dave Bautista", "Scarlett Johansen", "Sean Connery",
                "Daniel Craig", "Jennifer Lawrence", "Jim Carrey", "Will Smith");

        actors.addEdges(
                new WeightedEdge<>("Dave Bautista", "Scarlett Johansen", 4.0),
                new WeightedEdge<>("Dave Bautista", "Jim Carrey", 5.0),
                new WeightedEdge<>("Dave Bautista", "Daniel Craig", 2.0),
                new WeightedEdge<>("Jennifer Lawrence", "Jim Carrey", 4.0),
                new WeightedEdge<>("Jennifer Lawrence", "Scarlett Johansen", 5.0),
                new WeightedEdge<>("Jennifer Lawrence", "Daniel Craig", 1.0),
                new WeightedEdge<>("Jim Carrey", "Will Smith", 5.0),
                new WeightedEdge<>("Daniel Craig", "Sean Connery", 5.0)
        );

        // create a new directed graph
        DirectedWeightedGraph<String> numbers = new DirectedWeightedGraph<>();
        numbers.addVertices("1", "2", "3", "4", "5");
        numbers.addEdges(
                new WeightedEdge<>("1", "2", 1.0),
                new WeightedEdge<>("2", "3", 1.0),
                new WeightedEdge<>("3", "1", 1.0),
                new WeightedEdge<>("4", "5", 1.0),
                new WeightedEdge<>("5", "1", 1.0),
                new WeightedEdge<>("3", "4", 1.0)
        );
        System.out.println(numbers.dfs("3"));

//        // Test out contains edge - F, T, T, F
//        System.out.println("Should be F: " + actors.containsEdge("Will Smith", "Sean Connery"));
//        System.out.println("Should be T: " + actors.containsEdge("Dave Bautista", "Jim Carrey"));
//        System.out.println("Should be T: " + actors.containsEdge("Dave Bautista", "Daniel Craig"));
//        System.out.println("Should be F: " + actors.containsEdge("Dave Baptista", "Scarlett Johansen"));
//        // get the vertices in the graph
//        System.out.println("Vertices: " + actors.getVertexSet());
//        // get the weighted edges in the graph
//        System.out.println("Edges: " + actors.getEdgeSet());
//
//        System.out.println(actors);
    }
}
