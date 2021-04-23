public class BackgroundImage implements Comparable<BackgroundImage>{
    private String imageFileName;
    private String title;
    private String description;

    /**
     * Contructor takes in and sets variables to given parameters.
     *
     * @param imageFileName Given file name for initialization
     * @param title Given title for initialization
     * @param description Given description for initialization
     */
    public BackgroundImage(String imageFileName, String title, String description) {
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
    }

    /**
     * Default constructor initializes the variables of this instance to thier own default
     */
    public BackgroundImage() {
        imageFileName = new String();
        title = new String();
        description = new String();
    }

    /**
     * Gets the filename for the image
     *
     * @return a string of the filname
     */
    public String getImageFileName() {
        return imageFileName;
    }

    /**
     * Sets the filename to a new value
     *
     * @param imageFileName given filename to update the imageFileName variable
     */
    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    /**
     * Gets the title for the java.BackgroundImage
     *
     * @return the title of this java.BackgroundImage
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the filename to a new value
     *
     * @param title given title to update the imageFileName variable
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the description for the java.BackgroundImage
     *
     * @return the description of this java.BackgroundImage
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description to a new value
     *
     * @param description given description to update the imageFileName variable
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * To string in format: "title <description>"
     * ex: "How bots laugh <Image of Joquain Phoenix in his role as Joker,laughing maniacally>"
     *
     * @return String in the format above
     */
    public String toString(){
        return String.format("%s <%s>", title, description);
    }

    /**
     * Equals Method
     *
     * @param obj Object to compare this instance to
     * @returns True if the obj has all the same attributes (user, score) as this instance and false if not.
     */
    public boolean equals(Object obj){
        if ( obj instanceof BackgroundImage && obj != null ) {
            BackgroundImage other = (BackgroundImage) obj;
            return other.getImageFileName().equals(imageFileName) && other.getDescription().equals(description) && other.getTitle().equals(title);
        }
        return false;
    }

    /**
     * CompareTo method compares this BackGroundImage with another based on the following priorities:
     * 1. imageFileName in ascending order
     * 2. title in ascending order
     * 3. description in ascending order
     * 4. Shared condition where shared images come first and non-shared come second
     *
     * @param backgroundImage BackgroundImage to compare against
     * @return an int representing the placement of this BackgroundImage relative to the other in natural order and priority specified above.
     */
    @Override
    public int compareTo(BackgroundImage backgroundImage) {
        if ( backgroundImage.getImageFileName().equals(imageFileName) ) {
            if ( backgroundImage.getTitle().equals(title) ) {
                return description.compareTo(backgroundImage.getDescription());
            }
            return title.compareTo(backgroundImage.getTitle());
        }
        return imageFileName.compareTo(backgroundImage.getImageFileName());
    }

}
