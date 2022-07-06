package bst;

import baby_names.BabyNames;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Stack;


/**
 * Represents a tree class that implements the
 * INamesTree class. This class should contain all of the methods
 * from that interface.
 *
 * @author Cesar Escalona
 * @version 1.0
 */
public class BabyNamesTree implements INamesTree {
    // private instance fields
    private Node root;
    private int size;
    private int treeHeight;
    private int modCount;


    /**
     * Default Constructor for BabyNamesTree class
     * No params, constructor doesn't return anything
     */
    // Constructor
    public BabyNamesTree() {
        // do nothing...
    }

    /**
     * Adds a new BabyNames object to the tree.
     *
     * @param element a BabyNames object to add to the tree
     * @return true if name and year of the BabyNames object is unique to the tree, or false otherwise
     */
    @Override
    public boolean add(BabyNames element) {
        // save the old size to return boolean
        int oldSize = size;
        // is the tree empty?
        if (root == null) {
            // create a new node if no root
            root = new Node(element, null, null);
            // update size
            size++;
            // if a mod has been made, update
            modCount++;
            return true;
        } else {  // not empty
            // recursively move down the tree and try to add the new element
            root = add(root, element, 0, 0);
            // check if size changes, if it does then its true
            return oldSize != size;
        }
    }

    // Private add recursive method
    private Node add(Node current, BabyNames element, int heightSum, int depthSum) {
        treeHeight = heightSum;
        //is this a null reference? then we found a spot for the element
        if (current == null) {
            size++;
            modCount++;
            // create a new node
            Node test2 = new Node(element, null, null);
            // update the depth of the new node with info from below
            test2.depth = depthSum;
            return test2;
        }
        int comparison = current.data.compareTo(element);
        if (comparison > 0) {
            // You must assign the value back to each reference encountered
            current.left = add(current.left, element, heightSum + 1, depthSum + 1);
        }
        //otherwise search to the right
        else if (comparison < 0) {
            // You must assign the value back to each reference encountered
            current.right = add(current.right, element, heightSum + 1, depthSum + 1);
        }
        if (comparison != 0) {
            // if node is not a dup and child node is not null, if the same height is
            // there then increment
            if (current.left != null && current.left.height == current.height) {
                current.height++;
            } else if (current.right != null && current.right.height == current.height) {
                current.height++;
            }
        }
        //return current if there is a duplicate, or otherwise
        return current;
    }

    /**
     * Adds several BabyNames object to the tree.
     *
     * @param elements a group of BabyNames objects
     * @return true if all BabyNames are added to the tree, without encountering any duplicates, or false otherwise
     */
    @Override
    public boolean add(BabyNames... elements) {
        int oldSize = size;
        // loop through the elements and add them into the tree as it goes through
        for (BabyNames element : elements) {
            add(element);
        }
        return oldSize != size;
    }

    /**
     * Returns true if the BabyNames object is found in the tree. Two BabyNames should be considered equal if
     * the name and year of the BabyNames objects are equal.
     *
     * @param element the element to search for
     * @return true if the input element is found, or false otherwise
     */
    @Override
    public boolean contains(BabyNames element) {
        if (size == 0) {
            return false;
        }
        return contains(root, element);
    }

    // Private contains recursive method
    private boolean contains(Node current, BabyNames element) {
        if (current == null) {
            return false;
        }
        int comparison = current.data.compareTo(element);
        if (comparison == 0) {
            return true;
        } else if (comparison > 0) {
            return contains(current.left, element);
        } else {
            return contains(current.right, element);
        }
    }

    /**
     * Searches for the BabyNames object in the tree with the given name.
     *
     * @param name a name to search for
     * @return a BabyNames object that matches the search value, or null if no BabyNames object is found with a
     * matching name
     */
    @Override
    // similar to contains, go down the tree, each node has a baby names obj
    // each baby name obj has a name field inside.
    public BabyNames get(String name) {
        if (size == 0) {
            return null;
        }
        return get(root, name);
    }

    // private get recursive method
    private BabyNames get(Node current, String name) {
        if (current == null) {
            return null;
        }
        int comparison = current.data.getName().compareTo(name);
        if (comparison == 0) {
            return current.data;
        } else if (comparison > 0) {
            return get(current.left, name);
        } else {
            return get(current.right, name);
        }
    }

    /**
     * Returns the number of elements in the tree.
     *
     * @return the number of elements in the tree
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Reports whether the tree is empty or not.
     *
     * @return true if the tree is empty, or false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes all BabyNames objects from the tree.
     */
    @Override
    public void clear() {
        root = null;
        size = 0;
        modCount++;
    }

    /**
     * Reports the height of the root node in the tree.
     *
     * @return the height of the root node in the tree, or -1 if the tree is empty
     */
    @Override
    public int treeHeight() {
        if (root == null) {
            return -1;
        }
        // returns tree height
        return nodeHeight(root.data);
    }

    /**
     * Reports the height of the Node that contains the input element.
     *
     * @param element the element to search for
     * @return the height of the Node containing the input parameter, or -1 if not found
     */
    @Override
    public int nodeHeight(BabyNames element) {
        if (size == 0) {
            return -1;
        } else {
            Node testH = nodeHeight(root, element);
            if (testH == null) {
                return -1;
            } else {
                return testH.height;
            }
        }
    }

    // private nodeHeight recursive method
    private Node nodeHeight(Node current, BabyNames element) {
        if (size == 0) {
            return null;
        }
        int comparison = current.data.compareTo(element);
        //search for a duplicate
        if (comparison == 0) {
            return current;
        }
        //search to the left
        else if (comparison > 0) {
            return nodeDepth(current.left, element);
        }
        //search to the right
        else {
            return nodeDepth(current.right, element);
        }
    }

    /**
     * Reports the depth of the Node that contains the input element.
     *
     * @param element the element to search for
     * @return the depth of the Node containing the input parameter, or -1 if not found
     */
    @Override
    public int nodeDepth(BabyNames element) {
        if (size == 0) {
            return -1;
        } else {
            Node test1 = nodeDepth(root, element);
            if (test1 == null) {
                return -1;
            } else {
                return test1.depth;
            }
        }
    }

    // private depth recursive method
    private Node nodeDepth(Node current, BabyNames element) {
        //if a null reference is found, insert element into spot
        if (current == null) {
            return null;
        }

        int comparison = current.data.compareTo(element);
        //search for a duplicate
        if (comparison == 0) {
            return current;
        }
        //search to the left
        else if (comparison > 0) {
            return nodeDepth(current.left, element);
        }
        //search to the right
        else {
            return nodeDepth(current.right, element);
        }
    }

    @Override
    public Iterator<BabyNames> iterator() {
        return new BabyNamesTreeIterator();
    }


    // nested classes
    private class BabyNamesTreeIterator implements Iterator<BabyNames> {
        // create a stack of Node obj
        private Stack<Node> nodeStack = new Stack<>();
        private int savedModCount = modCount;

        // Iterator Constructor
        public BabyNamesTreeIterator() {
            Node current = root;
            // traverse from the root to the smallest element
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
        }

        private void checkChanges() {
            if (savedModCount != modCount) {
                throw new ConcurrentModificationException("You can't edit while iterating");
            }
        }

        @Override
        public boolean hasNext() {
            // check for changes
            checkChanges();
            return !nodeStack.isEmpty();
        }

        @Override
        public BabyNames next() {
            // check for changes
            checkChanges();
            // whenever the next method is called,
            // pop the next element in the stack
            Node current = nodeStack.pop();

            //save the BabyNames object to return
            BabyNames first = current.data;
            // if the node has a right child
            if (current.right != null) {
                // add the right child to the stack
                nodeStack.push(current.right);
                current = current.right;
                // from the right child, follow any left references to the smallest element
                while (current.left != null) {
                    // add the node to the stack
                    nodeStack.push(current.left);
                    current = current.left;
                }
            }
            return first;
        }

        @Override
        public String toString() {
            return "BabyNamesTreeIterator{" +
                    "nodeStack=" + nodeStack +
                    '}';
        }
    }

    // added static class
    private static class Node {
        private BabyNames data;
        private Node left;
        private Node right;
        private int height;
        private int depth;

        public Node(BabyNames data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            String leftChild = left == null ? "null" : left.data.toString();
            String rightChild = right == null ? "null" : right.data.toString();

            return leftChild + " <-- " + data.toString() + " --> " + rightChild;
        }
    }

    @Override
    public String toString() {
        return "BabyNamesTree{" +
                "root=" + root +
                ", size=" + size +
                ", treeHeight=" + treeHeight +
                ", modCount=" + modCount +
                '}';
    }
}
