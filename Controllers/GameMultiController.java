package Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import src.Music;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GameMultiController {

    int counter = 0;
    @FXML GridPane gridPane;
    @FXML Button turnLabel;
    @FXML Label nextPlayerLabel;

    private ArrayList<PlayerRowController> playersControllers = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private int noOfInputs;
    private String gameType;
    private int noOfTurns;

    public void initialize(ArrayList<Player> players, int noOfInputs, String gameType, int noOfTurns) {
        this.noOfTurns = noOfTurns;
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

        this.nextPlayerLabel.setText(players.get(counter).getName());
    }

    public  void goOnButtonClicked(){

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

            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(WindowEvent we) {
                    Music.changeToPause();
                }
            });

            Music.changeToIntense();

            stage.showAndWait();


            counter++;
            this.refresh();

        } catch (IOException e) {
            e.printStackTrace();
            // Quit the program (with an error code)
            System.exit(-1);
        }


    }



    private void refresh(){

        Collections.sort(players, Collections.reverseOrder());

        if(counter == players.size()){
            counter = 0;
            turnLabel.setText(String.valueOf(Integer.parseInt(turnLabel.getText())+1));
            if(Integer.parseInt(turnLabel.getText())==this.noOfTurns + 1){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success");
                alert.setContentText("Congratulations " + players.get(0).getName() + "\nYou won!");
                alert.showAndWait();

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Scenes/Welcome.fxml"));
                    Parent editRoot = (Parent) fxmlLoader.load();

                    WelcomeController dc = fxmlLoader.getController();
                    dc.initialize();

                    Stage stage = (Stage) turnLabel.getScene().getWindow();
                    Scene scene = new Scene(editRoot, MainGUI.BIG_WIDTH, MainGUI.BIG_HEIGHT);
                    stage.setTitle("Welcome");
                    stage.setScene(scene);
                    stage.show();

                    Music.changeToIntro();

                } catch (Exception e) {
                    e.printStackTrace();
                    // Quit the program (with an error code)
                    System.exit(-1);
                }
            }
        }

        this.nextPlayerLabel.setText(players.get(counter).getName());


        int position = 1;
        for (Player elem : players) {

            elem.setPosition(position);
            position++;

        }

//        for (Player elem : players) {
//            System.out.println(elem);
//        }

        for (PlayerRowController elem : playersControllers) {
            elem.refresh();
        }
    }

}
