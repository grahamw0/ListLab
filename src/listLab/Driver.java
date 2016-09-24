/**
 * 
 */
package listLab;

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
    Song song = new Song("Some RadioHead Bull", "Radiohead", 2.3f);
    Song song2 = new Song("Some RadioHead Bull", "Radiohead", 2.1f);
    System.out.println(song.equals(song2));
  }

}
