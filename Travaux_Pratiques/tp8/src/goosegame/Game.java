package goosegame;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import goosegame.boards.Board;
import goosegame.cells.Cell;
import goosegame.util.io.Input;

public class Game
 {

    //attributs
	private List<Player> thePlayers ;
	private Board board;
	private boolean isGameFinished;

	/**
     * Constructor for this game. It is used to initialized the attributs of this calss
     * @param board
     */
    public Game (Board board)
    {
		this.board = board;
		this.thePlayers = new ArrayList<> ();
		this.isGameFinished = false;
	}

	/**
     * verifiy if the game is finished
	 * @return <code> true </code> if the game is finished, <code> false </code> otherwise
	 */
    public boolean isGameFinished()
    {
		return this.isGameFinished;
	}

	/** Changes the status of this game
	 * @param change is the status to set
	 */
	public void setGameFinished(boolean change) {
		this.isGameFinished = change;
	}

	/** returns the current board
	 * @return the current board
	 */
	public Board getBoard() {
		return this.board;
	}

	/** Add a player in this game and assigns him to the first cell ( the starting cell)
	 * @param player is the new player to add
	 */
	public void addPlayer(Player player) {
		this.thePlayers.add(player);
		this.getBoard().getIndexedCell(0).setPlayer(player);
	}

    /**
     * return true if the player can play
     * @param Currentplayer the current player
     * @return returns true if the player can play
     */
    public boolean canPlay(Player currentPlayer){
        return currentPlayer.getCell().canBeLeft();
    }

    /**
     * Method that helps to play juste one game/turn
     */
    public void playOneTurn()
    {
		// we recuperate the size of the baord
		int boardSize = this.getBoard().getNbOfCells() - 1;
        /**
         * Each player will play by throwing the dices
         * label firstRound is used as witness. It helps to break the game when there is a winner
         */
		firstRound:
        for (Player player : thePlayers)
        {

			// verifiying if the player can play
            if (this.canPlay(player))
            {
				// we recuperate the player's result after throwing the dices
				int result = player.twoDiceThrow();

				// get the current player's indexes
				int currentIndex = player.getCell().getIndex();
				int interIndex = currentIndex + result; // the inter index
				int intermediateIndex ; // the intrermediate index
				int destinationIndex; // the destination index


				// verifying if the current player is not out of the board
                if (interIndex < boardSize + 1)
                {
                    intermediateIndex = interIndex;
                    // display the status of the current player
                    System.out.println("  - "+player.getName() + " is in cell " +currentIndex +","+player.getName()+
                    " throws " +result + " and reaches the cell " +intermediateIndex +"."   );

					destinationIndex = this.getBoard().getIndexedCell(intermediateIndex).bounce(result);
				} else {
                    int intervalIndex = boardSize - currentIndex;
					intermediateIndex = boardSize - (result - intervalIndex);
					destinationIndex = intermediateIndex;
				}


				Cell destinationCell = this.getBoard().getIndexedCell(destinationIndex);
				destinationCell.movePlayer(player);
				player.setCell(destinationCell);
				this.getBoard().getIndexedCell(destinationIndex).setPlayer(player);


				if (destinationIndex == boardSize) {
					System.out.println(player.getName() + " is in cell " +destinationIndex +"\n\t\t"+player.getName() +"  wins it ! ");
					this.setGameFinished(true);
					break firstRound;
				}
			} else {
				player.getCell().applyEffect();
			}

		}

	}


	public static void menuPrincipal()
    {

        //on fait un menu pour indiquer l'utilisateur quand il veut faire son choix
        System.out.println("=========================================");
        System.out.println("|       MENU SELECTION                  |");
        System.out.println("=========================================");
        System.out.println("| Options:                              |");
        System.out.println("|        1.Le Nombre de Joueur!         |");
        System.out.println("|        2.Quitter le Jeu!              |");
        System.out.println("|        Faites Votre Choix             |");
        System.out.println("=========================================");
        System.out.println();
    }
    public static void souMenu()
    {
        System.out.println("=========================================");
        System.out.println("| Options:                              |");
        System.out.println("|        1.Lancer la partie             |");
        System.out.println("=========================================");
        System.out.println();
    }
    public static void bienvenue()
    {
        System.out.println("=========================================");
        System.out.println("|               BIENVENU                 |");
        System.out.println("=========================================");
        System.out.println();
    }
    //Méthode permettant d'initialiser la partie
    public void initPartie() {



    }

	/**
     * Method used to play more than a round
     * @param n the number of turns we want to play
     */
    public void playTurns(int n)
    {

		int choix = 1;//varibale de type  entier(int)-->permettant de faire un choix
		//boucle qui nous permet de controler la partie
		do
		{

			int nbJoueur = 0;//varibale de type entier(int)-->réprésentant le nombre de joueur choisi par l'utilisateur
			String playerName = null;//varibie de type String-->réprésentant le nom des joueurs
			this.menuPrincipal();
			try {
				System.out.println("Make a choice : ?");
				choix = Input.readInt();
			} catch (java.io.IOException e) {

				System.out.println(e.getMessage());
			}

			switch (choix)
			{

				case 1:
				{
					nbJoueur = initGame(nbJoueur);
					play(n, nbJoueur);
					break;
				}
				case 2: {
					System.out.println("Au revoir!");
					break;
				}
				default:
					System.out.println("Choix incorrecte!");

			}

		}while (choix != 2);
	}

	private int initGame(int nbJoueur)
	{
		String playerName;
		bienvenue();
		//Boucle permettant de conroler le nombre de joueur--->qui doit être un nombre strictement positif
		do
		{
			try {
				//on lit le nombre de joueur donné par l'utilisateur
				System.out.println("Enter the number of player : ?");
				nbJoueur = Input.readInt();
			} catch (java.io.IOException e) {

				System.out.println(e.getMessage());
			}

			//boucle permettant de parcourir le nombre de joueur
			for (int j = 0; j < nbJoueur; j++)
			{

				//on lit le nom du joueur donné par l'utilisateur
				System.out.println("Player N°" + (j + 1) +": ?");
				playerName = Input.readString();
				//on ajoute les noms dans la liste des joueurs
				this.addPlayer(new Player(playerName));
				//this.lstjoueur.ajouteJoueur(new Joueur(nomJoueur, new Reserve()));
			}
		} while (nbJoueur <= 0);
		return nbJoueur;
	}

	private void play(int n, int nbJoueur)
	{
		if (nbJoueur > 0)//si le nombre de joueur est positif, on commence le jeu
		{
			int c = 1;
			do
			{
				souMenu();
				try {
					//on lit le nom du joueur donné par l'utilisateur
					System.out.println("Make a choice: ?");
					c = Input.readInt();
				} catch (java.io.IOException e) {

					System.out.println(e.getMessage());
				}
				switch (c)
				{
					case 1:
					{
						int i = 1;
						while (i < n && !this.isGameFinished())
						{
							System.out.println("Round " +i);
							this.playOneTurn();
							i++;
						}
						break;
					}
					default :{
						System.out.println("Error ! ");
					}
				}


			} while (c != 1);
		}
	}

}
