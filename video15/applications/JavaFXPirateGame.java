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
	
	@Override
	public void start(Stage arg0) throws Exception {
		rootVBox.getStylesheets().add("applications/pirategame.css");
		
		generateMap();
		rootVBox.getChildren().addAll(mapGridPane, buttonsHBox);
		
		Scene scene = new Scene(rootVBox, 1280, 720);
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
				
				label.setOnMouseClicked(event -> {
					if(previousSelectedLabel != null) {
						previousSelectedLabel.getStyleClass().remove("placeable_label_selected");
					}
					previousSelectedLabel = label;
					label.getStyleClass().add("placeable_label_selected");
				});
				
				mapGridPane.add(label, x, y);
			}
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
