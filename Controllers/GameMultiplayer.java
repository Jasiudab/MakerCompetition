package Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
//import src.Player;

import java.util.ArrayList;

public class GameMultiplayer {

    @FXML GridPane gridPane;
//    private ArrayList<Player> players = new ArrayList<Player>();

    private ArrayList<foo> foos = new ArrayList<>();

//    public GameMultiplayer(ArrayList<Player> players) {
//        this.players = players;
//    }

    public void initialize(){
        this.dynamicPlayersGridPane(this.gridPane);
    }

//    private void dynamicPlayersGridPane(GridPane gridPane, ArrayList<Player> players) {
//        int row = 0;
//        gridPane.addRow(players.size());
//        for (Player elem : players) {
//
//            foo customControl = new foo();
//            customControl.setText("Hello!");
//
//            gridPane.add(customControl, 0, row);
//            row++;
//        }
//    }

    private void dynamicPlayersGridPane(GridPane gridPane) {
        int row = 0;
//  //      gridPane.addRow(players.size());
        for (int i = 0; i < 3; i++) {

            foo customControl = new foo();
            customControl.setText("Hello!");

            foos.add(customControl);

            gridPane.add(customControl, 0, row);
            row++;
        }
    }
}
