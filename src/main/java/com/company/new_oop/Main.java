package com.company.new_oop;

import com.company.new_oop.domain.users.Adult;
import com.company.new_oop.domain.users.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    private void testDatabase() {
//        try {
//
//            Connection con = Database.getConnection();
//            try {
//                Statement stmt = con.createStatement();
//                ResultSet rs = stmt.executeQuery("SELECT * FROM \"Users\"");
//                while (rs.next()) {
//                    String str = rs.getString("firstName") + " " +
//                            rs.getString("lastName");
//                    System.out.println("Contact:" + str);
//                }
//                rs.close();
//                stmt.close();
//            } finally {
//                con.close();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws SQLException {

        User user = User.authorization("petrov.p", "123");
        System.out.println(user.getFirstName());
        ArrayList<Adult> adults = Adult.selectAllAdults();
        for (Adult adult:adults
             ) {
            System.out.println(adult.getFirstName() + " " + adult.getLastName());
        }
    }
}
