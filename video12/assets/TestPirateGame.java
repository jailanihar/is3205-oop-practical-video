package assets;

import assets.weapons.Axe;
import assets.weapons.Drumstick;
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
		map1.addAsset(0, 0, new Sword(5));
		map1.addAsset(0, 1, new Potion(5));
		map1.addAsset(0, 2, new Drumstick(6));
		
		printMap(map1);
		
		map1.movePirateLeft(1, 0);
		printMap(map1);
		
		map1.movePirateDown(0, 0);
		printMap(map1);
		
		map1.movePirateDown(0, 1);
		printMap(map1);
		
		map1.movePirateRight(0, 2);
		map1.movePirateRight(1, 2);
		map1.movePirateRight(2, 2);
		printMap(map1);
	}
	
	public static void printMap(Map map) {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				System.out.print(map.selectAsset(x, y) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
