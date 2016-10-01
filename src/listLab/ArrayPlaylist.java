/**
 * 
 */
package listLab;

import java.util.Arrays;
import java.util.List;

/**
 * @author grahamw0
 *
 */
public class ArrayPlaylist implements Playlist {
  private String name;
  private ListArray<Song> array;
  
  public ArrayPlaylist(String name) {
    this.name = name;
    array = new ListArray<>(Song.class);
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#playlistName()
   */
  @Override
  public String playlistName() {
    return name;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSong(listLab.Song)
   */
  @Override
  public boolean addSong(Song s) {
    return array.add(s);
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSongAt(listLab.Song, int)
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    return array.add(index, s);
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#getSongAt(listLab.Song, int)
   */
  @Override
  public Song getSongAt(Song s, int index) {
    return array.get(index);
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#getList()
   */
  @Override
  public List getList() {
    return (List<Song>) Arrays.asList(array.toArray());
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#removeSong(listLab.Song)
   */
  @Override
  public boolean removeSong(Song s) {
    array.remove(s);
    return true;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#totalSongs()
   */
  @Override
  public int totalSongs() {
    return array.size();
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#playListTime()
   */
  @Override
  public float playListTime() {
    float totalTime = 0;
    for(Song s : array.toArray()) {
      totalTime += s.getPlayTime();
    }
    return totalTime;
  }

  /**
   * Has to manually check through, because play time was not specified,
   * so no new Song created will ever match one in the playlist already.
   * @param name
   * @param artist
   * @return
   */
  @Override
  public boolean isSongInPlaylsit(String name, String artist) {
    for(Song s : array.toArray()) {
      if(s.getSongName().equals(name) && s.getArtist().equals(artist)) {
        return true;
      }
    }
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#songsByArtist(java.lang.String)
   */
  @Override
  public void songsByArtist(String name) {
    for(Song s : array.toArray()) {
      if(s.getArtist().equals(name)) {
        System.out.println(s.getSongName());
      }
    }

  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSongsFrom(listLab.Playlist)
   */
  @Override
  public boolean addSongsFrom(Playlist p) {
    for(Song s : (List<Song>)p.getList()) {
      array.add(s);
    }
    return true;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#moveSong(listLab.Song, int)
   */
  @Override
  public boolean moveSong(Song song, int position) {
    if(!array.contains(song)) {
      throw new IllegalArgumentException("String to move doesn't exist in playlist");
    }
    array.remove(song);
    array.add(position, song);
    
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

  /* (non-Javadoc)
   * @see listLab.Playlist#swapSongs(int, int)
   */
  @Override
  public boolean swapSongs(int position1, int position2) {
    array.swap(position1, position2);
    return true;
  }

}
