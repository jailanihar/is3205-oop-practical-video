package assets;

public class Pirate {
	
	String name;
	int health;
	static int numDefault = 1;
	
	public Pirate() {
		this("Pirate" + numDefault, 2);
		numDefault++;
	}
	
	public Pirate(String name, int pirateHealth) {
		this.name = name;
		if(pirateHealth > 1) {			
			health = pirateHealth;
		} else {
			health = 2;
		}
	}
	
	public void attackOtherPirate(Pirate otherPirate) {
		otherPirate.health--;
	}
	
	public String toString() {
		return "[" + name + ", " + health + "]";
	}
	
}
