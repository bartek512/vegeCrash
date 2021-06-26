package main.java.vegeCrash.rules;

import main.java.vegeCrash.data.enums.GameStateType;
import main.java.vegeCrash.implementation.Board;

public abstract class AbstractRule implements Rule {

	@Override
	public GameStateType checkForVictory(Board board) {

		return GameStateType.VICTORY;
	}

	@Override
	public GameStateType checkForDefeat(Board board) {

		return GameStateType.REGULAR;
	}
}