/**
 * 
 */
package listLab;

import java.util.List;
import java.util.Random;

/**
 * @author grahamw0
 *
 */
public class Driver {

  /**
   * @param args
   */
  public static void main(String[] args) {
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
    
    ListArray<Integer> test = new ListArray<>(Integer.class);
    for(int i = 0; i < 20; i++) {
      test.add(i);
    }
    test.shift(2);
    for(Integer i : test.toArray()) {
      System.out.println(i);
    }
    
  }

}
