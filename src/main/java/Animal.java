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


  @Override
  public boolean equals(Object otherAnimal){
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) &&
             this.getSightingId() == newAnimal.getSightingId();
    }
  }

}