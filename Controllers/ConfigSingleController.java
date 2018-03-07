package Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ConfigSingleController {
	
	@FXML Button playButton;
	/**
	 * Event handler for when user clicks the play button
	 */
	public void playClicked() {

		try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameSingle.fxml"));
				Parent editRoot = (Parent) fxmlLoader.load();
				
				GameSingleController dc = fxmlLoader.getController();
				dc.initialize(70);

			
				Scene newScene = new Scene(editRoot);
				Stage stage = (Stage) playButton.getScene().getWindow();
				stage.setTitle("Shooter | Game");

				stage.setScene(newScene);

		} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
	}
}
