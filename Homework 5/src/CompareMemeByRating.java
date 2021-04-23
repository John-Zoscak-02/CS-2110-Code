import java.util.Comparator;

public class CompareMemeByRating implements Comparator<Meme> {

    /**
     * Compare method for two memes with the following priority:
     * 1. overall rating in descending order
     * 2. caption in ascending order
     * 3. BackGroundImage in ascending order
     *
     * @param m1 First meme to compare with the other
     * @param m2 Second meme to compare with the other
     * @return an int representing the placement of the first meme relative to the other in natural order and priority specified above.
     */
    @Override
    public int compare(Meme m1, Meme m2) {
        if ( m1.calculateOverallRating() == m2.calculateOverallRating() ) {
            if ( m1.getCaption().equals(m2.getCaption()) ) {
                if ( m1.getBackgroundImage().equals(m2.getBackgroundImage())) {
                    return m1.getCreator().compareTo(m2.getCreator());
                }
                return m1.getBackgroundImage().compareTo(m2.getBackgroundImage());
            }
            return m1.getCaption().compareTo(m2.getCaption());
        }
        return (int)(m2.calculateOverallRating() - m1.calculateOverallRating());
    }

}
