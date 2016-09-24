package listLab;

import java.util.Arrays;

/**
 * @author grahamw0
 * @param <T>
 *
 */
public class ArrayMyList<T> implements MyList<T> {

  private int size;
  private Object[] array;

  public ArrayMyList() {
    this.size = 0;
    this.array = new Object[10];
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#add(int, java.lang.Class)
   */
  @Override
  public boolean add(int index, T o) {

    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#add(java.lang.Class)
   */
  @Override
  public boolean add(T o) {
    if ((size + 1) > array.length) {
      this.array = Arrays.copyOf(array, (array.length * 2));
      this.array[size] = o;
      size++;
    } else {
      this.array[size] = o;
      size++;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#clear()
   */
  @Override
  public boolean clear() {
    this.array = new Object[10];
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#contains(java.lang.Class)
   */
  @Override
  public boolean contains(T o) {
    for(Object i : array) {
      // TODO ask Prof if the double checking is worth not going through null entries
      if(i == null) {  // the end of the array should be all nulls, so return false on the 1st one
        return false;
      }
      else if(i == o) {
        return true;
      }
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#get(int)
   */
  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#indexOf(java.lang.Class)
   */
  @Override
  public int indexOf(T o) {
    // TODO Auto-generated method stub
    return 0;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#isEmpty()
   */
  @Override
  public boolean isEmpty() {
    if (size == 0) {
      return true;
    } else {
      return false;
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#remove(int)
   */
  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#remove(java.lang.Object)
   */
  @Override
  public T remove(Object o) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#set(int, java.lang.Object)
   */
  @Override
  public boolean set(int index, Object element) {
    // TODO Auto-generated method stub
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#size()
   */
  @Override
  public int size() {
    return size;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#subList(int, int)
   */
  @Override
  public MyList<T> subList(int fromindex, int toIndex) {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#toArray()
   */
  @Override
  public T[] toArray() {
    // TODO Auto-generated method stub
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#swap(int, int)
   */
  @Override
  public boolean swap(int position1, int position2) {
    // TODO Auto-generated method stub
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#shift(int)
   */
  @Override
  public boolean shift(int positions) {
    // TODO Auto-generated method stub
    return false;
  }

}
