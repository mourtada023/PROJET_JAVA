package competition;
import java.util.List;
import competition.League;
import competitor.Competitor;

public class MockLeague extends League {

    public int numberOfTimesPlayMatchCalled = 0;
    
    public int addPointsCalled = 0;
    
    public MockLeague(List<Competitor> competitors) {
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
