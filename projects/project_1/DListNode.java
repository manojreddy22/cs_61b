package projects.project_1;

public class DListNode {
 
	DListNode next;
	DListNode prev;
	int[] value;
	
	
	
	DListNode(int[] val,DListNode next,DListNode prevNode){
		this.value=val;
		
		this.next=next;
		this.prev=prevNode;
	}
	
	
	
	DListNode(int[] val){
		this( val,null,null);
	}
	
}
