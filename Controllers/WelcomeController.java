package Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import java.io.IOException;


public class WelcomeController {

	private ObservableList<String> noOfPlayersChoiceList = FXCollections.observableArrayList("2 players", "3 players","4 players","5 players");

	@FXML private Button singleButton;
	@FXML private ComboBox<String> noOfPlayersComboBox;

	public void initialize() {
		noOfPlayersComboBox.setItems(noOfPlayersChoiceList);
	}


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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/ConfigMulti.fxml"));
			Parent editRoot = (Parent) fxmlLoader.load();

			ConfigMultiController dc = fxmlLoader.getController();
			dc.initialize(Integer.parseInt(noOfPlayersComboBox.getValue().substring(0,1)));

			Scene newScene = new Scene(editRoot);
			Stage stage = (Stage) singleButton.getScene().getWindow();
			stage.setTitle("LaserGun | Game");

			stage.setScene(newScene);

		} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);

		}
	}

	@FXML
	private void noOfPlayersComboBox() {
	}

}
