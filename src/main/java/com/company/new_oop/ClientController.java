package com.company.new_oop;

import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.documents.Passport;
import com.company.new_oop.domain.users.Adult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientController implements Initializable {

    private static Adult selectedClient;

    public static Adult getSelectedClient() {
        return selectedClient;
    }

    @FXML
    public TableColumn <TestUser, String> birthdayColumn;
    @FXML
    public TableColumn <TestUser, String> documentTypeColumn;
    @FXML
    public TableColumn <TestUser, String> serialColumn;
    @FXML
    public TableColumn <TestUser, String> numberColumn;

    @FXML
    public TableColumn <TestUser, Integer> idColumn;

    @FXML
    public Button mainMenuButton;

    @FXML
    public Button updateClientButton;

    @FXML
    private Button addClientButton;

    @FXML
    private Button deleteClientButton;

    @FXML
    private TableColumn<TestUser, String> firstNameColumn;

    @FXML
    private TableColumn<TestUser, String> lastNameColumn;

    @FXML
    private TableColumn<TestUser, String> patronymicColumn;

    @FXML
    private TableView<TestUser> tableViewsClients;

    @FXML
    void addClientButtonOnAction(ActionEvent event) throws IOException {

        mainMenuButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("addClient.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    void deleteClientButtonOnAction(ActionEvent event) throws SQLException, IOException {
        selectedClient = Adult.getAdult(tableViewsClients.getSelectionModel().getSelectedItem().getId());
        Adult.markForDeletionAdult(selectedClient);

        ObservableList<TestUser> list = FXCollections.observableArrayList();
        ArrayList<Adult> temp = Adult.selectAllAdults();
        for (Adult adult:temp
        ) {
            list.add(new TestUser(adult.getUserID(),adult.getFirstName(),adult.getLastName(),
                    adult.getPatronymic(), MyDate.covertLocalDateToString(adult.getBirthday()), "Паспорт",
                    adult.getClientPassport().getPassportSerial(), adult.getClientPassport().getPassportNumber()));
        }


        tableViewsClients.setItems(list);

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<TestUser> list = FXCollections.observableArrayList();
        ArrayList<Adult> temp = Adult.selectAllAdults();
        for (Adult adult:temp
             ) {
            list.add(new TestUser(adult.getUserID(),adult.getFirstName(),adult.getLastName(),
                    adult.getPatronymic(), MyDate.covertLocalDateToString(adult.getBirthday()), "Паспорт",
                    adult.getClientPassport().getPassportSerial(), adult.getClientPassport().getPassportNumber()));
        }


        tableViewsClients.setItems(list);
    }

    @FXML
    public void mainMenuButtonOnAction(ActionEvent actionEvent) throws IOException {
        mainMenuButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("main.fxml"));

        loader.load();

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void updateClientButtonOnAction(ActionEvent actionEvent) throws IOException {
        selectedClient = Adult.getAdult(tableViewsClients.getSelectionModel().getSelectedItem().getId());


        if (selectedClient!=null) {
            mainMenuButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("clientInfo.fxml"));

            loader.load();

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }
    }
}
