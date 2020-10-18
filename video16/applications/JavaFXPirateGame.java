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
		
		map.addPirate(0, 2, new Pirate());
		map.addPirate(5, 5, new Pirate("Blackbeard", 10, 2));
		map.addAsset(0, 0, new Sword(3));
		map.addAsset(1, 1, new Potion(4));
		
		generateMap();
		generateMovePirateButtons();
		
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
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
