package assets.weapons;

public class Weapon {

	private int damage;
	
	public Weapon(int damage) {
		setDamage(damage);
	}
	
	public void doDamage() {
		System.out.println("Do damage: " + damage);
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
