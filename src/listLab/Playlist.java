/**
 * 
 */
package listLab;

import java.util.List;

/**
 * @author grahamw0
 *
 */
public interface Playlist {
  public String playlistName();
  public boolean addSong(Song s);
  public boolean addSongAt(Song s, int index);
  public Song getSongAt(int index);
  public List getList();
  public boolean removeSong(Song s);
  public int totalSongs();
  public float playListTime();
  public boolean isSongInPlaylsit(String name, String artist);
  public void songsByArtist(String name);
  public boolean addSongsFrom(Playlist p);
  public boolean moveSong(Song song, int position);
  public boolean moveAllSongs(int positions);
  public boolean swapSongs(int position1, int position2);
}
