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
    /*
     * Song song = new Song("Some RadioHead Bull", "Radiohead", 2.3f); Song song2 = new
     * Song("Some RadioHead Bull", "Radiohead", 2.1f); System.out.println(song.equals(song2));
     */

    /*Random rand = new Random(666);

    ArrayMyList<Long> test = new ArrayMyList<>(Long.class);
    for (long i = 0; i < 1000000L; i++) {
      test.add(i);
    }
    
      System.out.println(test.contains(17L)); System.out.println(test.get(2));
     

    long startTime = System.currentTimeMillis();
    /*for (long i = 0; i < 500000L; i++) {
      //test.add(rand.nextInt(1000001), rand.nextLong());  // This test took 2780309 milliseconds
      //test.get(rand.nextInt(100001)); // 8 milliseconds
      //test.swap(rand.nextInt(1000001), rand.nextInt(1000001));  //This test took 92 milliseconds
      test.shift(rand.nextInt(200001)-100001);
    }
    test.shift(rand.nextInt(200001)-100001);
    long stopTime = System.currentTimeMillis();
    long elapsedTime = (stopTime - startTime);
    System.out.println(elapsedTime);*/
    
    ArrayMyList<String> stringTest = new ArrayMyList<>(String.class);
    stringTest.add("hello");
    stringTest.add("world");
    stringTest.add("hello");
    
    System.out.println(stringTest.contains("hello"));
  }

}
