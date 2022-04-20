package com.company.new_oop.domain.pricelist;

import com.company.new_oop.Database;
import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.documents.Passport;
import com.company.new_oop.domain.users.Adult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Price {
    private int priceId;
    private Tour priceTour;
    private float priceTourPrice; // Цена за тур
    private LocalDate priceTourDate; // Цена за тур
    private int tourDuration; // Длительность тура в днях

    public Price(int priceId, Tour priceTour, float priceTourPrice, LocalDate priceTourDate, int tourDuration) {
        this.priceId = priceId;
        this.priceTour = priceTour;
        this.priceTourPrice = priceTourPrice;
        this.priceTourDate = priceTourDate;
        this.tourDuration = tourDuration;
    }

    public float getPriceTourPrice() {
        return priceTourPrice;
    }

    public void setPriceTourPrice(float priceTourPrice) {
        this.priceTourPrice = priceTourPrice;
    }

    //    public Price(int priceId, Tour priceTour, LocalDate priceTourDate, int tourDuration) {
//        this.priceId = priceId;
//        this.priceTour = priceTour;
//        this.priceTourDate = priceTourDate;
//        this.tourDuration = tourDuration;
//    }

    public int getPriceId() {
        return priceId;
    }

    public void setPriceId(int priceId) {
        this.priceId = priceId;
    }

    public Tour getPriceTour() {
        return priceTour;
    }

    public void setPriceTour(Tour priceTour) {
        this.priceTour = priceTour;
    }

    public LocalDate getPriceTourDate() {
        return priceTourDate;
    }

    public void setPriceTourDate(LocalDate priceTourDate) {
        this.priceTourDate = priceTourDate;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public void setTourDuration(int tourDuration) {
        this.tourDuration = tourDuration;
    }


    public static ArrayList<Price> selectPriceList() {
        ArrayList<Price> priceArrayList = new ArrayList<>();
        try {
            Connection con = Database.getConnection();
            try {
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("" +
                        "SELECT *, \"Hotels\".name as \"hotelName\", " +
                        "\"HotelRooms\".number as \"hotelRoomNumber\", " +
                        "\"Tours\".name as \"tourName\", " +
                        "\"Prices\".id as \"priceId\" " +
                        "FROM \"Prices\"  " +
                        "JOIN \"Tours\" ON \"Tours\".id =  \"Prices\".tour " +
                        "JOIN \"HotelRooms\" ON \"HotelRooms\".id = \"Tours\".\"hotelRoom\" " +
                        "JOIN \"Hotels\" ON \"Hotels\".id = \"HotelRooms\".hotel " +
                        "JOIN \"Addresses\" ON \"Addresses\".id = \"Hotels\".address " +
                        "JOIN \"Localities\" ON \"Localities\".id = \"Addresses\".locality ");


                while (rs.next()) {

                    int localityId = rs.getInt("locality");
                    String country = rs.getString("country");
                    String region = rs.getString("region");
                    String inhabited = rs.getString("inhabited");
                    Locality locality = new Locality(localityId, country, region, inhabited);

                    int addressId = rs.getInt("address");
                    String street = rs.getString("street");
                    String house = rs.getString("house");
                    String extension = rs.getString("extension");
                    String apartment = rs.getString("apartment");
                    Address address = new Address(addressId, street, house, extension, apartment, locality);

                    int hotelId = rs.getInt("hotel");
                    String hotelName = rs.getString("hotelName");
                    Hotel hotel = new Hotel(hotelName, address);

                    int hotelRoomId = rs.getInt("hotelRoom");
                    String hotelRoomNumber = rs.getString("hotelRoomNumber");
                    int hotelRoomStars = rs.getInt("stars");
                    String hotelRoomTypeOfFood = rs.getString("typeOfFood");

                    HotelRoom hotelRoom = new HotelRoom(hotelRoomId, hotelRoomNumber, hotelRoomStars, hotel, hotelRoomTypeOfFood);

                    int tourId = rs.getInt("tour");
                    String tourName = rs.getString("tourName");
                    Tour tour = new Tour(tourId, tourName, hotelRoom);

                    int priceId = rs.getInt("priceId");
                    int price = rs.getInt("price");
                    LocalDate date = MyDate.covertStringToLocalDate(rs.getString("date"), "yyyy-MM-dd");
                    int duration = rs.getInt("duration");
                    Price priceElem = new Price(priceId, tour, price, date, duration);


                    priceArrayList.add(priceElem);


                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return priceArrayList;

    }



}
