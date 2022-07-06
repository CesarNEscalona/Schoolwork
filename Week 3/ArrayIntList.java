
public class ArrayIntList {
   // constant
   public static final int DEFAULT_CAPACITY = 100;

   // fields
   private int[] elementData;    // plain old Java array
   private int size;             // number of "slots used"
   
   // methods
   
   // constructor
   public ArrayIntList() {
      elementData = new int[100];   // capacity of 100 items
       size = 0;                     // number of the 100 that are used

      // this(DEFAULT_CAPACITY);      
   }
   
   public ArrayIntList(int capacity) {
      elementData = new int[capacity];
      size = 0;
   }
   
   public void add(int value) {
      elementData[size] = value;
      size++;
   }
   
   // shift items right, and then put value into elementData at index
   public void add(int index, int value) {
   
      // shift all the values to the right
      for (int i = size; i >= index + 1; i--) {
         elementData[i] = elementData[i - 1];
      }
      
      // put the value at index
      elementData[index] = value;
      
      // bump the size up
      size++;
   }
   
   // return number of elements used
   public int size() {
      return size;
   }
   
   // given some index, it will get the value at that position
   // and return it
   public int get(int index) {
      return elementData[index];
   }
   
   // return the first index where the value occurs
   // or returns -1 if the value does not exist
   public int indexOf(int value) {
      for (int i = 0; i < size; i++) {
         if (elementData[i] == value) {
            return i;
         }
      }
      // when we get here outside the loop, it means we didn't find it
      return -1;
   }
   
   // when provided an index, remove the value, slide everything left
   public void remove(int index) {
      
      // shift values over to the left
      for (int i = index; i < size - 1; i++) {
         elementData[i] = elementData[i + 1];
      }
      
      // reduce size by 1
      size--;
   }
   
   
   @Override
   public String toString() {
      if (size == 0) {
         return "[]";
      }
      else {
         String result = "[";
         
         // join in the 0th value
         result += elementData[0];
         
         // loop from 1st value to print comma then value
         for (int i = 1; i < size; i++) {
            result += ", " + elementData[i];
         }
         
         result += "]";
         return result;
      }
   }

}