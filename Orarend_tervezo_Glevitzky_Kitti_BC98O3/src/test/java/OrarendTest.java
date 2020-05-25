import Adatkezeles.Orarend_adattabla_GK;
import model.Orarendterv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrarendTest {
    Orarendterv Test;

    Orarend_adattabla_GK test;

    @BeforeEach
    void setUp() {
        Test = new Orarendterv();
        test = new Orarend_adattabla_GK();
    }

    @Test
    void testkiirtargy(){
        assertEquals("matematika",Test.kiirtargy("matematika"));
    }

    @Test
    void testkiirnap(){
        assertEquals("péntek",Test.kiirnap("péntek"));
    }


    @Test
    void testkiirora(){
        assertEquals("4",Test.kiirora("4"));
    }


    @Test
    void testkiirevfolyam(){
        assertEquals("6",Test.kiirevfolyam("6"));
    }

    @Test
    void testkiirosztaly(){
        assertEquals("A",Test.kiirosztaly("A"));
    }

    @Test
    void testkiiveg(){
        assertEquals("matematika péntek 4 6 A",Test.kiirveg("matematika péntek 4 6 A"));
    }

    @Test
    void testNapInvalid() {
        test.setNap("péntekasd");
        assertFalse(test.napValid());
    }

    @Test
    void testNapValid() {
        test.setNap("péntek");
        assertTrue(test.napValid());
    }

    @Test
    void testEvfolyamInvalidTulAlacsony() {
        test.setEvfolyam(-1);
        assertFalse(test.evfolyamValid());
    }

    @Test
    void testEvfolyamInvalidTulMagas() {
        test.setEvfolyam(100);
        assertFalse(test.evfolyamValid());
    }

    @Test
    void testEvfolyamValid() {
        test.setEvfolyam(10);
        assertTrue(test.evfolyamValid());
    }

}