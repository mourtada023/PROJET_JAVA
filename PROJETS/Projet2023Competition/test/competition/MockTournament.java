package competition;
import java.util.List;
import competitor.Competitor;
import competition.Tournament;

public class MockTournament extends Tournament {
	
	public int numberOfTimesPlayMatchCalled = 0;
	
	public int addPointsCalled = 0;
	
	public MockTournament(List<Competitor> competitors) {
		super(competitors);
	}
	
	@Override
	public void playMatch(Competitor a, Competitor b) {
		this.numberOfTimesPlayMatchCalled++;
		super.playMatch(a,b);
	}
	
	public void addPoints(Competitor competitor) {
		this.addPointsCalled++;
		super.addPoints(competitor);
	}

}
