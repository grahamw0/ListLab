/**
 * 
 */
package listLab;

import java.lang.reflect.Array;

/**
 * @author grahamw0
 *
 */
public class CircularLL<T> implements MyList<T> {
  private Node head;
  private Node tail;
  private int size;

  public CircularLL() {
    head = null;
    tail = null;
    size = 0;
  }


  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#add(int, java.lang.Object)
   */
  @Override
  public boolean add(int index, T o) {
    checkBoundsHead(index);
    Node newNode = new Node(o);
    if (index == 0) {
      newNode.setNext(head);
      this.head = newNode;
      this.tail.setNext(head);
      size++;
    } else {
      Node currentNode = head;
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      newNode.setNext(currentNode.getNext());
      currentNode.setNext(newNode);
      size++;
    }

    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#add(java.lang.Object)
   */
  @Override
  public boolean add(T o) {
    if (size == 0) {
      this.head = new Node(o);
      this.tail = head;
      this.tail.setNext(head);
      size++;
    } else {
      this.tail.setNext(new Node(o));
      this.tail = tail.getNext();
      this.tail.setNext(head);
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
    this.head = null;
    this.tail = null;
    this.size = 0;
    return true;
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#contains(java.lang.Object)
   */
  @Override
  public boolean contains(T o) {
    if (head != null) {
      Node currentNode = head;
      for (int i = 0; i < size; i++) {
        if (currentNode.getData() == o) {
          return true;
        }
        currentNode = currentNode.getNext();
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
    checkBoundsHead(index);
    Node currentNode = head;
    for (int i = 0; i < index; i++) {
      currentNode = currentNode.getNext();
    }
    return (T) currentNode.getData();
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#indexOf(java.lang.Object)
   */
  @Override
  public int indexOf(T o) {
    if (head != null) {
      Node currentNode = head;
      for (int i = 0; i < size; i++) {
        if (currentNode.getData() == o) {
          return i;
        }
        currentNode = currentNode.getNext();
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
    return (size == 0);
  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#remove(int)
   */
  @Override
  public T remove(int index) {
    checkBoundsHead(index);

    Node currentNode = head;
    Object deletedData;
    if (index == size - 1) {
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deletedData = tail.getData();
      tail = currentNode;
      currentNode.setNext(head);
      size--;
    } else if (index == 0) { // Head case
      deletedData = head.getData();
      head = head.getNext();
      size--;
    } else {
      for (int i = 0; i < index - 1; i++) {
        currentNode = currentNode.getNext();
      }
      deletedData = currentNode.getNext().getData();
      currentNode.setNext(currentNode.getNext().getNext());
      size--;
    }
    return (T) deletedData;

  }

  /*
   * (non-Javadoc)
   * 
   * @see listLab.MyList#remove(java.lang.Object)
   */
  @Override
  public T remove(Object o) {
    if (head == null) {
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
