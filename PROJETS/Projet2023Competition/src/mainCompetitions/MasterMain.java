package mainCompetitions;


import java.util.ArrayList;
import java.util.List;

import competition.Master;
import competitor.Competitor;
import match.Match;
import match.RandomMatch;
import observer.Bookmaker;
import observer.Journalist;
import observer.MatchObserver;
import select.FirstSelected;
import select.Selection;


public class MasterMain {

    public static void main(String[] args) throws Exception {
        List<Competitor> MesCompetiteurs = new ArrayList<>();
        for(int i = 0; i < 16; i++){
                MesCompetiteurs.add(new Competitor(Integer.toString(i)));
        }
        MatchObserver journaliste = new Journalist();
        Bookmaker bookmaker  = new Bookmaker();
 
        bookmaker.addCompetitorsOdds(MesCompetiteurs);
        Selection myselection = new FirstSelected();
        Master master = new Master(MesCompetiteurs, myselection, 4, 4 );

        
        master.addObserver(journaliste);
        master.addObserver(bookmaker);

        master.play();


    }
    
    
}
