public class Rating {
    private int score;
    private User user;


    public static void main(String[] args) {
        BackgroundImage backgroundImage1 = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Picture of morpheus from Matrix holding out a red and blue pill");
        BackgroundImage backgroundImage2 = new BackgroundImage("backgroundimage2filename", "How bots laugh", "Image of Joquain Phoenix in his role as Joker,laughing maniacally");

        User user1 = new User();
        User user2 = new User();

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

        Meme meme1 = new Meme(backgroundImage1, "Meme caption 1", user1);
        Meme meme2 = new Meme(backgroundImage2, "Meme caption 2", user2);

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

        System.out.println(backgroundImage1);
        System.out.println(backgroundImage2);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(rating1);
        System.out.println(rating2);
        System.out.println(rating3);
        System.out.println(meme1);
        System.out.println(meme2);
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

    }

    /**
     * Default Constructor for rating initializes score as 0, and creates a new users
     */
    public Rating() {
        score = 0;
        user = new User();
    }

    /**
     * Contructor takes in and sets variables to given parameters.
     *
     * @param user Guven user for initialization
     * @param score Given score for initialization
     */
    public Rating(User user, int score ) {
        this.user = user;
        this.score = score;
    }

    /**
     * returns the score for this rating
     *
     * @returns The score for this rating
     */
    public int getScore() {
        return score;
    }

    /**
     * sets the score for this Rating
     *
     * @param score Given score to change the score variable to
     */
    public boolean setScore(int score) {
        if ( !(Math.abs(score) > 1) ) {
            this.score = score;
            return true;
        }
        return false;
    }

    /**
     * returns the user for this rating
     *
     * @returns The user for this rating
     */
    public User getUser() {
        return user;
    }

    /**
     * sets the user for this Rating
     *
     * @param user Given user to change the user variable to
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns rating as "Rating was 'type_of_rating'"
     *
     * @returns String in the format above
     */
    public String toString() {
        switch ( score ) {
            case 1 :
                return "Rating was an upvote";
            case -1 :
                return "Rating was a downvote";
            default :
                return "Rating was a pass";
        }
    }

    /**
     * Equals Method
     *
     * @returns True if the obj has all the same attributes (user, score) as this instance and false if not.
     */
    public boolean equals(Object obj) {
        if ( obj instanceof Rating && obj != null ) {
            Rating other = (Rating) obj;
            return other.getScore() == score && other.getUser().equals(user);
        }
        return false;
    }
}
