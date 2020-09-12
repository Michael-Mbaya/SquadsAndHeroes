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

    @Test
    public void getMaxSize_SquadInstantiatesWithMaxSize_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals(1,squad.getMaxSize());   //

    }

    @Test
    public void getName_SquadInstantiatesWithSquadName_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals("Squad 1",squad.getName());   //
    }

    @Test
    public void getCause_SquadInstantiatesWithSquadCause_true() throws Exception {
        Squad squad = setNewSquad();
        assertEquals("pass IP",squad.getCause());   //
    }

    @Test
    public void getId_SquadInstantiateWithAnID_1() throws Exception{
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(1,"other Squad","testing");
        assertEquals(1, squad.getId());
        assertEquals(2,otherSquad.getId());
    }

    @Test
    public void clearAllSquads_SquadClearAllInstances_true() throws Exception{
        Squad squad = setNewSquad();
        Squad otherSquad = new Squad(1,"other Squad","testing");
        assertEquals(2,Squad.getAllSquads().size());
        Squad.clearAllSquads();
        assertEquals(0,Squad.getAllSquads().size());
    }


}
