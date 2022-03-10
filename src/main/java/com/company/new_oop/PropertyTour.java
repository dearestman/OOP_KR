package com.company.new_oop;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class PropertyTour {
    private SimpleIntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty name = new SimpleStringProperty();
    private SimpleStringProperty country = new SimpleStringProperty();
    private SimpleStringProperty hotel = new SimpleStringProperty();
    private SimpleStringProperty startDate = new SimpleStringProperty();
    private SimpleIntegerProperty duration = new SimpleIntegerProperty();
    private SimpleStringProperty price = new SimpleStringProperty();

    public PropertyTour(int id, String name, String country, String hotel, String startDate, int duration, String price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.hotel = new SimpleStringProperty(hotel);
        this.startDate = new SimpleStringProperty(startDate);
        this.duration = new SimpleIntegerProperty(duration);
        this.price = new SimpleStringProperty(price);
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

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public String getHotel() {
        return hotel.get();
    }

    public SimpleStringProperty hotelProperty() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel.set(hotel);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public SimpleStringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public int getDuration() {
        return duration.get();
    }

    public SimpleIntegerProperty durationProperty() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration.set(duration);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }
}
