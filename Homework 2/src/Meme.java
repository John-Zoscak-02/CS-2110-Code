public class Meme {
    private User creator;
    private BackgroundImage backGroundImage;
    private Rating[] ratings;
    private String caption;
    private String captionVerticalAlign;
    private boolean shared;

    public Meme() {}
    public User getCreator() {return null;}
    public void setCreator(User creator) {}
    public BackgroundImage getBackgroundImage() {return null;}
    public void setBackgroundImage(BackgroundImage backgroundImage) {}
    public Rating[] getRatings() {return null;}
    public void setRatings(Rating[] ratings) {}
    public String getCaption() {return null;}
    public void setCaption(String caption) {}
    public String getCaptionVerticalAlign() {return null;}
    public void setCaptionVerticalAlign(String captionVerticalAlign) {}
    public boolean getShared() {return false;}
    public void setShared(boolean shared) {}
    public boolean addRating(Rating rating) {return false;}
    public double calculateOverallRating() {return 0d;}
    public String toString() {return null;}
    public boolean equals(Object obj) {return false;}
}
