package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import src.Player;

import java.io.IOException;
import java.util.ArrayList;


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

		Player p1 = new Player("Jan");
		Player p2 = new Player("Ben");
		Player p3 = new Player("Tom");

		ArrayList<Player> players = new ArrayList<>();

		players.add(p1);
		players.add(p2);
		players.add(p3);

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameMulti.fxml"));
			Parent editRoot = (Parent) fxmlLoader.load();


			GameMultiController dc = fxmlLoader.getController();
			dc.initialize(players);

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

}
