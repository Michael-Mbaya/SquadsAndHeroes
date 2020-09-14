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
    public void Hero_InstantiatesCorrectly_true() throws Exception {
        Hero myHero = new Hero("Me", 25, "Wits", "LWK", 1);
        assertTrue(myHero instanceof Hero);
    }

    public Hero setUpNewHero() {

        return new Hero("Batman", 32, "Sulking", "Robin", 1);
    }

    @Test
    public void getName_HeroInstantiatesWithName_true() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Batman", myHero.getName());
    }

    @Test
    public void getAge_HeroInstantiatesWithAge_32() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals(32, myHero.getAge());
    }

    @Test
    public void getSpecialPower_HeroInstantiatesWithSpecialPower_Sulking() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Sulking", myHero.getSpecialPower());
    }

    @Test
    public void getWeakness_HeroInstantiatesWithWeakness_Robin() throws Exception {
        Hero myHero = setUpNewHero();
        assertEquals("Robin", myHero.getWeakness());
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