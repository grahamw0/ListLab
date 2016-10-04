package structures;

import java.lang.reflect.Array;

/**
 * Class CircularLL will create a Circular Linked List and is
 * one of the 3 generic list classes that implement MyList. 
 * This class is responsible for creating the Linked List
 * that class CircularLLPlaylist will utilize.    
 * @author Will Graham, Ryan Godfrey
 * @version 10/2/2016
 */
public class CircularLL<T> implements MyList<T> {
  private Node head; // The beginning of the list
  private Node tail; // The end of the list
  private int size; // current size

  /**
   * Constructor for class CircularLL.  When creating
   * an instance of this class it will set the head and
   * tail to null, and set the size to 0.  
   */
  public CircularLL() {
    head = null;
    tail = null;
    size = 0;
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
    checkBoundsHead(index); // checks the bounds and checks if the list is null.  
    Node newNode = new Node(o);
    if (index == 0) { // The head case
      newNode.setNext(head);
      this.head = newNode;
      this.tail.setNext(head);
      size++;
    } else { // add it to the specified index in the list.
      Node currentNode = head;
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext()); // set the new node's next from the former tail's next.  
      currentNode.setNext(newNode);
      size++;
    }
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
    if (size == 0) { // The head case
      this.head = new Node(o);
      this.tail = head;
      this.tail.setNext(head); // Point the head back to itself.
      size++;
    } else { // Append it to the list.
      this.tail.setNext(new Node(o));
      this.tail = tail.getNext();
      this.tail.setNext(head); // Point the tail back to the head. 
      size++;
    }
    return true;
  }

  /**
   * The clear() method will remove all of the elements from the list.
   * @return boolean
   */
  @Override
  public boolean clear() {
    this.head = null; // set the head to null
    this.tail = null; // set the tail to null
    this.size = 0; // set the size to 0
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
    if (head != null) { // If the list is not empty
      Node currentNode = head;
      for (int i = 0; i < size; i++) { 
        if (currentNode.getData() == o) { // If an element in the list matches the element in question
          return true; // return true if there is a match
        }
        currentNode = currentNode.getNext();
      }
    }
    return false; // If there is no match then return false.
  }

  /**
   * The get() method takes in an index and returns the element located
   * in the specified position of this list.  This method also throws an
   * exception if the position value is less than 1 or greater than the
   * list size.  
   * @param index The index in question
   * @return T Retrieve the element at the index
   */
  @SuppressWarnings("unchecked")
  @Override
  public T get(int index) {
    checkBoundsHead(index); // Check bounds of the index and throw an exception if needed
    Node currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return (T) currentNode.getData(); // return the specified element
  }

  /**
   * The indexOf() method will return an index in the list of the first occurrence
   * of the specified element, or -1 if this list does not contain the element.
   * @param object
   * @return The index or -1 if it does not exist
   */
  @Override
  public int indexOf(T o) {
    if (head != null) { // If the list is not empty
      Node currentNode = head;
      for (int i = 0; i < size; i++) {
        if (currentNode.getData() == o) { // If there is an element that matches the element in question
          return i; // return the index
        }
        currentNode = currentNode.getNext();
      }
    }
    return -1; // return if not found
  }

  /**
   * The isEmpty() method will return true if the list contains no elements.
   * @return boolean True if list is empty
   */
  @Override
  public boolean isEmpty() {
    return (size == 0);
  }

  /**
   * The remove() method will remove the element at the specified position
   * in this list.  It also throws and exception if the position value is less
   * than 1 or greater than the list size.
   * @param index 
   * @return the deleted data
   */
  @SuppressWarnings("unchecked")
  @Override
  public T remove(int index) {
    checkBoundsHead(index);

    Node currentNode = head;
    Object deletedData;
    if (index == size - 1) { // If it's the tail
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deletedData = tail.getData();
      tail = currentNode;
      currentNode.setNext(head);
      size--;
    } else if (index == 0) { // If it's the head
      deletedData = head.getData();
      head = head.getNext();
      size--;
    } else { // If it's in the middle
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deletedData = currentNode.getNext().getData(); // get the data
      currentNode.setNext(currentNode.getNext().getNext()); // Point the current node's next to the right location.  
      size--;
    }
    return (T) deletedData; // return the deleted data

  }

  /**
   * The overloaded remove() method is different in that it
   * takes in an object as a parameter instead of an index. It removes
   * the first occurrence of the specified element from the list.
   * @param object
   * @return The deleted data
   */
  @SuppressWarnings("unchecked")
  @Override
  public T remove(Object o) {
    if (head == null) { // If the list is empty throw an exception.
      throw new NullPointerException("Linked list is empty");
    }
    Node currentNode = head;
    boolean searching = true;
    T deletedData = null;
    
    // If node to be removed is head
    if (head.getData() == o) {
      deletedData = (T) head.getData(); 
      head.setData(null);
      head = head.getNext();
      size--;
    } else {

      // If node is in middle of list
      while (searching && currentNode.getNext() != tail) {
        if (currentNode.getNext().getData() == o) {
          deletedData = (T) currentNode.getNext().getData();
          currentNode.setNext(currentNode.getNext().getNext());
          size--;
          searching = false;
        } else {
          currentNode = currentNode.getNext();
        }
      }

      // If node to remove is tail
      if (currentNode.getNext().getData() == o && searching) {
        deletedData = (T) currentNode.getNext().getData();
        currentNode.setNext(head);
        tail = currentNode;
        size--;
      }
    }
    return deletedData; // return the deleted data
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
    checkBoundsHead(index); // Check the bounds and throw an exception if needed.
    Node newNode = new Node(element);
    Node currentNode = head;

    if (index == 0) { // If it's the Head case
      newNode.setNext(head.getNext());
      this.head = newNode;
    } else if (index == size - 1) { // If it's the Tail case
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(newNode);
      newNode.setNext(null);
      this.tail = newNode;

    } else { // If it's in the middle

      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext().getNext());
      currentNode.setNext(newNode);
    }

    return true; // return true is the element is set
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
  @SuppressWarnings("unchecked")
  @Override
  public MyList<T> subList(int fromindex, int toIndex) {
    checkBoundsHead(fromindex); // Check the bounds and throw an exception if needed.
    checkBoundsHead(toIndex); // Check the bounds and throw an exception if needed.

    Node currentNode = head;
    boolean inRange = false;
    CircularLL<T> newList = new CircularLL<>(); // Create a new CircularLL
    for (int i = 0; i < toIndex; i++) { // get the end of the new list
      if (i == fromindex) { // get the beginning of the list
        inRange = true; // create the range by setting to true
      }
      if (inRange) { // If i is in range add it to the new sub list
        newList.add((T) currentNode.getData());
      }
      currentNode = currentNode.getNext();
    }
    return newList; // return the new sublist
  }

  /**
   * The toArray() method will return an array containing all of the
   * elements in the list in proper sequence. 
   * @return the array
   */
  @SuppressWarnings("unchecked")
  @Override
  public T[] toArray() {
    if (head == null) { // If there is no head then return null.
      return null;
    }
    Node currentNode = head;
    T[] array = (T[]) Array.newInstance(head.getData().getClass(), size); // Create a new array 
    for (int i = 0; i < size; i++) {
      array[i] = (T) currentNode.getData(); // put the data into the array.
      currentNode = currentNode.getNext();
    }
    return array; // Return the contents of the array.
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
    if (size < 2) {  // If there are not at least 2 elements to swap
      return false;
    }
    checkBoundsHead(position1); // Check the bounds and throw an exception if needed.
    checkBoundsHead(position2); // Check the bounds and throw an exception if needed.
    Node currentNode = head;
    Node node1 = null; // create the nodes
    Node node2 = null;
    Object data1 = null;
    Object temp = null; // create a temp

    for (int i = 0; i <= Math.max(position1, position2); i++) {
      if (i == position1) { // get positition 1
        node1 = currentNode;
      } else if (i == position2) { // get position 2
        node2 = currentNode;
      }
      currentNode = currentNode.getNext();
    }
    data1 = node1.getData(); // swap the data
    temp = data1;
    node1.setData(node2.getData());
    node2.setData(temp);
    
    return true; // return true if the swap was a success
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#shift(int)
   */
  @Override
  public boolean shift(int positions) {
    if(size == 0) {
      return false;
    }
    if(positions > 0) {
      for(int i = 0; i < size - positions; i++) {
        head = head.getNext();
        tail = tail.getNext();
      }
    } else if (positions < 0) {
      for(int i = 0; i < Math.abs(positions); i++) {
        head = head.getNext();
        tail = tail.getNext();
      }
    }
    return true;
  }

  private void checkBoundsHead(int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("Index is invalid");
    }

    if (head == null) {
      throw new NullPointerException("Linked list is empty");
    }
  }

}
