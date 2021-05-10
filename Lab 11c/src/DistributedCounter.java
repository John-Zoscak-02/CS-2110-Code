
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DistributedCounter {

	public DistributedCounter() {

	}

	public static void main(String[] args) throws InterruptedException {
		DataGrid dataGrid = new DataGrid();
		// by default there should be 100 cells in our 10 x 10 grid
		System.out.println(dataGrid.zeroCount());
		// searching with three threads should mark 30 cells, leaving 70 empty
		
		TargetFinder tf1 = new TargetFinder(dataGrid);
		TargetFinder tf2 = new TargetFinder(dataGrid);
		TargetFinder tf3 = new TargetFinder(dataGrid);
		
		Thread t1 = new Thread(tf1);
		Thread t2 = new Thread(tf2);
		Thread t3 = new Thread(tf3);
		
		t1.start();
		t2.start();
		t3.start();
		
		
		// check our work by printing the zero count again. 
		// if all works as expected, the resulting zero count should be the number
		// of possible targets - ( the number of targets for each target finder * number of target finders )
		// 100 - ( 20 * 3 ) by default
		// did it work as expected?
		// fix it with a lock in the right place(s)
		while ( t1.isAlive() || t2.isAlive() || t3.isAlive()) {
			Thread.sleep(100);
		}
		System.out.println(dataGrid.zeroCount());

	}

}

class DataGrid {
	Lock checkCellLock = new ReentrantLock();
	final int GRID_DIMENSION_SIZE = 10;
	// a two-dimensional array holds our data points
	int[][] grid = new int[GRID_DIMENSION_SIZE][GRID_DIMENSION_SIZE];

	/**
	 * 
	 * @return the total possible number of cells in this DataGrid
	 */
	public int cellCount() {
		return GRID_DIMENSION_SIZE * GRID_DIMENSION_SIZE;
	}
	/**
	 * 
	 * @param p
	 * @return the value at Point p
	 */
	public int getCell(Point p) {
		return grid[p.getX()][p.getY()];
	}

	/**
	 * 
	 * @param p point to mark
	 */
	public void markTarget(Point p) {
		grid[p.getX()][p.getY()] = 1;
	}

	/**
	 * 
	 * @return the number of cells that contain a zero
	 */
	public int zeroCount() {
		int retval = 0;
		for (int i = 0; i < GRID_DIMENSION_SIZE; i++) {
			for (int p = 0; p < GRID_DIMENSION_SIZE; p++) {
				if (grid[i][p] == 0) {
					retval++;
				}
			}

		}
		return retval;
	}

	/**
	 * @return the gRID_DIMENSION_SIZE
	 */
	public int getGRID_DIMENSION_SIZE() {
		return GRID_DIMENSION_SIZE;
	}
	
}

class TargetFinder implements Runnable {
	DataGrid targetField;
	int numberOfTargetsToFind = 20; // default this to 20
	int possibleTargets;

	public TargetFinder(DataGrid targetField) {
		this.targetField = targetField;
		this.possibleTargets = targetField.cellCount();
	}

	@Override
	public void run() {
		// we'll use a random number generator to pick points at random
		Random r = new Random();
		// in this run method, choose a number of targets to return
		// look for targets until we find the desired number of targets or have searched
		// a number of times equal to the total possible number of targets

			for (int i = 0; i < numberOfTargetsToFind && i <= possibleTargets; i++) {
				// generate a point with two random x and y values
				Point t = new Point( r.nextInt(targetField.getGRID_DIMENSION_SIZE()), r.nextInt(targetField.getGRID_DIMENSION_SIZE()));
				targetField.checkCellLock.lock();
				try {
					if ( targetField.getCell(t) == 0 ) {
						// this is an open cell, the value is 0, we'll return it as a target
						targetField.markTarget(t);
					} else {
						// this isn't zero, we'll keep looking
						i--;
					}
				} finally {
					targetField.checkCellLock.unlock();
				}
			}
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public String toString() {
		return "Point: ("+x+","+y+")";
	}
	@Override
	public boolean equals(Object o) {
		if (o == null) { return false; }
		if (o == this) { return true; }
		if ( o instanceof Point) {
			Point otherPoint = (Point) o;
			if (this.x == otherPoint.x && this.y == otherPoint.y) {
				return true;
			}
		}
		return false;
	}
			
		
	
}