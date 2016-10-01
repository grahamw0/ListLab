/**
 * 
 */
package listLab;

import java.util.List;

/**
 * @author grahamw0
 *
 */
public class SingularLLPlaylist implements Playlist {

  /* (non-Javadoc)
   * @see listLab.Playlist#playlistName()
   */
  @Override
  public String playlistName() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSong(listLab.Song)
   */
  @Override
  public boolean addSong(Song s) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSongAt(listLab.Song, int)
   */
  @Override
  public boolean addSongAt(Song s, int index) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#getSongAt(listLab.Song, int)
   */
  @Override
  public Song getSongAt(Song s, int index) {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#getList()
   */
  @Override
  public List getList() {
    // TODO Auto-generated method stub
    return null;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#removeSong(listLab.Song)
   */
  @Override
  public boolean removeSong(Song s) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#totalSongs()
   */
  @Override
  public int totalSongs() {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#playListTime()
   */
  @Override
  public float playListTime() {
    // TODO Auto-generated method stub
    return 0;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#isSongInPlaylsit(java.lang.String, java.lang.String)
   */
  @Override
  public boolean isSongInPlaylsit(String name, String artist) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#songsByArtist(java.lang.String)
   */
  @Override
  public void songsByArtist(String name) {
    // TODO Auto-generated method stub

  }

  /* (non-Javadoc)
   * @see listLab.Playlist#addSongsFrom(listLab.Playlist)
   */
  @Override
  public boolean addSongsFrom(Playlist p) {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see listLab.Playlist#moveSong(listLab.Song, int)
   */
  @Override
  public boolean moveSong(Song song, int position) {
    // TODO Auto-generated method stub
    return false;
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
    // TODO Auto-generated method stub
    return false;
  }

}
