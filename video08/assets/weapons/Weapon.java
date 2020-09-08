package assets.weapons;

public class Weapon {

	private int damage;
	
	public Weapon(int damage) {
		this.damage = damage;
	}
	
	public void doDamage() {
		System.out.println("Do damage: " + damage);
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
}
