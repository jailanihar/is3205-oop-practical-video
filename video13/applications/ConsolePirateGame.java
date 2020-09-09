package applications;

import java.util.Scanner;

import assets.Map;
import assets.Pirate;
import assets.Potion;
import assets.weapons.Axe;
import assets.weapons.Drumstick;
import assets.weapons.Gun;
import assets.weapons.Sword;

public class ConsolePirateGame {

	private static Scanner scanner = new Scanner(System.in);
	private static boolean gameRunning = true;
	private static Map map = new Map(6, 6);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Pirate Game");
		
		while(gameRunning) {
			System.out.println("Select menu below by inputting its respective number.");
			System.out.println();
			printMenu();
			
			String input = scanner.nextLine();
			int inputValue = Integer.parseInt(input);
			
			switch(inputValue) {
			case 1:
				printMap();
				break;
			case 2:
				addObjectToMap();
				break;
			case 3:
				movePirate(1);
				break;
			case 4: 
				movePirate(2);
				break;
			case 5: 
				movePirate(3);
				break;
			case 6: 
				movePirate(4);
				break;
			case 7:
				map = new Map(6, 6);
				break;
			case 8:
				System.exit(0);
				break;
			}
		}
		
		scanner.close();
	}
	
	public static void printMenu() {
		System.out.println("(1) Print Map");
		System.out.println("(2) Add Object to Map");
		System.out.println("(3) Move Pirate Up");
		System.out.println("(4) Move Pirate Right");
		System.out.println("(5) Move Pirate Down");
		System.out.println("(6) Move Pirate Left");
		System.out.println("(7) Restart Game");
		System.out.println("(8) Quit Game");
	}
	
	public static void printMap() {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				System.out.print(map.selectAsset(x, y) + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void addObjectToMap() {
		int x = -1;
		int y = -1;
		System.out.println("To which x coordinate:");
		x = Integer.parseInt(scanner.nextLine());
		System.out.println("To which y coordinate:");
		y = Integer.parseInt(scanner.nextLine());
		
		System.out.println("What object you want to add?");
		System.out.println("(1) Pirate");
		System.out.println("(2) Weapon");
		System.out.println("(3) Potion");
		int inputValue = Integer.parseInt(scanner.nextLine());
		
		switch(inputValue) {
		case 1:
			addPirateToMap(x, y);
			break;
		case 2:
			addWeaponToMap(x, y);
			break;
		case 3:
			addPotionToMap(x, y);
			break;
		}
		printMap();
	}
	
	public static void addPirateToMap(int x, int y) {
		System.out.println("Custom Pirate? Y/n");
		String input = scanner.nextLine();
		if(input.toLowerCase().equals("y")) {
			System.out.println("Input pirate name:");
			String name = scanner.nextLine();
			System.out.println("Input pirate health:");
			int health = Integer.parseInt(scanner.nextLine());
			System.out.println("Input pirate defence:");
			int defence = Integer.parseInt(scanner.nextLine());
			
			map.addPirate(x, y, new Pirate(name, health, defence));
		} else {
			map.addPirate(x, y, new Pirate());
		}
	}
	
	public static void addWeaponToMap(int x, int y) {
		System.out.println("(1) Sword");
		System.out.println("(2) Gun");
		System.out.println("(3) Axe");
		System.out.println("(4) Drumstick");
		
		int inputValue = Integer.parseInt(scanner.nextLine());
		int damage = -1;
		int ammo = -1;
		
		switch(inputValue) {
		case 1:
			System.out.println("Input sword damage:");
			damage = Integer.parseInt(scanner.nextLine());
			Sword sword = new Sword(damage);
			map.addAsset(x, y, sword);
			break;
		case 2:
			System.out.println("Input gun damage:");
			damage = Integer.parseInt(scanner.nextLine());
			System.out.println("Input gun ammo:");
			ammo = Integer.parseInt(scanner.nextLine());
			Gun gun = new Gun(damage, ammo);
			map.addAsset(x, y, gun);
			break;
		case 3:
			System.out.println("Input axe damage:");
			damage = Integer.parseInt(scanner.nextLine());
			Axe axe = new Axe(damage);
			map.addAsset(x, y, axe);
			break;
		case 4:
			System.out.println("Input Drumstick damage:");
			damage = Integer.parseInt(scanner.nextLine());
			Drumstick drumstick = new Drumstick(damage);
			map.addAsset(x, y, drumstick);
			break;
		}
	}
	
	public static void addPotionToMap(int x, int y) {
		System.out.println("Input Potion heal:");
		int heal = Integer.parseInt(scanner.nextLine());
		Potion potion = new Potion(heal);
		map.addAsset(x, y, potion);
	}
	
	public static void movePirate(int direction) {
		int x = -1;
		int y = -1;
		System.out.println("Pirate x coordinate:");
		x = Integer.parseInt(scanner.nextLine());
		System.out.println("Pirate y coordinate:");
		y = Integer.parseInt(scanner.nextLine());
		
		switch(direction) {
		case 1:
			map.movePirateUp(x, y);
			break;
		case 2:
			map.movePirateRight(x, y);
			break;
		case 3:
			map.movePirateDown(x, y);
			break;
		case 4:
			map.movePirateLeft(x, y);
			break;
		}
		printMap();
	}
	
}
