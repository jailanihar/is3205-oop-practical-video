package assets;

import assets.weapons.Weapon;

public class Pirate {
	
	private String name;
	private int health;
	private static int numDefault = 1;
	private int defence;
	private Weapon weapon;
	
	public Pirate() {
		this("Pirate" + numDefault, 2, 0);
		numDefault++;
	}
	
	public Pirate(String name, int pirateHealth, int defence) {
		setName(name);
		setHealth(pirateHealth);
		setDefence(defence);
	}
	
	public void equipWeapon(Weapon weapon) {
		if(weapon != null) {
			this.weapon = weapon;
		}
	}
	
	public void unEquipWeapon() {
		weapon = null;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void attackOtherPirate(Pirate otherPirate) {
		if(weapon != null) {
			int damage = weapon.doDamage(otherPirate);
			if(damage > 0) {
				int newHealth = otherPirate.health - damage;
				otherPirate.health = newHealth;
			}
		} else {
			if(otherPirate.getDefence() <= 0) {
				otherPirate.health--;
			}
		}
	}
	
	public String toString() {
		return "[" + name + ", " + health + ", " + weapon + "]";
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if(health > 1) {			
			this.health = health;
		} else {
			this.health = 2;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.equals("")) {
			this.name = "Pirate" + numDefault;
			numDefault++;
		} else {
			this.name = name;
		}
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		if(defence < 0) {
			defence = 0;
		}
		this.defence = defence;
	}
	
}
