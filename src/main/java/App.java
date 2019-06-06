import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        port(8000);
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

    get("/", (request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl" );
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    
    get("/form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("sightings", Sighting.all());
            model.put("template", "templates/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/form1", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("template", "templates/form1.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/form2", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("species", Specie.all());
            model.put("template", "templates/form2.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/species", (request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("species", Specie.all());
            model.put("template", "templates/species.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/sightings", (request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("sightings", Sighting.all());
            model.put("template", "templates/sightings.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/animals", (request,response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("template", "templates/animals.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/species/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Specie specie = Specie.find(Integer.parseInt(request.params(":id")));
            model.put("specie", specie);
            model.put("template", "templates/specie.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/sightings/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
            model.put("sighting", sighting);
            model.put("template", "templates/sighting.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    get("/animals/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Animal animal = Animal.find(Integer.parseInt(request.params(":id")));
            model.put("animal", animal);
            model.put("template", "templates/animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    post("/species", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int population = Integer.parseInt(request.queryParams("population"));
            boolean endangered =Boolean.parseBoolean(request.queryParams("endangered")) ;
            int sightingId = Integer.parseInt(request.queryParams("sightingId"));
            Specie newSpecie = new Specie(name, population, endangered, sightingId);
            newSpecie.save();
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    post("/sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangername = request.queryParams("rangername");
            String location = request.queryParams("location");
            Sighting newSighting = new Sighting(rangername, location);
            newSighting.save();
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    post("/animals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            int sightingId = Integer.parseInt(request.queryParams("sightingId"));
            Animal newAnimal = new Animal(name, health, age, sightingId);
            newAnimal.save();
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    // post("/sightings/:id/delete", (request, response) -> {
    //         Map<String, Object> model = new HashMap<String, Object>();
    //         Sighting sighting = Sighting.find(Integer.parseInt(request.params(":id")));
    //         sighting.deleteSighting();
    //         model.put("sightings", Sighting.all());
    //         model.put("template", "templates/sightings.vtl");
    //         return new ModelAndView(model, layout);
    //     }, new VelocityTemplateEngine());

    }
}