package assets;

public class TestPirateGame {

	public static void main(String[] args) {
		Pirate pirate1 = new Pirate("Blackbeard", -20);
		Pirate pirate2 = new Pirate("Whitebeard", 10);
		Pirate pirate3 = new Pirate();
		
		System.out.println(pirate1.name + " " + pirate1.health);
		System.out.println(pirate2.name + " " + pirate2.health);
		System.out.println(pirate3.name + " " + pirate3.health);
	}
	
}
