import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class User {
    private String userName;
    private ArrayList<Meme> memesCreated;
    private ArrayList<Meme> memesViewed;

    /**
     * This is the default constructor, Inititializes and declares all variables to their respective default
     */
    public User() {
        userName = new String();
        memesCreated = new ArrayList<Meme>();
        memesViewed = new ArrayList<Meme>();
    }

    /**
     * Initializes this user with a given username, sets other types to thier default because an newly created users should have no data
     * @param userName username for this instance of user
     */
    public User( String userName ) {
        this.userName = userName;
        memesCreated = new ArrayList<Meme>();
        memesViewed = new ArrayList<Meme>();
    }

    /**
     * @return grabs this user's userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName provides this user with a new username with the provided parameter "userName"
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return returns the memes created by this user
     */
    public ArrayList<Meme> getMemesCreated() {
        return memesCreated;
    }

    /**
     * @param memesCreated Provides this user with a new set of created memes with the provided parameter "memesCreated"
     */
    public void setMemesCreated(ArrayList<Meme> memesCreated) {
        this.memesCreated = memesCreated;
    }

    /**
     * @return returns the memes seen by this user
     */
    public ArrayList<Meme> getMemesViewed() {
        return memesViewed;
    }

    /**
     * @param memesViewed Provides this user with a new set of viewed memes with the provided parameter "memesViewed"
     */
    public void setMemesViewed(ArrayList<Meme> memesViewed) {
        this.memesViewed = memesViewed;
    }

    /**
     * Rates any given meme with the rating parameter. Calls on the Meme's addRating method during processing
     * Note: this method will only be successful if rating and meme are valid, rating must be -1, 0, 1
     *
     * @param meme meme to rate
     * @param rating rating to give the meme
     */
    public void rateMeme(Meme meme, int rating) {
        meme.addRating(new Rating(this, rating));
        memesViewed.add(meme);
    }

    /**
     * Instantiates a new meme with the given backgroundimage, and caption. Sets the creator to this user, and adds the new meme to the memesCreated List of this class.
     *
     * @param bgi Background image to be passed on to the meme object
     * @param caption Caption to be passed onto the meme object
     * @return Returns the new Meme
     */
    public Meme createMeme(BackgroundImage bgi, String caption) {
        Meme newMeme = new Meme(bgi, caption, this);
        memesCreated.add(newMeme);
        return newMeme;
    }

    /**
     * Deletes the given meme in found in the createdMemes list of this user. Will not work if the meme has been shared
     *
     * @param meme the meme that the caller wishes to delete
     * @return Returns whether or not the deletion was successful
     */
    public boolean deleteMeme(Meme meme) {
        return !meme.getShared() && memesCreated.remove(meme);
    }

    /**
     * Sets the shared value of the meme to true. Also adds this meme to the given feed.
     * Note: This is an unstable method, any user can set any meme to be shared, regardless of who owns it (if they have access to the Meme itself)
     *
     * @param meme meme to share
     * @param feed feed to add the given meme
     */
    public void shareMeme(Meme meme, Feed feed) {
        meme.setShared(true);
        ArrayList<Meme> tempMemeFeed = feed.getMemes();
        tempMemeFeed.add(meme);
        feed.setMemes(tempMemeFeed);
    }

    /**
     * Gets a meme from the feed that has not yet been viewed or created by this user. Rates it.
     *
     * @param feed Feed to get a new Meme from
     * @param ratingScore rating to give the next meme retrieved from the feed
     * @return returns whether or not the next meme from the feed has been successfully rated
     */
    public boolean rateNextMemeFromFeed(Feed feed, int ratingScore) {
        Meme tempMeme = feed.getNewMeme(this );
        if (tempMeme != null) {
            tempMeme.addRating(new Rating(this, ratingScore));
            memesViewed.add(tempMeme);
            return true;
        }
        return false;
    }

    /**
     * Calculates reputation by finding the average of the overall ratings of this user's created memes.
     *
     * @return Calculated reputation
     */
    public double calculateReputation() {
        if (memesCreated.size() == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for ( Meme m : memesCreated ) {
            sum += m.calculateOverallRating();
        }
        return sum / memesCreated.size();
    }

    /**
     * creates a string representation of this user in the format: "username has rated (numberofmemesviewed) memes, (reputation)"
     *
     * @return String representation of this user
     */
    public String toString() {
//        return String.format("%s has rated %d memes, %d", userName, memesViewed.size(), calculateReputation());
        return userName + " has rated (" + memesViewed.size() + ") memes, (" + calculateReputation() + ")";
    }

    /**
     * determines whether this user and the given object are the same user. Bases this decision on the username alone
     *
     * @param o object to compare this user to
     * @return returns whether or not this user and the given object are the same.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName.equals(user.getUserName());
    }

}
