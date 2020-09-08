package assets.weapons;

public class TestWeapon {

	public static void main(String[] args) {
		Weapon weapon = new Weapon(-2);
		weapon.doDamage();
		System.out.println(weapon.toString());
		
		Sword sword = new Sword(3);
		sword.doDamage();
		System.out.println(sword);
		
		Axe axe = new Axe(4);
		axe.doDamage();
		System.out.println(axe);
		
		Gun gun = new Gun(1,-3);
		gun.doDamage();
		System.out.println(gun);
	}
	
}
