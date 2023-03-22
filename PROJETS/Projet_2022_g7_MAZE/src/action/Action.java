package action;




public class Action {

	 protected int nbTurns ;
	
	

	 public Action() {
		 this.nbTurns = 0;
		 }
	 

   public int getNbTurns(){
	 return this.nbTurns;
}


   public void setNbTurns(){
	this.nbTurns = this.nbTurns + 1;
}
   

  
   
	 

	public String toString() {
		return null;
	}
}
