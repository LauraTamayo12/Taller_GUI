package com.example.taller_gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
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

    @FXML
    void startTheGame(ActionEvent event) {
        this.lanza_player.setDisable(false);
        this.new_game.setDisable(false);
        this.startGame.setDisable(true);
        this.parameter_config.setDisable(true);
        this.N_Players.setDisable(true);
        this.Levels.setDisable(true);
    }

    // " Resultados---------
    @FXML
    private Label advanced_positions;

    @FXML
    private Label player_turn;

    @FXML
    private Label remaining_positions;

    @FXML
    private Label returns;

    // " Botones-------
    @FXML
    private Button parameter_config;

    @FXML
    private Button new_game;

    @FXML
    private Button about_game;

    private ControllerConfig controllerConfig;

    private ControllerAbout controllerAbout;

    @FXML
    void configuration(ActionEvent event) throws IOException {
        Stage stageConfig = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader();
        AnchorPane anchorPane = fxmlLoader.load(getClass().getResource("panelConfig.fxml").openStream());
        this.controllerConfig = fxmlLoader.getController();
        Scene sceneConfig = new Scene(anchorPane);
        sceneConfig.setFill(Color.TRANSPARENT);
        stageConfig.setScene(sceneConfig);
        stageConfig.alwaysOnTopProperty();
        stageConfig.initModality(Modality.APPLICATION_MODAL);
        stageConfig.initStyle(StageStyle.TRANSPARENT);
        stageConfig.showAndWait();
        if (!this.controllerConfig.spinnerPlayers.getValue().equals("")) {
            jugadores();
        }
    }

    @FXML
    void aboutGame(ActionEvent event) throws IOException {
        Stage stageAbout = new Stage();
        FXMLLoader loaderAbout = new FXMLLoader();
        AnchorPane anchorPaneAbout = loaderAbout.load(getClass().getResource("about.fxml").openStream());
        this.controllerAbout = loaderAbout.getController();
        Scene sceneAbout = new Scene(anchorPaneAbout);
        stageAbout.setScene(sceneAbout);
        stageAbout.show();
    }

    public void jugadores() {
        ArrayList<String> listN = numbers();
        this.N_Players.getItems().setAll(listN);
        this.N_Players.getSelectionModel().select(0);
    }

    public ArrayList<String> numbers() {
        ArrayList<String> nPlayers = new ArrayList<>();
        int num = (int) this.controllerConfig.spinnerPlayers.getValue();
        for (int i = 2; i <= num; i++)
            nPlayers.add("" + i);
        return nPlayers;
    }

    @FXML
    void newGames(ActionEvent event) {
        this.lanza_player.setDisable(true);
        this.new_game.setDisable(true);
        this.startGame.setDisable(false);
        this.parameter_config.setDisable(false);
        this.N_Players.setDisable(false);
        this.Levels.setDisable(false);
    }

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
        comboBox();
        this.imgPair.setVisible(false);
        this.premio.setVisible(false);
        this.parameter_config.setDisable(false);
        this.about_game.setDisable(false);
        this.new_game.setDisable(true);
        this.lanza_player.setDisable(true);

    }

    public void comboBox(){
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Básico", "Medio", "Alto");
        Levels.getItems().addAll(list);
        Levels.getSelectionModel().select(0);

        ArrayList<String> listN = new ArrayList<>();
        Collections.addAll(listN, "2", "3", "4", "5");
        N_Players.getItems().addAll(listN);
        N_Players.getSelectionModel().select(0);
    }
}