package collections;

public class BinarySearchTree {
	private Node<Integer> root;
	
	public Node<Integer> getRoot() {
		return root;
	}
	
	public void createBST(int[] arr) {
		for (int val: arr) 
			add(val);
	}
	
	public void add(int val) {
		if(root == null)
			root = new Node<Integer>(val, null, null);
		else
			add(root, val);
	}
	
	public void add(Node<Integer> node, int val) {
		int nodeValue = (int)node.getValue();
		if(val < nodeValue) {
			if(node.left == null) {
				node.left = new Node<Integer>(val, null, null);
			} else {
				add(node.left, val);
			}
		} else if(nodeValue < val) {
			if(node.right == null) {
				node.right = new Node<Integer>(val, null, null);
			} else {
				add(node.right, val);
			}
		}
	}
	
	public void display() {
		System.out.print("Data from Binary Search Tree: [");
		displayNoRecursion(root);
		System.out.println("]");
	}
	
	private void traverse(Node<Integer> root){ // Each child of a tree is a root of its subtree.
	    if (root.left != null){
	    	traverse(root.left);
	    }
	    System.out.print(root.getValue() + ", ");
	    if (root.right != null){
	    	traverse(root.right);
	    }
	}
	
	private void displayNoRecursion(Node<Integer> root) {
		if(root != null) {
			Node<Integer> cur = root, pre;
			while(cur != null) {
				if(cur.left == null) {
					System.out.print(cur.getValue() + ", ");
					cur = cur.right;
				} else {
					/* inorder predecessor */
					pre = cur.left; 
					while(pre.right != null && pre.right != cur)
						pre = pre.right;
					
					/* making cur right child of inorder predecessor */
					if(pre.right == null) {
						pre.right = cur;
						cur = cur.left;
					}
					
					/* revert changes in if.. to restore tree [fix right child 
					 * of predecessor] */
					else {
						pre.right = null;
						System.out.print(cur.getValue() + ", ");
						cur = cur.right;
					}
				}
			}
		}
	}
	
	public Node<Integer> findNode(int val) {
		return findNode(root, val);
	}
	
	private Node<Integer> findNode(Node<Integer> cur, int val) {
		if(cur == null)
			return null;
		int curVal = (int)cur.getValue();
		if(curVal == val)
			return cur;
		if(val > curVal)
			return findNode(cur.right, val);
		else
			return findNode(cur.left, val);
	}
	
	public int getHeight() {
		return getHeight(root);
	}

	private int getHeight(Node<Integer> root) {
		if(root == null)
			return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}
	
	public Node<Integer> findLowestCommonAncestor(int val1, int val2) {
		return findLowestCommonAncestor(root, val1, val2);
	}

	private Node<Integer> findLowestCommonAncestor(Node<Integer> root, int val1, int val2) {
		while(root != null) {
			int value = (int)root.getValue();
			if(val1 < value && val2 < value) {
				root = root.left;
			} else if (val1 > value && val2 > value) {
				root = root.right;
			} else {
				return root;
			}	
		}
		return null; // for empty tree
	}
}
