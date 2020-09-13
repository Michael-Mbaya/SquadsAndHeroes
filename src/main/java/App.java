import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;


import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        //Show a new squad form
        get("/squad/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }), new HandlebarsTemplateEngine());

        //Captures all the form details

        post("/squad/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String squadName = request.queryParams("squadName");
            String cause = request.queryParams("cause");
            int maxSize= Integer.parseInt(request.queryParams("maxSize"));
            Squad newSquad = new Squad(maxSize,squadName,cause);
            return new ModelAndView(model, "success.hbs");

        }), new HandlebarsTemplateEngine());


        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            List<Squad> squads = Squad.getAllSquads();
            List<Hero> heroes= Hero.getAllHeroes();
            model.put("squads", squads);
            model.put("heroes",heroes);
            return new ModelAndView(model, "squads.hbs");
        }, new HandlebarsTemplateEngine());

        //Show an individual squad
        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadID = Integer.parseInt(request.params(":id")); //pull id - must match route segment
            Squad foundSquad = Squad.findSquad(squadID);           //use it (id) to find post
            model.put("squad", foundSquad);                     //add it to model for template to display
            return new ModelAndView(model, "squad-detail.hbs"); //individual squad page.
        }, new HandlebarsTemplateEngine());

        //get: Show a form to update a squad
        get("/squads/:id/update", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadIdToEdit = Integer.parseInt(request.params("id"));
            Squad editSquad = Squad.findSquad(squadIdToEdit);
            model.put("editSquad", editSquad);
            return new ModelAndView(model, "squad-form.hbs");
        }), new HandlebarsTemplateEngine());

        //POST:process a form to update a squad
        post("/squads/:id/update", ((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            String newSquadName = request.queryParams("squadName");
            String newCause = request.queryParams("cause");
            int newMaxSize= Integer.parseInt(request.queryParams("maxSize"));
            int squadIdToEdit = Integer.parseInt(request.params("id"));
            Squad editSquad = Squad.findSquad(squadIdToEdit);
            editSquad.update(newMaxSize,newSquadName,newCause);
            return new ModelAndView(model,"success.hbs");
        }), new HandlebarsTemplateEngine());

        //get:Deletes squads
        get("/squads/:id/delete", ((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(request.params("id"));
            Squad deleteThisSquad = Squad.findSquad(idOfSquadToDelete);
            deleteThisSquad.deleteSquad();
            return new ModelAndView(model, "success.hbs");

        }), new HandlebarsTemplateEngine());





    }

}
