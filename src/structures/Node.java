package structures;

/**
 * Class Node will create the instance of a 
 * node that will be used with the Linked List
 * classes.  
 * @author Will Graham, Ryan Godfrey
 * @version 9/30/2016
 */

public class Node {
  private Object data; 
  private Node next;
  
  /**
   * Constructor that creates a node that holds
   * data and sets its next to null.
   * @param data Object of data being passed in. 
   */
  public Node(Object data) {
    this.data = data;
    next = null;
  }

  /**
   * Overloaded node constructor. Creates
   * a node that holds a data Object and sets the 
   * path of where the current node points to.  
   * @param data Object of data being passed in.
   * @param next The location that this node will point to. 
   */
  public Node(Object data, Node next) {
    this.data = data;
    this.next = next;
  }

  /**
   * The getdata() method will retrieve 
   * the current data object. 
   * @return the data Object
   */
  public Object getData() {
    return data;
  }

  /**
   * The setdata() method will set the data Object to the 
   * current node.    
   * @param data the data to set
   */
  public void setData(Object data) {
    this.data = data;
  }

  /**
   * The getNext() method will retrieve the next
   * node in the Linked List.  
   * @return the next node in the Linked List
   */
  public Node getNext() {
    return next;
  }

  /**
   * The setNext() method will set the next node
   * of the current node in the Linked List.  
   * @param next the next to set
   */
  public void setNext(Node next) {
    this.next = next;
  }
}
