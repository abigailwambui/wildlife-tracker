public class Specie {
    private String name;
    private int population;
    private boolean endangered;
    private int sightingId;

  public Specie(String name, int population, boolean endangered, int sightingId) {
      this.name = name;
      this.population = population;
      this.endangered = endangered;
      this.sightingId = sightingId;
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

  public int getSightingId(){
    return sightingId;
  }

  @Override
  public boolean equals(Object otherSpecie){
    if (!(otherSpecie instanceof Specie)) {
      return false;
    } else {
      Specie newSpecie = (Specie) otherSpecie;
      return this.getName() == newSpecie.getName() &&
             this.getPopulation() == newSpecie.getPopulation() &&
             this.getEndangered() == newSpecie.getEndangered() &&
             this.getSightingId() == newSpecie.getSightingId();
    }
  }
}