package divide_and_conquer;

public class MergeSort {

    private int[] array;
    private int[] temp; // not an in-place sort

    public MergeSort(int[] array){
        this.array = array;

    }

    public void MergeSort(){
        temp = new int[array.length];
        mergeSort(0, array.length - 1);


    }

    private void mergeSort(int low, int high){
        // checks to see if array still needs to be split, if not, go in
        if(high - low <= 0) {

            if(high - low == 0){
                System.out.println("One element " + array[high]);
            }
            return; // this sub array is sorted.
        }

        // split the indeces and recurse until we get down to 1
        int mid = (high + low) / 2;  // (7 + 0) / 2 = 3
        mergeSort(low, mid); // left sub array
        mergeSort(mid + 1, high); // right sub array
        merge(low, high);
    }

    // this is where all the work happens
    private void merge(int low, int high) {
        int mid = (high + low) / 2;
        int left = low;
        int right = mid + 1;
        int numToMerge = high - low + 1;

        // merge the elements into the temp array
        for (int i = 0; i < numToMerge; i++) {
            // first check if we have exhausted either sub-array
            if(left > mid) {
                temp[i] = array[right++];
            }
            else if(right > high){
                temp[i] = array[left++];
            }
            // otherwise compare each sub-array element
            else if(array[left] <= array[right]){
                temp[i] = array[left++];
            }
            else if(array[right] < array[left]) {
                temp[i] = array[right++];
            }
        }

        // move the elements back into the original array
        for (int i = 0; i < numToMerge; i++) {
            array[low + i] = temp[i];
        }

    }
}
