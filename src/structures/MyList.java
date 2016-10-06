package structures;

/**
 * This is the interface Mylist.  It is the interface
 * for all 3 List classes.
 * @author Ryan Godfrey, Will Graham
 * @version 10/5/2016
 */
public interface MyList<T> {
  
  public boolean add(int index, T o);
  public boolean add(T o);
  public boolean clear();
  public boolean contains(T o);
  public T get(int index);
  public int indexOf(T o);
  public boolean isEmpty();
  public T remove(int index);
  public T remove(Object o);
  public boolean set(int index, Object element);
  public int size();
  public MyList<T> subList(int fromindex, int toIndex);
  public T[] toArray();
  public boolean swap(int position1, int position2);
  public boolean shift(int positions);
}
