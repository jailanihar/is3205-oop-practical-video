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
	
	// TODO: Adding pirate to map
	// TODO: Select specific pirate
		// Move the specific pirate, up, right, down or left
			// If the space is being occupied by other pirate, the pirate will attack the other pirate.
	
}
