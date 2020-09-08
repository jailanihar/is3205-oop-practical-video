package assets.weapons;

public class TestWeapon {

	public static void main(String[] args) {
		Weapon weapon = new Weapon(2);
		weapon.doDamage();
		
		Sword sword = new Sword(3);
		sword.doDamage();
		
		Axe axe = new Axe(4);
		axe.doDamage();
		
		Gun gun = new Gun(1,3);
		gun.doDamage();
	}
	
}
