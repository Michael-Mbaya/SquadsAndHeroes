package models;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }
        port(port);


        //The homepage
        get("/", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }), new HandlebarsTemplateEngine());

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
            Squad newSquad = new Squad(squadName, cause, maxSize);
            return new ModelAndView(model, "success.hbs");

        }), new HandlebarsTemplateEngine());

        //View all the squads
        get("/squads", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            ArrayList<Hero> heroes = Hero.getAll();
            model.put("squads", squads);
            model.put("heroes",heroes);
            return new ModelAndView(model, "view-squad.hbs");
        }), new HandlebarsTemplateEngine());

        //Show an individual squad
        get("/squads/:id", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadID = Integer.parseInt(request.params(":id"));
            Squad foundSquad = Squad.findById(squadID);
            //ArrayList<Hero> heroes = Squad.get;
            model.put("squad", foundSquad);

            return new ModelAndView(model, "view-squad-details.hbs");
        }), new HandlebarsTemplateEngine());

        //get: Show a form to update a squad
        get("/squads/:id/update", ((request, response) -> {
          Map<String, Object> model = new HashMap<>();
          int squadIdToEdit = Integer.parseInt(request.params("id"));
          Squad editSquad = Squad.findById(squadIdToEdit);
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
            Squad editSquad = Squad.findById(squadIdToEdit);
            editSquad.update(newSquadName, newCause,newMaxSize);
            return new ModelAndView(model,"success.hbs");
        }), new HandlebarsTemplateEngine());

        //get:Deletes squads
        get("/squads/:id/delete", ((request, response) -> {
            Map<String,Object> model = new HashMap<>();
            int idOfSquadToDelete = Integer.parseInt(request.params("id"));
            Squad deleteSquad = Squad.findById(idOfSquadToDelete);
            deleteSquad.deleteSquad();
            return new ModelAndView(model, "success.hbs");

        }), new HandlebarsTemplateEngine());

        get("/squads/:id/heroes/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadID = Integer.parseInt(request.params(":id"));
            Squad foundSquad = Squad.findById(squadID);
            model.put("squad",foundSquad);
            return new ModelAndView(model, "heroes.hbs");
        }), new HandlebarsTemplateEngine());

        //get: Process form to add a new Hero
        post("/squads/:id/heroes/new", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age= Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("specialPower");
            String weakness = request.queryParams("weakness");
            int squadID = Integer.parseInt(request.params(":id"));
//            Squad foundSquad = Squad.findById(squadID);

            Hero newHero = new Hero(name,age, specialPower, weakness, squadID);

            return new ModelAndView(model, "success.hbs");


        }), new HandlebarsTemplateEngine());

        //View all the heroes

        get("/squads/:id/heroes", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int squadID = Integer.parseInt(request.params(":id"));
            Squad foundSquad = Squad.findById(squadID);
            model.put("heroes", foundSquad.getSquadMembers());
            return new ModelAndView(model, "view-heroes.hbs");
        }), new HandlebarsTemplateEngine());




    }
}
