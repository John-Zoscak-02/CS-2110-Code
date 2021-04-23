import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MemeTest {

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
    public void setUp(){
        empty = new Meme();
        
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

    ///////// Test getCreator
    @Test
    public void getCreatorTest() {
        assertEquals(user1, memes[0].getCreator());
        assertEquals(user4, memes[memes.length-1].getCreator());
        assertEquals(new User(), (empty).getCreator());
    }

    ////////// Test setCreator
    @Test
    public void setCreatorTest() {
        memes[1].setCreator(user2);
        assertEquals(user2, memes[1].getCreator());

        memes[memes.length-1].setCreator(user3);
        assertEquals(user3, memes[memes.length-1].getCreator());

        User temp = new User();
        empty.setCreator(temp);
        assertEquals(temp, empty.getCreator());
    }


    /////////// Test getBackGroundImage
    @Test
    public void getBackGroundImageTest() {
        assertEquals(backgroundImage1, memes[0].getBackgroundImage());
        assertEquals(backgroundImage6, memes[memes.length-1].getBackgroundImage());
        assertEquals(new BackgroundImage(), (empty).getBackgroundImage());
    }

    ///////// Test setBackGroundImage
    @Test
    public void setBackGroundImageTest() {
        memes[1].setBackgroundImage(backgroundImage2);
        assertEquals(backgroundImage2, memes[1].getBackgroundImage());

        memes[memes.length-1].setBackgroundImage(backgroundImage5);
        assertEquals(backgroundImage5, memes[memes.length-1].getBackgroundImage());

        assertEquals(new BackgroundImage(), (empty).getBackgroundImage());
    }

    //////// Test getRatings
    @Test
    public void getRatingsTest() {
        user1.rateMeme(empty, 1);
        user1.rateMeme(empty, 0);
        user1.rateMeme(empty, -1);
        user1.rateMeme(empty, 0);
        user1.rateMeme(empty, 0);
        user1.rateMeme(empty, 1);

        assertArrayEquals(new Rating[]{new Rating(user1, 1), new Rating(user1, 0), new Rating(user1, -1), new Rating(user1, 0), new Rating(user1, 0), new Rating(user1, 1), null, null, null, null}, empty.getRatings());

        empty = new Meme();
        assertArrayEquals(new Rating[10], (empty).getRatings());
    }
    
    /////// Test setRatings
    @Test
    public void setRatingsTest() {
        Rating[] ratings = {upvote, abstain, abstain, downvote, abstain, upvote, upvote, upvote, upvote, upvote};
        empty.setRatings(ratings);
        assertArrayEquals(ratings, empty.getRatings());

        ratings = new Rating[]{upvote, abstain, abstain, downvote, abstain, upvote};
        empty.setRatings(ratings);
        assertArrayEquals(ratings, empty.getRatings());

        ratings = new Rating[0];
        empty.setRatings(ratings);
        assertArrayEquals(ratings, empty.getRatings());
    }

    /////// Test getCaption
    @Test
    public void getCaptionTest() {
        assertEquals("Meme caption A", memes[0].getCaption());
        assertEquals("Meme caption J", memes[memes.length-1].getCaption());
        assertEquals("", empty.getCaption());
    }

    /////// Test setCaption
    @Test
    public void setCaptionTest() {
        memes[1].setCaption("new meme caption 1");
        assertEquals("new meme caption 1", memes[1].getCaption());

        memes[memes.length-1].setCaption("new meme caption 2");
        assertEquals("new meme caption 2", memes[memes.length-1].getCaption());
    }

    /////// Test setCaptionVertical Align and getCaptionVerticalAlign
    @Test
    public void getAndSetCaptionVerticalAlignTest() {
        assertEquals("bottom", memes[0].getCaptionVerticalAlign());

        if (!memes[0].setCaptionVerticalAlign("middle")) {
            fail("failed to properly set the caption");
        }
        assertEquals("middle", memes[0].getCaptionVerticalAlign());

        if (!memes[0].setCaptionVerticalAlign("top")) {
            fail("failed to properly set the caption");
        }
        assertEquals("top", memes[0].getCaptionVerticalAlign());

        if (memes[0].setCaptionVerticalAlign("aioudsvsf;g")) {
            fail("failed to properly set the caption");
        }
        assertEquals("top", memes[0].getCaptionVerticalAlign());
    }

    ////// Test getShared
    @Test
    public void getSharedTest() {
        assertTrue(memes[0].getShared());

        user1.shareMeme(memes[0], feed);
        assertTrue(memes[0].getShared());
    }

    /////// Test setShared
    @Test
    public void setSharedTest() {
        memes[0].setShared(false);
        assertFalse(memes[0].getShared());

        memes[0].setShared(true);
        assertTrue(memes[0].getShared());

    }

    /////// Test addRating
    @Test
    public void addRatingTest() {
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertArrayEquals(new Rating[]{upvote, upvote, upvote, upvote, upvote, upvote, downvote, downvote, downvote, downvote}, memes[0].getRatings());

        memes[0].setRatings(new Rating[10]);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertArrayEquals(new Rating[]{upvote, upvote, upvote, upvote, downvote, upvote, downvote, downvote, null, null}, memes[0].getRatings());

        memes[0].setRatings(new Rating[1]);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertArrayEquals(new Rating[]{downvote}, memes[0].getRatings());

        memes[0].setRatings(new Rating[0]);
        assertFalse(memes[0].addRating(upvote));
    }

    ////// Test calculateOverallRating
    @Test
    public void calculateOverallRatingTest() {
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(abstain);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertTrue(1d == memes[0].calculateOverallRating());
    }

    /////// Test toString
    @Test
    public void toStringTest() {
        String expected = "Red pill blue pill <Picture of morpheus from Matrix holding out a red and blue pill> 'Meme caption A' 1.0 [+1: 4, -1: 3] - created by MemeLord";
        memes[0].addRating(upvote);
        memes[0].addRating(upvote);
        memes[0].addRating(abstain);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertEquals(expected, memes[0].toString());

        expected = "Frustrated cat <Dramatic foreplay between two people and a cat looks at them with a frustrated expression> 'Meme caption D' 0.0 [+1: 0, -1: 0] - created by NoobMaster";
        assertEquals(expected, memes[3].toString());

        expected = " <> '' 0.0 [+1: 0, -1: 0] - created by ";
        assertEquals(expected, empty.toString());
    }

    ///// Test equals
    @Test
    public void testEquals1() {
        Meme temp = new Meme(memes[0].getBackgroundImage(), memes[0].getCaption(), memes[0].getCreator());
        temp.setRatings(new Rating[5]);
        temp.setShared(true);
        assertTrue(memes[0].equals(temp));

        assertTrue(memes[0].equals(memes[0]));

        assertFalse(memes[0].equals(memes[1]));

        temp = new Meme(memes[0].getBackgroundImage(), memes[0].getCaption(), memes[0].getCreator());
        temp.setBackgroundImage(backgroundImage6);
        assertFalse(memes[0].equals(temp));

        assertFalse(memes[0].equals(new Object()));
    }

    ///// Test compareTo
    @Test
    public void compareToTest() {
        assertTrue(memes[0].compareTo(memes[1]) < 0);
        assertTrue(memes[1].compareTo(memes[0]) > 0);
        assertTrue(memes[0].compareTo(memes[0]) == 0);

        BackgroundImage tempb = new BackgroundImage("backgroundimage1filename", "Z", "Picture of morpheus from Matrix holding out a red and blue pill");
        Meme temp = new Meme(tempb, memes[0].getCaption(), memes[0].getCreator());
        assertTrue(memes[0].compareTo(temp) < 0);

        temp = new Meme(backgroundImage1, memes[0].getCaption(), memes[0].getCreator());
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(upvote);
        memes[0].addRating(downvote);
        memes[0].addRating(downvote);
        assertTrue(memes[0].compareTo(temp) > 0);

        memes[0].setShared(false);
        temp = new Meme(backgroundImage1, memes[0].getCaption(), memes[0].getCreator());
        temp.setShared(true);
        assertTrue(memes[0].compareTo(temp) > 0);

        memes[0].setRatings(new Rating[10]);
        temp = new Meme(backgroundImage1, memes[0].getCaption(), memes[0].getCreator());
        assertTrue(memes[0].compareTo(temp) == 0);

        temp = new Meme(backgroundImage1, memes[0].getCaption(), memes[0].getCreator());
        memes[0].setShared(true);
        temp.setShared(false);
        assertTrue(memes[0].compareTo(temp) < 0);
    }

}