import org.junit.Test;
import static org.junit.Assert.*;

public class SquadTest {

    public Squad setNewSquad(){
        return new Squad(1,"Mbaya Squad","pass IP");
    }

    @Test
    public  void creates_instanceOfSquad_true(){
        Squad newSquad = setNewSquad();
        assertTrue(newSquad instanceof Squad);
    }


}
