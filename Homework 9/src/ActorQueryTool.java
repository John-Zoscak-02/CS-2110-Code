import java.io.File;

/**
 * 
 * <p>This class, ActorQueryTool, runs the queries for you. If your computer has enough memory to
 * load the entire data set, you can search for ANY actor! The subject of your
 * search, Mr Wilson, is far enough down in the data file to provide an example of how much
 * faster the performance will be using Binary Search. </p>
 * 
 * <p>updated 4/18/2021
 * 
 * @author Your friendly CS professors</p>
 *
 */
public class ActorQueryTool {
	
	// use this value to limit the amount of data loaded into memory
	// (if your computer is low on memory and locks up when running, 1_000_000 is enough)
	final static int MAXIMUM_NUMBER_RECORDS = 1_000_000;
	final static String NAME_TO_FIND = "Rainn Wilson";

	public static void main(String[] args) {
		//Initialize the DataParser, which will read the file and load the data structures
		DataParser dp = new DataParser(new File("name.basics.tsv"), MAXIMUM_NUMBER_RECORDS);
		
		//System.currentTimeMillis() is a useful method for timing how long it takes to run an algorithm
		long startListSizeTime = System.currentTimeMillis();
		System.out.println(dp.getListDataStore().size() + " items in the list.");
		System.out.println("Calculating list size completed in " + (System.currentTimeMillis() - startListSizeTime) + "ms");

		// record the current time
		long startListQueryTime = System.currentTimeMillis();
		
		Actor a = new Actor();
		
		// search the list data structure sequentially
		for (int i = 0; i < dp.getListDataStore().size(); i++) {
			a = dp.getListDataStore().get(i);
			if (a.getPrimaryName().equals(NAME_TO_FIND)) {
				// we found the record, we can exit the loop with this data
				break;
			} else {
				// if we don't set our test value to null, the last item is returned as a match
				a=null;
			}
		}
		if (a == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found!");
			System.out.println(a);
		}
		
		System.out.println("Sequential search completed in " + (System.currentTimeMillis() - startListQueryTime) + "ms");

		// Binary Search Trees provide fast searching, but other methods like size() can take longer
		long startTreeSizeTime = System.currentTimeMillis();
		System.out.println(dp.getTreeDataStore().size() + " items in the tree.");
		System.out.println("Calculating tree size completed in " + (System.currentTimeMillis() - startTreeSizeTime) + "ms");
        System.out.println("Resulting BST has a height of " + dp.getTreeDataStore().height());

		// search the tree data structure with binary search
		long startTreeQueryTime = System.currentTimeMillis();
		Actor b = new Actor();
		b = dp.getTreeDataStore().find(NAME_TO_FIND);

		if (b == null) {
			System.out.println("Not found");
		} else {
			System.out.println("Found!");
			System.out.println(b);
		}
		
		System.out.println("Binary search completed in " + (System.currentTimeMillis() - startTreeQueryTime) + "ms");
		
		//this method should print out all the actors in order
		// You may want to set the number of items to search down to a smaller number
		//System.out.println(dp.getTreeDataStore().inOrder());
	}

}
