package Controllers;


/**
 * 
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import src.Music;

public class MainGUI extends Application {

	public static final int BIG_HEIGHT = 600;
	public static final int BIG_WIDTH = 800;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main.setUpInput();
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/Welcome.fxml"));
			Parent editRoot = (Parent) fxmlLoader.load();

			WelcomeController dc = fxmlLoader.getController();
			dc.initialize();
		
		Scene scene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
		stage.setTitle("Welcome");
		stage.setScene(scene);
		stage.show();

		Music.playIntroMusic();

		} catch (Exception e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
	}

	
}