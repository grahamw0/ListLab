package playlists;

/**
 * Class Song will create a song Object.
 * It will initialize 3 fields upon creation.  
 * 1. The name of the song. 
 * 2. The name of the artist.
 * 3. The length of the song in minutes and seconds.
 * @author Will Graham, Ryan Godfrey
 * @version 9/30/2016
 */

public class Song {
  private String name; // The name of the song.
  private String artist; // The name of the artist.
  private float playTime; // The length of the song. 

  /**
   * Constructor of class Song.  It will take in 
   * 3 parameters upon creation of a Song object.  
   * @param name Name of the song.
   * @param artist Name of the artist.
   * @param playTime The length of the song.
   */
  public Song(String name, String artist, float playTime) {
    this.name = name;
    this.artist = artist;
    this.playTime = playTime;
  }

  /**
   * The toString() method will return a string
   * representation of the specified fields in 
   * class Song.  
   */
  public String toString() {
    int playTimeInSec = (int) (playTime * 60); // converts float into total seconds
    int minutes = playTimeInSec / 60; // converts total seconds into minutes.
    int seconds = playTimeInSec % 60; // converts total seconds left to display
    // return the String "Song: (name), Artist: (artist), Playtime: (minutes):(seconds)"
    return "Song: " + name + ", Artist: " + artist + ", Playtime: " + minutes + ":" + seconds;
  }

  /**
   * The getPlayTime() method will return
   * the playTime of the song.   
   * @return The playTime field
   */
  public double getPlayTime() {
    return (double) playTime;
  }

  /**
   * The getArtist() method will return
   * the name of the artist. 
   * @return The artist field
   */
  public String getArtist() {
    return artist;
  }

  /**
   * The getSongName() method will return
   * the name of the song.
   * @return The name field
   */
  public String getSongName() {
    return name;
  }

  /**
   * The equals() method will take in 
   * a Song object and be useful for matching
   * it to another Song object.  It will return true
   * if there is a match and false if there is not.  
   * @param s The song object
   * @return True if there is a match and false if there is no match.  
   */
  public boolean equals(Song s) {
    boolean equal = false; 
    boolean nameBool = name.equals(s.getSongName()); // check the song name
    boolean artistBool = artist.equals(s.getArtist()); // check the artist name
    boolean timeBool = playTime == s.getPlayTime(); // check the play time
    if (nameBool && artistBool && timeBool) {
      equal = true; 
    }
    return equal; // returns true if match is made
  }

}


