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
public class CircularLLPlaylist implements Playlist {
  private String name;
  private CircularLL<Song> list;

  public CircularLLPlaylist(String name) {
    this.name = name;
    this.list = new CircularLL<>();
  }

  /**
   * 
   */
  @Override
  public String playlistName() {
    return this.name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#addSong(listLab.Song)
   */
  @Override
  public boolean addSong(Song s) {
    return list.add(s);
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#addSongAt(listLab.Song, int)
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    return list.add(index, s);
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#getSongAt(listLab.Song, int)
   */
  @Override
  public Song getSongAt(int index) {
    return list.get(index);
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#getList()
   */
  @Override
  public List<Song> getList() {
    return (List<Song>) Arrays.asList(list.toArray());
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#removeSong(listLab.Song)
   */
  @Override
  public boolean removeSong(Song s) {
    list.remove(s);
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#totalSongs()
   */
  @Override
  public int totalSongs() {
    return list.size();
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#playListTime()
   */
  @Override
  public float playListTime() {
    float totalTime = 0;
    for (Song s : list.toArray()) {
      totalTime += s.getPlayTime();
    }
    return totalTime;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#isSongInPlaylsit(java.lang.String, java.lang.String)
   */
  @Override
  public boolean isSongInPlaylsit(String name, String artist) {
    for (Song s : list.toArray()) {
      if (s.getSongName().equals(name) && s.getArtist().equals(artist)) {
        return true;
      }
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#songsByArtist(java.lang.String)
   */
  @Override
  public void songsByArtist(String name) {
    for (Song s : list.toArray()) {
      if (s.getArtist().equals(name)) {
        System.out.println(s.getSongName());
      }
    }

  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#addSongsFrom(listLab.Playlist)
   */
  @Override
  public boolean addSongsFrom(Playlist p) {
    for (Song s : (List<Song>) p.getList()) {
      list.add(s);
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#moveSong(listLab.Song, int)
   */
  @Override
  public boolean moveSong(Song song, int position) {
    if (!list.contains(song)) {
      throw new IllegalArgumentException("String to move doesn't exist in playlist");
    }
    list.remove(song);
    list.add(position, song);

    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#moveAllSongs(int)
   */
  @Override
  public boolean moveAllSongs(int positions) {
    // TODO Auto-generated method stub
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.Playlist#swapSongs(int, int)
   */
  @Override
  public boolean swapSongs(int position1, int position2) {
    list.swap(position1, position2);
    return true;
  }

}
