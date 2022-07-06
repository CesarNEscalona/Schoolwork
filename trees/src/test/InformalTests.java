package test;

import trees.BinarySearchTree;
import java.util.List;


public class InformalTests {

    public static void main(String[] args) {
        BinarySearchTree<Integer> treeOfNums = new BinarySearchTree<>();

        treeOfNums.add(24);
        treeOfNums.add(23);
        treeOfNums.add(42);
        treeOfNums.add(80);
        treeOfNums.add(-3);
        treeOfNums.add(13);

        System.out.println(treeOfNums);
        System.out.println(treeOfNums.contains(24)  + " <- Should be true");
        System.out.println(treeOfNums.contains(40)  + " <- Should be false");
        System.out.println();

        // practice using traversal
        List<Integer> Pre = treeOfNums.preOrder();
        System.out.println("Pre Order: ");
        for (int element : Pre){
            System.out.println(element);
        }
        System.out.println();

        List<Integer> Post = treeOfNums.postOrder();
        System.out.println("Post Order: ");
        for (int element : Post){
            System.out.println(element);
        }
        System.out.println();

        List<Integer> inOr = treeOfNums.inOrder();
        System.out.println("In Order: ");
        for (int element : inOr){
            System.out.println(element);
        }

        // we should also have an iterator to use
        System.out.println();
        System.out.println("Iterator inOrder: ");
        for (int element : treeOfNums){
            System.out.println(element);
        }
        System.out.println();

        //BFS traversal
        List<Integer> results = treeOfNums.bfs();
        System.out.println("BFS: ");
        for (int element : results)
        {
            System.out.println(element);
        }



    }
}
