import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class FeedTest {

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

    private static Rating downvote;
    private static Rating upvote;
    private static Rating abstain;
    private static Rating[] ratings;

    private static OrderableFeed feed;

    private static Meme[] memes;

    @Before
    public void setUp(){
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

    ///////// Test getMemes
    @Test
    public void getMemesTest() {
        Assert.assertArrayEquals(memes, feed.getMemes().toArray());
        Assert.assertArrayEquals(new Meme[0], (new Feed()).getMemes().toArray());
    }

    /////////// Test setMemes
    @Test
    public void setMemesTest() {
        ArrayList<Meme> temp = new ArrayList<>(Arrays.asList(memes));
        Collections.shuffle(temp);
        feed.setMemes(temp);
        Assert.assertArrayEquals(temp.toArray(), feed.getMemes().toArray());

        feed.setMemes(new ArrayList<>());
        Assert.assertArrayEquals(new Meme[0], feed.getMemes().toArray());
    }

    ////////// Test getNewMeme
    @Test
    public void testGetNewMemeTest() {
        for ( User user : users ) {
            for (int i = 0; i < feed.getMemes().size(); i++) {
                Meme meme = feed.getNewMeme(user);
                if (meme != null && (user.getMemesViewed().contains(meme) || user.getMemesViewed().contains(meme))) {
                    fail("Failed to properly get another meme for User: " + user + " by giving them this meme: " + meme);
                }
            }
        }

        user1.setMemesViewed(feed.getMemes());
        assertNull(feed.getNewMeme(user1));

        for (Meme meme : feed.getMemes()) {
            meme.setCreator(user1);
        }
        user1.setMemesCreated(feed.getMemes());
        assertNull(feed.getNewMeme(user1));
    }


    ////////// Test to String
    @Test
    public void toStringTest() {
        String expected = "Red pill blue pill <Picture of morpheus from Matrix holding out a red and blue pill> 'Meme caption A' 0.0 [+1: 0, -1: 0] - created by MemeLord\n" +
                "Scared dog <Picture of a dog with a hilarious expression> 'Meme caption B' 0.0 [+1: 0, -1: 0] - created by MemeLord\n" +
                "How bots laugh <Image of Joquain Phoenix in his role as Joker,laughing maniacally> 'Meme caption C' 0.0 [+1: 0, -1: 0] - created by NoobMaster\n" +
                "Frustrated cat <Dramatic foreplay between two people and a cat looks at them with a frustrated expression> 'Meme caption D' 0.0 [+1: 0, -1: 0] - created by NoobMaster\n" +
                "red or blue button <Image of superhero wiping sweat off his forehead, looking at a red and blue button> 'Meme caption E' 0.0 [+1: 0, -1: 0] - created by NoobMaster\n" +
                "First time <Image of man with noose around neck, looking into the camera> 'Meme caption F' 0.0 [+1: 0, -1: 0] - created by NoobMaster\n" +
                "Red pill blue pill <Picture of morpheus from Matrix holding out a red and blue pill> 'Meme caption G' 0.0 [+1: 0, -1: 0] - created by Billybob\n" +
                "How bots laugh <Image of Joquain Phoenix in his role as Joker,laughing maniacally> 'Meme caption H' 0.0 [+1: 0, -1: 0] - created by Billybob\n" +
                "red or blue button <Image of superhero wiping sweat off his forehead, looking at a red and blue button> 'Meme caption I' 0.0 [+1: 0, -1: 0] - created by Willy\n" +
                "First time <Image of man with noose around neck, looking into the camera> 'Meme caption J' 0.0 [+1: 0, -1: 0] - created by Willy\n";
        Assert.assertEquals(expected, feed.toString());
    }

}