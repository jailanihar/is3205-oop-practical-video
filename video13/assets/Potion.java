package assets;

import assets.interfaces.Consumable;
import assets.interfaces.Placeable;

public class Potion implements Placeable, Consumable {

	private int heal;
	
	public Potion(int heal) {
		setHeal(heal);
	}

	public int getHeal() {
		return heal;
	}

	public void setHeal(int heal) {
		if(heal < 0) {
			heal = 0;
		}
		this.heal = heal;
	}

	@Override
	public String toString() {
		return "Potion [heal=" + heal + "]";
	}

	@Override
	public void eat(Pirate pirate) {
		if(pirate != null) {
			int newHealth = pirate.getHealth() + heal;
			pirate.setHealth(newHealth);
		}
	}
	
}
