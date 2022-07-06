/*
   Cesar Escalona
   It-220
   This program will create an interface type
   named SongList
*/

public interface SongList {
   
   // adds a song to the end of the SongList
   public void add(Song song);
   
   // adds a song at a particular index
   public void add(int index, Song song);
   
   // removes a song at a particular index
   public void remove(int index);
   
   // returns the number of songs in the list
   public int size();
   
   // returns the song at a particular index
   public Song get(int index);
   
   // searches and returns the first index of a given song
   public int indexOf(Song song);
   
   // toString
   public String toString();
   
   // returns the total duration of the SongList in seconds
   public int totalDuration();
}