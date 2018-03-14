package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import src.Player;

import java.io.IOException;
import java.util.ArrayList;

public class ConfigMultiController {

    @FXML
    GridPane gridPane;

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerConfigRowController> playersControllers = new ArrayList<>();
    private int noOfPlayers;

    public void initialize(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        gridPane.addRow(noOfPlayers);
        int row = 0;
        for (int i = 0; i < this.noOfPlayers; i++) {

            PlayerConfigRowController playerConfigRowController = new PlayerConfigRowController();
            playerConfigRowController.initialize(row+1);

            playersControllers.add(playerConfigRowController);

            gridPane.add(playerConfigRowController, 0, row);
            row++;
        }
    }

    public void playButtonClicked(){
        for (PlayerConfigRowController elem : playersControllers) {

            Player player = new Player(elem.getNameTextField());
            players.add(player);

            try{

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameMulti.fxml"));
                Parent editRoot = (Parent) fxmlLoader.load();

                GameMultiController dc = fxmlLoader.getController();
                dc.initialize(players);

                Scene newScene = new Scene(editRoot);
                Stage stage = (Stage) gridPane.getScene().getWindow();
                stage.setTitle("LaserGun | Game");

                stage.setScene(newScene);


            } catch (IOException e) {
                e.printStackTrace();
                // Quit the program (with an error code)
                System.exit(-1);

            }

        }
    }
}
