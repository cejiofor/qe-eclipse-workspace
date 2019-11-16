package com.perscholas.exercises;


/*Do not use the LinkedList class in Java for these exercises.
 * Create a Node class which includes the attributes:
 	* Object value
 	* Node nextNode
 * Create a SinglyLinkedList class that includes the attribute:
 	* Node head
 * Write a method to add a node to the linked lists
 * */

public class SinglyLinkedList {
	private Node head;

	public SinglyLinkedList(Node head) {
		super();
		this.head = head;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	public void insertAtHead(Object o) {
		Node newNode = new Node(o);
		newNode.setNextNode(this.head);
		this.setHead(newNode);
	}
	
	
}
