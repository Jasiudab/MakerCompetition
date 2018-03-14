package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PlayerConfigRowController extends HBox {

    @FXML
    private Label numberLabel;
    @FXML private TextField nameTextField;

    public PlayerConfigRowController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource( "../Scenes/PlayerConfigRow.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void initialize(int number){
        this.numberLabel.setText(String.valueOf(number));
        this.nameTextField.setText("player");
    }
}
