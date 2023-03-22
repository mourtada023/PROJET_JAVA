package match;
import org.junit.Test;
import competition.Competition;
import static org.junit.Assert.assertSame;
import org.junit.Before;
import competitor.Competitor;
import match.Match;

public class RandomMatchTest {
	
	private Match match;
	private Competition competition;
	
	@Before
	public void init() {
		this.match = this.createMatch();
	}
	
	private MockMatch createMatch() {
		return new MockMatch(competition);
	}
	
	@Test
	public void testChooseWinner() {
		// we create two competitors
		Competitor c1 = new Competitor("c1");
		Competitor c2 = new Competitor("c2");
		MockMatch matchMock = this.createMatch();
		
		Competitor winner = matchMock.chooseWinner(c1, c2);
		
		// the winner is the c1
		assertSame(c1, winner);
	}
	
	// ---Pour permettre l'execution des tests ----------------------
	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(RandomMatchTest.class);
	}
	
}
