package observer;

import competitor.Competitor;


public interface MatchObserver {
	
	/**
     *  this match follow the match of two competitors
     * @param c1 competitor 1
     * @param c2 competitor 2
     */
    public void followMatch(Competitor c1,Competitor c2);

}
