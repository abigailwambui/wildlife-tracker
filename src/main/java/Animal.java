public class Animal {
    private String name;
    private int sightingId;

  public Animal(String name, int sightingId) {
      this.name = name;
      this.sightingId = sightingId;
  }

  public String getName(){
      return name;
  }

  public int getSightingId(){
      return sightingId;
  }

}