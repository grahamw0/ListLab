package run;

import java.util.Random;

import playlists.ArrayPlaylist;
import playlists.CircularLLPlaylist;
import playlists.SingularLLPlaylist;
import playlists.Song;

/**
 * Class to run runtime tests on all Playlist implementations. Tests run are 500000 random element
 * gets, 500000 shifts in random directions a random amount and 500000 adds at random positions.
 * Times for each test are output to the console in seconds.
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

    ArrayPlaylist array = new ArrayPlaylist("Array Playlist");
    for (int i = 0; i < 1000000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      array.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
    }

    // Getting array test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      array.getSongAt(rand.nextInt(100000));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Array gets took:" + elapsedTime + " seconds");

    // Shifting array test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      array.moveAllSongs(rand.nextInt(2000000) - 1000000);
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Array shifts took:" + elapsedTime + " seconds");

    // Adding array test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      array.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()),
          rand.nextInt(1000001));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Array adds took:" + elapsedTime + " seconds");

    SingularLLPlaylist singular = new SingularLLPlaylist("LL Playlist");
    for (int i = 0; i < 1000000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      singular.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
    }

    // Getting linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      singular.getSongAt(rand.nextInt(100000));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("LL gets took:" + elapsedTime + " seconds");

    // Shifting linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      singular.moveAllSongs(rand.nextInt(2000000) - 1000000);
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("LL shifts took:" + elapsedTime + " seconds");

    // Adding linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      singular.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()),
          rand.nextInt(1000001));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("LL adds took:" + elapsedTime + " seconds");

    CircularLLPlaylist circular = new CircularLLPlaylist("Circular Playlist");
    for (int i = 0; i < 1000000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      circular.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
    }

    // Getting circular linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      circular.getSongAt(rand.nextInt(100000));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Circular LL gets took:" + elapsedTime + " seconds");

    // Shifting circular linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      circular.moveAllSongs(rand.nextInt(2000000) - 1000000);
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Circular LL shifts took:" + elapsedTime + " seconds");

    // Adding circular linked list test
    startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      circular.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()),
          rand.nextInt(1000001));
    }
    stopTime = System.currentTimeMillis();
    elapsedTime = (stopTime - startTime) * 0.001;
    System.out.println("Circular LL adds took:" + elapsedTime + " seconds");

  }
}


