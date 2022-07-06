/*
   Cesar Escalona
   It-220
   This program will create a class that has public fields and public constructor methods
*/

public class SongListNode {
   public Song data;
   public SongListNode next;
   
   public SongListNode(Song data, SongListNode next) {
      this.data = data;
      this.next = next;
   }
   
   public SongListNode(Song data) {
      this(data, null);
   }
   
   public SongListNode() {
      this(null, null);
   }
}