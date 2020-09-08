package assets;

import assets.weapons.Axe;
import assets.weapons.Gun;
import assets.weapons.Sword;
import assets.weapons.Weapon;

public class TestPirateGame {

	public static void main(String[] args) {
		Map map1 = new Map(5, 4);

		printMap(map1);
		
		map1.addPirate(1, 0, new Pirate("Blackbeard", -20, 2)); 
		map1.addPirate(2, 1, new Pirate("Whitebeard", 10, 1));
		map1.addPirate(3, 1, new Pirate());
		map1.addPirate(3, 2, new Pirate());
		map1.addPirate(3, 3, new Pirate());
		map1.selectPirate(1, 0).equipWeapon(new Weapon(5));
		
		printMap(map1);
		
		map1.movePirateRight(1, 0);
		map1.movePirateDown(2, 0);
		printMap(map1);
		
		map1.movePirateDown(2, 0);
		printMap(map1);
	}
	
	public static void printMap(Map map) {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				System.out.print(map.selectPirate(x, y) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
