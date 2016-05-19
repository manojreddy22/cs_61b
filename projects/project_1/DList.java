package projects.project_1;

public class DList {

    DListNode head;
    DListNode tail;
	private int size;
	
	
	DList(){
	head=null;
	tail=null;
	size=0;
	}
	
	public int length(){
		return size;
	}
	
	
	
	
	public void insertFront(int value[]){
		if(head==null){
		head=new DListNode(value);
		tail=head;
		size++;
		}
		else{
			DListNode currentNode=head;
			head=new DListNode(value);
			head.next=currentNode;
			currentNode.prev=head;
			size++;
		}
	}
	
	
	public void insertEnd(int value[]){
		if(head==null){
			head=new DListNode(value);
			tail=head;
			size++;
			}
			else{
				DListNode currentNode=this.head;
				head=new DListNode(value);
				head.next=currentNode;
				currentNode.prev=head;
				size++;
			}
	}
	
	
}
