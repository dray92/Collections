package collections;

public class Stack {
	private Node top;
	private int size;
	
	public Stack() {
		size = 0;
		top = null;
	}
	
	public void push(Node<Integer> n) {
		size++;
		if(top == null) {
			top = n;
		} else {
			n.next = top;
			top = n;
		}
	}
	
	public Node pop() {
		if(size == 0)
			return null;
		size--;
		Node cur = top;
		top = top.next;
		cur.next = null;
		return cur;
	}
	
	public int getSize() {
		return size;
	}
}
