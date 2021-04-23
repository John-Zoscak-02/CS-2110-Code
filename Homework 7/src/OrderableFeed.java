import java.util.Collections;

public class OrderableFeed extends Feed {

    /**
     * Default constructor for OrderableFeed just calls on the parent constructor
     */
    public OrderableFeed () {
        super();
    }

    /**
     * Sorts this feed's meme list in the natural order for memes
     */
    public void sortByCaption() {
        Collections.sort(getMemes());
    }

    /**
     * Sorts this feed's meme list in custom order with rating at the highest priority
     */
    public void sortByRating() {
        Collections.sort(getMemes(), new CompareMemeByRating() );
    }

    /**
     * Sorts this feed's meme list in custom order with creator at the highest priority
     */
    public void sortByCreator() {
        Collections.sort(getMemes(), new CompareMemeByCreator() );
    }
}