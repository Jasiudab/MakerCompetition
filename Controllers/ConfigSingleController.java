package Controllers;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.awt.Event;
import java.io.IOException;

import com.sun.glass.events.MouseEvent;


public class ConfigSingleController {
	
	@FXML Button playButton;
	@FXML Button inputs2;
	@FXML Button inputs3;
	@FXML Button inputs4;
	@FXML Button inputs5;
	static int noOfInputs = 2;
	String gameType = "addition";
	/**
	 * Event handler for when user clicks the play button
	 */
	public void playClicked() {

		try {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameSingle.fxml"));
				Parent editRoot = (Parent) fxmlLoader.load();
				
				GameSingleController dc = fxmlLoader.getController();
				Main e = new Main(noOfInputs, gameType);
				dc.initialize(e.getSolution(), noOfInputs, gameType, e);

			
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
	public void getInputs2(){
		noOfInputs = 2;
	}
	public void getInputs3(){
		noOfInputs = 3;
	}
	public void getInputs4(){
		noOfInputs = 4;
	}
	public void getInputs5(){
		noOfInputs = 5;
	}
	public void setAdditionGame(){
		gameType = "addition";
	}
	public void setMultiplicationGame(){
		gameType = "multiplication";
	}
	public static int getInputs(){
		return noOfInputs;
	}
	

}