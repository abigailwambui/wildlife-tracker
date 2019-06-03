import org.sql2o.*;

public class Sighting {
    private String location;
    private String name;

    public Sighting(String location, String name) {
        this.location = location;
        this.name = name;
        
    }

    public String getLocation(){
      return location;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation())&&
             this.getName().equals(newSighting.getName());            
    }
  }

    public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (location, name) VALUES (:name, :location)";
      con.createQuery(sql)
        .addParameter("location", this.location)
        .addParameter("name", this.name)
        .executeUpdate();
    }
  }


}
