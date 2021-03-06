import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String health;
    private String age;
    private int sightingId;
    private int id;

  public Animal(String name, String health, String age, int sightingId) {
      this.name = name;
      this.health = health;
      this.age = age;
      this.sightingId = sightingId;
  }

  public String getName(){
      return name;
  }

  public String getHealth(){
      return health;
  }

  public String getAge(){
      return age;
  }

  public int getSightingId(){
      return sightingId;
  }

  public int getId(){
    return id;
  }


  @Override
  public boolean equals(Object otherAnimal){
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName()) &&
             this.getHealth().equals(newAnimal.getHealth()) &&
             this.getAge().equals(newAnimal.getAge()) &&
             this.getSightingId() == newAnimal.getSightingId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, health, age, sightingid) VALUES (:name, :health, :age, :sightingId)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .addParameter("sightingId", this.sightingId)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Animal> all() {
    String sql = "SELECT * FROM animals";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Animal.class);
    }
  }

  public static Animal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where id=:id";
      Animal animal = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Animal.class);
      return animal;
    }
  }

  public void updateAnimal(String name, String health, String age, int sightingId) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET name = :name , health = :health , age = :age, sightingId = :sightingId WHERE id = :id";
      con.createQuery(sql)
          .addParameter("name", name)
          .addParameter("health", health)
          .addParameter("age", age)
          .addParameter("sightingId", sightingId)
          .addParameter("id", id)
          .executeUpdate();
        }
    }

  public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM animals WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}