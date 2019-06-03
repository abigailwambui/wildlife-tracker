public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherAnimal){
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName());            
    }
  }

    public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name) VALUES (:name)";
      con.createQuery(sql)
        .addParameter("name", this.name)
        .executeUpdate();
    }
  }


}
