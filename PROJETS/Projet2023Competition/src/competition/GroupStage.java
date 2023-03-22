
package competition;

import java.util.*;
import competitor.*;
import observer.MatchObserver;

public class GroupStage extends Competition{

    /**Attributs */
    protected int NbGroup;
    protected int NbComParGroups;
    protected List<League>Leagues;
    private List<MatchObserver>observers;

    /**
     * constructor
     * @param competitors (List<Competitor>) is Competitors's list'
     * @param NbGroup (int) number of groups
     * @param NbComParGroups (int) number of competitor per groups
     */
    public GroupStage(List<Competitor> competitors, int NbGroup , int NbComParGroups, List<MatchObserver>observers ){
        super(competitors);
        this.NbGroup = NbGroup;
        this.NbComParGroups = NbComParGroups;
        this.Leagues = new ArrayList<League>();
        this.observers= observers;


    }

    /**
     * Getters
     * @return the list of League in competition
     */
    public List<League> getLeagues () {
        return this.Leagues;
    }


    /**
     * Generate the Leagues from the list in param
     * @param comp (List<Competitor>) is the of competitor
     */
    public void generateLeagues(List<Competitor> competitors){
        for (int i = 0; i < this.NbGroup; i++) {
            List<Competitor> newcomp= new ArrayList<Competitor>();
            for (int j = 0; j < this.NbComParGroups; j++) {
                Competitor c = competitors.get(j+(this.NbComParGroups*i));
                newcomp.add(c);
                
            }
            League l = new League(newcomp);
            for(MatchObserver obs: this.observers ) {
        		l.getMatch().addObserver(obs);

            }
            this.Leagues.add(l);
        }
    }

    /**
     * Play every League generate by (generateLeagues) method
     * @param competitors (List<Competitor>) is the of competitor
     * @throws Exception 
     */
    public void play(List<Competitor> competitors) throws Exception{
        this.generateLeagues(competitors);
        int cnt = 1;
        for (League L : this.Leagues) {
            System.out.println("Le groupe " + cnt + " commence !\n");
            L.play();
            this.points.putAll(L.points);
            cnt+=1;
        }
        

    }

	@Override
	public void playMatch(Competitor a, Competitor b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<Competitor, Integer> Ranking() {
		// TODO Auto-generated method stub
		return null;
	}

    public void affichage() {
    	
    }

}