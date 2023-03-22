package match;
import match.Match;
import competitor.Competitor;
import competition.Competition;

public class MockMatch extends Match {
	
	public MockMatch(Competition competition) {
		super(competition);
	}
	
    /**
     * The random method will always return the first competitor
     */
	@Override
	public Competitor chooseWinner(Competitor c1, Competitor c2) {
		return c1;
	}

}
