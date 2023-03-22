package competitor;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class CompetitorTest {

	private Competitor c1;
	private Competitor c2;

	@Before
	public void before() {
		this.c1 = new Competitor("competitor1");
		this.c2 = new Competitor("competitor2");
	}

	@Test
	public void testGetName() {
		assertEquals("competitor1", this.c1.getName());
		assertEquals("competitor2", this.c2.getName());
	}

    
}
