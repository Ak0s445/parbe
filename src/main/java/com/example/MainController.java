package com.example;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.stage.Stage;

public class MainController {

    Stage stage = new Stage();

    @FXML
    public ListView<String> carList;


    @FXML
    void initialize() {
        System.out.println("initialize...");
        carList.setEditable(true);
        carList.setCellFactory(TextFieldListCell.forListView());
        App._stage.setOnCloseRequest(event -> {
            System.out.println("onCloseRequest...");

            StringBuilder content = new StringBuilder();
            for (String car : carList.getItems()) {
                content.append(car);
                content.append("\n");
            }                
            Store.writeCars(content.toString());

        });
    }

    @FXML
    void onClickAddButton(ActionEvent event) {
        showDialog();
    }

    void showDialog() {
        try {
            tryShowDialog();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    
    void tryShowDialog() throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("dialogScene.fxml"));
        Scene scene = new Scene(loader.load());
        
        stage.setScene(scene);
        stage.show();

        DialogController controller = loader.getController();
        controller.setMainController(this);

    }

    //Törlés gomb beállitások
    @FXML
    void onClickDelButton(ActionEvent event) {
        System.out.println("Törlés...");
       int index =  this.carList
       .getSelectionModel()
       .getSelectedIndex();

       if (index == -1) {
        System.err.println("Hiba, nincs kijelölt elem");
        return;}

      String res = this.carList.getItems().remove(index);
       System.out.println("Törölve: " + res);
    }

    //kilépés gomb beállitások
    @FXML
    void onClickExitButton(ActionEvent event) {

    }

    //módositás gomb beállitások
    @FXML
    void onClickModifyButton(ActionEvent event) {

    }

}
