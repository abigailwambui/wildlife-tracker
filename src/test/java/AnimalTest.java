import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        assertEquals(true, testAnimal instanceof Animal);
  }

    @Test
    public void animal_instantiatesWithName_String() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        assertEquals("Elephants", testAnimal.getName());
  }

    @Test
    public void animal_instantiatesWithHealth_String() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        assertEquals("ill", testAnimal.getHealth());
  }

     @Test
    public void animal_instantiatesWithAge_String() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        assertEquals("young", testAnimal.getAge());
  }

    @Test
    public void animal_instantiatesWithSightingId_int() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        assertEquals(1, testAnimal.getSightingId());
  }
    @Test
    public void equals_returnsTrueIfNameAndSightingIdAreSame_true() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        Animal anotherAnimal = new Animal("Elephants", "ill", "young", 1);
        assertTrue(testAnimal.equals(anotherAnimal));
  }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
  }

    @Test
    public void save_assignsIdToAnimal() {
      Animal testAnimal = new Animal("Elephants", "ill", "young", 1);
      testAnimal.save();
      Animal savedAnimal = Animal.all().get(0);
      assertEquals(savedAnimal.getId(), testAnimal.getId());
  }

    @Test
    public void all_returnsAllInstancesOfAnimal_true() {
      Animal firstAnimal = new Animal("Elephants", "ill", "young", 1);
      firstAnimal.save();
      Animal secondAnimal = new Animal("Zebras", "okay", "old", 1);
      secondAnimal.save();
      assertEquals(true, Animal.all().get(0).equals(firstAnimal));
      assertEquals(true, Animal.all().get(1).equals(secondAnimal));
  }

    @Test
    public void find_returnsAnimalWithSameId_secondAnimal() {
      Animal firstAnimal = new Animal("Elephants", "ill", "young", 1);
      firstAnimal.save();
      Animal secondAnimal = new Animal("Zebras", "okay", "old", 1);
      secondAnimal.save();
      assertEquals(Animal.find(secondAnimal.getId()), secondAnimal);
  }
}