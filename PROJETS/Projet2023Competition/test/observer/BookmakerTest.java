package observer;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import competitor.Competitor;

public class BookmakerTest {
    protected Bookmaker b;
    protected Competitor c1;
    protected Competitor c2;
    protected List<Competitor> comp;
    
    @Before
    public void init(){
        this.b = new Bookmaker();
        this.c1 = new Competitor("c1");
        this.c2 = new Competitor("c2");
        this.comp = new ArrayList<Competitor>();
        this.comp.add(this.c1);
        this.comp.add(this.c2);
    }
	
	
	
	 @Test
	    public void addListTest(){
		
	        
	        this.b.addCompetitorsOdds(comp);
	        assertTrue(this.b.getCompetitorsOdds().containsKey(this.c1));
	        assertTrue(this.b.getCompetitorsOdds().containsKey(this.c2));
	        assertTrue(this.b.getCompetitorsOdds().get(this.c1)==1);
	        assertTrue(this.b.getCompetitorsOdds().get(this.c2)==1);
	    }
	
	 @Test
	    public void followmatchTest(){
		
	        
	        this.b.addCompetitorsOdds(this.comp);
	        this.b.followMatch(c1, c2);
	        assertTrue(this.b.getCompetitorsOdds().get(c1)==1);
	        assertTrue(this.b.getCompetitorsOdds().get(c2)==2);
	    }
	
	
	

}
