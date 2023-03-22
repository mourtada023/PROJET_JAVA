package competition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import match.RandomMatch;

import competitor.Competitor;
import util.MapUtil;

/** Leagues are played in two-legged matches */
public class League extends Competition {

	public League(List<Competitor> competitors) {
		super(competitors); 
		this.match = new RandomMatch(this);
	}
	
	/**
	 * Organizes the teams. Each competitor meets twice each other competitor of the league.
	 * @param competitors
	 */
	public void play(List<Competitor> competitors) {
		for(Competitor a : competitors) {
			for(Competitor b : competitors) {
				if ( !(a.equals(b)) ) {
					this.playMatch(a,b);
				}
			}
		}
	}
	
	/**
	 * plays a match between two competitors
	 */
	public void playMatch(Competitor a, Competitor b) {
	    this.match.playMatch(a,b);
	}
	
	
	/**
	 * Rank the competitors in descending order according to their points
	 * @return (Map <Competitor, Integer> ) the Ranking Map
	 */
	public Map<Competitor,Integer> Ranking(){ 
		return null;
	}
	
	
	public void affichage() {
		Map <Competitor,Integer> temp = MapUtil.sortByDescendingValue(this.getPoints());
		for (Entry<Competitor,Integer> entry: temp.entrySet())
			System.out.println(entry.getKey().getName() + " - " + this.points.get(entry.getKey()));
	}
	
	public String toString() {
		return "league";
	}
	
}
