package assets.weapons;

import assets.Pirate;

public class Sword extends Weapon {

	public Sword(int damage) {
		super(damage);
	}
	
	@Override
	public String toString() {
		return "Sword [damage=" + getDamage() + "]";
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			int newDamage = getDamage() - pirate.getDefence();
			return newDamage;
		}
		return -1;
	}
}
