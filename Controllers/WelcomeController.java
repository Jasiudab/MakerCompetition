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

/**
 * This class is the controller for the Login screen
 * It will handle all inputs and validation
 * 
 * @author Jan Dabrowski
 *
 */
public class WelcomeController {


	@FXML private Button singleButton;

	/**
	 * Event handler for when user clicks the singleplayer button
	 */
	public void singleModeClicked() {

		try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/ConfigSingle.fxml"));
				Parent editRoot = (Parent) fxmlLoader.load();

				Scene newScene = new Scene(editRoot);
				Stage stage = (Stage) singleButton.getScene().getWindow();
				stage.setTitle("Shooter | Config");

				stage.setScene(newScene);

		} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
			
		}
	}

	public void multiModeClicked() {

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameMultiplayer.fxml"));
			Parent editRoot = (Parent) fxmlLoader.load();


			GameMultiplayer dc = fxmlLoader.getController();
			dc.initialize();

			Scene newScene = new Scene(editRoot);
			Stage stage = (Stage) singleButton.getScene().getWindow();
			stage.setTitle("Shooter | Config");

			stage.setScene(newScene);

		} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);

		}
	}

}
