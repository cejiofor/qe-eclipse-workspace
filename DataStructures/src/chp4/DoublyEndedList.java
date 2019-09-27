package chp4;

public class DoublyEndedList {
	private Node head;
	private Node tail;
	
	
	public void insertAtTail(int data) {
		Node newNode = new Node(data);
		// Check to see if the list is empty, if so set the head to the new node
		if (this.head == null){
			this.head = newNode;
		}
		// Check to see if the tail is not empty, if not set the 
		if (this.tail != null) {
			this.tail.setNextNode(newNode);
			this.tail = newNode;
		}
	}
	
	@Override
	public String toString() {
		String result = "{";
		Node current = this.head;
		while (current != null) {
			result += current.toString() + ",";
			current = current.getNextNode();
		}
		result += "}";
		return result;
	}
}
