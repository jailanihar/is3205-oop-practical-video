package assets;

import assets.interfaces.Consumable;
import assets.interfaces.Placeable;
import assets.weapons.Weapon;

public class Map {

	private Placeable[][] map;
	
	public Map(int width, int height) {
		if(width <= 0) {
			width = 5;
		}
		if(height <= 0) {
			height = 5;
		}
		map = new Placeable[width][height];
	}
	
	public boolean addPirate(int x, int y, Pirate newPirate) {
		return addAsset(x, y, newPirate);
	}
	
	public boolean addAsset(int x, int y, Placeable placeable) {
		if(checkCoordinate(x, y) && map[x][y] == null) {
			map[x][y] = placeable;
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
				Placeable otherAsset = selectAsset(newX, newY);
				if(otherAsset != null) {
					if(otherAsset instanceof Pirate) {
						Pirate otherPirate = (Pirate) otherAsset;
						pirate.attackOtherPirate(otherPirate);
						if(otherPirate.getHealth() <= 0) {
							map[newX][newY] = pirate;
							map[x][y] = null;
						}
						if(pirate.getWeapon() instanceof Consumable) {
							Consumable consumable = (Consumable) pirate.getWeapon();
							consumable.eat(pirate);
							pirate.unEquipWeapon();
						}
					} else if(otherAsset instanceof Weapon) {
						Weapon weapon = (Weapon) otherAsset;
						pirate.equipWeapon(weapon);
						map[newX][newY] = pirate;
						map[x][y] = null;
					} else if(otherAsset instanceof Consumable) {
						Consumable consumable = (Consumable) otherAsset;
						consumable.eat(pirate);
						map[newX][newY] = pirate;
						map[x][y] = null;
					}
				} else {
					map[newX][newY] = pirate;
					map[x][y] = null;
				}
//				Pirate otherPirate = selectPirate(newX, newY);
//				if(otherPirate == null) {
//					map[newX][newY] = pirate;
//					map[x][y] = null;
//				} else {
//					pirate.attackOtherPirate(otherPirate);
//					if(otherPirate.getHealth() <= 0) {
//						map[newX][newY] = pirate;
//						map[x][y] = null;
//					}
//				}
				
			}
		}
	}
	
	public Pirate selectPirate(int x, int y) {
		Placeable asset = selectAsset(x, y);
		if(asset instanceof Pirate) {
			return (Pirate) asset;
		}
		return null;
	}
	
	public Placeable selectAsset(int x, int y) {
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
