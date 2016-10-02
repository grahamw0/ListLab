/**
 * 
 */
package listLab;

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
    return deletedData;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#set(int, java.lang.Object)
   */
  @Override
  public boolean set(int index, Object element) {
    checkBoundsHead(index);
    Node newNode = new Node(element);
    Node currentNode = head;

    if (index == 0) { // Head case
      newNode.setNext(head.getNext());
      this.head = newNode;
    } else if (index == size - 1) { // Tail case
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(newNode);
      newNode.setNext(null);
      this.tail = newNode;

    } else {

      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext().getNext());
      currentNode.setNext(newNode);
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
  public MyList<T> subList(int fromindex, int toIndex) {
    checkBoundsHead(fromindex);
    checkBoundsHead(toIndex);

    Node currentNode = head;
    boolean inRange = false;
    CircularLL<T> newList = new CircularLL<>();
    for (int i = 0; i < toIndex; i++) {
      if (i == fromindex) {
        inRange = true;
      }
      if (inRange) {
        newList.add((T) currentNode.getData());
      }
      currentNode = currentNode.getNext();
    }

    return newList;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#toArray()
   */
  @Override
  public T[] toArray() {
    if (head == null) {
      return null;
    }
    Node currentNode = head;
    T[] array = (T[]) Array.newInstance(head.getData().getClass(), size);
    for (int i = 0; i < size; i++) {
      array[i] = (T) currentNode.getData();
      currentNode = currentNode.getNext();
    }
    return array;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#swap(int, int)
   */
  @Override
  public boolean swap(int position1, int position2) {
    if (size < 2) {
      return false;
    }
    checkBoundsHead(position1);
    checkBoundsHead(position2);
    Node currentNode = head;
    Node node1 = null;
    Node node2 = null;
    Object data1 = null;
    Object temp = null;

    for (int i = 0; i <= Math.max(position1, position2); i++) {
      if (i == position1) {
        node1 = currentNode;
      } else if (i == position2) {
        node2 = currentNode;
      }
      currentNode = currentNode.getNext();
    }
    data1 = node1.getData();
    temp = data1;
    node1.setData(node2.getData());
    node2.setData(temp);


    return true;
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

  private void checkBoundsHead(int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException();
    }

    if (head == null) {
      throw new NullPointerException("Linked list is empty"); // Maybe custom exception???
    }
  }

}
