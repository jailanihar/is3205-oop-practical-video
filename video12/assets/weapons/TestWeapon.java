package assets.weapons;

public class TestWeapon {

	public static void main(String[] args) {
		byte x = 100; // 1 byte
		int y = x; // Implicit Casting // 4 bytes
		System.out.println(y);
		
		int a = 10000;
		byte b = (byte) a; // Explicit Casting
		System.out.println(b);
		
		Weapon weapon = null;
		weapon = new Sword(4); // Implicit Casting
		System.out.println(weapon.toString());
		weapon = new Axe(4);
		System.out.println(weapon.toString());
		weapon = new Gun(4, 1);
		System.out.println(weapon.toString());
		
		if(weapon instanceof Gun) {
			System.out.println(((Gun) weapon).getAmmo());
			((Gun) weapon).setAmmo(10);

			Gun gun = (Gun) weapon; // Explicit Casting
			System.out.println(gun.getAmmo());
			gun.setAmmo(15);
		}
	}
	
}
