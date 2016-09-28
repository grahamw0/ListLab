package listLab;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author grahamw0
 * @param <T>
 *
 */
public class ArrayMyList<T> implements MyList<T> {

  private int size;
  private T[] array;
  private final Class c;

  public ArrayMyList(Class<T> c) {
    this.size = 0;
    this.c = c;
    array = (T[]) Array.newInstance(this.c, 10);
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#add(int, java.lang.Class)
   */
  @Override
  public boolean add(int index, T o) {
    // TODO Finish
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    }

    if ((size + 1) > array.length) {
      this.array = Arrays.copyOf(array, (array.length * 2));
      for (int i = size - 1; i >= index; i--) {
        array[i + 1] = array[i];
      }
      array[index] = o;
      size++;
    } else {
      for (int i = size - 1; i >= index; i--) {
        array[i + 1] = array[i];
      }
      array[index] = o;
      size++;
    }
    return true;
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
    this.array = (T[]) Array.newInstance(c, 10);
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#contains(java.lang.Class)
   */
  @Override
  public boolean contains(T o) {
    if (array[0] == null) {
      return false;
    }

    for (int i = 0; i < size - 1; i++) {
      if (array[i] == o) {
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
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      return (T) array[index];
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#indexOf(java.lang.Class)
   */
  @Override
  public int indexOf(T o) {
    for (int i = 0; i < size; i++) {
      if (array[i] == o) {
        return i;
      }
    }
    return -1;
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
    T returnObject = array[index];
    for (int i = index; i < size - 1; i++) {
      array[i] = array[i + 1];
    }
    array[size - 1] = null;
    size--;

    return returnObject;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#remove(java.lang.Object)
   */
  @Override
  public T remove(Object o) {
    // TODO Auto-generated method stub

    int index = indexOf((T) o);
    remove(index);

    return (T) o;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#set(int, java.lang.Object)
   */
  @Override
  public boolean set(int index, Object element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      array[index] = (T) element;
    }
    return true;
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
  public MyList<T> subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    }

    ArrayMyList newList = new ArrayMyList<>(c);
    newList.setArray(Arrays.copyOfRange(array, fromIndex, toIndex));
    return newList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#toArray()
   */
  @Override
  public T[] toArray() {
    return array;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#swap(int, int)
   */
  @Override
  public boolean swap(int position1, int position2) {
    if (position1 < 0 || position1 > size || position2 < 0 || position2 > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      T temp = array[position1];
      array[position1] = array[position2];
      array[position2] = temp;
    }
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#shift(int)
   */
  @Override
  public boolean shift(int positions) {
    Collections.rotate(Arrays.asList(array), positions);
    return true;
  }

  public void setArray(T[] array) {
    this.array = array;
  }

}
