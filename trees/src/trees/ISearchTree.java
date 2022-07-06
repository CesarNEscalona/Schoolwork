package trees;

import java.util.List;

public interface ISearchTree<T extends Comparable<T>> extends Iterable<T>
{
    //basic methods for inserting and searching
    boolean add(T element);
    boolean contains(T element);
    boolean remove(T element);
    int size();
    boolean isEmpty();
    void clear();

    //other (interesting) methods
    T min();
    T max();
    ISearchTree<T> prune(T newRoot);
    int treeHeight();
    void invert(); //insert meme here...

    //traversal methods
    List<T> inOrder();
    List<T> preOrder();
    List<T> postOrder();
    List<T> bfs();
}