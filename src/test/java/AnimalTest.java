import org.junit.*;
import static org.junit.Assert.*;

public class AnimalTest {

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

}

