package competition;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import competition.GroupStage;
import competition.Master;
import competitor.Competitor;
import select.FirstSelected;

public class MasterTest {

	private List<Competitor> competitors;
	private Master master ;
	
	/*
	 * this method test if nbCompetitor are correct  
	 * 
	 * **/

	 @BeforeEach
	    public void before(){
		 Competitor c1 = new Competitor("c1");
			Competitor c2 = new Competitor("c2");
			Competitor c3 = new Competitor("c3");
			Competitor c4 = new Competitor("c4");
			this.competitors = List.of(c1, c2,c3,c4);
	        
	    }
	@Test
    public void checkNbCompetitorTestOk() {
		FirstSelected first= new FirstSelected();

		this.master =  new Master(this.competitors,first,2,2);
		assertTrue(this.master.checkNbCompetitor(this.master.getCompetitors()));

	}
	@Test
    public void checkNbCompetitorTestKo() {
	
		FirstSelected first= new FirstSelected();
		this.master =  new Master(this.competitors,first,3,2);
		assertFalse(this.master.checkNbCompetitor(this.master.getCompetitors()));
		
	}
}
