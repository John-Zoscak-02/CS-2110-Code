
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
   Counts how many words in a file.
 */
public class WordCountRunnable implements Runnable {
    private String filename;

    /**
      Constructs a WordCountRunnable object with a file name.
      @param aFilename the file name that needs to count words
     */
    public WordCountRunnable(String aFilename) {
        filename = aFilename;
    }

    public void run() {
        //add your code here:
        int counter = 0;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext() && scanner.next().length() > 0) {
                counter++;
            }
            System.out.println("Number of words in " + filename + " is: " + counter);
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Could not locate given file!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // hints:
        // initialize a counter
        // create Scanner - can use, ... new Scanner(new FileInputStream(filename))
        // don't forget try-catch	  
        // while loop 
        //      count individual words
        // what are you going to catch??
        // print statement of the format:  filename: wordCount
    }
}