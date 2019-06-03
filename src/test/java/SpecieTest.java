import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class SpeciesTest {

    @Rule
  public DatabaseRule database = new DatabaseRule();

    @Test
    public void Specie_instantiatesCorrectly_true() {
        Specie testSpecie = new Specie("Bubbles", 1);
        assertEquals(true, testSpecie instanceof Specie);
  }

}