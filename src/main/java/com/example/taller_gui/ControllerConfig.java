package com.example.taller_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerConfig implements Initializable {
    @FXML
    public Spinner spinnerPlayers;

    @FXML
    public Button update;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SpinnerValueFactory<Integer> spinnerPlayersFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(2,20,2);
        this.spinnerPlayers.setValueFactory(spinnerPlayersFactory);
    }

    @FXML
    void updatePlayers(ActionEvent event) {
        Object objPlay = event.getSource();
        Node sourceConfig = (Node) event.getSource();
        Stage stageConfg = (Stage) sourceConfig.getScene().getWindow();
        if (objPlay.equals(this.update)){
            stageConfg.close();
        }
    }
}
