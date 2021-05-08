package org.teamGame.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.teamGame.game.configs.Configs;
import org.teamGame.util.HandlerApp;

public class SettingSceneController implements FxController{

    HandlerApp handlerApp;

    public SettingSceneController(HandlerApp handlerApp){
        this.handlerApp = handlerApp;
    }


    @FXML
    private Button soundOn;

    @FXML
    private Button soundOff;

    @FXML
    private Button back;

    @FXML
    public void initialize(){
        soundOn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(Configs.IS_MUTE) {
                    handlerApp.getSoundManager().unMuteAll();
                    Configs.IS_MUTE = false;
                }
            }
        });

        soundOff.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(!Configs.IS_MUTE){
                    handlerApp.getSoundManager().muteAll();
                    Configs.IS_MUTE = true;
                }
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handlerApp.getApp().getSettingStage().close();
            }
        });
    }
}
