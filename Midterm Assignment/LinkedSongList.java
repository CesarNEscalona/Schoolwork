/*
   Cesar Escalona
   It-220
   This program will create a linked song list that implements
   the SongList interface.
*/

public class LinkedSongList implements SongList {
   
   private SongListNode front;
   private int totalDuration;
   
   public LinkedSongList() {
      front = null;
   } // end of constructor
   
   public void add(Song song) {
      if (front == null) {
         // if the list is empty (has no nodes)
         front = new SongListNode(song, null);
      }
      else {
         SongListNode current = front;
         
         while (current.next != null) {
            current = current.next;
         }
         current.next = new SongListNode(song, null);
      }
   } // end of add method
   
   public void add(int index, Song song) {
      if (index == 0) {
         front = new SongListNode(song, front);
      }
      else {
         SongListNode current = front;
         
         for (int i = 0; i < index - 1; i++) {
            current = current.next;
         }
         current.next = new SongListNode(song, current.next);
      }  
   } // end of add
   
   public void remove(int index) {
      if (index == 0) {
         front = front.next;
      }
      else {
         SongListNode current = front;
         for (int i = 0; i < index - 1; i++) {
            current = current.next;
         }
         current.next = current.next.next;
      } 
   } // end of remove
   
   public int size() {
      int count = 0;
      SongListNode current = front;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;   
   } // end of size
   
   public Song get(int index) {
      SongListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current.data;
   } // end of get
   
   public int indexOf(Song song) {
      int index = 0;
      SongListNode current = front;
      
      while(current != null) {
         if(current.data.equals(song)) {
            return index;
         }
         index++;
         current = current.next;
      }
      return -1;
   } // end of indexOf
   
   public String toString() {
      if (front == null) {
         return "[]";
      }
      else {
         String result = "[";
         result += front.data;
         SongListNode current = front.next;
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
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
      
      SongListNode current = front;
      
      while(current != null) {
         total += current.data.getDuration();
         current = current.next;
         hours = total / 3600; 
         minutes = total / 60 - hours * 60; 
         seconds = total - hours * 3600 - minutes * 60;
      }
      return total;
   } // end of totalDuration
} // end of Class