package playlists;

import java.util.List;

/**
 * This is the interface Playlist.  It is the interface
 * for all 3 Playlist classes.  
 * @author Will Graham, Ryan Godfrey
 * @version 10/5/2016
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
  public boolean isSongInPlaylist(String name, String artist);
  public void songsByArtist(String name);
  public boolean addSongsFrom(Playlist p);
  public boolean moveSong(Song song, int position);
  public boolean moveAllSongs(int positions);
  public boolean swapSongs(int position1, int position2);
}
