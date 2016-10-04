package playlists;

import java.util.Arrays;
import java.util.List;

import structures.CircularLL;

/**
 * Class CircularLLPlaylist is one of the 3 playlist classes
 * that implement Playlist.java as an interface.  CircularLLPlaylist is the
 * playlist class that is designed to create an instance of class CircularLL 
 * and call on the methods that handle the CircularLL list called list. 
 * This class CircularLLPlaylist will house the methods that 
 * pertain to the actual CircularLL playlist itself. 
 * 
 * @author Will Graham, Ryan Godfrey
 *
 */
public class CircularLLPlaylist implements Playlist {
  private String name;
  private CircularLL<Song> list;

  /**
   * Constructor of class CircularLLPlaylist.
   * It initializes the specified name of the playlist 
   * and creates a new instance of class CircularLL, which
   * is a circular Linked list called list.  
   * @param name
   */
  public CircularLLPlaylist(String name) {
    this.name = name;
    this.list = new CircularLL<>();
  }

  /**
   * The playlistName() method returns
   * the name of the playlist that is 
   * set when a new instance of the CircularLLPlaylist 
   * class is created.
   * @return name The name of the playlist
   */
  @Override
  public String playlistName() {
    return this.name;
  }

  /**
   * The addSong method will add
   * a song to the CircularLL called list.
   * @param Song s The song object
   * @return boolean 
   */
  @Override
  public boolean addSong(Song s) {
    return list.add(s);
  }

  /**
   * The addSongAt() method will add a song
   * to the CircularLL called list at a specified
   * index location. 
   * @param Song s The song object
   * @param index The index location
   * @return boolean
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    return list.add(index, s);
  }

  /**
   * The getSongAt() method will retrieve the song
   * object at the specified index location. 
   * @param index The specified index location.
   * @return The song object at the specified index location.
   */
  @Override
  public Song getSongAt(int index) {
    return list.get(index);
  }

  /**
   * The getList() method will return the current
   * list of songs in the CircularLL called list.
   * @return The list of songs. 
   */
  @Override
  public List<Song> getList() {
    return (List<Song>) Arrays.asList(list.toArray());
  }

  /**
   * The removeSong method removes the specified
   * song object from the CircularLL called list.
   * @param Song s The song object
   * @return boolean
   */
  @Override
  public boolean removeSong(Song s) {
    list.remove(s);
    return true;
  }

  /**
   * The totalSongs() method will return the
   * current size of the CircularLL called list. 
   * @return array.size() The total size of the list. 
   */
  @Override
  public int totalSongs() {
    return list.size();
  }

  /**
   * The playListTime() method will iterate
   * through the entire CircularLL called list
   * and total up the entire list's playtime.  
   * @return totaltime: The total playtime of the list.
   */
  @Override
  public float playListTime() {
    float totalTime = 0; // Create variable called totaltime
    for (Song s : list.toArray()) { // Iterate the entire list
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
    for (Song s : list.toArray()) { // Iterate the entire list
      if (s.getSongName().equals(name) && s.getArtist().equals(artist)) { // If there is a match
        return true; // return true if found
      }
    }
    return false;
  }

  /**
   * The songsByArtist() method will search the entire 
   * CircularLL called list and show all songs that were
   * written by the specified artist.  
   * @param name The name of the artist
   */
  @Override
  public void songsByArtist(String name) {
    for (Song s : list.toArray()) { // Iterate the entire list
      if (s.getArtist().equals(name)) { // If the name matches
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
    for (Song s : (List<Song>) p.getList()) { // get the list
      list.add(s); // and add on the songs
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
    if (!list.contains(song)) { // If the song is not in the list
      throw new IllegalArgumentException("String to move doesn't exist in playlist");
    }
    list.remove(song); // If found in the list then remove it.
    list.add(position, song); // Add it to the specified position.

    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#moveAllSongs(int)
   */
  @Override
  public boolean moveAllSongs(int positions) {
    return list.shift(positions);
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
    list.swap(position1, position2); // Swap the data between two different indexes.
    return true;
  }

}
