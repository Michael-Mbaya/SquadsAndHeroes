import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class HeroTest {

    public Hero setNewHero(){
        return new Hero("Mbaya",25,"Wits","LWK");
    }

    @After
    public void tearDown(){
        Hero.clearAllHeroes();      //clear out all the Hero's before each test.
    }

    @Test   //see if Hero is instantiated correctly
    public void creates_instanceOfHero_true(){
        Hero newHero = setNewHero();
        assertTrue(newHero instanceof Hero);
    }

    @Test   //see if all Hero instances are returned
    public void AllHeroesAreCorrectlyReturned_true() {
        Hero hero = setNewHero();
        Hero otherHero = new Hero("other me",25,"sleep","Mornings");
        assertEquals(2,Hero.getInstances().size());
    }

    @Test   //see if Hero objects contains some instances
    public void Hero_ContainsHeroesInstances_true() {
        Hero hero = setNewHero();
        Hero otherHero = new Hero("other me",25,"sleep","Mornings");
        assertTrue(Hero.getInstances().contains(hero));
        assertTrue(Hero.getInstances().contains(otherHero));
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = setNewHero();
        assertEquals("Mbaya",hero.getName());   //name is "Mbaya"
    }

    @Test
    public void HeroInstantiatesWithAge_true() throws Exception {
        Hero hero = setNewHero();
        assertEquals(25,hero.getAge());     //age is 25
    }

    @Test
    public void HeroInstantiatesWithSpecialPower_true() throws Exception {
        Hero hero = setNewHero();
        assertEquals("Wits",hero.getSpecialPower());    //specialPower is "Wits"
    }

    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception {
        Hero hero = setNewHero();
        assertEquals("LWK",hero.getWeakness());     //weakness is "LWK"
    }

    @Test
    public void getId_HeroesInstantiateWithAnID_1() throws Exception{
        Hero hero = setNewHero();
        Hero otherHero = new Hero("other me",25,"sleep","Mornings");
        assertEquals(1, hero.getId());
        assertEquals(2,otherHero.getId());
    }

}
