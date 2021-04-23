public class Rating {
    private int score;
    private User user;

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
     * sets the score for this java.Rating
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
     * sets the user for this java.Rating
     *
     * @param user Given user to change the user variable to
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns rating as "java.Rating was 'type_of_rating'"
     *
     * @returns String in the format above
     */
    public String toString() {
        switch ( score ) {
            case 1 :
                return user.getUserName() + " rated as an upvote";
            case -1 :
                return user.getUserName() + " rated as a downvote";
            default :
                return user.getUserName() + " rated as a pass";
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
