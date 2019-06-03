import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SpecieTest {

    @Rule
  public DatabaseRule database = new DatabaseRule();

    @Test
    public void Specie_instantiatesCorrectly_true() {
        Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
        assertEquals(true, testSpecie instanceof Specie);
  }

    @Test
    public void Specie_instantiatesWithName_String() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      assertEquals("Homo sapiens", testSpecie.getName());
  }

    @Test
    public void Specie_instantiatesWithPopulation_int() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      assertEquals(30, testSpecie.getPopulation());
  }

    @Test
    public void Specie_instantiatesWithEndangered_boolean() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      assertEquals(false, testSpecie.getEndangered());
  }

    @Test
    public void Specie_instantiatesWithSightingId_int() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      assertEquals(1, testSpecie.getSightingId());
  }

    @Test
    public void equals_returnsTrueIfAllInstancesIdAreSame_true() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      Specie anotherSpecie = new Specie("Homo sapiens", 30, false, 1);
      assertTrue(testSpecie.equals(anotherSpecie));
  }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
      Specie testSpecie = new Specie("Homo sapiens", 30, false, 1);
      testSpecie.save();
      assertTrue(Specie.all().get(0).equals(testSpecie));
  }

    @Test
    public void save_assignsIdToAnimal() {
      Animal testAnimal = new Animal("Homo sapiens", 30, false, 1);
      testAnimal.save();
      Animal savedAnimal = Animal.all().get(0);
      assertEquals(savedAnimal.getId(), testAnimal.getId());
  }

    @Test
    public void all_returnsAllInstancesOfSpecie_true() {
      Specie firstSpecie = new Specie("Homo sapiens", 30, false, 1);
      firstSpecie.save();
      Specie secondSpecie = new Specie("Gazella", 15, true, 1);
      secondSpecie.save();
      assertEquals(true, Specie.all().get(0).equals(firstSpecie));
      assertEquals(true, Specie.all().get(1).equals(secondSpecie));
  }

    @Test
    public void find_returnsSpecieWithSameId_secondSpecie() {
      Specie firstSpecie = new Specie("Homo sapiens", 30, false, 1);
      firstSpecie.save();
      Specie secondSpecie = new Specie("Gazella", 15, true, 1);
      secondSpecie.save();
      assertEquals(Specie.find(secondSpecie.getId()), secondSpecie);
  }

    @Test
    public void save_savesSightingIdIntoDB_true() {
      Sighting testSighting = new Sighting("Riverbed" , "Martin Olelenku");
      testSighting.save();
      Specie testSpecie = new Specie("Homo sapiens", 30, false, testSighting.getId());
      testSpecie.save();
      Specie savedSpecie = Specie.find(testSpecie.getId());
      assertEquals(savedSpecie.getSightingId(), testSighting.getId());
  }
}