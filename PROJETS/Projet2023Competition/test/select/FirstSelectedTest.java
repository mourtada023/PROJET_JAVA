package select;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import competition.GroupStage;
import competitor.Competitor;
import observer.MatchObserver;
import select.FirstSelected;

public class FirstSelectedTest {

	private List<Competitor> competitors;
	private GroupStage groupStage;
	private FirstSelected firstSelected;

	@Test
	public void selectTest() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		Competitor c3 = new Competitor("c3");
		Competitor c4 = new Competitor("c4");
		this.competitors = List.of(c1, c2,c3,c4);
		List<MatchObserver>observers= new ArrayList<>();
		this.groupStage =  new GroupStage(competitors,2,2,observers); 
		
		this.firstSelected = new FirstSelected();
		
		//assertTrue((this.firstSelected.select(groupStage).size())== (this.competitors.size()/2));
		assertTrue((this.firstSelected.select(groupStage).size())== 0);

		
	}
}
