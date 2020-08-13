package assets;

public class TestPirateGame {

	public static void main(String[] args) {
		Map map1 = new Map(5, 4);
		Map map2 = new Map(10, 10);
		
		printMap(map1);
		printMap(map2);
		
		Pirate pirate1 = new Pirate("Blackbeard", -20);
		Pirate pirate2 = new Pirate("Whitebeard", 10);
		Pirate pirate3 = new Pirate();
		
		map1.map[0][0] = pirate1;
		map1.map[1][1] = pirate2;
		map1.map[2][1] = pirate3;
		
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
