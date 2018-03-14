package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import src.Player;

import java.util.ArrayList;

public class GameMultiController {

    @FXML GridPane gridPane;
    @FXML
    Button turnLabel;

    private ArrayList<PlayerRowController> playersControllers = new ArrayList<>();
    private int noOfInputs;
    private String gameType;

    public void initialize(ArrayList<Player> players, int noOfInputs, String gameType) {
        this.gameType = gameType;
        this.noOfInputs = noOfInputs;
        this.turnLabel.setText("1");

        gridPane.addRow(players.size());
        int row = 0;
        for (Player elem : players) {

            PlayerRowController playerRowController = new PlayerRowController();
            playerRowController.initialize(elem, row+1);

            playersControllers.add(playerRowController);

            gridPane.add(playerRowController, 0, row);
            row++;
        }
    }

    public  void goOnButtonClicked(){

    }
}
