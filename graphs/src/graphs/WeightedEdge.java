package graphs;

public class WeightedEdge<V>
{
    private V source;
    private V destination;
    private double weight;

    public WeightedEdge(V source, V destination, double weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public V getSource()
    {
        return source;
    }

    public V getDestination()
    {
        return destination;
    }

    public double getWeight()
    {
        return weight;
    }

    public String toString()
    {
        return "(" + source + ", " + destination + ", " + weight +")";
    }
}