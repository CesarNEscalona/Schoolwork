package priority_queue;

public class MaxBinaryHeap<T extends Comparable<T>> implements IPriorityQueue<T>{

    public static final int INITIAL_HEAP_SIZE = 10;
    public static final int RESIZE_RATE = 2;
    private T[] heap;
    private int nextUnusedIndex = 1;

    public MaxBinaryHeap(){
        heap = (T[]) new Comparable[INITIAL_HEAP_SIZE];
    }

   public MaxBinaryHeap(T...inputElements){
        // create a heap array large enough for the inputs
        heap = (T[]) new Comparable[inputElements.length + 1];

        // copy elements over to the heap array
       for (int i = 0; i < inputElements.length; i++) {
           heap[i + 1] = inputElements[i];
       }

       // perform a build heap
       nextUnusedIndex = inputElements.length;
       int size = size();
       for (int i = size / 2; i <= 1 ; i--) {
           sink(i);
       }
   }

    @Override
    public void add(T element) {
        // what if we have no room for the new element
        if(nextUnusedIndex == heap.length){
            resize();
        }

        heap[nextUnusedIndex] = element;
        swim(nextUnusedIndex);
        nextUnusedIndex++;
    }

    @Override
    public void add(T... elements) {
        for (T element: elements) {
            add(element);
        }
    }

    private void swim(int currentIndex) {
        // loop as long as we have a parent index
        while(currentIndex > 1){
            int parentIndex = currentIndex / 2;

            if(heap[currentIndex].compareTo(heap[parentIndex]) > 0 ){
                // swap them
                swap(parentIndex, currentIndex);
            }
            else {
                break; // short circuit, the heap is ordered!
            }

            // move the current index to the parent index
            currentIndex = parentIndex;
        }
    }

    private void swap(int first, int second) {
        // swap the elements at the input indices in the heap array
        T temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private void resize() {
        // Copy all elements over to a new array at the same index for each element
        T[] oldHeap = heap;
        heap = (T[]) new Comparable[oldHeap.length * RESIZE_RATE];

        for (int i = 0; i < oldHeap.length; i++) {
            heap[i] = oldHeap[i];
        }
    }

    @Override
    public T remove() {
        // pre conditions?
        if(isEmpty()){
            return null;
        }

        // save my result
        T largest = heap[1];

        // remove the last node and reorder the heap
        int highestUsedIndex = nextUnusedIndex - 1;
        heap[1] = heap[highestUsedIndex];
        heap[highestUsedIndex] = null;
        nextUnusedIndex--;

        // re order the heap
        sink(1);




        return largest;
    }

    private void sink(int currentIndex) {
        // loop while the current index has a child
        int size = size();
        while (currentIndex <= size / 2){
            int leftIndex = currentIndex * 2;
            int rightIndex = (currentIndex * 2) + 1;

            // find the biggest child ( *2 and *2+1)
            int largestChildIndex = leftIndex;

            // is the right index valid? and is the element at right child smaller
            if(rightIndex < nextUnusedIndex && heap[leftIndex].compareTo(heap[rightIndex]) < 0 ){
                largestChildIndex = rightIndex;
            }

            // if out of order, then swap them
            if(heap[currentIndex].compareTo(heap[largestChildIndex]) < 0){
                // swap and move to the largest child index
                swap(currentIndex, largestChildIndex);
                currentIndex = largestChildIndex;
            }
            else {
                break;
            }
        }



        // check which element is larger


        // swap and re set that index

    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return nextUnusedIndex - 1;
    }

    @Override
    public boolean isEmpty() {
        return nextUnusedIndex == 1;
    }

    @Override
    public void clear() {

    }
}
