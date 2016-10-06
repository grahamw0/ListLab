package run;

import java.util.List;
import java.util.Random;

import playlists.CircularLLPlaylist;
import playlists.SingularLLPlaylist;
import playlists.Song;
import structures.CircularLL;

/**
 * This is the Driver class for the program called ListLab
 * It will initiate an instance of a the specified playlist 
 * and test all of the specified methods in that playlist.
 * 
 * @author Will Graham, Ryan Godfrey
 * @version 10/5/2016
 *
 */
public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
	  Random rand = new Random(666);
	   long startTime;
	   long stopTime;
	   double elapsedTime;

	   // Array-Based playlist testing
	   /*ArrayPlaylist arrayList = new ArrayPlaylist("Test List");
	   for(int i = 0; i < 1000000; i++) {
	     Integer n = rand.nextInt();
	     Integer m = rand.nextInt();
	     arrayList.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
	   }

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      Integer n = rand.nextInt();
	      Integer m = rand.nextInt();
	      // Adds take 1hr 35min
	      arrayList.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()), rand.nextInt(1000001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("Array adds took:" + elapsedTime + " seconds");
	    
	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      //Gets take 0.054 seconds
	      arrayList.getSongAt(rand.nextInt(100001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("Array gets took:" + elapsedTime + " seconds");

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      // Swapping takes 0.188 seconds
	      arrayList.swapSongs(rand.nextInt(1000001), rand.nextInt(1000001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("Array swapping took:" + elapsedTime + " seconds");

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      arrayList.moveAllSongs(rand.nextInt(2000001)-1000001);
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("Array shifting took:" + elapsedTime + " seconds");*/

	    //********** LL Testing ************
	    CircularLLPlaylist cirLL = new CircularLLPlaylist("Test List");
	   for(int i = 0; i < 1000000; i++) {
	     Integer n = rand.nextInt();
	     Integer m = rand.nextInt();
	     cirLL.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
	   }

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      Integer n = rand.nextInt();
	      Integer m = rand.nextInt();
	      
	      cirLL.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()), rand.nextInt(1000001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("CirLL adds took:" + elapsedTime + " seconds");
	    
	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      
	      cirLL.getSongAt(rand.nextInt(100001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("CirLL gets took:" + elapsedTime + " seconds");

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      
	      cirLL.swapSongs(rand.nextInt(1000001), rand.nextInt(1000001));
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("CirLL swapping took:" + elapsedTime + " seconds");

	    startTime = System.currentTimeMillis();
	    for (int i = 0; i < 500000; i++) {
	      cirLL.moveAllSongs(rand.nextInt(2000001)-1000001);
	    }
	    stopTime = System.currentTimeMillis();
	    elapsedTime = (stopTime - startTime) * 0.001;
	    System.out.println("CirLL shifting took:" + elapsedTime + " seconds");

	  }

   /*Random rand = new Random(666);

   ArrayPlaylist list = new ArrayPlaylist("Test List");
   for(int i = 0; i < 1000000; i++) {
     Integer n = rand.nextInt();
     Integer m = rand.nextInt();
     list.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
   }

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      // Adds take 1hr 35min
      //list.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()), rand.nextInt(1000001));
      
      //Gets take 0.054 seconds
      list.getSongAt(rand.nextInt(100001));
      
      // Swapping takes 0.188 seconds
      list.swapSongs(rand.nextInt(1000001), rand.nextInt(1000001));
      //test.shift(rand.nextInt(2000001)-1000001);
    }
    long stopTime = System.currentTimeMillis();
    double elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println(elapsedTime + " seconds");*/
    
    /*CircularLL<Integer> test = new CircularLL<>();
    for(int i = 0; i < 20; i++) {
      test.add(i);
    }
    test.shift(2);
    for(Integer i : test.toArray()) {
      System.out.println(i);
    }
    
    CircularLLPlaylist test = new CircularLLPlaylist("test");
    test.addSong(new Song("one", "", 0f));
    test.addSong(new Song("two", "", 0f));
    test.addSong(new Song("three", "", 0f));
    test.moveAllSongs(1);
    for(Song s : test.getList()) {
      System.out.println(s.getSongName());
    }*/
    
    
  }


