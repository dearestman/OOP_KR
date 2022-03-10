package com.company.new_oop;

import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.animations.Shake;
import com.company.new_oop.domain.documents.Document;
import com.company.new_oop.domain.documents.Passport;
import com.company.new_oop.domain.users.Adult;
import com.company.new_oop.domain.users.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class AddClientController {
    @FXML
    public AnchorPane anchorPaneMainId;

    @FXML
    private TextField apartmentField;

    @FXML
    private DatePicker birthdayField;

    @FXML
    private TextField countryField;

    @FXML
    private DatePicker dateOfIssueField;

    @FXML
    private TextField extensionField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField houeseField;

    @FXML
    private TextField inhabitedField;

    @FXML
    private Button insertClientButton;

    @FXML
    private TextField issuedByField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField mailField;

    @FXML
    private TextField numberField;

    @FXML
    private TextField patronymicField;

    @FXML
    private TextField regionField;

    @FXML
    private TextField serialField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField telephoneField;

    @FXML
    private TextField typeOfDocumentField;

    @FXML
    void insertClientButtonOnAction(ActionEvent event) throws SQLException, IOException {
        if (issuedByField.getText().equals("") || serialField.getText().equals("") ||
                numberField.getText().equals("") || countryField.getText().equals("") ||
                regionField.getText().equals("") || inhabitedField.getText().equals("") ||
                streetField.getText().equals("") || houeseField.getText().equals("") ||
                extensionField.getText().equals("") || apartmentField.getText().equals("") ||
                firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                patronymicField.getText().equals("") || telephoneField.getText().equals("") ||
                mailField.getText().equals(""))
        {
            Shake anchorPaneMainShake = new Shake(anchorPaneMainId);
            anchorPaneMainShake.playAnim();
        } else {
            Adult.insertAdult(
                    dateOfIssueField.getValue(), issuedByField.getText(), serialField.getText(),
                    numberField.getText(), countryField.getText(), regionField.getText(),
                    inhabitedField.getText(), streetField.getText(), houeseField.getText(),
                    extensionField.getText(), apartmentField.getText(), firstNameField.getText(),
                    lastNameField.getText(), patronymicField.getText(), birthdayField.getValue(),
                    "", "", telephoneField.getText(), mailField.getText()
            );
            insertClientButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("clients.fxml"));

            loader.load();

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            stage.show();
        }

    }

}
