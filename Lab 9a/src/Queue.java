/*
Name:
Computing ID:

*/


import java.util.Arrays;

public class Queue {

	final int INITIAL_SIZE = 10;
	String[] elements;
	int currentSize, head, tail;
	
	public Queue(){
		this.elements = new String[this.INITIAL_SIZE];
		this.currentSize = this.head = this.tail = 0;
	}
	
	public void add(String s){
		// TODO: Complete this method to implement the add() method for a Queue
        growIfNecessary();
        elements[tail] = s;
        tail++;
        currentSize++;
	}
	
	public String remove(){
		// TODO: Complete this method to implement the remove() method for a Queue
		if (elements[head] != null) {
			String out = elements[head];
			elements[head] = null;
			head++;
			currentSize--;
			return out;
		}
		return null;
	}
	
	private void growIfNecessary(){
		if(tail == elements.length){
			String[] newElements = new String[2*elements.length];
			for(int i = 0; i < elements.length; i++){
				newElements[i] = elements[(head+i)%elements.length];
			}
			elements = newElements;
			head = 0;
			tail = currentSize;
		}
	}
	
	public static void main(String[] args) {
        // TODO: Use main-method testing to test your code!
        // Optional suggestion: Write a print method to show the contents of the queue and maybe even your pointers
		Queue queue = new Queue();
		System.out.println(Arrays.toString(queue.elements));
		for (int i = 0; i < 30; i++) {
			String str = "" + i;
			if (Math.random() >= .5) {
				queue.add(str);
				System.out.println("Added: " + str );
			}
			else {
				System.out.println("Removed: " + queue.remove());
			}
			System.out.println(Arrays.toString(queue.elements));
		}
	}

}
