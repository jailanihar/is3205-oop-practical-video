package assets;

public class Pirate {
	
	String name;
	int health;
	
	public Pirate() {
		
	}
	
	public Pirate(String pirateName, int pirateHealth) {
		name = pirateName;
		if(pirateHealth > 0) {			
			health = pirateHealth;
		} else {
			health = 1;
		}
	}
	
	// TODO: Attack another pirate
	
	public String toString() {
		return "[" + name + ", " + health + "]";
	}
	
}
