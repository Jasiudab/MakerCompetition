package Controllers;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.Music;

public class GameSingleController {

	@FXML
	private Button shotNumber;
	@FXML
	private Button currentNumber;
	@FXML
	private Button goalNumber;
	@FXML
	private TextField numberInputTextFields;
	@FXML
	Label l1, l2, l3, l4, l5;

	int goal;
	int noOfInputs;
	int currentInputs;
	String game;
	Timeline fiveSecondsWonder;
	private Player player;
	int score = 10;

	/*
	Timer stuff
	 */
	private static final Integer STARTTIME = 5;
	private Timeline timeline;
	@FXML Button timerLabel;
	private IntegerProperty timeSeconds = new SimpleIntegerProperty(STARTTIME);

	public void initialize(int goal, int noOfInputs, String game, Player player) {
		this.player = player;
		this.goalNumber.setText(String.valueOf(goal));
		this.goal = goal;
		switch (game) {
		case "multiplication":
			this.currentNumber.setText("1");
			break;
		case "addition":
			this.currentNumber.setText("0");
			break;
		}
		this.currentInputs = 0;
		this.noOfInputs = noOfInputs;
		this.game = game;
		int[] pinValues = Main.getPinValues();
		l1.setText("Box 1 : \n" + pinValues[0]);
		l2.setText("Box 2 : \n" + pinValues[1]);
		l3.setText("Box 3 : \n" + pinValues[2]);
		l4.setText("Box 4 : \n" + pinValues[3]);
		l5.setText("Box 5 : \n" + pinValues[4]);
		fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(0.1), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (Main.newInput()) {
					shotHappenedFor(Main.getNewInput());

				}
			}
		}));

		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();

		/*
		Timer stuff, don't try to understand,
		Source: http://asgteach.com/2011/10/javafx-animation-and-binding-simple-countdown-timer-2/
		and my own code of course
		 */
		timerLabel.textProperty().bind(timeSeconds.asString());
		if (timeline != null) {
			timeline.stop();
		}
		timeSeconds.set(STARTTIME);
		timeline = new Timeline();
		timeline.getKeyFrames().add(
				new KeyFrame(Duration.seconds(STARTTIME+1),
						new KeyValue(timeSeconds, 0)));
		timeline.playFromStart();
		timeline.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				accept();
			}
		});
	}

	public void shotHappenedFor(int number) {
		Music.shootLaser();
		System.out.println("current input " + currentInputs);
		if (currentInputs < noOfInputs) { // if inputs is less than number

			this.shotNumber.setText(number + "");
			int currentNew = Integer.parseInt(this.currentNumber.getText());
			switch (game) {
			case "addition":
				currentNew += number;
				break;
			case "multiplication":
				currentNew *= number;
				break;
			}
			this.currentNumber.setText(currentNew + "");
			currentInputs++;
		}
		if (currentInputs == noOfInputs) { // if the game is over
			accept();
		}
	}

	public void accept() {
		if (Integer.parseInt(currentNumber.getText()) == goal) {
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Success");
			alert.setContentText("You won!");
			alert.show();
		} else {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Error");
			alert.setContentText("You Lost");
			alert.show();

		}
		// return to setup
		reset();
		player.addScore(score);
		try {
			timeline.stop();
			Stage stage = (Stage) currentNumber.getScene().getWindow();
			stage.close();
			Music.changeToPause();

		} catch (Exception e) {
		}
		// textBasedSetup();
	}
	public void reset() {
		currentInputs = 0;
		if(fiveSecondsWonder != null) {
			fiveSecondsWonder.getKeyFrames().clear();
			fiveSecondsWonder = null;
		}
	}

	public void timerLabelClicked(){
		this.shotHappenedFor(5);
	}
}