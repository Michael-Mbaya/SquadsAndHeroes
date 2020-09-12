import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class SquadTest {

    public Squad setNewSquad(){
        return new Squad(1,"Squad 1","pass IP");
    }

    @After
    public void tearDown(){
        Squad.clearAllSquads();      //clear out all the Squad's before each test.
    }

    @Test
    public  void creates_instanceOfSquad_true(){
        Squad newSquad = setNewSquad();
        assertTrue(newSquad instanceof Squad);
    }

    @Test   //see if all Squad instances are returned
    public void AllSquadsAreCorrectlyReturned_true() {
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(2,"squad 2","IP>80%");
        assertEquals(2,Squad.getAllSquads().size());
    }

    @Test   //see if Squad objects contains some instances
    public void Squad_ContainsSquadInstances_true() {
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(1,"other Squad","testing");
        assertTrue(Squad.getAllSquads().contains(squad));
        assertTrue(Squad.getAllSquads().contains(otherSquad));
    }

    @Test   //see if a new Squad instance has Max Size
    public void getMaxSize_SquadInstantiatesWithMaxSize_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals(1,squad.getMaxSize());   //

    }

    @Test   //see if a new Squad instance has Squad Name
    public void getName_SquadInstantiatesWithSquadName_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals("Squad 1",squad.getName());   //
    }

    @Test   //see if a new Squad instance has Squad Cause
    public void getCause_SquadInstantiatesWithSquadCause_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals("pass IP",squad.getCause());   //
    }

    @Test   //see if a new Squad instance has Id
    public void getId_SquadInstantiateWithAnID_1() throws Exception{
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(1,"other Squad","testing");
        assertEquals(1, squad.getId());
        assertEquals(2,otherSquad.getId());
    }

    @Test   //see if Squad can delete all Squad instances
    public void clearAllSquads_SquadClearAllInstances_true() throws Exception{
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(1,"other Squad","testing");
        assertEquals(2,Squad.getAllSquads().size());
        Squad.clearAllSquads();
        assertEquals(0,Squad.getAllSquads().size());
    }

    @Test   //see if a new Squad instance can add a Hero
    public void addHero_addsHeroToList_true() {
        Squad otherSquad = new Squad(1,"other Squad","testing");
        Hero testHero = new Hero("T-bag",25,"Annoying","Scofield");
        otherSquad.addHero(testHero);
        assertTrue(otherSquad.getSquadHeroes().contains(testHero));
    }

    @Test   //see if Squad instance has a Hero instance from the addHero method
    public void heroAlreadyExists_checksIfHeroExistsinSquads_true() {
        Squad testSquad = new Squad(1,"other Squad","testing");
        Hero testHero = new Hero("T-bag",25,"Annoying","Scofield");
        Hero testHeroTwo = new Hero("T-pain",25,"Auto-tune","Akon");
        testSquad.addHero(testHero);
        assertTrue(testSquad.heroAlreadyExists(testHero));
        assertEquals(false,testSquad.heroAlreadyExists(testHeroTwo));
        assertEquals(true,testSquad.heroAlreadyExists(testHero));
    }

}
