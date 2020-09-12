import java.util.ArrayList;
import java.util.List;

public class Squad {

    private int maxSize;
    private String name;
    private String cause;
    private static List<Squad> instances = new ArrayList<Squad>();
    private int id;

        //constructor for Squad
    public Squad(int maxSize, String squadName, String squadCause) {
        this.maxSize = maxSize;
        this.name = squadName;
        this.cause = squadCause;
        instances.add(this);
        this.id = instances.size();
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
    //getter/return list of Squad Instances
    public static List<Squad> getAllSquads() {
        return instances;
    }
    //clear all Squad instances
    public static void clearAllSquads() {
        instances.clear();
    }

}

