package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PlayerRowController extends HBox {

    private Player player;

    @FXML private Label numberLabel;
    @FXML private Label nameLabel;
    @FXML private Label scoreLabel;
    @FXML private Label positionLabel;


    public PlayerRowController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "../Scenes/PlayerRow.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }


    public void initialize(Player player, int number){
        this.numberLabel.setText(String.valueOf(number));
        this.player = player;
        this.nameLabel.setText(player.getName());
        this.refresh();
    }

    public void refresh() {
        this.scoreLabel.setText(String.valueOf(player.getScore()));
        this.positionLabel.setText("1");
    }

    public void foo(String foo) {
        System.out.println(foo);
    }
}
