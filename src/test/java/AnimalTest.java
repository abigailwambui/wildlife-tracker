import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AnimalTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void animal_instantiatesCorrectly_true() {
      Animal testAnimal = new Animal("Elephant");
      assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    public void getName_animalInstantiatesWithName_leopard(){
      Animal testAnimal = new Animal("Elephant");
      assertEquals("Elephant", testAnimal.getName());
  
  }

    @Test
    public void equals_returnsTrueIfNameisSame_true() {
      Animal firstAnimal = new Animal("Elephant");
      Animal anotherAnimal = new Animal("Elephant");
      assertTrue(firstAnimal.equals(anotherAnimal));
    }


}

