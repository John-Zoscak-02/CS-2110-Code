import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RatingTest {

    private static User user1;
    private static User user2;
    private static User user3;
    private static User user4;
    private static User[] users;

    private static Rating downvote;
    private static Rating upvote;
    private static Rating abstain;
    private static Rating[] ratings;

    @Before
    public void setUp() {
        user1 = new User("MemeLord" );
        user2 = new User( "NoobMaster" );
        user3 = new User( "Billybob" );
        user4 = new User( "Willy" );
        users = new User[]{user1, user2, user3, user4};

        downvote = new Rating(user2, -1);
        upvote = new Rating(user1, 1);
        abstain = new Rating(user1, 0);
        ratings = new Rating[]{downvote, upvote, abstain};
    }

    @Test
    public void setAndGetScoreTest() {
        Rating rating = new Rating();
        rating.setScore(1);
        assertEquals(1, rating.getScore());

        rating.setScore(0);
        assertEquals(0, rating.getScore());

        rating.setScore(-1);
        assertEquals(-1, rating.getScore());

        rating.setScore(3);
        assertEquals(-1, rating.getScore());
    }

    @Test
    public void setAndGetUserTest() {
        Rating rating = new Rating();
        rating.setUser(user1);
        assertEquals(user1, rating.getUser());

        rating.setUser(user2);
        assertEquals(user2, rating.getUser());

        rating.setUser(user3);
        assertEquals(user3, rating.getUser());
    }

    @Test
    public void toStringTest() {
        assertEquals("NoobMaster rated as a downvote", downvote.toString());
        assertEquals("MemeLord rated as an upvote", upvote.toString());
        assertEquals("MemeLord rated as a pass", abstain.toString());
    }

    @Test
    public void equalsTest() {
        assertTrue(downvote.equals(downvote));
        assertFalse(downvote.equals(abstain));
        assertFalse(upvote.equals(abstain));
    }
}