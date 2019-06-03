public class Specie {
    private String name;
    private int population;

  public Specie(String name, int population, boolean endangered, int sightingId) {
      this.name = name;
      this.population = population;
  }

  public String getName(){
    return name;
  }

  public int getPopulation(){
    return population;
  }

}