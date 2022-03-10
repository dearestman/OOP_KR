package com.company.new_oop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class PriceListController implements Initializable {

    @FXML
    private TableColumn<PropertyTour, String> HotelColumn;

    @FXML
    private Button addClientButton;

    @FXML
    private TableColumn<PropertyTour, String> countryColumn;

    @FXML
    private Button deleteTourButton;

    @FXML
    private TableColumn<PropertyTour, Integer> durationColumn;

    @FXML
    private TableColumn<PropertyTour, Integer> idColumn;

    @FXML
    private Button mainMenuButton;

    @FXML
    private TableColumn<PropertyTour, String> nameColumn;

    @FXML
    private TableColumn<PropertyTour, String> priceTour;

    @FXML
    private TableColumn<PropertyTour, String> startDateTour;

    @FXML
    private TableView<PropertyTour> tableViewsTours;

    @FXML
    private Button updateTourButton;

    @FXML
    void addClientButtonOnAction(ActionEvent event) {

    }

    @FXML
    void deleteTourButtonOnAction(ActionEvent event) {

    }

    @FXML
    void mainMenuButtonOnAction(ActionEvent event) {

    }

    @FXML
    void updateTourButtonOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<PropertyTour> list = FXCollections.observableArrayList(
        );
        list.add(new PropertyTour(1,"dasda","dsadas","Dasdas","dasdas", 1, "dsadas"));
//        ArrayList<Adult> temp = Adult.selectAllAdults();


        tableViewsTours.setItems(list);
    }
}
