package main.java.vegeCrash.rules;

import main.java.vegeCrash.data.enums.GameStateType;
import main.java.vegeCrash.implementation.Board;

public interface Rule {
	
	
	/**Checks if the rule conditions for victory are met.
	 * @return
	 */
	GameStateType checkForVictory(Board board);
	
	/**Checks if the rule conditions for defeat are met.
	 * @return
	 */
	GameStateType checkForDefeat(Board board);
	
	/**
	 * Returns the name of the rule.
	 * @return
	 */
	String getRuleName();
}
