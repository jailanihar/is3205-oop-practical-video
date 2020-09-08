package assets.weapons;

public class Gun extends Weapon {

	private int ammo;

	public Gun(int damage, int ammo) {
		super(damage);
		setAmmo(ammo);
	}
	
	// Method overriding
	public void doDamage() {
		System.out.print("Ammo reduced. ");
		super.doDamage();
	}

	@Override
	public String toString() {
		return "Gun [ammo=" + ammo + ", damage=" + getDamage() + "]";
	}

	public int getAmmo() {
		return ammo;
	}

	public void setAmmo(int ammo) {
		if(ammo < 1) {
			ammo = 1;
		}
		this.ammo = ammo;
	}
	
}
