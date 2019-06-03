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

}