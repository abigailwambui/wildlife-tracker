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
      assertEquals("Martin Olelenku", testSighting.getRangerName());
  
  }

    @Test
    public void equals_returnsTrueIfLocationandNameareSame_true() {
      Sighting firstSighting = new Sighting("Riverbed" , "Martin Olelenku");
      Sighting anotherSighting = new Sighting("Riverbed" , "Martin Olelenku");
      assertTrue(firstSighting.equals(anotherSighting));
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
      Sighting firstSighting = new Sighting("Riverbed" , "Martin Olelenku");
      firstSighting.save();
      Sighting secondSighting = new Sighting("TallBushes", "Mary Nyawira");
      secondSighting.save();
      assertEquals(true, Sighting.all().get(0).equals(firstSighting));
      assertEquals(true, Sighting.all().get(1).equals(secondSighting));
  }

    @Test
    public void save_assignsIdToObject() {
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      testSighting.save();
      Sighting savedSighting = Sighting.all().get(0);
      assertEquals(testSighting.getId(), savedSighting.getId());
  }
}

