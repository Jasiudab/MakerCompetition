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

public class ConfigMultiController {

    @FXML
    GridPane gridPane;

    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<PlayerConfigRowController> playersControllers = new ArrayList<>();
    private int noOfPlayers;

    public void initialize(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        gridPane.addRow(noOfPlayers);
        int row = 1;
        for (int i = 0; i < this.noOfPlayers; i++) {

            PlayerConfigRowController playerConfigRowController = new PlayerConfigRowController();
            playerConfigRowController.initialize(row);

            playersControllers.add(playerConfigRowController);
            System.out.println(row);

            gridPane.add(playerConfigRowController, 0, row);
            row++;
        }
    }

    public void playButtonClicked(){
        for (PlayerConfigRowController elem : playersControllers) {

            Player player = new Player(0,elem.getNameTextField());
            players.add(player);

        }

        try{

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/GameMulti.fxml"));
            Parent editRoot = (Parent) fxmlLoader.load();

            GameMultiController dc = fxmlLoader.getController();
            dc.initialize(players, noOfInputs, gameType);

            Scene newScene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
            Stage stage = (Stage) gridPane.getScene().getWindow();
            stage.setTitle("LaserGun | Game");

            stage.setScene(newScene);


        } catch (IOException e) {
            e.printStackTrace();
            // Quit the program (with an error code)
            System.exit(-1);

        }
    }


    @FXML Button inputs2;
    @FXML Button inputs3;
    @FXML Button inputs4;
    @FXML Button inputs5;

    @FXML Button addButton;
    @FXML Button multiButton;

    static int noOfInputs = 2;
    String gameType = "addition";

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
}
