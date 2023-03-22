package observer;

import competitor.Competitor;

public class Journalist implements MatchObserver{

	
	
	
	@Override
	public void followMatch(Competitor c1, Competitor c2) {
		// TODO Auto-generated method stub
		System.out.println(" --------------------------this is a journalist------------  ");
		System.out.println(" winner is   : "+ c1.getName()+ " the loser is   "+c2.getName());

		
	}
	
	
	

}
