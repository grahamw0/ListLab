package playlists;

import java.util.Arrays;
import java.util.List;

import structures.ListArray;

/**
 * Class ArrayPlaylist is one of the 3 playlist classes
 * that implement Playlist.java as an interface.  ArrayPlaylist is the
 * playlist class that is designed to create an instance of class ListArray 
 * and call on the methods that handle the array-based list. 
 * This class ArrayPlaylist will house the methods that 
 * pertain to the actual array-based playlist itself. 
 * 
 * @author Will Graham, Ryan Godfrey
 * @version 10/5/2016
 */
public class ArrayPlaylist implements Playlist {
  private String name;
  private ListArray<Song> array;
  
  /**
   * Constructor of class ArrayPlaylist.
   * It initializes the specified name of the playlist 
   * and creates a new instance of class ListArray, which
   * is an array-based list called array.  
   * @param name
   */
  public ArrayPlaylist(String name) {
    this.name = name;
    array = new ListArray<>(Song.class);
  }

  /**
   * The playlistName() method returns
   * the name of the playlist that is 
   * set when a new instance of the ArrayPlaylist 
   * class is created.
   * @return name The name of the playlist
   */
  @Override
  public String playlistName() {
    return name;
  }

  /**
   * The addSong method will add
   * a song to the ListArray called array.
   * @param Song s The song object
   * @return boolean 
   */
  @Override
  public boolean addSong(Song s) {
    return array.add(s);
  }

  /**
   * The addSongAt() method will add a song
   * to the ListArray called array at a specified
   * index location. 
   * @param Song s The song object
   * @param index The index location
   * @return boolean
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    return array.add(index, s);
  }

  /**
   * The getSongAt() method will retrieve the song
   * object at the specified index location. 
   * @param index The specified index location.
   * @return The song object at the specified index location.
   */
  @Override
  public Song getSongAt(int index) {
    return array.get(index);
  }

  /**
   * The getList() method will return the current
   * list of songs in the ListArray called array
   * @return The list of songs in the ListArray called array. 
   */
  @Override
  public List<Song> getList() {
    return (List<Song>) Arrays.asList(array.toArray());
  }

  /**
   * The removeSong method removes the specified
   * song object from the ListArray called array
   * @param Song s The song object
   * @return boolean
   */
  @Override
  public boolean removeSong(Song s) {
    array.remove(s);
    return true;
  }

  /**
   * The totalSongs() method will return the
   * current size of the ListArray called array 
   * @return array.size() The total size of the list called array. 
   */
  @Override
  public int totalSongs() {
    return array.size();
  }

  /**
   * The playListTime() method will iterate
   * through the entire ListArray called array
   * and total up the entire list's playtime.  
   * @return totaltime: The total playtime of the list.
   */
  @Override
  public float playListTime() {
    float totalTime = 0; // Create variable called totalTime
    for(Song s : array.toArray()) { // Iterate the entire list
      totalTime += s.getPlayTime(); // Tally up the playtime
    }
    return totalTime; // return the total playtime
  }

  /**
   * The isSongInPlaylist() method 
   * has to manually check through, because play time was not specified,
   * so no new Song created will ever match one in the playlist already.
   * @param name The name of the song
   * @param artist The name of the artist
   * @return boolean
   */
  @Override
  public boolean isSongInPlaylist(String name, String artist) {
    for(Song s : array.toArray()) { // Iterate the entire list
      if(s.getSongName().equals(name) && s.getArtist().equals(artist)) { // If there is a match 
        return true; // return true if found

      }
    }
    return false;
  }

  /**
   * The songsByArtist() method will search the entire 
   * ListArray called array and show all songs that were
   * written by the specified artist.
   * @param name The name of the artist
   */
  @Override
  public void songsByArtist(String name) {
    for(Song s : array.toArray()) { // Iterate the entire list
      if(s.getArtist().equals(name)) { // If the name matches
        System.out.println(s.getSongName()); // Print all song names for that artist
      }
    }
  }

  /**
   * The addSongsFrom method will add the songs
   * from one playlist and append it to this playlist.
   * @param Playlist p A specified playlist object.
   * @return boolean
   */
  @SuppressWarnings("unchecked")
  @Override
  public boolean addSongsFrom(Playlist p) {
    for(Song s : (List<Song>) p.getList()) { // get the list
      array.add(s); // and add on the songs
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
    if(!array.contains(song)) {  // If the song is not in the list
      throw new IllegalArgumentException("String to move doesn't exist in playlist");
    }
    array.remove(song); // If found in the list then remove it.
    array.add(position, song); // Add it to the specified position.
    
    return true;
  }

  /**
   * The moveAllSongs() method will move all the songs a given number of 
   * positions in the list.  If the value of positions is positive then
   * the elements are shifted from left to right.  If the value of positions is negative 
   * then the elements are shifted from right to left.  
   * @param postitions
   * @return boolean  
   */
  @Override
  public boolean moveAllSongs(int positions) {
    return array.shift(positions);
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
    array.swap(position1, position2); // Swap the data between two different indexes. 
    return true;
  }

}
