package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import src.Player;

import java.util.ArrayList;

public class GameMultiController {

    @FXML GridPane gridPane;
    private ArrayList<PlayerRowController> playersControllers = new ArrayList<>();

    public void initialize(ArrayList<Player> players) {
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
}
