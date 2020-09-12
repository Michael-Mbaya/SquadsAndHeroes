import org.junit.Test;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public  void creates_instanceOfSquad_true(){
        Squad newSquad = new Squad();
        assertTrue(newSquad instanceof Squad);
    }


}
