package assets;

public class TestPirateGame {

	public static void main(String[] args) {
		Map map1 = new Map(5, 4);

		printMap(map1);
		
		map1.addPirate(1, 0, new Pirate("Blackbeard", -20)); 
		map1.addPirate(2, 1, new Pirate("Whitebeard", 10));
		map1.addPirate(3, 1, new Pirate());
		map1.addPirate(3, 2, new Pirate());
		map1.addPirate(3, 3, new Pirate());
		
		printMap(map1);
		
		map1.movePirateUp(2, 1);
		printMap(map1);
		
		map1.movePirateLeft(2, 0);
		printMap(map1);
	}
	
	public static void printMap(Map map) {
		for(int y = 0; y < map.map[0].length; y++) {
			for(int x = 0; x < map.map.length; x++) {
				System.out.print(map.map[x][y] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
