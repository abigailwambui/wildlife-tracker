import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;

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

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
      Sighting firstSighting = new Sighting("Riverbed" , "Martin Olelenku");
      firstSighting.save();
      Sighting secondSighting = new Sighting("TallBushes", "Mary Nyawira");
      secondSighting.save();
      assertEquals(Sighting.find(secondSighting.getId()), secondSighting);
  }

    @Test
    public void getAnimals_retrievesAllAnimalsFromDatabase_animalsList() {
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      testSighting.save();
      Animal firstAnimal = new Animal("Elephants", "ill", "young", testSighting.getId());
      firstAnimal.save();
      Animal secondAnimal = new Animal("Zebras", "okay", "old", testSighting.getId());
      secondAnimal.save();
      Animal[] Animals = new Animal[] { firstAnimal, secondAnimal };
      assertTrue(testSighting.getAnimals().containsAll(Arrays.asList(Animals)));
  }

    @Test
    public void getSpecies_retrievesAllSpeciesFromDatabase_speciesList() {
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      testSighting.save();
      Specie firstSpecie = new Specie("Homo sapiens", 30, false, testSighting.getId());
      firstSpecie.save();
      Specie secondSpecie = new Specie("Gazella", 15, true, testSighting.getId());
      secondSpecie.save();
      Specie[] Species = new Specie[] { firstSpecie, secondSpecie };
      assertTrue(testSighting.getSpecies().containsAll(Arrays.asList(Species)));
  }

    @Test
    public void update_updatesSighttDescription_true() {
        Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
        testSighting.save();
        testSighting.updateSighting("Grazing area", "Zion Jabari");
        Sighting updated = new Sighting("Grazing area", "Zion Jabari");
        assertEquals(updated.getLocation(), Sighting.find(testSighting.getId()).getLocation());
    }

    @Test
    public void delete_deletesSightings_true() {
        Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
        testSighting.save();
        int testSightingId = testSighting.getId();
        testSighting.delete();
        assertEquals(null, Sighting.find(testSightingId));
    }
}

