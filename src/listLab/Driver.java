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
   Random rand = new Random(666);

   ArrayPlaylist list = new ArrayPlaylist("Testing List");
   for(int i = 0; i < 1000000; i++) {
     Integer n = rand.nextInt();
     Integer m = rand.nextInt();
     list.addSong(new Song(n.toString(), m.toString(), rand.nextFloat()));
   }

    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 500000; i++) {
      Integer n = rand.nextInt();
      Integer m = rand.nextInt();
      list.addSongAt(new Song(n.toString(), m.toString(), rand.nextFloat()), rand.nextInt(1000001));  // This test took 2780309 milliseconds
      //test.get(rand.nextInt(100001)); // 8 milliseconds
      //test.swap(rand.nextInt(1000001), rand.nextInt(1000001));  //This test took 92 milliseconds
      //test.shift(rand.nextInt(2000001)-1000001);
      //test.shift(rand.nextInt(1000001));
    }
    long stopTime = System.currentTimeMillis();
    double elapsedTime = (stopTime - startTime) * 1000;
    System.out.println(elapsedTime + " seconds");
    
    
  }

}
