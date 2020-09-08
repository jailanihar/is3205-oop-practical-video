package assets.weapons;

import assets.Pirate;

public class Weapon {

	private int damage;
	
	public Weapon(int damage) {
		setDamage(damage);
	}
	
	public int doDamage(Pirate pirate) {
		if(pirate != null) {
			if(this instanceof Axe) {
				return damage;
			}
			int newDamage = damage - pirate.getDefence();
			return newDamage;
		}
		return -1;
	}

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
