package com.company.new_oop.domain.documents;

import com.company.new_oop.Database;
import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Passport extends Document{
    private String passportSerial;
    private String passportNumber;
    private Address addressRegistration;

    public Passport(int documentId, LocalDate dateOfIssue, String issuedBy, String passportSerial, String passportNumber, Address addressRegistration) {
        super(documentId, dateOfIssue, issuedBy);
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
        this.addressRegistration = addressRegistration;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Address getAddressRegistration() {
        return addressRegistration;
    }

    public void setAddressRegistration(Address addressRegistration) {
        this.addressRegistration = addressRegistration;
    }

    //SQL

    public static void insertPassport(LocalDate dateOfIssue, String issuedBy, String serial,
                                      String number, int addressRegistration) throws SQLException {

        String formattedString = MyDate.covertLocalDateToString(dateOfIssue);
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();
            String rs = "INSERT INTO \"Documents\" (\"dateOfIssue\", \"issuedBy\", \"documentType\"," +
                    " serial, \"number\", \"addressRegistration\") " +
                    "VALUES ('"+formattedString+"', '"+issuedBy+"', "+1+", '"+serial+"', '"+number+"', "+addressRegistration+")";

            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static int getPassportId(LocalDate dateOfIssue, String issuedBy, String serial,
                                     String number, int addressRegistration){
            int passportId=-1;
            String stringDateOfIssue = MyDate.covertLocalDateToString(dateOfIssue);
            try {
                Connection con = Database.getConnection();
                try {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * " +
                            "FROM \"Documents\" " +
                            "WHERE \"dateOfIssue\"='"+dateOfIssue+"' " +
                            "AND \"issuedBy\"='"+issuedBy+"' " +
                            "AND \"documentType\" = 1 " +
                            "AND \"serial\"='"+serial+"' " +
                            "AND \"number\"='"+number+"' " +
                            "AND \"addressRegistration\"='"+addressRegistration+"'");

                    while (rs.next()) {

                        passportId = rs.getInt("id");

                    }
                    rs.close();
                    stmt.close();
                } finally {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return passportId;
    }

    public static void updatePassport(int passportId, LocalDate dateOfIssue, String issuedBy, String serial,
                                      String number, int addressRegistration) throws SQLException {

        String formattedString = MyDate.covertLocalDateToString(dateOfIssue);
        try {
            Connection con = Database.getConnection();
            Statement stmt = con.createStatement();

            String rs = "" +
                    "UPDATE \"Documents\" " +
                    "SET \"dateOfIssue\"='"+MyDate.covertLocalDateToString(dateOfIssue)+"', " +
                    "\"issuedBy\"='"+issuedBy+"', serial='"+serial+"', \"number\"='"+number+"', " +
                    "\"addressRegistration\"='"+addressRegistration+"'" +
                    "WHERE id="+passportId+";";

            stmt.executeUpdate(rs);
            stmt.close();
            con.close();
        }
        catch (SQLException throwable) {
            throwable.printStackTrace();
        }

    }


//    SQL
}
