/**
 * 
 */
package listLab;

/**
 * @author grahamw0
 *
 */

class Node {
  Object data;
  Node next;
  
  public Node(Object data) {
    this.data = data;
    next = null;
  }
  
  public Node(Object data, Node next) {
    this.data = data;
    this.next = next;
  }

  /**
   * @return the data
   */
  public Object getData() {
    return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(Object data) {
    this.data = data;
  }

  /**
   * @return the next
   */
  public Node getNext() {
    return next;
  }

  /**
   * @param next the next to set
   */
  public void setNext(Node next) {
    this.next = next;
  }
  
  
}

public class SingularLL implements MyList<T> {
  private int count;
  private Node head;
  private Node tail;
  
  
}
