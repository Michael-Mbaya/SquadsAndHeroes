package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String squadName;
    private String cause;
    private int maxSize;
    private List<Hero> squadMembers = new ArrayList<>();
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int id;



    public Squad(String squadName, String cause, int maxSize) {
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;
        instances.add(this);
        this.id = instances.size();

    }

    public void addMember(Hero hero){
        squadMembers.add(hero);
    }

    public List<Hero> getSquadMembers() {
        return squadMembers;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getCause() {
        return cause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public static ArrayList<Squad> getAll() {
        return instances;
    }

    public static void clearAllSquads(){
        instances.clear();
    }

    public int getId() {
        return id;
    }

    public static Squad findById(int id) {
        return instances.get(id-1);
    }

    public void update(String squadName, String cause , int maxSize) {
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;
    }

    public void deleteSquad(){
        instances.remove(id-1);
    }


}
