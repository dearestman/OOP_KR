package com.company.new_oop;

import com.company.new_oop.domain.animations.Shake;
import com.company.new_oop.domain.users.Adult;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ClientInfoController implements Initializable {
    private Adult client = ClientController.getSelectedClient();

    @FXML
    public AnchorPane anchorPaneMain;

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
    private TextField idField;

    @FXML
    private TextField inhabitedField;

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
    private Button updateClientButton;

    @FXML
    void updateClientButtonOnAction(ActionEvent event) throws SQLException, IOException {
        if (issuedByField.getText().equals("") || serialField.getText().equals("") ||
                numberField.getText().equals("") || countryField.getText().equals("") ||
                regionField.getText().equals("") || inhabitedField.getText().equals("") ||
                streetField.getText().equals("") || houeseField.getText().equals("") ||
                extensionField.getText().equals("") || apartmentField.getText().equals("") ||
                firstNameField.getText().equals("") || lastNameField.getText().equals("") ||
                patronymicField.getText().equals("") || telephoneField.getText().equals("") ||
                mailField.getText().equals(""))
        {
            Shake anchorPaneMainShake = new Shake(anchorPaneMain);
            anchorPaneMainShake.playAnim();
        } else {
            Adult.updateAdult(client,
                    dateOfIssueField.getValue(), issuedByField.getText(), serialField.getText(),
                    numberField.getText(), countryField.getText(), regionField.getText(),
                    inhabitedField.getText(), streetField.getText(), houeseField.getText(),
                    extensionField.getText(), apartmentField.getText(), client.getUserID(), firstNameField.getText(),
                    lastNameField.getText(), patronymicField.getText(), birthdayField.getValue(),
                    "", "", telephoneField.getText(), mailField.getText()
            );
            updateClientButton.getScene().getWindow().hide();

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idField.setText(String.valueOf(client.getUserID()));
        firstNameField.setText(client.getFirstName());
        lastNameField.setText(client.getLastName());
        patronymicField.setText(client.getPatronymic());
        birthdayField.setValue(client.getBirthday());
        telephoneField.setText(client.getClientTelephone());
        mailField.setText(client.getClientMail());
        serialField.setText(client.getClientPassport().getPassportSerial());
        numberField.setText(client.getClientPassport().getPassportNumber());
        dateOfIssueField.setValue(client.getClientPassport().getDateOfIssue());
        issuedByField.setText(client.getClientPassport().getIssuedBy());
        countryField.setText(client.getClientPassport().getAddressRegistration().getAddressLocality().getCountry());
        regionField.setText(client.getClientPassport().getAddressRegistration().getAddressLocality().getRegion());
        inhabitedField.setText(client.getClientPassport().getAddressRegistration().getAddressLocality().getInhabitedLocality());
        streetField.setText(client.getClientPassport().getAddressRegistration().getAddressStreet());
        houeseField.setText(client.getClientPassport().getAddressRegistration().getAddressHouse());
        extensionField.setText(client.getClientPassport().getAddressRegistration().getAddressExtension());
        apartmentField.setText(client.getClientPassport().getAddressRegistration().getAddressApartment());

    }
}
