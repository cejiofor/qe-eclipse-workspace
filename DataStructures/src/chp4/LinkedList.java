package chp4;

public class LinkedList {
	private Node head;
	
//	Insert a new node at the head
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		// Point new not to the current head of the LinkedList
		newNode.setNextNode(this.head);
		//point head of LinkedList to the new node;
		this.head = newNode;
	}
	
	public int length() {
		int length = 0;
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	public void deleteFromHead() {
		this.head = this.head.getNextNode();
		 
	}
	
	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		return result;
	}
}
