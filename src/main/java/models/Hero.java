package models;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String specialPower;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();
    private int id;
    private int squadID;

    public Hero(String name, int age, String specialPower, String weakness, int squadID) {
        this.name = name;
        this.age = age;
        this.specialPower = specialPower;
        this.weakness = weakness;
        instances.add(this);
        this.squadID = squadID;
        addHeroToSquad(squadID);
        this.id = instances.size();

    }

    public void addHeroToSquad(int squadID){
        for(Squad squad:Squad.getAll()){
            if(squad.getId() == squadID){
                squad.addMember(this);
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getAll() {
        return instances;
    }

    public static void clearAllHeroes(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

        public int getSquadID() {
        return squadID;
    }

}
