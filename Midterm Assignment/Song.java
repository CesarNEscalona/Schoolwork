/*
   Cesar Escalona
   It-220
   This program will create a Song class
*/

public class Song {
   private String name;
   private String artist;
   private int duration;
      
      // constructor
   public Song(String name, String artist, int duration) {
      this.name = name;
      this.artist = artist;
      this.duration = duration;
   }
      
      // returns the song's name
   public String getName() {
      return name;
   }
      
      // returns the songs artist
   public String getArtist() {
      return artist;
   }
      
      // returns the duration of the song in seconds
   public int getDuration() {
      return duration;   // return in seconds
   }
      
      // toString method
   @Override
      public String toString()  {
      return  name + " by " + artist + ", its duration is " + duration + " seconds long";
   }
      
      // equals method
   @Override
      public boolean equals(Object obj) { 
          // check the type to make sure its a song
      if (obj instanceof Song) {
          // create a temporary song variable
         Song other = (Song)obj;
         if(this.artist.equals (other.artist) && this.name.equals(other.name) && this.duration == other.duration) {
            return true;
         } 
      }
      return false;
   }// end of equals
} // end of Class