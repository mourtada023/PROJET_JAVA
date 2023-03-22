package game.war.exceptions;

import game.exceptions.CanNotDeployCharacterException;
import game.exceptions.CanNotDoActionException;

public class SoldiersWillExceedMaxException extends CanNotDeployCharacterException{

	public SoldiersWillExceedMaxException(String message) throws CanNotDoActionException {
		super(message);
	}

}
