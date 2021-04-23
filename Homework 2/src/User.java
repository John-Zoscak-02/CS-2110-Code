import java.util.ArrayList;
import java.util.Arrays;

public class User {
    private String userName;
    private ArrayList<Meme> memesCreated = new ArrayList<Meme>();
    private ArrayList<Meme> memesViewed = new ArrayList<Meme>();

    public User() {}
    public String getUserName() {return null;}
    public void setUserName(String userName) {}
    public ArrayList<Meme> getMemesCreated() {return null;}
    public void setMemesCreated(ArrayList<Meme> memesCreated) {}
    public ArrayList<Meme> getMemesViewed() {return null;}
    public void setMemesViewed(ArrayList<Meme> memesViewed) {}
    public void rateMeme(Meme meme, int rating) {}
    public Meme createMeme(BackgroundImage bgi, String string) {return null;}
    public boolean deleteMeme(Meme meme) {return false;}
    public void shareMeme(Meme meme, Feed feed) {}
    public void rateNextMemeFromFeed(Feed feed, int ratingScore) {}
    public double calculateReputation() {return 0d;}
    public String toString() {return null;}
    public boolean equals(Object object) {return false;}
}
