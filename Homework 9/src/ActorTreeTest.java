import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTreeTest {

    private ActorTree actorTree;

    @Before
    public void setUp() {
        actorTree = new ActorTree();
        actorTree.insert(new Actor("Fred Astaire"));
        actorTree.insert(new Actor("Lauren Bacall"));
        actorTree.insert(new Actor("Brigitte Bardot"));
        actorTree.insert(new Actor("John Belushi"));
        actorTree.insert(new Actor("Ingmar Bergman"));
        actorTree.insert(new Actor("Ingrid Bergman"));
        actorTree.insert(new Actor("Kelly Gene"));
        actorTree.insert(new Actor("Kirk Douglas"));
        actorTree.insert(new Actor("Audrey Hepburn"));
        actorTree.insert(new Actor("Alan Ladd"));
        actorTree.insert(new Actor("Veronica Lake"));
        actorTree.insert(new Actor("Bruce Lee"));
        actorTree.insert(new Actor("Brad Pitt"));
        actorTree.insert(new Actor("Burt Lancaster"));
        actorTree.insert(new Actor("Fred Astaire"));
        actorTree.insert(new Actor("Fred Astaire"));
        actorTree.insert(new Actor("Fred Astaire"));
        actorTree.insert(new Actor("Fred Astaire"));
        actorTree.insert(new Actor("Fred Astaire"));
    }

    @Test
    public void find1() {
        assertEquals(new Actor("Fred Astaire"), actorTree.find("Fred Astaire"));
    }

    @Test
    public void find2() {
        assertEquals(new Actor("Audrey Hepburn"), actorTree.find("Audrey Hepburn"));
    }

    @Test
    public void find3() {
        assertEquals(new Actor("Kirk Douglas"), actorTree.find("Kirk Douglas"));
    }

    @Test
    public void size1() {
        assertEquals(0, (new ActorTree()).size());
    }

    @Test
    public void size2() {
        assertEquals(14, actorTree.size());
    }

    @Test
    public void height1() {
        assertEquals(0, (new ActorTree()).height());
    }

    @Test
    public void height2() {
        assertEquals(5, actorTree.height());
    }

    @Test
    public void isEmpty1() {
        assertTrue((new ActorTree()).isEmpty());
    }

    @Test
    public void isEmpty2() {
        assertFalse(actorTree.isEmpty());
    }

    @Test
    public void insert() {
        String expected = "Actor [nconst=null, primaryName=Alan Ladd, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Audrey Hepburn, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Brad Pitt, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Brigitte Bardot, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Bruce Lee, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Burt Lancaster, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Fred Astaire, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Ingmar Bergman, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Ingrid Bergman, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=John Belushi, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Kelly Gene, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Kirk Douglas, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Lauren Bacall, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Veronica Lake, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Zack Efron, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n";
        actorTree.insert(new Actor("Zack Efron") );
        assertEquals(expected, actorTree.inOrder());
    }

    @Test
    public void inOrder() {
        String expected = "Actor [nconst=null, primaryName=Alan Ladd, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Audrey Hepburn, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Brad Pitt, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Brigitte Bardot, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Bruce Lee, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Burt Lancaster, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Fred Astaire, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Ingmar Bergman, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Ingrid Bergman, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=John Belushi, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Kelly Gene, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Kirk Douglas, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Lauren Bacall, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n" +
                "Actor [nconst=null, primaryName=Veronica Lake, birthYear=null, deathYear=null, primaryProfession=null, knownForTitles=null]\n";
        assertEquals(expected, actorTree.inOrder());
    }
}