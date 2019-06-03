import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class Sighting {
    private String location;
    private String rangername;
    private int id;
    private Timestamp date;

    public Sighting(String location, String rangername) {
        this.location = location;
        this.rangername = rangername;
        
    }

    public String getLocation(){
      return location;
    }

    public String getRangerName() {
        return rangername;
    }

    public int getId() {
      return id;
    }

    public Timestamp getDate() {
      return date;
    }

    @Override
    public boolean equals(Object otherSighting){
        if (!(otherSighting instanceof Sighting)) {
            return false;
        } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation())&&
             this.getRangerName().equals(newSighting.getRangerName());        
    }
  }

    public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO sightings (location, rangername, date) VALUES (:location, :rangername, now())";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("location", this.location)
        .addParameter("rangername", this.rangername)
        .executeUpdate()
        .getKey();
    }
  }

    public static List<Sighting> all() {
    String sql = "SELECT * FROM sightings";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Sighting.class);
    }
  }

    public static Sighting find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM sightings where id=:id";
      Sighting sighting = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Sighting.class);
      return sighting;
    }
  }

    public List<Animal> getAnimals() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals where sightingId=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Animal.class);
    }
  }

    
}
