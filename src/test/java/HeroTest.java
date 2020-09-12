import org.junit.Test;
import static org.junit.Assert.*;

public class HeroTest {

    @Test
    public void creates_instanceOfHero_true(){
        Hero newHero = new Hero();
        assertTrue(newHero instanceof Hero);
    }


}
