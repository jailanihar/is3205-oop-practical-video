package assets.weapons;

import assets.Pirate;
import assets.interfaces.Consumable;

public class Drumstick extends Weapon implements Consumable {

	public Drumstick(int damage) {
		super(damage);
	}

	@Override
	public int doDamage(Pirate pirate) {
		return getDamage() * 2;
	}

	@Override
	public String toString() {
		return "Drumstick [damage=" + getDamage() + "]";
	}

	@Override
	public void eat(Pirate pirate) {
		if(pirate != null) {
			int newHealth = pirate.getHealth() + 5;
			pirate.setHealth(newHealth);
		}
	}

}
