package structures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Class ListArray<T> will create an array-based list and is
 * one of the 3 generic list classes that implement MyList. 
 * This class is responsible for creating the array-based list
 * that class ArrayPlaylist will utilize.    
 * @author Will Graham, Ryan Godfrey
 * @version 10/2/2016
 *
 */
public class ListArray<T> implements MyList<T> {

  private int size; // The current size
  private T[] array; // The array		
  private final Class c; // A class object

  /**
   * Constructor for class ListArray.  When creating 
   * an instance of this class it will set the size
   * to 0, initialize the class object.  It will 
   * also initialize a new array with a starting size
   * of 10.  
   * @param c
   */
  public ListArray(Class<T> c) {
    this.size = 0;
    this.c = c;
    array = (T[]) Array.newInstance(this.c, 10);
  }

  /**
   * The add method inserts an element into a specified position
   * in the list.  It throws an exception if the position value
   * is less than 1 or greater than list size.
   * @param index
   * @param object. 
   * @return boolean
   */
  @Override
  public boolean add(int index, T o) {
    // TODO Finish
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    }
    ensureArraySpace();
    for (int i = size - 1; i >= index; i--) { // Iterate through the list starting at the end.
      array[i + 1] = array[i]; // Shift to the right including the specified index.
    }
    array[index] = o; // Add the object at the specified index in the array
    size++;
    return true;
  }

  /**
   * The overloaded add() method is different by taking
   * in only a list object as a parameter.  It appends an 
   * element to the end of the list. 
   * @param object
   * @return boolean  
   */
  @Override
  public boolean add(T o) {
	// Check to see if there is space in the array.  If not create a copy and double the size.
    ensureArraySpace(); 
    this.array[size] = o; 
    size++;
    return true;
  }

  /**
   * The clear() method will remove all of the elements from the list.
   * @return boolean
   */
  @Override
  public boolean clear() {
	// Create a new instance of an array and set it to the current array. This will clear the current.  
    this.array = (T[]) Array.newInstance(c, 10);  
    this.size = 0; // Reset size to 0
    return true;
  }

  /**
   * The contains() method will return true if the list contains
   * the specified element.  
   * @param object
   * @return boolean
   */
  @Override
  public boolean contains(T o) {
    if (array[0] == null) { // return false if the list is empty.
      return false;
    }

    for (int i = 0; i < size - 1; i++) {
      if (array[i] == o) { // Return true if the element matches an element in the list.
        return true;
      }
    }
    return false;
  }

  /**
   * The get() method takes in an index and returns the element located
   * in the specified position of this list.  This method also throws an
   * exception if the position value is less than 1 or greater than the
   * list size.  
   * @param index The index in question
   * @return T Retrieve the element at the index
   */
  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      return (T) array[index]; // If there is no exception return the element at the specified index.
    }
  }

  /**
   * The indexOf() method will return an index in the list of the first occurrence
   * of the specified element, or -1 if this list does not contain the element.
   * @param object
   * @return The index or -1 if it does not exist
   */
  @Override
  public int indexOf(T o) {
    for (int i = 0; i < size; i++) { 
      if (array[i] == o) { // If the element is in the list then return the index.
        return i;
      }
    }
    return -1; // return -1 if no such element
  }

  /**
   * The isEmpty() method will return true if the list contains no elements.
   * @return boolean True if list is empty
   */
  @Override
  public boolean isEmpty() {
    return (size == 0); // If size is equal to 0 then return true.
  }

  /**
   * The remove() method will remove the element at the specified position
   * in this list.  It also throws and exception if the position value is less
   * than 1 or greater than the list size.
   * @param index 
   * @return the deleted data
   */
  @Override
  public T remove(int index) {
    T returnObject = array[index]; // Get the element at the index and set it to a variable. 
    for (int i = index; i < size - 1; i++) { // Starting at the index position
      array[i] = array[i + 1]; // Shift all elements after the index left.
    }
    array[size - 1] = null; // Clear the last element.  
    size--; 
    return returnObject; // return the deleted data.  
  }

  /**
   * The overloaded remove() method is different in that it
   * takes in an object as a parameter instead of an index. It removes
   * the first occurrence of the specified element from the list.
   * @param object
   * @return The deleted data
   */
  @Override
  public T remove(Object o) {
    int index = indexOf((T) o); // Get the element and its index.
    remove(index); // Remove that index
    return (T) o; // Return the deleted data.
  }

  /**
   * The set method() will replace the element in specified position 
   * in the list with the provided element.  It also throws an exception
   * if the position value is less than 1 or greater than the list size.
   * @param index
   * @param Object element
   * @return boolean
   */
  @Override
  public boolean set(int index, Object element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      array[index] = (T) element;  // Set the element at the specified index. 
    }
    return true;
  }

  /**
   * The size() method will return the number of elements in the list
   * @return the size of the list
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * The subList() method will return a new list that contains the portion of 
   * the original list between the specified fromIndex, inclusive, and toIndex, exclusive.
   * It also throws an exception if the either the index values is less than 1 or greater
   * than the list size.
   * @param fromindex
   * @param toindex
   * @return the new list
   */
  @Override
  public MyList<T> subList(int fromIndex, int toIndex) {
    // TODO Auto-generated method stub
    if (fromIndex < 0 || fromIndex > size || toIndex < 0 || toIndex > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    }

    ListArray newList = new ListArray<>(c); // Create a new array to copy to.
    newList.setArray(Arrays.copyOfRange(array, fromIndex, toIndex)); // Grab the elements within the range.
    newList.size = toIndex - fromIndex; // Update the list size.
    return newList; // Return the new sub list
  }

  /**
   * The toArray() method will return an array containing all of the
   * elements in the list in proper sequence. 
   * @return the array
   */
  @Override
  public T[] toArray() {
    T[] newArray = (T[]) Array.newInstance(this.c, size); // Create a new array to copy to. 
    for (int i = 0; i < size; i++) {
      newArray[i] = array[i]; // Shift the elements from the array to the new one.  
    }                 
    return newArray; // Return the new array.
  }

  /**
   * The swap() method will swap elements of the List located in the
   * positions 1 and 2.  It also throws an exception if either position values
   * is less than 1 or greater than the list size.
   * @param position1
   * @param position2
   * @return boolean
   */
  @Override
  public boolean swap(int position1, int position2) {
    if (position1 < 0 || position1 > size || position2 < 0 || position2 > size) {
      throw new IndexOutOfBoundsException(); // TODO Should this be recoverable?
    } else {
      T temp = array[position1]; // Load position1 data into a temporary
      array[position1] = array[position2]; // Load position2 data into postition1
      array[position2] = temp; // Load the temp into position2
    }
    return true;
  }

  /**
   * The shift() method will shift all elements in the List by a specified number
   * of location.  If the value of positions is positive then the elements are
   * shifted from left to right.  If the value of positions is negative then the 
   * elements are shifted from right to left.  
   * @param positions
   * @return boolean
   */
  @Override
  public boolean shift(int positions) {
    positions *= -1;
    T[] newArray = (T[]) new Object[size];
    if (positions > 0) {
      int j = 0;
      for (int i = positions; i < size ; i++) {
        newArray[j] = array[i];
        j++;
      }
      for (int i = 0; i < positions ; i++) {
        newArray[j] = array[i];
        j++;
      }
    }
    else if (positions < 0) {
      int j = 0;
      for (int i = size + positions ; i < size; i++) {
        newArray[j] = array[i];
        j++;
      }
      for (int i = 0; i < size + positions; i++) {
        newArray[j] = array[i];
        j++;
      }
    }
    else {
      return false;
    }
    this.array = newArray;
    return true;
  }


  /**
   * The setArray() method will take in an array
   * object and set it to the current array. 
   * @param array
   */
  public void setArray(T[] array) {
    this.array = array;
  }

  /**
   * The ensureArraySpace() method will check to see
   * if the current space in the array is sufficient for 
   * the upcoming actions.  If it is not then it creates
   * more space by copying to a new array and doubling the size.  v
   */
  private void ensureArraySpace() {
    if ((size + 1) > array.length) // If the size of the list is 1 bigger than the array itself
      this.array = Arrays.copyOf(array, (array.length * 2)); // Create a copy and double the size of the old array.
  }

}
