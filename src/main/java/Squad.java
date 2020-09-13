import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int maxSize;
    private String squadName;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<Squad>();
    private int id;
    private List<Hero> squadMember = new ArrayList<>();

        //constructor for Squad
    public Squad(int maxSize, String name, String cause) {
        this.maxSize = maxSize;
        this.squadName = name;
        this.cause = cause;
        instances.add(this);
        this.id = instances.size();
//        this.squadMembers = new ArrayList<>();
    }

    //getter for a Squad size(members are Hero's)
    public int getMaxSize() {
        return maxSize;
    }
    //getter for a Squad name
    public String getName() {
        return squadName;
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
    public static Squad findSquad(int id) {
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
        return squadMember;
    }
    //method to add a Squad's Hero/Heroes
    public void addHero(Hero hero) {
        squadMember.add(hero);
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

    public void update(int maxSize,String squadName,String cause) {
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;
    }

    public void deleteSquad(){
        instances.remove(id-1);
    }

}

