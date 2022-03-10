package com.company.new_oop.domain.users;

import com.company.new_oop.Database;
import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.documents.Document;
import com.company.new_oop.domain.documents.Passport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class Adult extends Client{


    private Passport clientPassport;
    public Adult(int userID, String firstName, String lastName, String patronymic,
                 LocalDate birthday, String login, String password,
                 String clientTelephone, String clientMail, Passport clientPassport) {
        super(userID, firstName, lastName, patronymic, birthday,
                login, password, clientTelephone, clientMail);
        this.clientPassport = clientPassport;
    }
    public Document checkUserDocument(){
        System.out.println("У данного клиента паспорт");
        return this.clientPassport;
    }



    public Passport getClientPassport() {
        return clientPassport;
    }

    public void setClientPassport(Passport clientPassport) {
        this.clientPassport = clientPassport;
    }

    //SQL


    public static ArrayList<Adult> selectAllAdults(){
        ArrayList<Adult> adults = new ArrayList<>();
        try {
            Connection con = Database.getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("" +
                        "SELECT * " +
                        "FROM \"Users\" " +
                        "JOIN \"Documents\" ON \"Users\".document=\"Documents\".id " +
                        "JOIN \"Addresses\" ON \"Documents\".\"addressRegistration\"=\"Addresses\".id " +
                        "JOIN \"Localities\" ON \"Addresses\".locality=\"Localities\".id " +
                        "WHERE \"Users\".\"typeOfUser\"=3");


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
                    Address addressRegistration = new Address(addressId,street,house,extension,apartment,locality);

                    int documentId = rs.getInt("document");
                    String dateOfIssue = rs.getString("dateOfIssue");
                    LocalDate localDateOfIssue = MyDate.covertStringToLocalDate(dateOfIssue,"yyyy-MM-dd");
                    String issuedBy = rs.getString("issuedBy");
                    String documentType = rs.getString("documentType");
                    String serial = rs.getString("serial");
                    String number = rs.getString("number");
                    Passport passport = new Passport(documentId,localDateOfIssue,issuedBy,serial,number,addressRegistration);


                    int clientId = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String patronymic = rs.getString("patronymic");
                    String birthday = rs.getString("birthday");
                    LocalDate localBirthday = MyDate.covertStringToLocalDate(birthday,"yyyy-MM-dd");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    String telephone = rs.getString("telephone");
                    String mail = rs.getString("mail");

                    Adult adult = new Adult(clientId,firstName,lastName, patronymic,
                                    localBirthday, login, password, telephone, mail, passport);
                    int typeOfUser = 3;

                    adults.add(adult);


                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adults;
    }


    public static Adult getAdult(int id){
        Adult adult = null;
        try {
            Connection con = Database.getConnection();
            try {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("" +
                        "SELECT * " +
                        "FROM \"Users\" " +
                        "JOIN \"Documents\" ON \"Users\".document=\"Documents\".id " +
                        "JOIN \"Addresses\" ON \"Documents\".\"addressRegistration\"=\"Addresses\".id " +
                        "JOIN \"Localities\" ON \"Addresses\".locality=\"Localities\".id " +
                        "WHERE \"Users\".id = "+id+"");


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
                    Address addressRegistration = new Address(addressId,street,house,extension,apartment,locality);

                    int documentId = rs.getInt("document");
                    String dateOfIssue = rs.getString("dateOfIssue");
                    LocalDate localDateOfIssue = MyDate.covertStringToLocalDate(dateOfIssue,"yyyy-MM-dd");
                    String issuedBy = rs.getString("issuedBy");
                    String documentType = rs.getString("documentType");
                    String serial = rs.getString("serial");
                    String number = rs.getString("number");
                    Passport passport = new Passport(documentId,localDateOfIssue,issuedBy,serial,number,addressRegistration);


                    int clientId = rs.getInt("id");
                    String firstName = rs.getString("firstName");
                    String lastName = rs.getString("lastName");
                    String patronymic = rs.getString("patronymic");
                    String birthday = rs.getString("birthday");
                    LocalDate localBirthday = MyDate.covertStringToLocalDate(birthday,"yyyy-MM-dd");
                    String login = rs.getString("login");
                    String password = rs.getString("password");
                    String telephone = rs.getString("telephone");
                    String mail = rs.getString("mail");

                    adult = new Adult(clientId,firstName,lastName, patronymic,
                            localBirthday, login, password, telephone, mail, passport);
                    int typeOfUser = 3;



                }
                rs.close();
                stmt.close();
            } finally {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adult;
    }

    public static void insertAdult(
            LocalDate dateOfIssue, String issuedBy, String serial,
            String number, String country, String region, String inhabited, String street,
            String house, String extension, String apartment, String firstName,
            String lastName, String patronymic,
            LocalDate birthday, String login, String password,
            String clientTelephone, String clientMail) throws SQLException {

        Locality.insertLocality(country,region,inhabited);
        int localityId = Locality.getLocalityId(country,region,inhabited);

        Address.insertAddress(street,house,extension,apartment, localityId);
        int addressId = Address.getAddressId(street,house,extension,apartment, localityId);

        Passport.insertPassport(dateOfIssue,issuedBy,serial,number,addressId);

        int passportId = Passport.getPassportId(dateOfIssue,issuedBy,serial,number,addressId);
        String stringBirthday = MyDate.covertLocalDateToString(birthday);


        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            String rs = "INSERT INTO \"Users\" (" +
                    "\"firstName\", \"lastName\", patronymic, " +
                    "birthday, login, password, \"typeOfUser\", " +
                    "telephone, mail, document) " +
                    "VALUES ('"+firstName+"', '"+lastName+"', '"+patronymic+"'" +
                    ", '"+birthday+"', '"+login+"', '"+password+"'" +
                    ", 3, '"+clientTelephone+"'" +
                    ", '"+clientMail+"', "+passportId+")";

            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public static void updateAdult(Adult client,
            LocalDate dateOfIssue, String issuedBy, String serial,
            String number, String country, String region, String inhabited, String street,
            String house, String extension, String apartment, int clientId, String firstName,
            String lastName, String patronymic,
            LocalDate birthday, String login, String password,
            String clientTelephone, String clientMail) throws SQLException {


        int localityId = client.getClientPassport().getAddressRegistration().getAddressLocality().getLocalityId();
        Locality.updateLocality(localityId, country, region, inhabited);


        int addressId = client.getClientPassport().getAddressRegistration().getAddressId();
        Address.updateAddress(addressId,street,house,extension,apartment, localityId);


        int passportId = client.getClientPassport().getDocumentId();
        Passport.updatePassport(passportId, dateOfIssue,issuedBy,serial,number,addressId);

        String stringBirthday = MyDate.covertLocalDateToString(birthday);


        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();


            String rs = "UPDATE \"Users\" " +
                    "SET \"firstName\"='"+firstName+"', \"lastName\"='"+lastName+"', patronymic='"+patronymic+"', " +
                    "birthday='"+stringBirthday+"', " +
                    "telephone='"+clientTelephone+"', mail='"+clientMail+"', document='"+passportId+"' " +
                    "WHERE \"Users\".id='"+clientId+"';";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }


    public static void markForDeletionAdult(Adult client) throws SQLException {

        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();


            String rs = "UPDATE \"Users\" " +
                    "SET \"typeOfUser\" = 4 " +
                    "WHERE \"Users\".id = "+client.getUserID()+"";
            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }

    //SQL
}
