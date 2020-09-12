import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int maxSize;
    private String name;
    private String cause;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int id;
    private List<Hero> squadHeroes;

        //constructor for Squad
    public Squad(int maxSize, String squadName, String squadCause) {
        this.maxSize = maxSize;
        this.name = squadName;
        this.cause = squadCause;
        instances.add(this);
        this.id = instances.size();
        this.squadHeroes = new ArrayList<Hero>();
    }

    //getter for a Squad size(members are Hero's)
    public int getMaxSize() {
        return maxSize;
    }
    //getter for a Squad name
    public String getName() {
        return name;
    }
    //getter for a Squad cause
    public String getCause() {
        return cause;
    }
    //getter for a Squad id
    public int getId() {
        return id;
    }
    //method to find a Squad instance
    public static Squad find(int id) {
        return instances.get(id - 1);
    }
    //getter/return list of Squad Instances
    public static List<Squad> getAllSquads() {
        return instances;
    }
    //clear all Squad instances
    public static void clearAllSquads() {
        instances.clear();
    }
    //getter/return list of Squad Hero/Heroes
    public List<Hero> getSquadHeroes() {
        return squadHeroes;
    }
    //method to add a Squad's Hero/Heroes
    public void addHero(Hero hero) {
        squadHeroes.add(hero);
    }
    //check if a squadHero is in another Squad
    public static boolean heroAlreadyExists(Hero newHero) {
        boolean exists = false;
        for(Squad squad: instances){
            for(Hero hero: squad.getSquadHeroes()){
                if (hero.getName().equals(newHero.getName())) {
                    exists = true;
                }
            }
        }
        return exists;
    }

}

