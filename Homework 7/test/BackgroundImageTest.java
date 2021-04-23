import org.junit.*;

import static org.junit.Assert.*;

public class BackgroundImageTest {

    private static BackgroundImage backgroundImage1;
    private static BackgroundImage backgroundImage2;
    private static BackgroundImage backgroundImage3;
    private static BackgroundImage backgroundImage4;
    //private static BackgroundImage backgroundImage5;
    private static BackgroundImage backgroundImage6;
    //private static BackgroundImage[] backgroundImages;

    @Before
    public void setUp() {
        backgroundImage1 = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Picture of morpheus from Matrix holding out a red and blue pill");
        backgroundImage2 = new BackgroundImage("backgroundimage2filename", "How bots laugh", "Image of Joquain Phoenix in his role as Joker,laughing maniacally");
        backgroundImage3 = new BackgroundImage("backgroundimage3filename", "Scared dog", "Picture of a dog with a hilarious expression");
        backgroundImage4 = new BackgroundImage("backgroundimage4filename", "Frustrated cat", "Dramatic foreplay between two people and a cat looks at them with a frustrated expression");
        //backgroundImage5 = new BackgroundImage("backgroundimage5filename", "red or blue button", "Image of superhero wiping sweat off his forehead, looking at a red and blue button");
        backgroundImage6 = new BackgroundImage("backgroundimage6filename", "First time", "Image of man with noose around neck, looking into the camera");
        //backgroundImages = new BackgroundImage[]{backgroundImage1, backgroundImage2, backgroundImage3, backgroundImage4, backgroundImage5, backgroundImage6};
    }

    ////// Test getImageFileName
    @Test
    public void getImageFileNameTest() {
        assertEquals("backgroundimage1filename", backgroundImage1.getImageFileName());
        assertEquals("backgroundimage6filename", backgroundImage6.getImageFileName());
        assertEquals("", (new BackgroundImage()).getImageFileName());
    }


    ////// Test setImageFileName
    @Test
    public void setImageFileNameTest() {
        String str = "New file name";
        backgroundImage1.setImageFileName(str);
        assertEquals(str, backgroundImage1.getImageFileName());
    }

    ////// Test getTitle
    @Test
    public void getTitleTest() {
        assertEquals("Red pill blue pill", backgroundImage1.getTitle());
        assertEquals("Scared dog", backgroundImage3.getTitle());
        assertEquals("", (new BackgroundImage()).getTitle());
    }

    ////// Test setTitle
    @Test
    public void setTitleTest() {
        String str = "New title for BackgroundImage";
        backgroundImage1.setTitle(str);
        assertEquals(str, backgroundImage1.getTitle());
    }

    ///// Test getTitle
    @Test
    public void getDescriptionTest() {
        assertEquals("Picture of morpheus from Matrix holding out a red and blue pill", backgroundImage1.getDescription());
        assertEquals("Dramatic foreplay between two people and a cat looks at them with a frustrated expression", backgroundImage4.getDescription());
        assertEquals("", (new BackgroundImage()).getDescription());
    }

    /////// Test setDescription
    @Test
    public void setDescriptionTest() {
        String str = "New description";
        backgroundImage2.setDescription(str);
        assertEquals(str, backgroundImage2.getDescription());
    }

    ////// Test toString
    @Test
    public void toStringTest() {
        assertEquals("Red pill blue pill <Picture of morpheus from Matrix holding out a red and blue pill>", backgroundImage1.toString());
        assertEquals("First time <Image of man with noose around neck, looking into the camera>", backgroundImage6.toString());
        assertEquals(" <>", (new BackgroundImage()).toString());
    }

    /////// Test Equals
    @Test
    public void equalsTest() {
        assertTrue(backgroundImage1.equals(backgroundImage1));
        assertTrue(backgroundImage1.equals(new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Picture of morpheus from Matrix holding out a red and blue pill")));
        assertFalse(backgroundImage1.equals(backgroundImage2));
        assertFalse(backgroundImage1.equals(null));
        assertFalse(backgroundImage1.equals(new Meme()));
    }

    /////// Test compareTo
    @Test
    public void compareToTest() {
        assertTrue(backgroundImage1.compareTo(backgroundImage2) < 0);
        assertTrue(backgroundImage2.compareTo(backgroundImage1) > 0);
        assertTrue(backgroundImage1.compareTo(backgroundImage1) == 0);

        BackgroundImage temp = new BackgroundImage("backgroundimage1filename", "Z", "Picture of morpheus from Matrix holding out a red and blue pill");
        assertTrue(backgroundImage1.compareTo(temp) < 0);

        temp = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "Z");
        assertTrue(backgroundImage1.compareTo(temp) < 0);

        temp = new BackgroundImage("backgroundimage1filename", "Red pill blue pill", "A");
        assertTrue(backgroundImage1.compareTo(temp) > 0);
    }

}