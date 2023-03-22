package competition;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import competition.GroupStage;
import competitor.Competitor;
import observer.MatchObserver;

public class StageTest  {

	private GroupStage   groupStage ;
	private List<Competitor> competitors;

	
	@Test
    public void generateLeaguesTest() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		Competitor c3 = new Competitor("c3");
		Competitor c4 = new Competitor("c4");
		this.competitors = List.of(c1, c2,c3,c4);
		List<MatchObserver>observers= new ArrayList<>();

		this.groupStage =  new GroupStage(competitors,2,2,observers);
		
		assertTrue(this.groupStage.getLeagues().isEmpty());
	this.groupStage.generateLeagues( competitors);
	//this assert test if nbleague  are correct
	assertTrue(this.groupStage.getLeagues().size()==2);
	//this assert test if nbcompetitor for league are correct
	assertTrue(this.groupStage.getLeagues().get(0).getCompetitors().size()==2);


		
		
	}
	
}
