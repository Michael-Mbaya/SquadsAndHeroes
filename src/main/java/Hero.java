import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private int age;
    private String specialPower;
    private  String weakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int id;

        //Hero constructor
        public Hero(String name, int age, String specialPower, String weakness) {
            this.name = name;
            this.age = age;
            this.specialPower = specialPower;
            this.weakness = weakness;
            instances.add(this);
            this.id = instances.size();
        }
    //getter for Hero name
    public String getName() {
        return name;
    }
    //getter for Hero age
    public int getAge() {
        return age;
    }
    //getter for Hero special power
    public String getSpecialPower() {
        return specialPower;
    }
    //getter for Hero weakness (Lame!!!)
    public String getWeakness() {
        return weakness;
    }
    //getter/return Hero instances
    public static List<Hero> getAllHeroes() {
        return instances;
    }
    //getter for a Hero id
    public int getId() {
        return id;
    }
    //method to delete all Hero instances (Haha! #Evil Laugh)
    public static void clearAllHeroes() {
        instances.clear();
    }
    //find a Hero instance
    public static Hero findHeroById(int id) {
        return instances.get(id - 1);
    }
//        try {
//            return instances.get(id - 1);
//        } catch (IndexOutOfBoundsException exception) {
//            return null;
//        }

    //find Hero instance by name
//    public static boolean findHeroByName(String name)
//    {
//        boolean isAvailable = false;
//        for (int i =0; i<instances.size(); i++)
//        {
//            if (name.equalsIgnoreCase(instances.get(i).name) )
//            {
//                isAvailable = true;
//            }
//        }
//
//        return isAvailable;
//    }


}
