package assets.weapons;

import assets.Pirate;

public class Axe extends Weapon {

	public Axe(int damage) {
		super(damage);
	}

	@Override
	public String toString() {
		return "Axe [damage=" + getDamage() + "]";
	}

	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null) {			
			return getDamage();
		}
		return -1;
	}

}
