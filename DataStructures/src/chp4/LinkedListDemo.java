package chp4;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(list.isEmpty());
		list.insertAtHead(5);
		list.insertAtHead(10);
		list.insertAtHead(15);
		list.insertAtHead(19);
		list.insertAtHead(2);
		list.insertAtHead(20);
		System.out.println(list.toString());
		System.out.println(list.isEmpty());
	}

}
