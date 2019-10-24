package chp4;

public class LinkedList<T> {
	private Node<T> head;
	
//	Insert a new node at the head
	public void insertAtHead(T data) {
		Node<T> newNode = new Node<T>(data);
		// Point new not to the current head of the LinkedList
		newNode.setNextNode(this.head);
		//point head of LinkedList to the new node;
		this.head = newNode;
	}
	
	// Return length of LinkedList
	public int length() {
		int length = 0;
		
		//set current node to list head node
		Node<T> current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	// Remove head node, set head to the next node
	public void deleteFromHead() {
		this.head = this.head.getNextNode();
		 
	}
	
	//ADD FIND NODE METHOD HERE!!
	public Node<T> find(T data){
		Node<T> current = this.head;
		while (current != null) {
			if(current.getClass().equals(data)) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;		
	}
	
	
	// Check to see if linkedList is empty by checking if the first node is null
	public Boolean isEmpty() {
		return this.head == null;
	}
	
	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.toString() + ", ";
			current = current.getNextNode();
		}
		result += "}";
		return result;
	}
}
