package com.company.new_oop;

import com.company.new_oop.domain.pricelist.Price;
import com.company.new_oop.domain.users.Adult;
import com.company.new_oop.domain.users.User;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args) throws SQLException {

        ArrayList<Price> prices = Price.selectPriceList();
        for (Price price:prices
             ) {
            System.out.println(price.getPriceId() + " " + price.getPriceTour().getTourName() + " " + price.getPriceTourPrice() + " p.");
        }
    }
}
