import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BackgroundImage backgroundImage1 = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Picture of morpheus from Matrix holding out a red and blue pill");
        BackgroundImage backgroundImage2 = new BackgroundImage("backgroundimage2filename", "How bots laugh", "Image of Joquain Phoenix in his role as Joker,laughing maniacally");

        User user1 = new User("MemeLord" );
        User user2 = new User( "NoobMaster" );

        Rating rating1 = new Rating(user2, -1);
        Rating rating2 = new Rating(user1, 1);
        Rating rating3 = new Rating(user1, 0);

        System.out.println(rating1.setScore(-1));
        System.out.println(rating1);
        System.out.println(rating1.setScore(0));
        System.out.println(rating1);
        System.out.println(rating1.setScore(1));
        System.out.println(rating1);
        System.out.println(rating1.setScore(5));
        System.out.println(rating1);
        rating1.setScore(-1);
        System.out.println();

        Feed feed1 = new Feed();

        user1.createMeme(backgroundImage1, "Meme caption 1");
        user2.createMeme(backgroundImage2, "Meme caption 2");

        Meme meme1 = user1.getMemesCreated().get(0);
        Meme meme2 = user2.getMemesCreated().get(0);

        System.out.println(meme1);
        System.out.println(meme2);

        user1.shareMeme(meme1, feed1);
        user2.shareMeme(meme2, feed1);

        System.out.println("Feed1: " + feed1);

        System.out.println(meme1.addRating(rating3));
        meme1.addRating(rating3);
        System.out.println(meme1.addRating(rating2));
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        meme1.addRating(rating2);
        System.out.println(meme1.addRating(rating2));
        user1.rateMeme(meme1, 1);
        user2.rateMeme(meme1, -1);
        System.out.println();

        System.out.println(meme1.setCaptionVerticalAlign("top"));
        System.out.println(meme1.getCaptionVerticalAlign());
        System.out.println(meme1.setCaptionVerticalAlign("middle"));
        System.out.println(meme1.getCaptionVerticalAlign());
        System.out.println(meme1.setCaptionVerticalAlign("bottom"));
        System.out.println(meme1.getCaptionVerticalAlign());
        System.out.println(meme1.setCaptionVerticalAlign("something"));
        System.out.println(meme1.getCaptionVerticalAlign());
        System.out.println();


        meme2.addRating(rating1);
        meme2.addRating(rating3);
        user1.rateMeme(meme2, 0);
        user2.rateMeme(meme2, -1);
        System.out.println(user1.calculateReputation());
        System.out.println(user2.calculateReputation());

        System.out.println(user1.getMemesViewed());
        System.out.println(user2.getMemesViewed());
        System.out.println();

        user1.setMemesViewed(new ArrayList<>());
        user2.setMemesViewed(new ArrayList<>());

        ArrayList<Meme> tempList = feed1.getMemes();
        tempList.add(new Meme());
        feed1.setMemes(tempList);
        System.out.println(user1.getMemesViewed());
        System.out.println(user1.rateNextMemeFromFeed(feed1, 1));
        System.out.println(user1.getMemesViewed());
        System.out.println(user1.rateNextMemeFromFeed(feed1, -1));
        System.out.println(user1.getMemesViewed());
        System.out.println(user1.rateNextMemeFromFeed(feed1, 0));
        System.out.println(user1.getMemesViewed());
        System.out.println(user2.rateNextMemeFromFeed(feed1, 3));
        System.out.println(user2.getMemesViewed());
        System.out.println();

        System.out.println(backgroundImage1);
        System.out.println(backgroundImage2);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(rating1);
        System.out.println(rating2);
        System.out.println(rating3);
        System.out.println(meme1);
        System.out.println(meme2);
        System.out.println(feed1);
        System.out.println();

        System.out.println(meme1.calculateOverallRating());
        System.out.println(meme2.calculateOverallRating());
        System.out.println();

        System.out.println(backgroundImage1.equals(backgroundImage1));
        System.out.println(backgroundImage1.equals(backgroundImage2));
        System.out.println(backgroundImage1.equals(null));
        System.out.println(meme1.equals(meme1));
        System.out.println(meme1.equals(meme2));
        System.out.println(meme1.equals(null));
        System.out.println(rating1.equals(rating1));
        System.out.println(rating1.equals(rating2));
        System.out.println(rating1.equals(null));
        System.out.println(user1.equals(user1));
        System.out.println(user1.equals(user2));
        System.out.println(user1.equals(null));
        System.out.println(feed1.equals(feed1));
        System.out.println(feed1.equals(new Feed()));
        System.out.println(feed1.equals(null));

    }
}
