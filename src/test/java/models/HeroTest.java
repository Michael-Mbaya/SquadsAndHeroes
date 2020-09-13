package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class HeroTest {

    @After
    public void clearInstances(){
        Hero.clearAllHeroes();
    }

    @Test
    public void HeroInstantiatesCorrectly_true() throws Exception {
        Hero myHero = new Hero("CatWoman", 23, "Climbing", "Robin", 1);
        assertTrue(myHero instanceof Hero);
    }

    public Hero setUpNewHero() {

        return new Hero("Batman", 32, "Sulking", "Robin", 1);
    }

    @Test
    public void addHeroToSquad() {
        Squad squad = new Squad("testName","IP",12);
        Hero hero = setUpNewHero();
        assertTrue(true);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Batman", myHero.getName());
    }

    @Test
    public void HeroInstantiatesWithAge_32() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals(32, myHero.getAge());
    }

    @Test
    public void HeroInstantiatesWithSpecialPower_Sulking() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Sulking", myHero.getSpecialPower());
    }

    @Test
    public void HeroInstantiatesWithWeakness_Robin() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Robin", myHero.getWeakness());
    }

    @After
    public void tearDown() throws Exception {
        Hero.clearAllHeroes();

    }

    @Test
    public void AllHeroesAreCorrectlyReturned() {
        Hero myHero = setUpNewHero();
        Hero otherHero = setUpNewHero();
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllHeroesContainsAllHeroes() {
        Hero myHero = setUpNewHero();
        Hero otherHero = setUpNewHero();
        assertTrue(Hero.getAll().contains(myHero));
        assertTrue(Hero.getAll().contains(otherHero));

    }

}