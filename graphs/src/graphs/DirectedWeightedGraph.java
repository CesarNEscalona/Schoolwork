package graphs;

import java.util.*;

/**
 * This class will contain all the methods from the directed weighted interface. This class will be responsible
 * for making changes and displaying data from the passed in hashmap.
 *
 * @param <V> The generic type of data that the directed weighted graph will consist of
 * @author Cesar Escalona
 * @version 1.0
 */
public class DirectedWeightedGraph<V> implements IDirectedWeightedGraph<V>
{
    // instance variables
    private int vertexSize;
    private int edgeSize;
    private V source;
    private Node<V> destination;
    private double weight;

    //adjacency lists
    private Map<V, Node<V>> adjLists = new HashMap<>();

    @Override
    public boolean addVertex(V vertex)
    {
        //preconditions?
        if (containsVertex(vertex))
        {
            return false; //a duplicate vertex!
        }

        //put the vertex in the graph
        adjLists.put(vertex, null);
        vertexSize++;
        return true;
    }

    @Override
    public boolean addEdge(WeightedEdge<V> edge)
    {
        //preconditions?
        if (!containsVertex(edge.getSource()) ||
                !containsVertex(edge.getDestination()))
        {
            return false;
        }
        else if (containsEdge(edge.getSource(), edge.getDestination()))
        {
            return false;
        }

        //otherwise add the edge
        Node<V> list = adjLists.get(edge.getSource());
        if (list == null)
        {
            //first incident edge
            adjLists.put(edge.getSource(), new Node<>(edge.getDestination(),
                    null, edge.getWeight()));
        }
        else
        {
            //add a new node at the front of the list
            Node<V> head = new Node<>(edge.getDestination(),
                    list, edge.getWeight());
            adjLists.put(edge.getSource(), head);
        }
        edgeSize++;
        return true;
    }

    // this method will try to add all the input vertices
    // this method will return true if all vertices are added successfully
    @Override
    public boolean addVertices(V... vertices)
    {
        boolean allSuccessful = true;
        // how to check if all are true
        // for each vertex in vertices given
        for (V vertex : vertices)
        {
            // return true if they got added, otherwise return false
            allSuccessful = allSuccessful && addVertex(vertex);
        }
        // return true or false
        return allSuccessful;
    }

    @Override
    public boolean addEdges(WeightedEdge<V>... edges)
    {
        // boolean flag
        boolean allSuccessful = true;
        // check each edge from all edged provided
        for (WeightedEdge<V> edge : edges)
        {
            // if the edge is added, return true, otherwise false
            allSuccessful = allSuccessful && addEdge(edge);
        }
        // return T or F
        return allSuccessful;
    }

    @Override
    public boolean removeVertex(V vertex)
    {
        return false;
    }

    // wait for last
    @Override
    public boolean removeEdge(V source, V destination)
    {
        return false;
    }

    @Override
    public Set<V> getVertexSet()
    {
        return adjLists.keySet();
    }

    @Override
    public Set<WeightedEdge<V>> getEdgeSet()
    {
        // create a set of weighted edges
        Set<WeightedEdge<V>> set = new HashSet<>();
        // iterate through the entry set, key & value
        for (Map.Entry<V, Node<V>> key: adjLists.entrySet()
             ) {
            // get the source key
            source = key.getKey();
            // check if there's a key value pair aka "edge"
            if(key.getValue() != null){
                // set the destination to the second vertex
                destination = key.getValue();
                // get the weight to add as a 3rd param to the weighted set
                weight = destination.weight;
                // add the weighted edge to our set
                set.add(new WeightedEdge<>(source, (V) destination, weight));
                // check every edge connected to that source
                while(destination.next != null){
                    // replace the second vertex with the next link
                    destination = destination.next;
                    // take the updated next link's weight
                    weight = destination.weight;
                    // add that to our set
                    WeightedEdge<V> edge = new WeightedEdge<>(source, (V) destination, weight);
                    set.add(edge);
                }
            }
        }
        // return our set
        return set;
    }

    @Override
    public boolean containsVertex(V vertex)
    {
        return adjLists.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(V source, V destination)
    {
        // if it doesn't contain the key, return false
        if(!adjLists.containsKey(source)){
            return false;
        }
        else {
            // set the source as a temp node
            Node<V> temp = adjLists.get(source);
            // hand the source to the map using get
            // while temp is not null
            while (temp != null){
                // check if temp.data = destination passed
                if(temp.data.equals(destination)){
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    @Override
    public int vertexSize()
    {
        return vertexSize;
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    @Override
    public List<V> dfs(V sourceVertex) {
        if(!containsVertex(sourceVertex)){
            return new ArrayList<>();
        }

        Set<V> visited = new HashSet<>();
        List<V> traversal = new ArrayList<>();

        // recursively search through the graph
        dfs(sourceVertex, visited, traversal);

        return traversal;
    }

    private void dfs(V currentVertex, Set<V> visited, List<V> traversal) {
        if(visited.contains((currentVertex))){
            return; // exit!
        }

        // otherwise visit the current vertex as part of the traversal
        traversal.add(currentVertex);
        visited.add(currentVertex);

        // move to adjacent vertices in the graph and continue the traversal
        Node<V> neighborList = adjLists.get(currentVertex);
        while(neighborList != null){
            // visit the neighbor
            dfs(neighborList.data, visited, traversal);
            // move to the next neighbor
            neighborList = neighborList.next;
        }
    }

    @Override
    public List<V> bfs(V sourceVertex) {
        List<V> traversal = new ArrayList<>();
        Queue<V> bfsQueue = new LinkedList<>();
        Set<V> visited = new HashSet<>();

        // preconditions
        if(!containsVertex(sourceVertex)){
            return traversal;
        }

        // perform the traversal
        bfsQueue.add(sourceVertex);

        while(!bfsQueue.isEmpty()){
            // take off the next element, visit it and add neighbors back to the queue
            V next = bfsQueue.remove();
            if(!visited.contains(next)){
                traversal.add(next);
                visited.add(next);

                Node<V> neighborList = adjLists.get(next);
                while(neighborList != null){
                    // visit the neighbor
                    bfsQueue.add(neighborList.data);
                    // move to the next neighbor
                    neighborList = neighborList.next;
                }
            }
        }
        return traversal;
    }

    private static class Node<V>
    {
        private V data;
        private Node<V> next;
        private double weight;

        public Node(V data, Node<V> next, double weight)
        {
            this.data = data;
            this.next = next;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    @Override
    public String toString() {
        return "|Vertices| = " + vertexSize() + ", |Edges| = " + edgeSize();
    }
}