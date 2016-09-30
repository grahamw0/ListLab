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
   /*Random rand = new Random(666);

    ArrayMyList<Long> test = new ArrayMyList<>(Long.class);
    for (long i = 0; i < 1000000L; i++) {
      test.add(i);
    }

    long startTime = System.currentTimeMillis();
    for (long i = 0; i < 5L; i++) {
      //test.add(rand.nextInt(1000001), rand.nextLong());  // This test took 2780309 milliseconds
      //test.get(rand.nextInt(100001)); // 8 milliseconds
      //test.swap(rand.nextInt(1000001), rand.nextInt(1000001));  //This test took 92 milliseconds
      //test.shift(rand.nextInt(2000001)-1000001);
      test.shift(rand.nextInt(1000001));
    }
    long stopTime = System.currentTimeMillis();
    long elapsedTime = (stopTime - startTime);
    System.out.println(elapsedTime);*/
    
    SingularLL<Integer> ll = new SingularLL<>();
    for(int i = 0; i < 20; i++) {
      ll.add(i);
    }
    
    ll.swap(19, 0);
    
    for(Integer i: ll.toArray()) {
      System.out.println(i);
    }
    
    
  }

}
