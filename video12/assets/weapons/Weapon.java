package assets.weapons;

import assets.Pirate;
import assets.interfaces.Placeable;

public abstract class Weapon implements Placeable {

	private int damage;
	
	public Weapon(int damage) {
		setDamage(damage);
	}
	
	public abstract int doDamage(Pirate pirate);

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		if(damage < 1) {
			damage = 1;
		}
		this.damage = damage;
	}

	@Override
	public String toString() {
		return "Weapon [damage=" + damage + "]";
	}
	
}
