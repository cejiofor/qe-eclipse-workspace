package com.perscholas.exercises;


/*Do not use the LinkedList class in Java for these exercises.
 * Create a Node class which includes the attributes:
 	* Object value
 	* Node nextNode
 * Create a SinglyLinkedList class that includes the attribute:
 	* Node head
 * Write a method to add a node to the linked lists
 * Write a method to remove a node from the linked list
 * 
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
	
	// Remove head node, set head to the next node
	public void deleteFromHead() {
		this.head = this.head.getNextNode();
		 
	}
	
	//ADD FIND NODE METHOD HERE!!
	public Node find(Object obj){
		Node current = this.head;
		while (current != null) {
			if(current.getClass().equals(obj.getClass())) {
				return current;
			}
			current = current.getNextNode();
		}
		return null;		
	}
	
	public Object remove(Node removed) {
		Object removeValue = removed.getValue();
		Node current = this.head;
		while(current != null) {
			//Check if removed is @ headcure
				if (removed.equals(current)) {
					Object removedData = current.getValue();
					deleteFromHead();
					return removedData;
				}
				// create a copy of head 
				// set head to head.next
				// return copy of head
			//Check if removed is btwn
				else if (removed.equals(current.getNextNode())) {
					Node nextNextNode = current.getNextNode().getNextNode();
					Object removedData = current.getNextNode().getValue();
					current.setNextNode(nextNextNode);
					return removedData;
				}
				// create pointer to node befre
				// set current to node before @pointer
				// set pointer.next to current.next
				// return current
			//Check if removed is @tail
				// 
		}
		return null;
	}

}
