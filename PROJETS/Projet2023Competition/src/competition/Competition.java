package competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import util.MapUtil;
import competitor.Competitor;
import exception.NotPowerOfTwoException;
import match.Match;
import match.RandomMatch;
import observer.MatchObserver;

/** A sport competition is defined as matches played between competitors. */
public abstract class Competition {
	
	protected List<Competitor> competitors;
	protected Map<Competitor, Integer> points;
	protected Match match;
	
	public Competition(List<Competitor> competitors) {
		this.competitors = competitors;
		this.points = new HashMap<Competitor, Integer>();
		// At the beginning, all the competitors have 0 point
		competitors.stream().forEach(c -> this.points.put(c, 0));
		
	this.match= new RandomMatch(this);
	}
	
	public Match getMatch() {
		return match;
		
	}
	public void addObserver(MatchObserver obs){
		this.match.addObserver(obs);
	}
	
	/**
	 * All the competitors
	 * @return list of competitors
	 */
	public List<Competitor> getCompetitors() {
		return this.competitors;
	}
	
	public Map<Competitor, Integer> getPoints() {
		return this.points;
	}
	
	 protected void setPoint(Competitor competitor){
		 this.points.put(competitor, 0);
	 }
	         
	
	/**
	 * changes the match
	 * @param match
	 */
	public void setMatch(Match match) {
	    this.match = match;
	}
	
	/**
	 * add points to the competitor
	 * @param competitor
	 */
	public void addPoints(Competitor competitor) {
		this.points.put(competitor, this.points.get(competitor) + 1);
	}
	
	

	
	
	/**
	 * Organizes the players of the competition in several matches
	 * Each match is played
	 * A competition is finished when all its matches have been played
	 * A ranking of the competitors is made
	 * The winner is displayed
	 * @throws Exception 
	 */
	public void play() throws Exception {
		this.play(this.competitors);
		System.out.println("\n*** Ranking ***\n");
		this.affichage();

	}

	
	
	protected abstract void play(List<Competitor> competitors) throws NotPowerOfTwoException, Exception;
	
	public abstract void playMatch(Competitor a, Competitor b);
	public abstract void affichage() ;
	public abstract  Map<Competitor, Integer> Ranking();
}
