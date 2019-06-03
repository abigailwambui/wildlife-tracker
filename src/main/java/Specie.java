public class Specie {
    private String name;

  public Specie(String name, int population, boolean endangered, int sightingId) {
      this.name = name;
  }

  public String getName(){
    return name;
  }

}