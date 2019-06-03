import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
        Animal testAnimal = new Animal("Elephants", 1);
        assertEquals(true, testAnimal instanceof Animal);
  }

    @Test
    public void animal_instantiatesWithName_String() {
        Animal testAnimal = new Animal("Elephants", 1);
        assertEquals("Elephants", testAnimal.getName());
  }

    @Test
    public void animal_instantiatesWithSightingId_int() {
        Animal testAnimal = new Animal("Elephants", 1);
        assertEquals(1, testAnimal.getSightingId());
  }

    @Test
    public void equals_returnsTrueIfNameAndSightingIdAreSame_true() {
        Animal testAnimal = new Animal("Elephants", 1);
        Animal anotherAnimal = new Animal("Elephants", 1);
        assertTrue(testAnimal.equals(anotherAnimal));
  }

    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        Animal testAnimal = new Animal("Elephants", 1);
        testAnimal.save();
        assertTrue(Animal.all().get(0).equals(testAnimal));
  }
}