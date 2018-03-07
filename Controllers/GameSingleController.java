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

public class GameSingleController {

	@FXML private Button shotNumber;
	@FXML private Button currentNumber;
	@FXML private Button goalNumber;
	
	public void initialize(int goal) {
		this.goalNumber.setText(String.valueOf(goal));
	}
	
	public void shotHappenedFor(int number) {
		
	}
}
