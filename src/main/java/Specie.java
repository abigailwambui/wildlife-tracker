public class Specie {
    private String name;
    private int population;
    private boolean endangered;

  public Specie(String name, int population, boolean endangered, int sightingId) {
      this.name = name;
      this.population = population;
      this.endangered = endangered;
  }

  public String getName(){
    return name;
  }

  public int getPopulation(){
    return population;
  }

  public boolean getEndangered(){
    return endangered;
  }
}