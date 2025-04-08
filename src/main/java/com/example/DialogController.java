package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DialogController {

    MainController mainController;


    @FXML
    void onClickCloseButton(ActionEvent event) {
        //((Stage) ((javafx.scene.Node)
         //event.getSource())
         //.getScene()
         //.getWindow())
         //.close();
        mainController.stage.close();
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }   

}
