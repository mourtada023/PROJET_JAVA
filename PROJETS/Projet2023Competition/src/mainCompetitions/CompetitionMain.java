package mainCompetitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import competition.Competition;
import competition.League;
import competition.Tournament;
import match.Match;
import match.RandomMatch;
import observer.Bookmaker;
import observer.Journalist;
import observer.MatchObserver;
import competitor.Competitor;

import static java.lang.Integer.parseInt;

public class CompetitionMain {
	
	public static void main(String[] args) throws Exception {
		
		String choice = "";
		Competition competition = null;
		
		// We create arrays with the competitors' names
		String[] leagueArray = {"Blastoff", "Drift", "Lynx", "Catalyst", "Raven", "Mildas"};
		String[] tournamentArray = {"Blastoff", "Drift", "Lynx", "Catalyst", "Raven", "Mildas", "Pat", "John"};
		
		List<Competitor> leagueCompetitors = new ArrayList<>();
		List<Competitor> tournamentCompetitors = new ArrayList<>();
		
		// We add each competitor to the league
		for(int i = 0; i < leagueArray.length; i++) {
			leagueCompetitors.add(new Competitor(leagueArray[i]));
		}

		// We add each competitor to the tournament
		for(int i = 0; i < tournamentArray.length; i++) {
			tournamentCompetitors.add(new Competitor(tournamentArray[i]));
		}

		try (Scanner scanner = new Scanner(System.in)) {
			while (choice.equals("")) {
				System.out.println("Please, select a competition : ");
				System.out.println("Choice          1  :  \"League\"");
				System.out.println("                2  :  \"Tournament\"");
				System.out.println("                3  :  \"Exit\"");
				String choix = scanner.nextLine();
				try {
					switch (parseInt(choix)) {
						case 1:
							competition = new League(leagueCompetitors);
							choice = choix;
							break;
						case 2:
							competition = new Tournament(tournamentCompetitors);
							choice = choix;
							break;
						case 3:
							System.out.println("Exit");
							System.exit(-1);
					}
				}
				catch (NumberFormatException e) {
					System.out.println("Please enter a valid number.");
				}
			}
            
            // To see if the chosen competition is correct
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("\nYou have chosen to play a *** " + competition + " ***.\n");
            
            System.out.println("---------------------------------------------------------------------------");
            
            // we create a match
            MatchObserver journaliste = new Journalist();
            Bookmaker bookmaker  = new Bookmaker();
     
            bookmaker.addCompetitorsOdds(tournamentCompetitors);
           

            Match match = new RandomMatch(competition);
            match.addObserver(journaliste);

            match.addObserver(bookmaker);
            competition.setMatch(match);

            // We play the competition
            competition.play();
            	
        }
    }

}