package select;
import java.util.*;
import java.util.Map.Entry;

import competitor.*;
import util.MapUtil;
import competition.*;

public class FirstSelected implements Selection{

	

    /**
     * This method select the first competitor of each league played in groupStage
     * @param g (A GroupeStage)
     * @return the selected Competitor
     */
    public List<Competitor> select (GroupStage g){
        List<League> Leagues = g.getLeagues();
        List <Competitor> selected = new ArrayList<Competitor>();
        for (League league : Leagues) { 
        	Map<Competitor,Integer> ranking =  MapUtil.sortByDescendingValue(league.getPoints());

            List<Entry<Competitor,Integer>> sortedEntries = new ArrayList<Entry<Competitor,Integer>>(ranking.entrySet());
            selected.add(sortedEntries.get(0).getKey());
        }
        
        
        return selected;
    }
    
}
