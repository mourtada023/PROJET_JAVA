package match;

import java.util.ArrayList;
import java.util.List;

import competition.Competition;
import competitor.Competitor;
import observer.MatchObserver;

/** There can be different types of matches. */
public abstract class Match {

	protected Competition competition;

    protected List<MatchObserver> observers;

	public Match(Competition competition) {
		this.competition = competition;
		this.observers=new ArrayList<MatchObserver>();
	}	

	public Competition getCompetition() {
		return this.competition;
	}

	/**
	 * A winner is chosen and earns points.
	 * A description of the match is displayed.
	 * @param a one competitor
	 * @param b another competitor
	 */
	public void playMatch(Competitor a, Competitor b) {
		Competitor winner = this.chooseWinner(a, b);
		
		
		this.competition.addPoints(winner);
		
		System.out.println(a + " vs " + b + " --> " + winner + " wins!");


		if(winner.equals(a)) {

            this.observate(a,b);

		}else {

            this.observate(b,a);

		}

	}
	
	/**
     * .
     * @param c1 Competitor 1
     * @param c2 Competitor 2
     */
    public void observate(Competitor c1, Competitor c2){

        for(MatchObserver o : this.observers){
        	
            o.followMatch(c1,c2);
        }
    }

    /**
     * add 
     * @param o match observer
     */
    public void addObserver(MatchObserver o){
        this.observers.add(o);
    }
    
    public List<MatchObserver> getMatchObserver(){
    	return this.observers;
    }
    
    /**
     * remove 
     * @param o match observer
     */
    public void removeObserver(MatchObserver o){
        this.observers.remove(o);
    }
    
    
    
	
	public abstract Competitor chooseWinner(Competitor a, Competitor b);
	
}
