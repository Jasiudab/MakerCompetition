/**
 * 
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
/**
 * @author Jan Dabrowski
 *
 */
public class GUI extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		try {
		Parent root = FXMLLoader.load(getClass().getResource("Scenes/Welcome.fxml"));

		Scene scene = new Scene(root);

		stage.setTitle("Welcome");
		stage.setScene(scene);
		stage.show();

		} catch (Exception e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
	}
}
