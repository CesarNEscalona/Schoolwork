/*
   Cesar Escalona
   It-220
   This program will test out my SongList
   implementations by creating playlists and displaying them.
*/


public class PlaylistManager {

   public static void main(String[] args) {
      System.out.println("Welcome to my PlaylistManager!");
            
      // Enter song info, Enter time in seconds
      Song Opus = new Song("Opus","Eric Prydz", 542);
      Song Roses = new Song("Roses","Imanbek", 256);
      Song makeItToHeaven = new Song("Make it to Heaven","RAYE", 151);
      Song iGotLove = new Song("I Got Love","Don Diablo", 143);
      Song Faded = new Song("Faded-Instrumental","Alan Walker", 200);
      
      
      Song Toxicity = new Song("Toxicity","System Of a Down", 203);
      Song Forest = new Song("Forest","System Of a Down", 240);
      Song chopSuey = new Song("Chop Suey!","System Of a Down", 198);
      Song suitePee = new Song("Suite-Pee","System Of a Down", 139);
      Song memoryRemains = new Song("The Memory Remains", "Metallica", 263);
      
      
      // Create an ArraySongList called workout that includes rock songs
      ArraySongList rockoutPlaylist = new ArraySongList();
      rockoutPlaylist.add(Forest);
      rockoutPlaylist.add(memoryRemains);
      
      // Test the add method
      rockoutPlaylist.add(Toxicity);
      System.out.println(rockoutPlaylist);
      
      // Test the add(int Song) method
      rockoutPlaylist.add(0, chopSuey);
      System.out.println(rockoutPlaylist);
      
      // Test the add(int, Song) method
      rockoutPlaylist.add(1, suitePee);
      System.out.println(rockoutPlaylist);
      
      // Test the remove method
      rockoutPlaylist.remove(1);
      System.out.println(rockoutPlaylist);
      
      // Test the size() method.
      System.out.println("This RockOut Playlist has " + rockoutPlaylist.size() + " songs.");
      
      // Test the get() method
      System.out.println("The name of the song at index 2 is " + rockoutPlaylist.get(2) +" .");  // Should be The memory remains
      
      // Test the indexOf method
      // int theIndex = workout.indexOf(chopSuey);
      System.out.println("The song Chop Suey! has an index of " +rockoutPlaylist.indexOf(chopSuey) + " in the list."); // Should be 0
      
      // Test out toString
      System.out.println(rockoutPlaylist.toString());
      
      // Check the totalDuration method
      int rockLength = rockoutPlaylist.totalDuration();
      System.out.println("The total time for the Rockout playlist is " +totalTime(rockLength));
      System.out.println("");
      
      
      // create a linked song list with good beats
      LinkedSongList beats = new LinkedSongList();
      beats.add(Faded);
      beats.add(Opus);
      beats.add(Roses);
      
      // Test the add() method and check to see if it worked
      beats.add(makeItToHeaven);
      System.out.println(beats);
      
      // Test the add(int Song) method and check to see if it worked
      beats.add(0, iGotLove);
      System.out.println(beats);
      
      // Test the remove() method and check to see if it worked
      beats.remove(0);
      System.out.println(beats);
      
      // Test the add(int Song) method and check to see if it worked
      beats.add(3, iGotLove);
      System.out.println(beats);
      
      // Test the size() method
      System.out.println("There are "+ beats.size() + " songs in this Beats playlist");
      
      // Test the get() method
      System.out.println("The song at Index 2 is " + beats.get(2));
      
      // Test the indexOf() method
      System.out.println("The song Faded has an index of " + beats.indexOf(Faded) + " in the list.");
      
      // Test the toString() method
      System.out.println(beats.toString());
      
      // Test the totalDuration() method
      int beatsLength = beats.totalDuration();
      System.out.println("The total time for the Beats playlist is " +totalTime(beatsLength));
      System.out.println("");
      
      
      
      // Create an empty list, add songs then remove them.
      LinkedSongList empty = new LinkedSongList();
      System.out.println(empty.toString());
      empty.add(suitePee);
      empty.add(Forest);
      System.out.println(empty.toString());
      empty.add(1, Toxicity);
      System.out.println(empty.toString());
      empty.remove(0);
      System.out.println(empty.toString());
      empty.remove(0);
      System.out.println(empty.toString());
      empty.remove(0);
      System.out.println(empty.toString());
      System.out.println("The song Toxicity has an index of " + empty.indexOf(Toxicity) + " in the list.");  // should be -1 if not in the list
      System.out.println("There are " + empty.size() + " songs in this list."); 
      int emptyLength = empty.totalDuration();
      System.out.println("The total time for the Empty playlist is " +totalTime(emptyLength));
   }
   
   // Create total time method that takes in total seconds and converts to hours mins and secs.
   public static String totalTime(int seconds) {
      int hours = 0;
      int minutes = 0;
      int secs = 0;
   
      hours = seconds / 3600; 
      minutes = seconds / 60 - hours * 60; 
      secs = seconds - hours * 3600 - minutes * 60;
         
      String result = hours + " Hours, " +minutes+ " Minutes, and " + secs+ " seconds.";
      return result;
   }
}