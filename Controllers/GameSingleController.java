package Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class GameSingleController {

	@FXML
	private Button shotNumber;
	@FXML
	private Button currentNumber;
	@FXML
	private Button goalNumber;
	@FXML
	private TextField numberInputTextFields;
	@FXML Label l1, l2, l3, l4, l5;
	Main e;
	int goal;
	int noOfInputs;
	int currentInputs;
	String game;
	public void initialize(int goal, int noOfInputs, String game, Main e) {
		this.goalNumber.setText(String.valueOf(goal));
		this.goal = goal;
		switch(game) {
		case "multiplication": this.currentNumber.setText("1"); break;
		case "addition": this.currentNumber.setText("0"); break;
		}
		this.e = e;
		this.currentInputs = 0;
		this.noOfInputs = noOfInputs;
		this.game = game;
		int[] pinValues = e.getPinValues();
		l1.setText("Box 1 : \n"+ pinValues[0]);
		l2.setText("Box 2 : \n"+ pinValues[1]);
		l3.setText("Box 3 : \n"+ pinValues[2]);
		l4.setText("Box 4 : \n"+ pinValues[3]);
		l5.setText("Box 5 : \n"+ pinValues[4]);
		Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (e.newInput()) {
					shotHappenedFor(e.getNewInput());

				}
			}
		}));

		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();
	}

	public void shotHappenedFor(int number) {
		if (currentInputs < noOfInputs) { //if inputs is less than number
			this.shotNumber.setText(number + "");
			int currentNew = Integer.parseInt(this.currentNumber.getText());
			switch(game) {
			case "addition": currentNew += number; break;
			case "multiplication":  currentNew *= number; break;
			}
			this.currentNumber.setText(currentNew + "");
			currentInputs++;
		}
		if(currentInputs == noOfInputs) { //if the game is over
			accept();
		}
	}
	
	public void accept() {
		if(Integer.parseInt(currentNumber.getText()) == goal){
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setContentText("You won!");
			alert.show();
		}
		else{
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Error");
			alert.setContentText("You Lost");
			alert.show();
		}	
		//textBasedSetup();
	}
	
	public void shootClicked() {
		int toShot = Integer.parseInt(this.numberInputTextFields.getText());
		this.shotHappenedFor(toShot);
	}

}