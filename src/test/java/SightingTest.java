import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SightingTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      assertEquals(true, testSighting instanceof Sighting);
    }

    @Test
    public void getLocation_SightingInstantiatesWithLocation_Riverbed(){
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      assertEquals("Riverbed", testSighting.getLocation());
  
  }

    @Test
    public void getName_SightingInstantiatesWithRangerName_String(){
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      assertEquals("Martin Olelenku", testSighting.getName());
  
  }

    @Test
    public void equals_returnsTrueIfLocationandNameareSame_true() {
      Sighting firstSighting = new Sighting("Riverbed" , "Martin Olelenku");
      Sighting anotherSighting = new Sighting("Riverbed" , "Martin Olelenku");
      assertTrue(firstSighting.equals(anotherSighting));
    }


}

