import org.sql2o.*;

public class Specie {
    private String name;
    private int population;
    private boolean endangered;
    private int sightingId;
    private int id;

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

  public int getId(){
    return id;
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

   public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO species (name, population, endangered, sightingid) VALUES (:name, :population, :endangered, :sightingid)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("population", this.population)
        .addParameter("endangered", this.endangered)
        .addParameter("sightingid", this.sightingId)
        .executeUpdate()
        .getKey();
    }
  }
}