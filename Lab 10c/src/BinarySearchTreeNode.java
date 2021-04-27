
/**
 * Binary Tree Node
 * 
 * Tree node that has two children: left and right
 *
 * Used for Binary Search Tree (BST) activity
 *
 * @param <T> The type of data this tree node stores
 */

public class BinarySearchTreeNode<T> {

    /**
     * Reference pointer to the left subtree
     */
    private BinarySearchTreeNode<T> left;

    /**
     * Reference pointer to the right subtree
     */
    private BinarySearchTreeNode<T> right;

    /**
     * Data stored at this node
     */
    private T data;

    /**
     * Default Constructor [1]
     * 
     * Creates a binary tree node with null data and null children
     */
    public BinarySearchTreeNode(){
        this(null,null,null); // calls full Constructor [3] passing three null values; thus assigning all to null
    }

    /**
     * Data-only Constructor [2]
     * 
     * Creates a binary tree node with the given data and null children
     * 
     * @param theData The data to store at this node
     */
    public BinarySearchTreeNode(T theData){
        this(theData,null,null); // calls full Constructor [3] where left and right values are null
    }							 // thus: this.data = theData; this.left = null; this.right = null; 


    /**
     * Full Constructor [3]
     * 
     * Creates a binary tree node with the given data and child reference pointers
     * 
     * @param theData The data to store at this node
     * @param leftChild A reference pointer to the left subtree
     * @param rightChild A reference pointer to the right subtree
     */
    public BinarySearchTreeNode(T theData, BinarySearchTreeNode<T> leftChild, BinarySearchTreeNode<T> rightChild){
        this.data = theData;
        this.left = leftChild;
        this.right = rightChild;
    }


    /**
     * Left Child/Subtree getter
     * 
     * @return A reference pointer to the root of the left subtree
     */
    public BinarySearchTreeNode<T> getLeft() {
        return this.left;
    }

    /**
     * Left Child/Subtree Setter
     * 
     * @param left A reference pointer to the new left subtree's root node
     */
    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    /**
     * Right Child/Subtree getter
     * 
     * @return A reference pointer to the root of the right subtree
     */
    public BinarySearchTreeNode<T> getRight() {
        return this.right;
    }

    /**
     * Right Child/Subtree Setter
     * 
     * @param left A reference pointer to the new right subtree's root node
     */
    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

    /**
     * Get the data at this node
     * 
     * @return The data stored at this node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Set the data at this node
     * 
     * @param data The data to be stored at this node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * toString method
     * (Written in a unique way - can you tell what it represents?)
     */
    @Override
    public String toString() {
        String retVal = "";
        if (this.left != null)
            retVal += this.left.toString(); // recursive call on left
        if (this.right != null) 
            retVal += this.right.toString(); // recursive call on right
        retVal += "("+this.data+")"; // add this node's data
        return retVal;
    }


    /**
     * Main method
     * 
     * Your code should go here
     * 
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

		// Create a BinarySearchTreeNode that holds data of type Integer
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<Integer>(6);
		// Create all the other nodes...

        BinarySearchTreeNode<Integer> node4 = new BinarySearchTreeNode<Integer>(4);
        root.setLeft(node4);

        BinarySearchTreeNode<Integer> node3 = new BinarySearchTreeNode<Integer>(3);
        node4.setLeft(node3);

        BinarySearchTreeNode<Integer> node5 = new BinarySearchTreeNode<Integer>(5);
        node4.setRight(node5);

        BinarySearchTreeNode<Integer> node8 = new BinarySearchTreeNode<Integer>(8);
        root.setRight(node8);

        BinarySearchTreeNode<Integer> node9 = new BinarySearchTreeNode<Integer>(9);
        node8.setRight(node9);

        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<Integer>(1);
        node3.setLeft(node1);

        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<Integer>(2);
        node1.setRight(node2);

        //Print the tree using toString() method (starting at the root of the tree) 
        System.out.println("Printing the tree:");
        System.out.println(root.toString());
		//Check your output matches our output (see in-class activity!) 
    }

}
