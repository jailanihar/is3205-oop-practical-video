package assets;

public class Pirate {
	
	private String name;
	private int health;
	private static int numDefault = 1;
	
	public Pirate() {
		this("Pirate" + numDefault, 2);
		numDefault++;
	}
	
	public Pirate(String name, int pirateHealth) {
		setName(name);
		setHealth(pirateHealth);
	}
	
	public void attackOtherPirate(Pirate otherPirate) {
		otherPirate.health--;
	}
	
	public String toString() {
		return "[" + name + ", " + health + "]";
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if(health > 1) {			
			this.health = health;
		} else {
			this.health = 2;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.equals("")) {
			this.name = "Pirate" + numDefault;
			numDefault++;
		} else {
			this.name = name;
		}
	}
	
}
