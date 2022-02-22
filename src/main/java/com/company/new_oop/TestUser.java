package com.company.new_oop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TestUser {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty patronymic = new SimpleStringProperty();
    private SimpleStringProperty birthday = new SimpleStringProperty();
    private SimpleStringProperty documentType = new SimpleStringProperty();
    private SimpleStringProperty serial = new SimpleStringProperty();
    private SimpleStringProperty number = new SimpleStringProperty();

    public TestUser(String firstName, String lastName, String patronymic) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.patronymic = new SimpleStringProperty(patronymic);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getBirthday() {
        return birthday.get();
    }

    public SimpleStringProperty birthdayProperty() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday.set(birthday);
    }

    public String getDocumentType() {
        return documentType.get();
    }

    public SimpleStringProperty documentTypeProperty() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType.set(documentType);
    }

    public String getSerial() {
        return serial.get();
    }

    public SimpleStringProperty serialProperty() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial.set(serial);
    }

    public String getNumber() {
        return number.get();
    }

    public SimpleStringProperty numberProperty() {
        return number;
    }

    public void setNumber(String number) {
        this.number.set(number);
    }


    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getPatronymic() {
        return patronymic.get();
    }

    public SimpleStringProperty patronymicProperty() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic.set(patronymic);
    }
}
