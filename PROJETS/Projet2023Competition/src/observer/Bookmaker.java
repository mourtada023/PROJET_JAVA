package observer;

import java.util.HashMap;
import java.util.List;

import competitor.Competitor;

public class Bookmaker implements MatchObserver {
	
	 protected HashMap<Competitor, Integer> competitorsOdds;
	    public Bookmaker(){
	        this.competitorsOdds = new HashMap<Competitor,Integer>();
	    }

	@Override
	/**
     * 
     * this method give a Odds to the competitor after a match, it add  one point for  looser and remove one point for the winner but stay at 1 if it's equals to 1.
     * @param c1 competitor 1
     * @param c2 competitor 2**/
	
	public void followMatch(Competitor c1, Competitor c2) {
		
	     int loserOdds = this.competitorsOdds.get(c2);
	     
	        this.competitorsOdds.put(c2, (loserOdds+1));
	        int winnerOds = this.competitorsOdds.get(c1);
	        if(winnerOds != 1){
	            this.competitorsOdds.put(c1, (winnerOds-1));
	        }
	        
	        System.out.println("---------------this is the bookmaker ods------------ ");
	        
	        System.out.println("The winner  : "+c1.getName()+" (ods : "+ this.competitorsOdds.get(c1) +") the loser is "+c2.getName()+" (ods : "+ this.competitorsOdds.get(c2) +").");

		
	}
	
	public HashMap<Competitor, Integer> getCompetitorsOdds(){
		return this.competitorsOdds;
	}
	
	
	
	
	 /**
     * add the list of competitors to the HashMap<Competitor, Integer> and start at 1 as rate
     * @param comp CompetitorList
     * 
     */
	public void addCompetitorsOdds(List<Competitor> comp) {
		 for(Competitor c : comp){
	            this.competitorsOdds.put(c, 1);
	        }
	}

}
