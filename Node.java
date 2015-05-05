package collections;

public class Node<T> {
	public Node<T> left;
	public Node<T> right;
	private T val;
	public Node<T> next;
	
	public Node(T val, Node<T> left, Node<T> right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public T getValue() {
		return val;
	}
	
	public String toString() {
		return "" + (int)getValue();
	}
}
