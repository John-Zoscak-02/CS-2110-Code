import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class UserTest {

    private static BackgroundImage backgroundImage1;
    private static BackgroundImage backgroundImage2;
    private static BackgroundImage backgroundImage3;
    private static BackgroundImage backgroundImage4;
    private static BackgroundImage backgroundImage5;
    private static BackgroundImage backgroundImage6;
    private static BackgroundImage[] backgroundImages;

    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static User[] users;

    private static Meme empty;

    private static Rating downvote;
    private static Rating upvote;
    private static Rating abstain;
    private static Rating[] ratings;

    private static OrderableFeed feed;

    private static Meme[] memes;

    @Before
    public void SetUp() {
        backgroundImage1 = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Picture of morpheus from Matrix holding out a red and blue pill");
        backgroundImage2 = new BackgroundImage("backgroundimage2filename", "How bots laugh", "Image of Joquain Phoenix in his role as Joker,laughing maniacally");
        backgroundImage3 = new BackgroundImage("backgroundimage3filename", "Scared dog", "Picture of a dog with a hilarious expression");
        backgroundImage4 = new BackgroundImage("backgroundimage4filename", "Frustrated cat", "Dramatic foreplay between two people and a cat looks at them with a frustrated expression");
        backgroundImage5 = new BackgroundImage("backgroundimage5filename", "red or blue button", "Image of superhero wiping sweat off his forehead, looking at a red and blue button");
        backgroundImage6 = new BackgroundImage("backgroundimage6filename", "First time", "Image of man with noose around neck, looking into the camera");
        backgroundImages = new BackgroundImage[]{backgroundImage1, backgroundImage2, backgroundImage3, backgroundImage4, backgroundImage5, backgroundImage6};

        user1 = new User("MemeLord" );
        user2 = new User( "NoobMaster" );
        user3 = new User( "Billybob" );
        user4 = new User( "Willy" );
        users = new User[]{user1, user2, user3, user4};

        downvote = new Rating(user2, -1);
        upvote = new Rating(user1, 1);
        abstain = new Rating(user1, 0);
        ratings = new Rating[]{downvote, upvote, abstain};

        feed = new OrderableFeed();

        user1.createMeme(backgroundImage1, "Meme caption A");
        user1.createMeme(backgroundImage3, "Meme caption B");
        user2.createMeme(backgroundImage2, "Meme caption C");
        user2.createMeme(backgroundImage4, "Meme caption D");
        user2.createMeme(backgroundImage5, "Meme caption E");
        user2.createMeme(backgroundImage6, "Meme caption F");
        user3.createMeme(backgroundImage1, "Meme caption G");
        user3.createMeme(backgroundImage2, "Meme caption H");
        user4.createMeme(backgroundImage5, "Meme caption I");
        user4.createMeme(backgroundImage6, "Meme caption J");

        Meme[] temp = new Meme[100];
        int i = 0;
        for (User user : users) {
            for (Meme meme : user.getMemesCreated()) {
                user.shareMeme(meme, feed);
                temp[i] = meme;
                i++;
            }
        }
        memes = Arrays.copyOf(temp, i);
    }

    /////// Test setMemesCreated
    @Test
    public void setMemesCreatedTest() {
        ArrayList<Meme> memesCreated = new ArrayList<>(Arrays.asList(memes[0], memes[2], memes[4], memes[6]));
        user1.setMemesCreated(memesCreated);
        assertEquals(memesCreated, user1.getMemesCreated());

        memesCreated = new ArrayList<>();
        user1.setMemesCreated(memesCreated);
        assertEquals(memesCreated, user1.getMemesCreated());
    }

    //////// Test setUsername
    @Test
    public void setUsernameTest() {
        user1.setUserName("Johnnyboi");
        assertEquals("Johnnyboi", user1.getUserName());

        user1.setUserName("");
        assertEquals("", user1.getUserName());
    }

    //////// Test setMemesViewed
    @Test
    public void testSetMemesViewed1() {
        ArrayList<Meme> memesViewed = new ArrayList<>(Arrays.asList(memes[0], memes[2], memes[4], memes[6]));
        user1.setMemesCreated(memesViewed);
        assertEquals(memesViewed, user1.getMemesCreated());

        memesViewed = new ArrayList<>();
        user1.setMemesCreated(memesViewed);
        assertEquals(memesViewed, user1.getMemesCreated());
    }


    //////// Test getMemesViewed and rateNextMemeFromFeed
    @Test
    public void testGetMemesViewed() {
        for (int i = 0; i < feed.getMemes().size()-3; i++) {
            user1.rateNextMemeFromFeed(feed, ratings[(int)(Math.random()*3)].getScore());
            if (feed.getMemes().subList(0, i).equals(user1.getMemesViewed())) {
                fail("getting the memes, or rating the next meme in the feed has failed");
            }
        }
    }

    //////// Test deleteMeme
    @Test
    public void deleteMemeTest() {
        assertFalse(user1.deleteMeme(memes[0]));

        memes[0].setShared(false);
        if (user1.deleteMeme(memes[0])) {
            assertEquals(new ArrayList<>(Arrays.asList(memes[1])), user1.getMemesCreated());
        }
        else {
            fail("deletion should have worked");
        }
    }

    //////// Test calculateReputation
    @Test
    public void calculateReputationTest() {
        for ( User user : users ) {
            for (int i = 0; i < feed.getMemes().size(); i++) {
                if (user1.getMemesCreated().contains(memes[i])) {
                    int randomRating = ratings[(int)(Math.random()*3)].getScore();
                    user.rateNextMemeFromFeed(feed, randomRating);
                }
            }
        }
        double sum = 0d;
        double div = 0d;
        for (Meme meme : user1.getMemesCreated()) {
            sum += meme.calculateOverallRating();
            div++;
        }
        assertTrue(sum/div == user1.calculateReputation());
    }


    /////// Test compareTo
    @Test
    public void testCompareTo1() {
        assertTrue(user3.compareTo(user1) < 0);

        assertTrue(user1.compareTo(user3) > 0);

        assertTrue(user1.compareTo(user1) == 0);

        User temp = new User("MemeLord");
        temp.setMemesCreated(new ArrayList<>(Arrays.asList(new Meme(), new Meme(), new Meme(), new Meme(), new Meme(), new Meme(), new Meme())));
        assertTrue(temp.compareTo(user1) < 0);

        temp = new User("MemeLord");
        temp.setMemesCreated(new ArrayList<>(Arrays.asList(new Meme(), new Meme())));
        assertTrue(temp.compareTo(user1) == 0);

        temp = new User("MemeLord");
        temp.setMemesCreated(new ArrayList<>(Arrays.asList(new Meme(), new Meme(), new Meme(), new Meme(), new Meme(), new Meme(), new Meme())));
        assertTrue(user1.compareTo(temp) > 0);
    }

    ////// Test toString
    @Test
    public void toStringTest() {
        for ( User user : users ) {
            for (int x = 0; x < feed.getMemes().size(); x++) {
                user.rateNextMemeFromFeed(feed, ratings[x%3].getScore());
            }
        }
        String expected = user1.getUserName() + " has rated (" + user1.getMemesViewed().size() + ") memes, (" + user1.calculateReputation() + ")";
        assertEquals(expected, user1.toString());
    }
}