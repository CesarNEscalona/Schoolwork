package test;

import priority_queue.MaxBinaryHeap;

public class QueueDriver {
    public static void main(String[] args) {
        MaxBinaryHeap<Integer> heapOfInts = new MaxBinaryHeap<>();
        System.out.println(heapOfInts);
        heapOfInts.add(6, 13, 28, 11, 19, -4, 999, 11, 42, 15, 11, 27);
        System.out.println("Size " + heapOfInts.size());

        while (!heapOfInts.isEmpty()){
            System.out.println(heapOfInts.remove());
        }

        MaxBinaryHeap<Double> heapOfDoubles = new MaxBinaryHeap<>(2.2, 18.5, 4.7, 24.9, 3.14, 4.2);
        System.out.println(heapOfDoubles);
    }

}
