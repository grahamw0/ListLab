/**
 * 
 */
package listLab;

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
    // TODO Auto-generated method stub
    /*Song song = new Song("Some RadioHead Bull", "Radiohead", 2.3f);
    Song song2 = new Song("Some RadioHead Bull", "Radiohead", 2.1f);
    System.out.println(song.equals(song2));*/
    
    Random rand = new Random(666);
    
    ArrayMyList<Long> test = new ArrayMyList<>(Long.class);
    for(long i = 0; i < 1000000L; i++) {
      test.add(i);
    }
    System.out.println(test.contains(17L));
    System.out.println(test.get(2));
    test.swap(rand.nextInt(1000001), rand.nextInt(1000001));
  }

}
