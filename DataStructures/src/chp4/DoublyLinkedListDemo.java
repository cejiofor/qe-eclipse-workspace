package chp4;

public class DoublyLinkedListDemo {

	public static void main(String[] args) {
		DoublyLinkedList integers = new DoublyLinkedList();
		
		integers.insertAtHead(13);
		integers.insertAtHead(3);
		integers.insertAtHead(43);
		integers.insertAtHead(56);
		integers.insertAtHead(29);
		integers.insertAtHead(10);
		
		System.out.println(integers);

	}

}
