package trees;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> implements ISearchTree<T>
{
    //fields
    private Node root;
    private int size;
    private int modCount;

    //constructor(s)
    public BinarySearchTree()
    {
        //do nothing...
    }

    //methods

    @Override
    public boolean add(T element)
    {
        //is the tree empty?
        if (root == null)
        {
            root = new Node(element, null, null);
            size++;
            modCount++;
            return true;
        }
        else //not empty?
        {
            //recursively move down the tree and try to add the new element
            int oldSize = size; //save it!
            root = add(root, element);
            return oldSize != size;
        }
    }

    private Node add(Node current, T element)
    {
        //is this a null reference? then we found a spot for the element
        if (current == null)
        {
            size++;
            modCount++;
            return new Node(element, null, null);
        }

        int comparison = current.data.compareTo(element);
        if (comparison > 0)
        {
            current.left = add(current.left, element);
        }
        //otherwise search to the right
        else if (comparison < 0)
        {
            current.right = add(current.right, element);
        }

        //return current if there is a duplicate, or otherwise
        return current;
    }

    @Override
    public boolean contains(T element)
    {

        return contains(root, element);
    }

    private boolean contains(Node current, T element)
    {
        if (current == null)
        {
            return false;
        }

        int comparison = current.data.compareTo(element);
        if (comparison == 0)
        {
            return true;
        }
        else if (comparison > 0)
        {
            return contains(current.left, element);
        }
        //otherwise search to the right
        else
        {
            return contains(current.right, element);
        }
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean remove(T element)
    {
        return false;
    }

    @Override
    public void clear()
    {
        root = null;
        size = 0;
        modCount++;
    }

    @Override
    public T min()
    {
        return min(root);
    }
    private T min(Node current)
    {
        if (current == null)
        {
            return null;
        }
        else if (current.left == null)
        {
            return current.data;
        }
        return min(current.left);
    }

    @Override
    public T max()
    {
        return max(root);
    }
    private T max(Node current)
    {
        if (current == null)
        {
            return null;
        }
        else if (current.right == null)
        {
            return current.data;
        }
        return max(current.right);
    }

    @Override
    public ISearchTree<T> prune(T newRoot)
    {
        return null;
    }

    @Override
    public int treeHeight()
    {
        return 0;
    }

    @Override
    public void invert()
    {

    }

    @Override
    public List<T> preOrder() {
        List<T> traversal = new ArrayList<>();
        preOrder(root, traversal);

        return traversal;
    }
    private void preOrder(Node current, List<T> traversal) {
        if (current != null) {
            // NLR - node left right
            traversal.add(current.data);
            preOrder(current.left, traversal);
            preOrder(current.right, traversal);
        }
    }

    @Override
    public List<T> postOrder() {
        List<T> traversal = new ArrayList<>();
        postOrder(root, traversal);
        return traversal;
    }
    private void postOrder(Node current, List<T> traversal) {
        if (current != null) {
            // LRN - left right node
            preOrder(current.left, traversal);
            preOrder(current.right, traversal);
            traversal.add(current.data);
        }
    }

    @Override
    public List<T> inOrder() {
        List<T> traversal = new ArrayList<>();
        inOrder(root, traversal);
        return traversal;
    }
    private void inOrder(Node current, List<T> traversal) {
        if (current != null) {
            // LNR - left node right
            inOrder(current.left, traversal);
            traversal.add(current.data);
            inOrder(current.right, traversal);
        }
    }

    // create a method that will place items in a queue to display breadth first alg
    @Override
    public List<T> bfs()
    {
        // create an array list
        List<T> results = new ArrayList<>();
        // create a new node
        Queue<Node> queue = new LinkedList<>();
        // add the root to the queue
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node next = queue.remove();
            results.add(next.data);

            if (next.left != null) queue.add(next.left);
            if (next.right != null) queue.add(next.right);
        }
        return results;
    }

    @Override
    public Iterator<T> iterator() {
        return new NaiveTreeIterator();
    }

    //nested classes
    private class NaiveTreeIterator implements Iterator<T> {
        private List<T> traversal;

        // this is the index of the next element to return
        private int nextElement;

        public NaiveTreeIterator(){
            traversal = inOrder();
        }

        @Override
        public boolean hasNext() {
            return nextElement < traversal.size();
        }

        @Override
        public T next() {
            return traversal.get(nextElement++);
        }
    }

    private class Node
    {
        private T data;
        private Node left;
        private Node right;

        public Node(T data, Node left, Node right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString()
        {
            String leftChild = left == null ? "null" : left.data.toString();
            String rightChild = right == null ? "null" : right.data.toString();

            return leftChild + " <-- " + data.toString() + " --> " + rightChild;
        }
    }
}