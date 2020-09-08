package assets.weapons;

import assets.Pirate;

public class Gun extends Weapon {

	private int ammo;

	public Gun(int damage, int ammo) {
		super(damage);
		setAmmo(ammo);
	}
	
	@Override
	public int doDamage(Pirate pirate) {
		if(pirate != null && ammo > 0) {
			ammo--;
			return super.doDamage(pirate);
		}
		return -1;
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
