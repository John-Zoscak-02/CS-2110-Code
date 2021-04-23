import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme> {

    /**
     * Compare method for two memes with the following priority:
     * 1. creator in ascending order
     * 2. overall rating in descending order
     * 3. caption in ascending order
     * 4. BackGroundImage in ascending order
     * 5. Shared memes come first
     *
     * @param m1
     * @param m2
     * @return
     */
    @Override
    public int compare(Meme m1, Meme m2) {
        if ( m1.getCreator().equals(m2.getCreator()) ) {
            if ( m1.calculateOverallRating() == m2.calculateOverallRating() ) {
                if ( m1.getCaption().equals(m2.getCaption())) {
                    if (m1.getBackgroundImage().equals(m2.getBackgroundImage())) {
                        if (m1.getShared() == m2.getShared()) {
                            return 0;
                        }
                        else if (m1.getShared()) {
                            return -1;
                        }
                        else {
                            return 1;
                        }
                    }
                    return m1.getBackgroundImage().compareTo(m2.getBackgroundImage());
                }
                return m1.getCaption().compareTo(m2.getCaption());
            }
            return (int)(m2.calculateOverallRating() - m1.calculateOverallRating());
        }
        return m1.getCreator().compareTo(m2.getCreator());
    }

}
