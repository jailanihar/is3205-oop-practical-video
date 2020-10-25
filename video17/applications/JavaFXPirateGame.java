package applications;

import assets.*;
import assets.interfaces.*;
import assets.weapons.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JavaFXPirateGame extends Application {
	
	private Map map = new Map(6, 6);
	private VBox rootVBox = new VBox();
	private GridPane mapGridPane = new GridPane();
	private HBox buttonsHBox = new HBox();
	private Label previousSelectedLabel = null;
	private int selectedX = -1;
	private int selectedY = -1;
	
	@Override
	public void start(Stage arg0) throws Exception {
		rootVBox.getStylesheets().add("applications/pirategame.css");
		
//		map.addPirate(0, 2, new Pirate());
//		map.addPirate(5, 5, new Pirate("Blackbeard", 10, 2));
//		map.addAsset(0, 0, new Sword(3));
//		map.addAsset(1, 1, new Potion(4));
		
		generateMap();
		generateMovePirateButtons();
		generateAddObjectButtons();
		
		rootVBox.getChildren().addAll(mapGridPane, buttonsHBox);
		ScrollPane rootScrollPane = new ScrollPane(rootVBox);
		Scene scene = new Scene(rootScrollPane, 1280, 720);
		arg0.setScene(scene);
		arg0.show();
	}
	
	public void generateMap() {
		for(int y = 0; y < map.getHeight(); y++) {
			for(int x = 0; x < map.getWidth(); x++) {
				Label label = new Label();
				label.setWrapText(true);
				
				Placeable asset = map.selectAsset(x, y);
				if(asset != null) {
					label.setText(asset.toString());
				}
				
				label.getStyleClass().add("placeable_label");
				
				if(x == selectedX && y == selectedY) {
					previousSelectedLabel = label;
					label.getStyleClass().add("placeable_label_selected");
				}
				
				label.setOnMouseClicked(event -> {
					if(previousSelectedLabel != null) {
						previousSelectedLabel.getStyleClass().remove("placeable_label_selected");
					}
					previousSelectedLabel = label;
					selectedX = GridPane.getColumnIndex(label);
					selectedY = GridPane.getRowIndex(label);
					label.getStyleClass().add("placeable_label_selected");
				});
				
				mapGridPane.add(label, x, y);
			}
		}
	}
	
	public void refreshMap() {
		mapGridPane.getChildren().clear();
		generateMap();
	}
	
	public void generateMovePirateButtons() {
		GridPane moveButtonsGridPane = new GridPane();
		
		Button upButton = new Button("Up");
		upButton.setOnAction(event -> {
			map.movePirateUp(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {				
				selectedY = selectedY - 1;
			}
			refreshMap();
		});
		
		Button rightButton = new Button("Right");
		rightButton.setOnAction(event -> {
			map.movePirateRight(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {				
				selectedX = selectedX + 1;
			}
			refreshMap();
		});
		
		Button downButton = new Button("Down");
		downButton.setOnAction(event -> {
			map.movePirateDown(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {				
				selectedY = selectedY + 1;
			}
			refreshMap();
		});
		
		Button leftButton = new Button("Left");
		leftButton.setOnAction(event -> {
			map.movePirateLeft(selectedX, selectedY);
			if(map.selectPirate(selectedX, selectedY) == null) {				
				selectedX = selectedX - 1;
			}
			refreshMap();
		});
		
		moveButtonsGridPane.add(upButton, 1, 0);
		moveButtonsGridPane.add(rightButton, 2, 1);
		moveButtonsGridPane.add(downButton, 1, 1);
		moveButtonsGridPane.add(leftButton, 0, 1);
		buttonsHBox.getChildren().add(moveButtonsGridPane);
	}
	
	public void generateAddObjectButtons() {
		GridPane objectButtonsGridPane = new GridPane();
		
		Button addDefaultPirateButton = new Button("Add Default Pirate");
		addDefaultPirateButton.setOnAction(event -> {
			Pirate pirate = new Pirate();
			map.addPirate(selectedX, selectedY, pirate);
			refreshMap();
		});
		
		Button addCustomPirateButton = new Button("Add Custom Pirate");
		addCustomPirateButton.setOnAction(event -> {
			Stage stage = new Stage();
			GridPane customPirateGridPane = new GridPane();
			customPirateGridPane.getStylesheets().add("applications/pirategame.css");
			
			Label titleLabel = new Label("Add Custom Pirate");
			Label pirateNameLabel = new Label("Name");
			TextField pirateNameTextField = new TextField();
			Label pirateHealthLabel = new Label("Health");
			TextField pirateHealthTextField = new TextField();
			Label pirateDefenceLabel = new Label("Defence");
			TextField pirateDefenceTextField = new TextField();
			Button addPirateButton = new Button("Add Custom Pirate");
			addPirateButton.setOnAction(e -> {
				String pirateName = pirateNameTextField.getText();
				int pirateHealth = Integer.parseInt(pirateHealthTextField.getText());
				int pirateDefence = Integer.parseInt(pirateDefenceTextField.getText());
				Pirate pirate = new Pirate(pirateName, pirateHealth, pirateDefence);
				map.addPirate(selectedX, selectedY, pirate);
				refreshMap();
				
				pirateNameTextField.clear();
				pirateHealthTextField.clear();
				pirateDefenceTextField.clear();
			});
			
			Button closePirateButton = new Button("Close");
			closePirateButton.setOnAction(e -> {
				stage.close();
			});
			
			titleLabel.getStyleClass().add("width_400");
			addPirateButton.getStyleClass().add("width_400");
			closePirateButton.getStyleClass().add("width_400");
			
			customPirateGridPane.add(titleLabel, 0, 0, 2, 1);
			customPirateGridPane.add(pirateNameLabel, 0, 1);
			customPirateGridPane.add(pirateNameTextField, 1, 1);
			customPirateGridPane.add(pirateHealthLabel, 0, 2);
			customPirateGridPane.add(pirateHealthTextField, 1, 2);
			customPirateGridPane.add(pirateDefenceLabel, 0, 3);
			customPirateGridPane.add(pirateDefenceTextField, 1, 3);
			customPirateGridPane.add(addPirateButton, 0, 4, 2, 1);
			customPirateGridPane.add(closePirateButton, 0, 5, 2, 1);
			Scene scene = new Scene(customPirateGridPane, 400, 400);
			stage.setScene(scene);
			stage.show();			
		});
		
		Button addWeaponButton = new Button("Add Weapon");
		addWeaponButton.setOnAction(event -> {
			Stage stage = new Stage();
			GridPane weaponGridPane = new GridPane();
			weaponGridPane.getStylesheets().add("applications/pirategame.css");
			
			Label titleLabel = new Label("Add Weapon");
			Label weaponTypeLabel = new Label("Type");
			ComboBox<String> weaponTypeComboBox = new ComboBox<String>();
			weaponTypeComboBox.getItems().addAll("Axe", "Drumstick", "Gun", "Sword");
			Label weaponDamageLabel = new Label("Damage");
			TextField weaponDamageTextField = new TextField();
			Label weaponAmmoLabel = new Label("Ammo");
			TextField weaponAmmoTextField = new TextField();
			
			weaponTypeComboBox.setOnAction(e -> {
				if(weaponTypeComboBox.getSelectionModel().getSelectedItem().equals("Gun")) {
					weaponAmmoLabel.setVisible(true);
					weaponAmmoTextField.setVisible(true);
				} else {
					weaponAmmoLabel.setVisible(false);
					weaponAmmoTextField.setVisible(false);
				}
			});
			
			Button addButton = new Button("Add Weapon");
			addButton.setOnAction(e -> {
				String weaponType = weaponTypeComboBox.getSelectionModel().getSelectedItem();
				int weaponDamage = Integer.parseInt(weaponDamageTextField.getText());
				Weapon weapon = null;
				switch(weaponType) {
				case "Axe":
					weapon = new Axe(weaponDamage);
					break;
				case "Drumstick":
					weapon = new Drumstick(weaponDamage);
					break;
				case "Gun":
					int weaponAmmo = Integer.parseInt(weaponAmmoTextField.getText());
					weapon = new Gun(weaponDamage, weaponAmmo);
					break;
				case "Sword":
					weapon = new Sword(weaponDamage);
					break;
				}
				map.addAsset(selectedX, selectedY, weapon);
				refreshMap();
				weaponDamageTextField.clear();
				weaponAmmoTextField.clear();
			});
			
			Button closeButton = new Button("Close");
			closeButton.setOnAction(e -> {
				stage.close();
			});
			
			titleLabel.getStyleClass().add("width_400");
			addButton.getStyleClass().add("width_400");
			closeButton.getStyleClass().add("width_400");
			
			weaponGridPane.add(titleLabel, 0, 0, 2, 1);
			weaponGridPane.add(weaponTypeLabel, 0, 1);
			weaponGridPane.add(weaponTypeComboBox, 1, 1);
			weaponGridPane.add(weaponDamageLabel, 0, 2);
			weaponGridPane.add(weaponDamageTextField, 1, 2);
			weaponGridPane.add(weaponAmmoLabel, 0, 3);
			weaponGridPane.add(weaponAmmoTextField, 1, 3);
			weaponGridPane.add(addButton, 0, 4, 2, 1);
			weaponGridPane.add(closeButton, 0, 5, 2, 1);
			
			Scene scene = new Scene(weaponGridPane, 400, 400);
			stage.setScene(scene);
			stage.show();
		});
		
		Button addPotionButton = new Button("Add Potion");
		addPotionButton.setOnAction(event -> {
			Stage stage = new Stage();
			GridPane potionGridPane = new GridPane();
			potionGridPane.getStylesheets().add("applications/pirategame.css");
			
			Label titleLabel = new Label("Add Potion");
			Label potionHealLabel = new Label("Heal");
			TextField potionHealTextField = new TextField();
			
			Button addButton = new Button("Add Potion");
			addButton.setOnAction(e -> {
				int potionHeal = Integer.parseInt(potionHealTextField.getText());
				map.addAsset(selectedX, selectedY, new Potion(potionHeal));
				refreshMap();
				potionHealTextField.clear();
			});
			
			Button closeButton = new Button("Close");
			closeButton.setOnAction(e -> {
				stage.close();
			});
			
			titleLabel.getStyleClass().add("width_400");
			addButton.getStyleClass().add("width_400");
			closeButton.getStyleClass().add("width_400");
			
			potionGridPane.add(titleLabel, 0, 0, 2, 1);
			potionGridPane.add(potionHealLabel, 0, 1);
			potionGridPane.add(potionHealTextField, 1, 1);
			potionGridPane.add(addButton, 0, 2, 2, 1);
			potionGridPane.add(closeButton, 0, 3, 2, 1);
			Scene scene = new Scene(potionGridPane, 400, 400);
			stage.setScene(scene);
			stage.show();
		});
		
		objectButtonsGridPane.add(addDefaultPirateButton, 0, 0);
		objectButtonsGridPane.add(addCustomPirateButton, 0, 1);
		objectButtonsGridPane.add(addWeaponButton, 1, 0);
		objectButtonsGridPane.add(addPotionButton, 2, 0);
		buttonsHBox.getChildren().add(objectButtonsGridPane);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
