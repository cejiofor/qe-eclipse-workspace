package com.perscholas.exercises;


/*Do not use the LinkedList class in Java for these exercises.
 * Create a Node class which includes the attributes:
 	* Object value
 	* Node nextNode
 * Create a SinglyLinkedList class that includes the attribute:
 	* Node head
 * Write a method to add a node to the linked lists
 * Write a method to remove a node from the linked list
 * Write a method to insert a node into the linked list after a specific value
 * Write a method for a singly-linked list to find the midpoint of the list.
 * If the list has an even number of nodes then the midpoint will be the last node of the first half of the list
 * Write a method for a singly-linked list that will find the nth node from the end.
 * DUAL POINTERS
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
	
	public void insertAtHead(Object obj) {
		Node newNode = new Node(obj);
		// Point new not to the current head of the LinkedList
		newNode.setNextNode(this.head);
		//point head of LinkedList to the new node;
		this.head = newNode;
	}
	
	// Check to see if linkedList is empty by checking if the first node is null
	public Boolean isEmpty() {
		return this.head == null;
	}
	
	// Return length of LinkedList
	public int length() {
		int length = 0;
		
		//set current node to list head node
		Node current = this.head;
		while (current != null) {
			length++;
			current = current.getNextNode();
		}
		return length;
	}
	
	// Find object in list and return node
	public Node find(Object obj){
		Node current = this.head;
		while (current != null) {
			// if(current.getClass().equals(obj.getClass())) {
			// 	return current;
			// }
			if (current.getValue().equals(obj)){
				return current;
			}
			current = current.getNextNode();
		}
		return null;		
	}
	
	public void remove(Object obj) {
		Node current = this.head;
		Node prev = null;
		//Check if removed is at head node
		if (current.getValue().equals(obj)) {
			prev = this.head;
			this.setHead(current.getNextNode());
			return;
		}
		while(current != null) {
			prev = current;
			current = current.getNextNode();
			if (current.getValue().equals(obj)) {
				prev.setNextNode(current.getNextNode());
				return;
			}
		}
	}

	public void insertAtValue(Object value){
		Node prev = this.find(value);
		Node next = prev.getNextNode();
		Node newNode = new Node(value);
		prev.setNextNode(newNode);
		newNode.setNextNode(next);
	}

	public Node returnMiddle(){
		int length = this.length();
		int mid = length/2;
		Node current = this.head;
		int currIndex = 0;

		if (length%2 != 1){
			while(currIndex <= mid){
				current = current.getNextNode();
			}
		}
		else {
			while(currIndex <= mid+1){
				current = current.getNextNode();
			}
		}
		return current;
	}

}
