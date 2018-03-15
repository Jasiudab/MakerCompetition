package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameMultiController {

    int counter = 1;
    @FXML GridPane gridPane;
    @FXML
    Button turnLabel;

    private ArrayList<PlayerRowController> playersControllers = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private int noOfInputs;
    private String gameType;

    public void initialize(ArrayList<Player> players, int noOfInputs, String gameType) {
        this.gameType = gameType;
        this.noOfInputs = noOfInputs;
        this.turnLabel.setText("1");
        this.players = players;

        gridPane.addRow(players.size());
        int row = 1;
        for (Player elem : players) {

            PlayerRowController playerRowController = new PlayerRowController();
            playerRowController.initialize(elem, row);

            playersControllers.add(playerRowController);

            gridPane.add(playerRowController, 0, row);
            row++;
        }
    }

    public  void goOnButtonClicked(){
        int turn = Integer.parseInt(this.turnLabel.getText());
        if(turn%players.size() == 0)
            turn ++;
        this.turnLabel.setText(String.valueOf(turn));

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameSingle.fxml"));
            Parent editRoot = (Parent) fxmlLoader.load();

            GameSingleController dc = fxmlLoader.getController();
            Main.reset();
            Main.setup(noOfInputs, gameType);
            dc.initialize(Main.getSolution(), noOfInputs, gameType, players.get(counter));


            Scene newScene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
            Stage stage = new Stage();
            stage.setTitle("Shooter | Game");

            stage.setScene(newScene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            // Quit the program (with an error code)
            System.exit(-1);
        }


    }

    private void refresh(){
        for (PlayerRowController elem : playersControllers) {

            elem.refresh();
        }
    }
}
