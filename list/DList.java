

/* DList.java */

package list;

/**
 *  A DList is a mutable doubly-linked list ADT.  Its implementation is
 *  circularly-linked and employs a sentinel (dummy) node at the head
 *  of the list.
 *
 *  DO NOT CHANGE ANY METHOD PROTOTYPES IN THIS FILE.
 */

public class DList {

  /**
   *  head references the sentinel node.
   *  size is the number of items in the list.  (The sentinel node does not
   *       store an item.)
   *
   *  DO NOT CHANGE THE FOLLOWING FIELD DECLARATIONS.
   */

  protected DListNode head;
  protected int size;
  protected DListNode tail;

  /* DList invariants:
   *  1)  head != null.
   *  2)  For any DListNode x in a DList, x.next != null.
   *  3)  For any DListNode x in a DList, x.prev != null.
   *  4)  For any DListNode x in a DList, if x.next == y, then y.prev == x.
   *  5)  For any DListNode x in a DList, if x.prev == y, then y.next == x.
   *  6)  size is the number of DListNodes, NOT COUNTING the sentinel,
   *      that can be accessed from the sentinel (head) by a sequence of
   *      "next" references.
   */

  /**
   *  newNode() calls the DListNode constructor.  Use this class to allocate
   *  new DListNodes rather than calling the DListNode constructor directly.
   *  That way, only this method needs to be overridden if a subclass of DList
   *  wants to use a different kind of node.
   *  @param item the item to store in the node.
   *  @param prev the node previous to this node.
   *  @param next the node following this node.
   */
  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
    return new DListNode(item, prev, next);
  }

  /**
   *  DList() constructor for an empty DList.
   */
  public DList() {
    //  Your solution here.
	  head=null;
	  size=0;
  }

  /**
   *  isEmpty() returns true if this DList is empty, false otherwise.
   *  @return true if this DList is empty, false otherwise. 
   *  Performance:  runs in O(1) time.
   */
  public boolean isEmpty() {
    return size == 0;
  }

  /** 
   *  length() returns the length of this DList. 
   *  @return the length of this DList.
   *  Performance:  runs in O(1) time.
   */
  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts an item at the front of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertFront(Object item) {
    // Your solution here.
	  if(head==null){
		  head=newNode(item,null,null);
		  head.next=head;
		  head.prev=head;
		   tail=head;
		  size++;
	  }
	  else{
		  DListNode currentNode=head;
		  head=newNode(item,tail,currentNode);
		  currentNode.prev=head;
		  size++;
	  }
  }

  /**
   *  insertBack() inserts an item at the back of this DList.
   *  @param item is the item to be inserted.
   *  Performance:  runs in O(1) time.
   */
  public void insertBack(Object item) {
    //.
	  if(head==null){
		  head=newNode(item,head,head);
		  tail=head;
		  size++;
	  }
	  else{
		  DListNode currentNode=tail;
		  tail=newNode(item,currentNode,head);
	  }
	  
  }

  /**
   *  front() returns the node at the front of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the front of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode front() {
    // Your solution here.
	  if(this.head==null){
		  return null;
	  }
	  DListNode frontNode=head;
	  return frontNode;
  }

  /**
   *  back() returns the node at the back of this DList.  If the DList is
   *  empty, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @return the node at the back of this DList.
   *  Performance:  runs in O(1) time.
   */
  public DListNode back() {
    // Your solution here.
	  if(this.head==null){
		  return null;
	  }
	  
		  DListNode lastNode=tail;
		  return lastNode;
	  
  }

  /**
   *  next() returns the node following "node" in this DList.  If "node" is
   *  null, or "node" is the last node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose successor is sought.
   *  @return the node following "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode next(DListNode node) {
    // Your solution here.
	 if(node.equals(null)||node.equals(tail)){
		 return null;
	 }
	 DListNode nextNode=node.next;
	 return nextNode;
  }

  /**
   *  prev() returns the node prior to "node" in this DList.  If "node" is
   *  null, or "node" is the first node in this DList, return null.
   *
   *  Do NOT return the sentinel under any circumstances!
   *
   *  @param node the node whose predecessor is sought.
   *  @return the node prior to "node".
   *  Performance:  runs in O(1) time.
   */
  public DListNode prev(DListNode node) {
    // Your solution here.
	  if(node.equals(null)||node.equals(head)){
		  return null;
	  }
	  DListNode prevNode=node.prev;
	  return prevNode;
  }

  /**
   *  insertAfter() inserts an item in this DList immediately following "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item after.
   *  Performance:  runs in O(1) time.
   */
  public void insertAfter(Object item, DListNode node) {
    // Your solution here.
	 DListNode nextNode=node.next;
	  DListNode currentNode=newNode(item,node,nextNode);
	  node.next=currentNode;
	  nextNode.prev=currentNode;
	  size++;
	  
  }

  /**
   *  insertBefore() inserts an item in this DList immediately before "node".
   *  If "node" is null, do nothing.
   *  @param item the item to be inserted.
   *  @param node the node to insert the item before.
   *  Performance:  runs in O(1) time.
   */
  public void insertBefore(Object item, DListNode node) {
    // Your solution here.
	  DListNode beforeNode=node.prev;
	  DListNode currentNode=newNode(item,beforeNode,node);
	  node.prev=currentNode;
	  beforeNode.next=currentNode;
	  size++;
  }

  /**
   *  remove() removes "node" from this DList.  If "node" is null, do nothing.
   *  Performance:  runs in O(1) time.
   */
  public void remove(DListNode node) {
    // Your solution here.
	  if(node.equals(this.tail)){
		  DListNode prevNode=node.prev;
		  DListNode firstNode=this.head;
		  prevNode.next=firstNode;
		  firstNode.prev=prevNode;
	  }
	  DListNode nextNode=node.next;
	  DListNode prevNode=node.prev;
	  prevNode.next=nextNode;
	  nextNode.prev=prevNode;
	  size--;
  }

  /**
   *  toString() returns a String representation of this DList.
   *
   *  DO NOT CHANGE THIS METHOD.
   *
   *  @return a String representation of this DList.
   *  Performance:  runs in O(n) time, where n is the length of the list.
   */
  public String toString() {
    String result = "[  ";
    DListNode current = head.next;
    while (current != head) {
      result = result + current.item + "  ";
      current = current.next;
    }
    return result + "]";
  }




public static void main(String args[]){
	DList list=new DList();
	list.insertFront(2);
	list.insertFront(4);
	list.insertFront(6);
	DListNode front=list.front();
	DListNode back=list.back();
	System.out.println(front.item);
	System.out.println(back.item);
	list.remove(back);
	DListNode back1=list.back();
	System.out.println(back1.item);
	list.insertAfter(0,back1);
	list.insertBefore(8, front);
	String s=list.toString();
	System.out.println(s);
	System.out.println("size: "+list.size);
	
}


}