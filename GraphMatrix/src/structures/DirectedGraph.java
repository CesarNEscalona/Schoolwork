package structures;

import graphs.Edge;
import graphs.IGraph;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This class consists of all methods from the iGraph class, this class will have all the
 * code needed to run and pass the GraphTests file.
 *
 * @param <V> the type of vertices in the graph
 * @author Cesar Escalona
 * @version 1.0
 */
public class DirectedGraph<V> implements IGraph<V>
{
    // instance variables
    private static final int DEFAULT_SIZE = 10;
    public static final double RESIZE_RATE = 1.5;
    private int vertexSize = 0;
    private int edgeSize = 0;
    // bijection of vertex type to int
    private final Bijection<V, Integer> bijection = new Bijection<>();
    // stack to hold integers
    private final Stack<Integer> ints = new Stack<>();
    private int[][] matrix;
    private int recycledIndex;
    private int nextUnusedIndex;


    /**
     * The default constructor will generate a new 2d array of default size and
     * will add the first item to the stack of ints
     */
    public DirectedGraph() {
        ints.push(-1);
        matrix = new int[DEFAULT_SIZE][DEFAULT_SIZE];
    }

    /**
     * This parameterized constructor will generate a new 2d array of given size and
     * will add the first item to the stack of ints
     *
     * @param initialSize the number passed in for the size of the initial 2d array
     */
    public DirectedGraph(int initialSize){
        ints.push(-1);
        matrix = new int[initialSize][initialSize];
    }

    @Override
    public boolean addVertex(V vertex)
    {
        // if vertex is a duplicate, don't add
        if(containsVertex(vertex)){
            return false;
        }
        // if the next index is larger than the matrix length, resize
        if(nextUnusedIndex == matrix.length){
            resize();
        }

        // remove the top element in the stack
        recycledIndex = ints.pop();
        // if stack is empty, go in
        if(ints.empty()){
            // increment the index popped, and add it back to the stack
            recycledIndex++;
            ints.push(recycledIndex);
            // add the vertex to the bijection
            bijection.add(vertex, recycledIndex);
            // increase vertex size and next unused index
            nextUnusedIndex++;
            vertexSize++;
        }
        // if the stack is not empty
        else{
            // add the vertex into the next index
            bijection.add(vertex, nextUnusedIndex);
            nextUnusedIndex++;
            vertexSize++;
        }
        return true;
    }

    private void resize() {
        // new size of array
        int resize = (int) (matrix.length * RESIZE_RATE);
        // new 2d array with updated size
        int[][] resized = new int[resize][resize];
        // for loop to copy all data over from initial array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                resized[i][j] = matrix[i][j];
            }
        }
        // replace old 2d with updated 2d
        matrix = resized;
    }

    @Override
    public boolean addEdge(V source, V destination, int weight)
    {
        // if edge already exists and edge is 0 or -1, go in
        if(source.equals(destination) && weight < 1){
            return false;
        }
        // if the key or destination are not in the bijection, return false
        if(!bijection.containsKey(source) || !bijection.containsKey(destination)){
            return false;
        }
        // otherwise, add it to the matrix
        int sourceVal = bijection.getValue(source);
        int destinationVal = bijection.getValue(destination);
        // if edge is not empty, it means we already have another edge there
        if(matrix[sourceVal][destinationVal] != 0){
            return false;
        }
        // if edge is empty and doesn't match the weight, update that edge
        if(matrix[sourceVal][destinationVal] != weight){
            matrix[sourceVal][destinationVal] = weight;
            edgeSize++;
        }
        return true;
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
    public boolean containsVertex(V vertex)
    {
        return bijection.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(V source, V destination)
    {
        // initialize variables
        int sourceVal = 0;
        int destVal = 0;
        // if edge size is 0, there are no edges
        if(edgeSize == 0){
            return false;
        }
        // grab the values
        // if the bijection contains it then assign it,
        // otherwise it will be null, check both keys!!!
        if(bijection.containsKey(source) && bijection.containsKey(destination)){
            sourceVal = bijection.getValue(source);
            destVal = bijection.getValue(destination);
            // i and j values cannot be larger than the matrix size
            if(matrix[sourceVal][destVal] > matrix.length){
                return false;
            }
        }
        // return T or F based on this statement
        return matrix[sourceVal][destVal] > 0;
    }

    @Override
    public int edgeWeight(V source, V destination)
    {
        // get the source and destination values
        int keyValue = bijection.getValue(source);
        int valValue = bijection.getValue(destination);
        // find the edge weight from the matrix
        int weight = matrix[keyValue][valValue];
        // if there is no edge, return 0
        if(weight < 1){
            return 0;
        }
        // return the weight
        return weight;
    }

    @Override
    public Set<V> vertices()
    {
        // create a set of vertices
        Set<V> verticesSet = new HashSet<>();
        // iterate through the bijection keys and add to the vertices set
        for (int i = 0; i < bijection.keySet().size(); i++) {
            verticesSet.add(bijection.getKey(i));
        }
        // return set
        return verticesSet;
    }

    @Override
    public Set<Edge<V>> edges()
    {
        // create a set of edges
        Set<Edge<V>> setOfEdges = new HashSet<>();
        // if the edge size is 0 it means no edges
        if(edgeSize == 0){
            return setOfEdges;
        }
        // iterate through and get the keys of the source and destination
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                if(matrix[i][j] > 0){
                    // save key values
                    V source = bijection.getKey(i);
                    V destination = bijection.getKey(j);
                    // create an edge to add to the set, and grab the weight
                    Edge<V> edge = new Edge<>(source, destination, edgeWeight(source, destination));
                    setOfEdges.add(edge);
                }
            }
        }
        return setOfEdges;
    }

    @Override
    public boolean removeVertex(V vertex)
    {
        // if vertex is not in bijection, return false
        if(!bijection.containsKey(vertex)){
            return false;
        }
        // get the index of the vertex to add back into the stack
        int index = bijection.getValue(vertex);
        ints.push(index);
        // remove the vertex from the bijection
        bijection.removeKey(vertex);
        // decrease vertex size and unused index size
        vertexSize--;
        nextUnusedIndex--;
        return true;
    }

    @Override
    public boolean removeEdge(V source, V destination)
    {
        // initialize values
        int sourceVal;
        int destVal;
        // if bijection doesn't contain source and destination edge, return false
        if(!containsEdge(source, destination)){
            return false;
        }
        // if bijection contains source and destination keys
        if(bijection.containsKey(source) && bijection.containsKey(destination)){
            // assign values
            sourceVal = bijection.getValue(source);
            destVal = bijection.getValue(destination);
            // if the matrix values are both greater than 0, it means the matrix has an edge
            if(sourceVal >= 0 && destVal > 0){
                // set that edge to 0 to disconnect the edge
                matrix[sourceVal][destVal] = 0;
                // remove an edge off the edge size
                edgeSize--;
                // return true as it's removed
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear()
    {
        // clear the bijection, vertex and edge sizes
        bijection.clear();
        vertexSize = 0;
        edgeSize = 0;
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                "vertexSize=" + vertexSize +
                ", edgeSize=" + edgeSize +
                ", bijection=" + bijection +
                ", ints=" + ints +
                ", matrix=" + Arrays.toString(matrix) +
                ", recycledIndex=" + recycledIndex +
                ", nextUnusedIndex=" + nextUnusedIndex +
                '}';
    }
}
