package main.java.vegeCrash.data;

import main.java.vegeCrash.data.enums.Loot;

import java.util.Map;

/**
 * Game move definition.
 * 
 *
 */
public class Move {

	private Coordinate from;
	private Coordinate to;
	private Map<Loot, Integer> loot;

	public Move(Coordinate from, Coordinate to) {
		this.from = from;
		this.to = to;
	}

	public Move() {}

	public Coordinate getFrom() {
		return from;
	}

	public void setFrom(Coordinate from) {
		this.from = from;
	}

	public Coordinate getTo() {
		return to;
	}

	public void setTo(Coordinate to) {
		this.to = to;
	}

	public Map<Loot, Integer> getLoot() {
		return loot;
	}

	public void setLoot(Map<Loot, Integer> loot) {
		this.loot = loot;
	}
}
