import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

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

    private static Meme meme1;
    private static Meme meme2;
    private static Meme[] memes;



    public static void init() {
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
                temp[i] = meme;
                i++;
            }
        }
        memes = Arrays.copyOf(temp, i);
        meme1 = memes[0];
        meme2 = memes[1];

    }

    public static void main(String[] args) {

        init();

        ///////////////// Test setScore /////////////////
//        System.out.println(downvote.setScore(-1));
//        System.out.println(downvote);
//        System.out.println(downvote.setScore(0));
//        System.out.println(downvote);
//        System.out.println(downvote.setScore(1));
//        System.out.println(downvote);
//        System.out.println(downvote.setScore(5));
//        System.out.println(downvote);
//        downvote.setScore(-1);
//        System.out.println();

        for (Meme meme : memes) {
            System.out.println(meme);
        }

        for (User user : users) {
            for (Meme meme : user.getMemesCreated()) {
                user.shareMeme(meme, feed);
            }
        }

        System.out.println();
        System.out.println("Feed1: " + feed);
        System.out.println();

        ////////////////  Test addRating //////////////////
//        System.out.println(meme1.addRating(abstain));
//        meme1.addRating(abstain);
//        System.out.println(meme1.addRating(upvote));
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme1.addRating(upvote);
//        meme2.addRating(downvote);
//        meme2.addRating(abstain);
//        System.out.println(meme1.addRating(upvote));
//        System.out.println();

        /////////////////// Test setCaptionVerticalAlign //////////////////////////
//        System.out.println(meme1.setCaptionVerticalAlign("top"));
//        System.out.println(meme1.getCaptionVerticalAlign());
//        System.out.println(meme1.setCaptionVerticalAlign("middle"));
//        System.out.println(meme1.getCaptionVerticalAlign());
//        System.out.println(meme1.setCaptionVerticalAlign("bottom"));
//        System.out.println(meme1.getCaptionVerticalAlign());
//        System.out.println(meme1.setCaptionVerticalAlign("something"));
//        System.out.println(meme1.getCaptionVerticalAlign());
//        System.out.println();

        //////////////////// Test Calculate Reputation ///////////////////////////
//        user1.rateMeme(meme1, 1);
//        user2.rateMeme(meme1, -1);
//        user1.rateMeme(meme2, 0);
//        user2.rateMeme(meme2, -1);
//        System.out.println(user1.calculateReputation());
//        System.out.println(user2.calculateReputation());

        //////////////////////// Test getMemesViewed /////////////////////////////
        System.out.println(user1.getMemesViewed());
        System.out.println(user2.getMemesViewed());
        System.out.println();

        user1.setMemesViewed(new ArrayList<>());
        user2.setMemesViewed(new ArrayList<>());

        /////////////////// Test ratNextMemeFromFeed and getNewMeme ///////////////////
//        for ( User user : users ) {
//            for (int i = 0; i < feed.getMemes().size(); i++) {
//                System.out.println(user.rateNextMemeFromFeed(feed, ratings[(int)(Math.random()*3)].getScore()));
//                System.out.println(user.getMemesViewed());
//            }
//        }
//        System.out.println();

        /////////////// Test toString ////////////////
        for ( BackgroundImage backgroundImage : backgroundImages ) {
            System.out.println(backgroundImage);
        }
        for ( User user : users ) {
            System.out.println(user);
        }
        for (Rating rating : ratings) {
            System.out.println(rating);
        }
        for ( Meme meme : memes) {
            System.out.println(meme);
        }
        System.out.println(feed);
        System.out.println();

        /////////////// Test calculateOverallRating ////////////////
        for (Meme meme : memes) {
            System.out.println(meme.calculateOverallRating());
        }
        System.out.println();

        /////////////////// Test Equals ///////////////////////
//        System.out.println(backgroundImage1.equals(backgroundImage1));
//        System.out.println(backgroundImage1.equals(backgroundImage2));
//        System.out.println(backgroundImage1.equals(null));
//        System.out.println(meme1.equals(meme1));
//        System.out.println(meme1.equals(meme2));
//        System.out.println(meme1.equals(null));
//        System.out.println(downvote.equals(downvote));
//        System.out.println(downvote.equals(upvote));
//        System.out.println(downvote.equals(null));
//        System.out.println(user1.equals(user1));
//        System.out.println(user1.equals(user2));
//        System.out.println(user1.equals(null));
//        System.out.println(feed.equals(feed));
//        System.out.println(feed.equals(new Feed()));
//        System.out.println(feed.equals(null));

        /////////////////// Test Comparables and Sorting ///////////////////

        for ( User user : users ) {
            for (int x = 0; x < feed.getMemes().size(); x++) {
                user.rateNextMemeFromFeed(feed, ratings[x%3].getScore());
            }
        }

        Collections.shuffle(feed.getMemes());

        System.out.println(feed);
        feed.sortByCaption();
        System.out.println(feed);
        feed.sortByCreator();
        System.out.println(feed);
        feed.sortByRating();
        System.out.println(feed);
    }
}