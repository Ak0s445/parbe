package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class DialogController {

    MainController mainController;

    @FXML
    private TextField plateField;    

    @FXML
    void onClickCloseButton(ActionEvent event) {

    
        startClose();
    }

    private void startClose() {
         // Stage stage = 
        // (Stage) 
        // ((javafx.scene.Node) event.getSource())
        // .getScene()
        // .getWindow();

        // stage.close();

        if (plateField.getText().isEmpty()){
            System.out.println("Üres");
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setHeaderText("Nem lehet ures");
            alert.setContentText("A rendszám nem lehet ures");
            alert.showAndWait();
        
            return;
        }
        mainController.carList.getItems().add(plateField.getText());
        mainController.stage.close();

    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

     @FXML
    void onKeyReleasedPlateField(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

            startClose();

        }
    }
}
