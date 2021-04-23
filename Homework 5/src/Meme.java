public class Meme implements Comparable<Meme> {
    private User creator;
    private BackgroundImage backGroundImage;
    private Rating[] ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;

    /**
     * Initializes new java.Meme object with default values
     */
    public Meme() {
        backGroundImage = new BackgroundImage();
        caption = new String();
        creator = new User();
        ratings = new Rating[10];
        captionVerticalAlign = "bottom";
    }

    /**
     * Initializes new meme object with specified values
     * @param backgroundImage java.BackgroundImage object
     * @param caption Caption object
     * @param creator Creator object
     */
    public Meme(BackgroundImage backgroundImage, String caption, User creator) {
        this.backGroundImage = backgroundImage;
        this.caption = caption;
        this.creator = creator;
        ratings = new Rating[10];
        captionVerticalAlign = "bottom";
    }

    /**
     * Gets the creator of a java.Meme object
     *
     * @return returns user held by this java.Meme object
     */
    public User getCreator() {
        return creator;
    }

    /**
     * Sets the creator of this java.Meme to a new value
     *
     * @param creator New creator for this object
     */
    public void setCreator(User creator) {
        this.creator = creator;
    }

    /**
     * Gets the java.BackgroundImage of a java.Meme object
     *
     * @return returns java.BackgroundImage held by this java.Meme object
     */
    public BackgroundImage getBackgroundImage() {
        return backGroundImage;
    }

    /**
     * Sets the creator of this java.Meme to a new value
     *
     * @param backgroundImage New BackGroundImage for this Object
     */
    public void setBackgroundImage(BackgroundImage backgroundImage) {
        this.backGroundImage = backgroundImage;
    }

    /**
     * Gets the Ratings of a java.Meme object
     *
     * @return returns Ratings held by this java.Meme object
     */
    public Rating[] getRatings() {
        return ratings;
    }

    /**
     * Sets the creator of this java.Meme to a new value
     *
     * @param ratings New set of Ratings for this Object
     */
    public void setRatings(Rating[] ratings) {
        this.ratings = ratings;
    }

    /**
     * Gets the caption of a java.Meme object
     *
     * @return returns caption held by this java.Meme object
     */
    public String getCaption() {
        return caption;
    }

    /**
     * Sets the caption of this java.Meme to a new value
     *
     * @param caption New set of Ratings for this Object
     */
    public void setCaption(String caption) {
        this.caption = caption;
    }

    /**
     * Gets the CaptionVerticalAlign Characteristic for display of the caption of a java.Meme object
     *
     * @return returns CaptionVerticalAlign Characteristic held by this java.Meme object
     */
    public String getCaptionVerticalAlign() {
        return captionVerticalAlign;
    }

    /**
     * Sets the CaptionVerticalAlign Characteristic of this java.Meme to a new value
     *
     * @param captionVerticalAlign New set of CaptionVerticalAlign Characteristic for this Object
     */
    public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
        switch (captionVerticalAlign) {
            case "top" :
            case "middle" :
            case "bottom" :
                this.captionVerticalAlign = captionVerticalAlign;
                return true;
            default :
                return false;
        }
    }

    /**
     * Gets the shared characteristic for display of the java.Meme object
     *
     * @return returns shared characteristic held by this java.Meme object
     */
    public boolean getShared() {
        return shared;
    }

    /**
     * Sets the caption of this java.Meme to a new value
     *
     * @param shared New set of Ratings for this Object
     */
    public void setShared(boolean shared) {
        this.shared = shared;
    }

    /**
     * Adds a rating to the ratings array. If there are already ten slots taken, the ratings array will discard the first/oldest rating to make space for the new rating at the end of the array
     *
     * @param rating New rating to add to the array of ratings for this class
     * @returns True if successful, false if not.
     */
    public boolean addRating(Rating rating) {
        try {
            for (int i = 0; i < ratings.length; i++) {
                if (ratings[i] == null) {
                    ratings[i] = rating;
                    return true;
                }
            }
            ratings = new Rating[]{ratings[1], ratings[2], ratings[3], ratings[4], ratings[5], ratings[6], ratings[7], ratings[8], ratings[9], rating};
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * returns the sum of all the ratings in the rating array for this java.Meme.
     * Note: all ratings are 0, -1, or 1
     *
     * @returns the sum of all the ratings in the rating array
     */
    public double calculateOverallRating() {
        int sum = 0;
        for ( Rating rating : ratings ) {
            if (rating != null) {
                sum += rating.getScore();
            }
        }
        return sum;
    }

    /**
     * returns a string with the following format:
     * "backgroundImage‘caption'overallRating[+1:the number of +1 ratings,-1:the number of -1 ratings]"
     * example:
     * How bots laugh<Image of Joquain Phoenix in his role as Joker,laughing maniacally>'When your professor calls an in person meeting at 9AMEST and you live inCali' 5.0[+1:10,-1:5]
     *
     * @returns String in format above
     */
    public String toString() {
        int minus = 0;
        int plus = 0;
        for ( Rating rating : ratings ) {
            if (rating != null) {
                if (rating.getScore() == -1) {
                    minus++;
                } else if (rating.getScore() == 1) {
                    plus++;
                }
            }
        }
//        return String.format("%s '%s' %d[+1: %d, -1: %d]", backGroundImage.toString(), caption, calculateOverallRating(), (double)plus, (double)minus);
        return backGroundImage.toString() + " '" + caption + "' " + calculateOverallRating() + " [+1: " + plus + ", -1: " + minus + "] - created by " + creator.getUserName();
    }

    /**
     * Equals Method
     *
     * @param obj Object to compare this instance to
     * @returns True if the obj has all the same attributes (creator, caption, backgroundImage) as this instance and false if not.
     */
    public boolean equals(Object obj) {
        if ( obj instanceof Meme && obj != null ) {
            Meme other = (Meme) obj;
            return other.getCreator().equals(creator) && other.getCaption().equals(caption) && other.getBackgroundImage().equals(backGroundImage);
        }
        return false;
    }

    /**
     * CompareTo method compares this meme with another based on the following priorities:
     * 1. Caption in ascending order
     * 2. BackGroundImage in Ascending order
     * 3. Rating in descending order
     * 4. Shared condition where shared images come first and non-shared come second
     *
     * @param meme meme to compare against
     * @return an int representing the placement of this meme relative to the other in natural order and priority specified above.
     */
    @Override
    public int compareTo(Meme meme) {
        if ( meme.getCaption().equals(caption) ) {
            if ( meme.getBackgroundImage().equals(getBackgroundImage()) ) {
                if ( meme.calculateOverallRating() == calculateOverallRating() ) {
                    if (shared == meme.getShared()) {
                        return 0;
                    }
                    else if (shared) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
                return (int)(meme.calculateOverallRating() - calculateOverallRating());
            }
            return backGroundImage.compareTo(meme.getBackgroundImage());
        }
        return caption.compareTo(meme.getCaption());
    }
}
