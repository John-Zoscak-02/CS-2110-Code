import java.util.ArrayList;
import java.util.stream.Collectors;

public class Feed {
    private ArrayList<Meme> memes;

    /**
     * Default constructor for java.Feed. Instatiates an empty array list which will keep track of memes shared to this feed.
     */
    public Feed() {
        memes = new ArrayList<>();
    }

    /**
     * @return Returns this Feeds memes. in the memes list
     */
    public ArrayList<Meme> getMemes() {
        return memes;
    }

    /**
     * @param memes Provides this feed with a new set of memes with the provided parameter "memes"
     */
    public void setMemes(ArrayList<Meme> memes) {
        this.memes = memes;
    }

    /**
     * Gets a meme from this feeds meme list that has not been viewed by or created by the given user
     *
     * @param user user for reference against who created a particular meme
     * @return returns a meme in the feed that has not been viewed or created by the given user. Returns null if no such meme exists.
     */
    public Meme getNewMeme(User user) {
        for ( Meme meme : memes ) {
            if (!user.getMemesViewed().contains(meme) && !meme.getCreator().equals(user)) {
                return meme;
            }
        }
        return null;
    }

    /**
     * Returns a string of the memes held by this feed where each line represents one meme in the format "backgroundImage‘caption'overallRating[+1:the number of +1 ratings,-1:the number of -1 ratings]"
     * Leaves an empty line at the end of the String.
     *
     * @return String representation of this feed in the format above.
     */
    public String toString() {
//        String string = "";
//        for ( java.Meme meme : memes ) {
//            string += meme.toString() + "\n";
//        }
//        return string;

        return memes.stream().map(meme -> {return meme.toString() + "\n";}).collect(Collectors.joining());
    }
}
