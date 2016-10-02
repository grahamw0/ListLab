/**
 * 
 */
package listLab;

import java.util.Arrays;
import java.util.List;

/**
 * Class SingularLLPlaylist is the playlist class
 * that implements Playlist.java as an interface.  It is 
 * the playlist class that is designed to create an instance of 
 * class SingularLL and call on the methods that handle the LL. 
 * This class SingularLLPlaylist will house the methods that 
 * pertain to the playlist itself. 
 * @author Will Graham, Ryan Godfrey
 * @version 10/01/2016
 */
public class SingularLLPlaylist implements Playlist {
	private String name; // The name of the SingularLLPlaylist. 
	private SingularLL<Song> sing; // A Singular linked list called sing.
	
	/**
	 * Constructor of class SingularLLPlaylist.
	 * It initializes the specified name of the playlist 
	 * and creates a new instance of class SingularLL, which
	 * is a linked list, called sing.  
	 * @param name
	 */
	public SingularLLPlaylist(String name){
		this.name = name; 
		sing = new SingularLL<Song>();
	}

  /**
   * The playlistName() method returns
   * the name of the playlist that is 
   * set when a new instance of the SingularLLPlaylist 
   * class is created.
   */
  @Override
  public String playlistName() {
    return name;
  }

  /**
   * The addSong(Song s) method will add
   * a song to the SingularLL called sing.
   * @return boolean 
   */
  @Override
  public boolean addSong(Song s) {
    return sing.add(s);
  }

  /**
   * The addSongAt() method will add a song
   * to the SingularLL called sing at a specified
   * index location. 
   * @param Song s The song object
   * @param index The index location
   * @return boolean
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    return sing.add(index, s);
  }

  /**
   * The getSongAt() method will retrieve the song
   * object at the specified index location. 
   * @param index The specified index location.
   * @return The song object at the specified index location.
   */
  @Override
  public Song getSongAt(int index) {
    return sing.get(index);
  }

  /**
   * The getList() method will return the current
   * list of songs in the SingularLL called sing
   * @return The list of songs in the SingularLL called sing. 
   */
  @Override
  public List<Song> getList() {
    return (List<Song>) Arrays.asList(sing.toArray());
  }

  /**
   * The removeSong method removes the specified
   * song object from the SingularLL called sing
   * @param Song s The song object
   * @return boolean
   */
  @Override
  public boolean removeSong(Song s) {  
    sing.remove(s);
    return true;
  }

  /**
   * The totalSongs() method will return the
   * current size of the SingularLL called sing. 
   * @return sing.size() The total size of the list called sing. 
   */
  @Override
  public int totalSongs() {
    return sing.size();
  }

  /**
   * The playListTime() method will iterate
   * through the entire SingularLL called sing
   * and total up the entire list's playtime.  
   * @return totaltime: The total playtime of the list called sing.
   */
  @Override
  public float playListTime() {
    float totalTime = 0; // Create variable called totalTime
    for(Song s : sing.toArray()){ // iterate the entire list
    	totalTime += s.getPlayTime(); // tally up the playtime
    }
    return totalTime; // return the total playtime
  }

  /**
   * The isSongInPlaylist() method will check the list called
   * sing for a specified name and artist.  It has to manually
   * check through, because play time was not specified, so no new Song
   * created will ever match one in the playlist currently.  
   * @param name The name of the Song
   * @param artist The name of the artist
   * @return boolean
   */
  @Override
  public boolean isSongInPlaylsit(String name, String artist) {
    for(Song s : sing.toArray()) { // Iterate the entire list.
      if(s.getSongName().equals(name) && s.getArtist().equals(artist)) { // If there is a match
    	return true; // return true if found
      }
    }
    return false;
  }

  /**
   * The songsByArtist() method will search the entire 
   * SingularLL called sing and show all songs that were
   * written by the specifed artist.
   * @param name The name of the artist
   */
  @Override
  public void songsByArtist(String name) {
    for(Song s : sing.toArray()) { // Iterate the entire list
      if(s.getArtist().equals(name)) { // If the name matches	
    	System.out.println(s.getSongName()); // Print all song names for that artist. 
      }
    }
  }

  /**
   * The addSongsFrom method will add the songs
   * from one playlist and append it to this playlist.
   * @param Playlist p A specified playlist object.
   * @return boolean
   */
  @Override
  public boolean addSongsFrom(Playlist p) {
    for(Song s : (List<Song>)p.getList()) { // get the list
    	sing.add(s); // and add on the songs.  
    }
    return true;
  }

  /**
   * The MoveSong() method will take in a song object
   * and move it to the specified position.
   * @param song The song object
   * @param position The position in the index
   * @return boolean
   */
  @Override
  public boolean moveSong(Song song, int position) {
    if(!sing.contains(song)) { // If the song is not in the list
      throw new IllegalArgumentException("String to move doesn't exist in playlist");
    }
    sing.remove(song); // if found in the list then remove it
    sing.add(position, song); // add it to the specified position
    
    return true;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#moveAllSongs(int)
   */
  @Override
  public boolean moveAllSongs(int positions) {
    // TODO Auto-generated method stub
    return false;
  }

  /**
   * The swapSongs() method will take in two different 
   * indexes and swap those two objects in the list.  
   * @param position1 
   * @param position2
   * @return boolean
   */
  @Override
  public boolean swapSongs(int position1, int position2) {
    sing.swap(position1, position2); // swap the data between two different indexes. 
    return true;
  }

}
