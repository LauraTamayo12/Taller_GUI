package com.example.taller_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button close;

    public Controller() {
    }

    @FXML
    void close(ActionEvent event) {
        System.exit(0);
    }

    // " Configuraciones---------
    @FXML
    private ComboBox<String> N_Players;

    @FXML
    private ComboBox<String> Levels;

    @FXML
    private Button startGame;

    // " Resultados---------
    @FXML
    private Label advanced_positions;

    @FXML
    private Label player_turn;

    @FXML
    private Label remaining_positions;

    @FXML
    private Label returns;

    // " Zona de juego---------
    @FXML
    private Label random_play;

    @FXML
    private Button lanza_player;

    // " Pares---------
    @FXML
    private Label pairs;

    @FXML
    private ImageView imgPair;

    // " Ganador---------
    @FXML
    private Label wiiiin;

    @FXML
    private ImageView premio;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Básico", "Medio", "Alto");
        Levels.getItems().addAll(list);
        Levels.getSelectionModel().select(0);

        ArrayList<String> listN = new ArrayList<>();
        Collections.addAll(listN, "1", "2", "3", "4", "5");
        N_Players.getItems().addAll(listN);
        N_Players.getSelectionModel().select(1);
    }
}