package assets;

public class Map {

	private Pirate[][] map;
	
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
		if(checkCoordinate(x, y) && map[x][y] == null) {
			map[x][y] = newPirate;
			return true;
		}
		return false;
	}
	
	public void movePirateUp(int x, int y) {
		movePirate(x, y, x, y - 1);
	}
	
	public void movePirateRight(int x, int y) {
		movePirate(x, y, x + 1, y);
	}
	
	public void movePirateDown(int x, int y) {
		movePirate(x, y, x, y + 1);
	}
	
	public void movePirateLeft(int x, int y) {
		movePirate(x, y, x - 1, y);
	}
	
	private void movePirate(int x, int y, int newX, int newY) {
		Pirate pirate = selectPirate(x, y);
		if(pirate != null) {
			if(checkCoordinate(newX, newY)) {
				Pirate otherPirate = selectPirate(newX, newY);
				if(otherPirate == null) {
					map[newX][newY] = pirate;
					map[x][y] = null;
				} else {
					pirate.attackOtherPirate(otherPirate);
					if(otherPirate.getHealth() <= 0) {
						map[newX][newY] = pirate;
						map[x][y] = null;
					}
				}
				
			}
		}
	}
	
	public Pirate selectPirate(int x, int y) {
		if(checkCoordinate(x, y)) {
			return map[x][y];
		}
		return null;
	}
	
	private boolean checkCoordinate(int x, int y) {
		if(x >= 0 && x < map.length && y >= 0 && y < map[x].length) {
			return true;
		}
		return false;
	}
	
	public int getWidth() {
		return map.length;
	}
	
	public int getHeight() {
		return map[0].length;
	}
}
