package Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;

public class GameSingleController {

	@FXML private Button shotNumber;
	@FXML private Button currentNumber;
	@FXML private Button goalNumber;
	@FXML private TextField numberInputTextFields;
	
	int goal;
	
	public void initialize(int goal) {
		this.goalNumber.setText(String.valueOf(goal));
		this.goal = goal;
		this.currentNumber.setText("1");
	}
	
	public void shotHappenedFor(int number) {

		this.shotNumber.setText(String.valueOf(number));
		int currentNew = Integer.parseInt(this.currentNumber.getText()) * number;
		
		if(currentNew > this.goal) {
	    	Alert alert = new Alert(Alert.AlertType.WARNING);
	        alert.setTitle("Error");
	        alert.setContentText("Number too high");
	        alert.showAndWait();
		} else if (currentNew == goal) {
	    	Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	        alert.setTitle("Success");
	        alert.setContentText("You won!");
	        alert.showAndWait();
		} else {
		
		this.currentNumber.setText(String.valueOf(currentNew));
		}
	}
	
	public void shootClicked() {
		int toShot = Integer.parseInt(this.numberInputTextFields.getText());
		this.shotHappenedFor(toShot);
	}
}
