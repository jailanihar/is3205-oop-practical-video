package assets;

public class Map {

	Pirate[][] map;
	
	public Map(int width, int height) {
		if(width <= 0) {
			width = 5;
		}
		if(height <= 0) {
			height = 5;
		}
		map = new Pirate[width][height];
	}
	
	public boolean addPirate(int x, int y, Pirate newPirate) {
		if(x >= 0 && x < map.length && y >= 0 && y < map[x].length && map[x][y] == null) {
			map[x][y] = newPirate;
			return true;
		}
		return false;
	}
	// TODO: Select specific pirate
		// Move the specific pirate, up, right, down or left
			// If the space is being occupied by other pirate, the pirate will attack the other pirate.
	
}
