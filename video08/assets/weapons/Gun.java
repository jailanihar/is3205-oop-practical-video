package assets.weapons;

public class Gun extends Weapon {

	int ammo;

	public Gun(int damage, int ammo) {
		super(damage);
		this.ammo = ammo;
	}
	
	// Method overriding
	public void doDamage() {
		System.out.print("Ammo reduced. ");
		super.doDamage();
	}

}
