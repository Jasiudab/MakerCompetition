package Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import src.Music;

import java.io.IOException;


public class ConfigSingleController {
	
	@FXML Button playButton;
	@FXML Button inputs2;
	@FXML Button inputs3;
	@FXML Button inputs4;
	@FXML Button inputs5;

	@FXML Button addButton;
	@FXML Button multiButton;

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
				Main.reset();
				Main.setup(noOfInputs, gameType);
				dc.reset();
				dc.initialize(Main.getSolution(), noOfInputs, gameType, new Player(0, "Player"));

			
				Scene newScene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
				Stage stage = new Stage();
				stage.setTitle("Shooter | Game");

				stage.setScene(newScene);
				stage.show();

				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					public void handle(WindowEvent we) {
						Music.changeToPause();
					}
				});

			Music.stopIntroMusic();
				Music.playTransitionMusic();
				Music.playIntenseMusic();

		} catch (IOException e) {
			e.printStackTrace();
			// Quit the program (with an error code)
			System.exit(-1);
		}
	}
	public void getInputs2(){
		noOfInputs = 2;
		this.unpressInputs();
		inputs2.setId("pressed-button");
	}
	public void getInputs3(){
		noOfInputs = 3;
		this.unpressInputs();
		inputs3.setId("pressed-button");
	}
	public void getInputs4(){
		noOfInputs = 4;
		this.unpressInputs();
		inputs4.setId("pressed-button");
	}
	public void getInputs5(){
		noOfInputs = 5;
		this.unpressInputs();
		inputs5.setId("pressed-button");
	}

	private void unpressInputs(){
		inputs2.setId("");
		inputs3.setId("");
		inputs4.setId("");
		inputs5.setId("");
	}
	public void setAdditionGame(){
		gameType = "addition";
		addButton.setId("pressed-button");
		multiButton.setId("");
	}
	public void setMultiplicationGame(){
		gameType = "multiplication";
		multiButton.setId("pressed-button");
		addButton.setId("");
	}
	public static int getInputs(){
		return noOfInputs;
	}
	

	public void backButtonClicked(){
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/Welcome.fxml"));
		try {
			Parent editRoot = (Parent) fxmlLoader.load();

			WelcomeController dc = fxmlLoader.getController();
			dc.initialize();

			Scene newScene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
			Stage stage = (Stage) multiButton.getScene().getWindow();
			stage.setTitle("Shooter | Config");

			stage.setScene(newScene);

			Music.changeToIntro();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
