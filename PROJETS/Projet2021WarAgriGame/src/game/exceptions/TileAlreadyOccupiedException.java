package game.exceptions;

public class TileAlreadyOccupiedException extends CanNotDoActionException{
	public TileAlreadyOccupiedException (String message) throws CanNotDeployCharacterException{
		super(message);
	}
}
