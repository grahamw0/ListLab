package listLab;

/**
 * @author grahamw0
 *
 */
public class Song {
  private String name;
  private String artist;
  private float playTime;

  public Song(String name, String artist, float playTime) {
    this.name = name;
    this.artist = artist;
    this.playTime = playTime;
  }



  public String toString() {
    
  }

  public double getPlayTime() {
    return (double) playTime;
  }

  public String getArtist() {
    return artist;
  }

  public String getSongName() {
    return name;
  }

  public boolean equals(Song s) {
    boolean equal = false;
    boolean nameBool = name.equals(s.getSongName());
    boolean artistBool = artist.equals(s.getArtist());
    boolean timeBool = playTime == s.getPlayTime();
    if (nameBool && artistBool && timeBool) {
      equal = true;
    }
    return equal;
  }

}

