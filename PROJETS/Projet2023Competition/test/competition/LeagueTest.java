package competition;
import competitor.Competitor;
import match.MockMatch;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import competition.League;

public class LeagueTest {
	
	private League league;
	
	@Before
	public void init() {
		this.league = this.createLeague();
	}
	
	private MockLeague createLeague() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		List<Competitor> competitors = List.of(c1, c2);
		return new MockLeague(competitors);
	}
	
	@Test
	public void shouldCallPlayMatchTwoTimesWhenTwoCompetitors() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		List<Competitor> competitors = List.of(c1, c2);
		
		MockLeague leagueMock = this.createLeague();
		leagueMock.setMatch(new MockMatch(leagueMock));
		leagueMock.play(competitors);
		
		assertEquals(2, leagueMock.numberOfTimesPlayMatchCalled);

	}
	
	@Test
	public void shouldNeverPlayMatchWhenNoCompetitor() {
		List<Competitor> noCompetitor = new ArrayList<>();
		
		MockLeague leagueMock = this.createLeague();
		leagueMock.play(noCompetitor);
		
		assertEquals(0, leagueMock.numberOfTimesPlayMatchCalled);
	}
	
	@Test
	public void createRightNumberOfMatches() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		Competitor c3 = new Competitor("c3");
		Competitor c4 = new Competitor("c4");
		Competitor c5 = new Competitor("c5");
		Competitor c6 = new Competitor("c6");
		List<Competitor> competitors = List.of(c1, c2, c3, c4, c5, c6);
		
		MockLeague leagueMock = this.createLeague();
		leagueMock.setMatch(new MockMatch(leagueMock));
		
		competitors.stream().forEach(c -> leagueMock.getPoints().put(c, 0));
		
		// If we have n competitors, a league plays n(n-1) games
		int numberOfCompetitors = competitors.size(); // Here, 6
		int numberOfMatches = numberOfCompetitors * (numberOfCompetitors - 1); // Here, 30
		
		leagueMock.play(competitors);
		
		assertEquals(numberOfMatches, leagueMock.numberOfTimesPlayMatchCalled);
	}
	
	@Test
	public void competitorsHaveEqualsPoints() {
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		Competitor c3 = new Competitor("c3");
		Competitor c4 = new Competitor("c4");
		List<Competitor> competitors = List.of(c1, c2, c3, c4);
		
		// in each match, the winner will be the first player, so they will have the same number of points at the end, 3 points
		MockLeague leagueMock = this.createLeague();
		leagueMock.setMatch(new MockMatch(leagueMock));
		
		competitors.stream().forEach(c -> leagueMock.getPoints().put(c, 0));
		
		leagueMock.play(competitors);
		
		assertEquals(3, leagueMock.getPoints().get(c1).intValue());
		assertEquals(3, leagueMock.getPoints().get(c2).intValue());
		assertEquals(3, leagueMock.getPoints().get(c3).intValue());
		assertEquals(3, leagueMock.getPoints().get(c4).intValue());	
	}
	
	@Test
	public void addPointsToTheWinnersOfTheMatch() {
		// we create two competitors and add them to the league
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		List<Competitor> competitors = List.of(c1, c2);
		
		MockLeague leagueMock = this.createLeague();
		leagueMock.setMatch(new MockMatch(leagueMock));
		competitors.stream().forEach(c -> leagueMock.getPoints().put(c, 0));
		// both competitors play a match, the winner is c1
		leagueMock.playMatch(c1, c2);
		
		// addPoints is call 1 time
		assertEquals(1, leagueMock.addPointsCalled);
		
		// c1 is the winner, he has 1 point
		assertEquals(1, leagueMock.getPoints().get(c1).intValue());
		
		// c2 has 0 point
		assertEquals(0, leagueMock.getPoints().get(c2).intValue());

	}

}
