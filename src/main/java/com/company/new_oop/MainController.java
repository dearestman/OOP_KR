package com.company.new_oop;

import com.company.new_oop.domain.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController {

    private static User authorizedUser;


    public static void setAuthorizedUser(User authorizedUser) {
        MainController.authorizedUser = authorizedUser;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button clientButton;

    @FXML
    private Label helloField;

    @FXML
    private Button orderButton;

    @FXML
    private Button tourButton;

    @FXML
    void onActionClients(ActionEvent event) throws IOException {
        clientButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("clients.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void initialize() {

    }

    @FXML
    public void tourButtonOnAction(ActionEvent actionEvent) throws IOException {
        clientButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("priceList.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
