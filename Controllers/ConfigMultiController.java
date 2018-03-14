package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import src.Player;

import java.util.ArrayList;

public class ConfigMultiController {

    @FXML
    GridPane gridPane;

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerConfigRowController> playersControllers = new ArrayList<>();
    private int noOfPlayers;

    public void initialize(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        int row = 0;
        for (int i = 0; i < this.noOfPlayers; i++) {

            PlayerConfigRowController playerConfigRowController = new PlayerConfigRowController();
            playerConfigRowController.initialize(row+1);

            playersControllers.add(playerConfigRowController);

            gridPane.add(playerConfigRowController, 0, row);
            row++;
        }
    }

}
