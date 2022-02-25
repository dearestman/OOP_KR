package com.company.new_oop;

import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.users.Adult;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    public TableColumn <TestUser, String> birthdayColumn;
    @FXML
    public TableColumn <TestUser, String> documentTypeColumn;
    @FXML
    public TableColumn <TestUser, String> serialColumn;
    @FXML
    public TableColumn <TestUser, String> numberColumn;
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
    void addClientButtonOnAction(ActionEvent event) {

        for (Adult adult: Adult.selectAllAdults()) {
            tableViewsClients.getItems().add(new TestUser(adult.getUserID(),adult.getFirstName(),adult.getLastName(),
                    adult.getPatronymic(), MyDate.covertLocalDateToString(adult.getBirthday()), "Паспорт",
                    adult.getClientPassport().getPassportSerial(), adult.getClientPassport().getPassportNumber()));
        }
//        TestUser testUser = new TestUser("dsa","dsada", "das");
//        tableViewsClients.getItems().add(testUser);
    }

    @FXML
    void deleteClientButtonOnAction(ActionEvent event) {

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
}
