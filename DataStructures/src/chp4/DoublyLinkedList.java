package chp4;

public class DoublyLinkedList {
	private DoublyLinkedNode head;
	private Node tail;
	
	public void insertAtHead(int data) {
		DoublyLinkedNode newNode = new DoublyLinkedNode(data);
		newNode.setNextNode(this.head);
		if (this.head != null) {
			this.head.setPreviousNode(newNode);
		}
		this.head = newNode;
	}
	
	
}
