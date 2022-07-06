/*
   Cesar Escalona
   It-220
   This class will implement the SongList interface and will include
   method bodies for all of the methods in the SongList interface
*/

public class ArraySongList implements SongList {
   
   private Song[] elementData;
   private int size;
   private int totalDuration;
   
   public ArraySongList() {
      elementData = new Song[100];
      size = 0;
   } // end of constructor
   
   public void add(Song song) {
      elementData[size] = song;
      size++;
   } // end of add method
   
   public void add(int index, Song song) {
      for (int i = size; i >= index + 1; i--) {
         elementData[i] = elementData[i - 1];
      }
      elementData[index] = song;
      size++;
   } // end of add
   
   public void remove(int index) {
      for (int i = index; i < size - 1; i++) {
         elementData[i] = elementData[i + 1];
      }
      size--;
   } // end of remove
   
   public int size() {
      return size;
   } // end of size
   
   public Song get(int index) {
      return elementData[index];
   } // end of get
   
   public int indexOf(Song song) {
      for (int i = 0; i < size; i++) {
         if (elementData[i].equals(song)) {
            return i;
         }
      }
      return -1;
   } // end of indexOf
   
   public String toString() {
      if (size == 0) {
         return "[]";
      }
      else {
         String result = "[";
         result += elementData[0];
         for (int i = 1; i < size; i++) {
            result += ", " + elementData[i];
         }
         result += "]";
         return result;
      }
   } // end of toString
   
   public int totalDuration() {
      int total = 0;
      int seconds = 0;
      int minutes = 0;
      int hours = 0;
      
      for(int i = 0; i < size; i++) {
         total += elementData[i].getDuration();
         hours = total / 3600; 
         minutes = total / 60 - hours * 60; 
         seconds = total - hours * 3600 - minutes * 60;
      }
      return total;
   } // end of totalDuration
} //end of Class