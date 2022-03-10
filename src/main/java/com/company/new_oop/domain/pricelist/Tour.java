package com.company.new_oop.domain.pricelist;

import com.company.new_oop.Database;
import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.documents.Passport;
import com.company.new_oop.domain.users.Adult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tour {

    private int tourId;
    private String tourName;
    private List<HotelRoom> tourHotelRooms;

    public Tour(int tourId, String tourName, List<HotelRoom> tourHotelRooms) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.tourHotelRooms = tourHotelRooms;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public List<HotelRoom> getTourHotelRooms() {
        return tourHotelRooms;
    }

    public void setTourHotelRooms(List<HotelRoom> tourHotelRooms) {
        this.tourHotelRooms = tourHotelRooms;
    }

    public static ArrayList<HotelRoom> selectAllHotelsInTour(int tourId){
        ArrayList<HotelRoom> hotelRooms = new ArrayList<>();
        try {
            Connection con = Database.getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("" +
                        "Select * " +
                        "From \"HotelRoomsInTour\" " +
                        "Join \"HotelRooms\" ON \"HotelRoomsInTour\".\"hotelRoom\" = \"HotelRooms\".id " +
                        "Join \"Hotels\" ON \"HotelRooms\".\"hotel\" = \"Hotels\".id " +
                        "Join \"Addresses\" ON \"Hotels\".address=\"Addresses\".id " +
                        "Join \"Localities\" ON \"Addresses\".locality=\"Localities\".id " +
                        "WHERE \"HotelRoomsInTour\".tour="+tourId+"");


                while (rs.next()) {

                    int localityId = rs.getInt("locality");
                    String country = rs.getString("country");
                    String region = rs.getString("region");
                    String inhabited = rs.getString("inhabited");
                    Locality locality = new Locality(localityId,country,region,inhabited);

                    int addressId = rs.getInt("addressRegistration");
                    String street = rs.getString("street");
                    String house = rs.getString("house");
                    String extension = rs.getString("extension");
                    String apartment = rs.getString("apartment");
                    Address address = new Address(addressId,street,house,extension,apartment,locality);

                    int hotelId = rs.getInt("hotel");
                    String hotelName = rs.getString("name");
                    Hotel hotel = new Hotel(hotelId, hotelName, address);


                    int hotelRoomId = rs.getInt("hotelRoom");
                    String numberHotelRoom = rs.getString("number");
                    int starsHotelRoom = rs.getInt("stars");
                    String typeOfFood = rs.getString("typeOfFood");
                    HotelRoom hotelRoom = new HotelRoom(hotelRoomId, numberHotelRoom, starsHotelRoom, hotel, typeOfFood);

                    hotelRooms.add(hotelRoom);


                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return hotelRooms;
    }

}
