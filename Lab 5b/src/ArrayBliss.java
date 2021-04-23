import java.util.Arrays;

public class ArrayBliss<T> {
	private Object[] internalArray;
	private int size = 0;
	private int MAXSIZE = 100;


	public ArrayBliss() {
		internalArray = new Object[MAXSIZE];
	}

	public void addItem(T item) {
		internalArray[size] = item;
		size++;
	}

	public void clear() {
		internalArray = new Object[MAXSIZE];
		size = 0;
	}

	public void expandArray(int i) {
		internalArray = Arrays.copyOf(internalArray, i);
	}

	public T getItemAtIndex(int i) {
		return (T) internalArray[i];
	}

	public String toString() {
		return Arrays.toString(internalArray);
	}
	
	/**
	 * Expands the memory allocated to ArrayBliss. 
	 */
	public void expandArray() {
		Object[] newArray = new Object[this.MAXSIZE*2];
		for (int i = 0; i < MAXSIZE; i++) {
			newArray[i] = this.internalArray[i];
		} 
		this.internalArray = newArray;
		this.MAXSIZE *= 2;
	}
	
	public static void main(String[] args) {
		ArrayBliss<String> stringArrayBliss = new ArrayBliss();
		System.out.println(stringArrayBliss);
		stringArrayBliss.addItem("CS");
		System.out.println(stringArrayBliss);
		stringArrayBliss.addItem("2110");
		System.out.println(stringArrayBliss);
		stringArrayBliss.addItem("Grade A");
		System.out.println(stringArrayBliss);
		String courseNumber = stringArrayBliss.getItemAtIndex(1);
		System.out.println(courseNumber);
		ArrayBliss<Integer> intArrayBliss = new ArrayBliss();
		System.out.println(intArrayBliss);
		intArrayBliss.addItem(1);
		System.out.println(intArrayBliss);
		intArrayBliss.addItem(432);
		System.out.println(intArrayBliss);
		intArrayBliss.clear();
		System.out.println(intArrayBliss);
		intArrayBliss.addItem(55);
		System.out.println(intArrayBliss);
		intArrayBliss.addItem(77);
		System.out.println(intArrayBliss);
		int x = intArrayBliss.getItemAtIndex(0);
		System.out.println(x);	
	}

}
