package main.java.vegeCrash.data;

import main.java.vegeCrash.data.enums.GameStateType;

import java.util.List;

public class GameState {

	private GameStateType stateType;
	private List<String> fulfilledDefeatRulesList;
	private List<String> fulfilledWinRulesList;

	public GameState(GameStateType stateType, List<String> fulfilledDefeatRules, List<String> fulfilledWinRules) {
		this.stateType = stateType;
		fulfilledDefeatRulesList = fulfilledDefeatRules;
		fulfilledWinRulesList = fulfilledWinRules;
	}

	public GameStateType getStateType() {
		return stateType;
	}

	public List<String> getFulfilledDefeatRulesList() {
		return fulfilledDefeatRulesList;
	}

	public List<String> getFulfilledWinRulesList() {
		return fulfilledWinRulesList;
	}

	public boolean addFulfilledDefeatRule(String rule) {
		return fulfilledDefeatRulesList.add(rule);
	}

	public boolean addFulfilledWinRule(String rule) {
		return fulfilledWinRulesList.add(rule);
	}

}
