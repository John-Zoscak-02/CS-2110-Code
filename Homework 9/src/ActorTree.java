/**
 * <p>This is the class you will complete - fill in all the missing method implementations</p>
 * 
 *  * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 * 
 * @author Your friendly CS professors
 *
 */
public class ActorTree {
	/**
	 * ActorTree has only one property, the root node
	 */
	Node root;

	/**
	 * Initialize the root node in the default constructor
	 */
	public ActorTree() {
		root = null;
	}

	/**
	 * 
	 * @param name
	 *            - the name to find
	 * @return the matching Actor object
	 */
	public Actor find(String name) {
		return find(name, root);
	}

	private Actor find(String name, Node node) {
		if (node == null) {
			return null;
		}
		else if (name.equals(node.actor.getPrimaryName())) {
			return node.actor;
		}
		else if (name.compareTo(node.actor.getPrimaryName()) < 0) {
			return find(name, node.left);
		}
		else {
			return find(name,node.right);
		}
	}

	/**
	 * 
	 * @return an int representing 1 for each node in the tree
	 * 
	 */
	public int size() {
	    return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		}
		else {
			return 1 + size(node.right) + size(node.left);
		}
	}

	/**
	 * 
	 * @return an int representing the maximum height of any branch
	 */
	public int height() {
		return height(root);
	}

	private int height( Node node ) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}

	/**
	 * an empty tree is one with no data
	 * 
	 * @return boolean - True if the tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * 
	 * @param a
	 *            - an Actor object
	 * @return boolean - True if the element was inserted
	 */
	public boolean insert(Actor a) {
		return insert(a, root);
	}

	private boolean insert(Actor a, Node node) {
		if (node == null) {
			node = new Node(a);
			return true;
		}
		else if (a.getPrimaryName().equals(node.actor.getPrimaryName())) {
			return false;
		}
		else if (a.getPrimaryName().compareTo(node.actor.getPrimaryName()) < 0) {
			return insert(a, node.left);
		}
		else {
			return insert(a, node.right);
		}
	}
	
	/**
	 * In order Traversal
	 *
	 * @return a String representing the in-order traversal of this tree
	 */
	public String inOrder() {
		return inOrder(root);
	}

	private String inOrder(Node node) {
		if (node == null) {
			return "";
		}
		return inOrder(node.left) + node.actor.toString() + "\n" + inOrder(node.left);
	}

	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 * 
	 * @author Your friendly CS Professors
	 *
	 */
	class Node {
		Actor actor;
		Node left;
		Node right;

		/**
		 * default constructor
		 */
		public Node() {
			actor = new Actor();
			left = null;
			right = null;
		}

		/**
		 * Constructor that takes an Actor object
		 * 
		 * @param a
		 *            - an Actor left and right children are initialized to null
		 */
		public Node(Actor a) {
			actor = a;
			left = null;
			right = null;
		}

		/**
		 * The size method is recursive
		 * 
		 * @return an int to represent a count of all nodes
		 */
		public int size() {
			if (left == null) {
				if (right == null) {
					return 1;
				}
				return 1 + right.size();
			}
			else if (right == null) {
				return 1 + left.size();
			}
			return 1 + left.size() + right.size();
		}

		/**
		 * The height method is recursive
		 * 
		 * @return an int to represent the maximum height of right or left child nodes,
		 *         plus 1 for the current node
		 */
		public int height() {
			if (left == null) {
				if (right == null) {
					return 1;
				}
				return 1 + right.height();
			}
			else if (right == null) {
				return 1 + left.height();
			}
			return 1 + Math.max(left.height(), right.height());
		}
		
		/**
		 * The insert method finds the best place to insert the Actor argument
		 * 
		 * @param a
		 *            - an Actor to insert
		 * @return boolean - True if the Actor argument was added, false otherwise
		 */
		public boolean insert(Actor a) {
			if (a.compareTo(actor) == 0) {
				return false;
			}
			else if (a.compareTo(actor) < 0) {
				if (left == null) {
					left = new Node(a);
					return true;
				}
				return left.insert(a);
			}
			else {
				if (right == null) {
					right = new Node(a);
					return true;
				}
				return right.insert(a);
			}
		}

		/**
		 * The find method returns an Actor object with a matching name
		 * 
		 * @param name
		 *            - the name to search for
		 * @return the searched for Actor, or null
		 */
		public Actor find(String name) {
			return null;
		}
		
			
	    /**
	     * In order Traversal
	     *
	     * @return a String representing the in-order traversal of the subtree rooted at this node
	     */
		public String inOrder() {
			return null;
		}
	}
	
}
