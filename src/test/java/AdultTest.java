package test;

import com.company.new_oop.domain.MyDate;
import com.company.new_oop.domain.address.Address;
import com.company.new_oop.domain.address.Locality;
import com.company.new_oop.domain.documents.Passport;
import com.company.new_oop.domain.users.Adult;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AdultTest {
    Adult adult = Adult.getAdult(4);

    ArrayList<Adult> adults = Adult.selectAllAdults();


    @Test
    public void checkUserDocument() {
        Assert.assertEquals(adult.getClientPassport(),adult.checkUserDocument());
    }

    @Test
    public void selectAllAdults() {
        Assert.assertEquals(adults.size(), Adult.selectAllAdults().size());
    }

    @Test
    public void getAdult() {
        Assert.assertEquals(Adult.getAdult(4).getUserID(),adult.getUserID());
    }

    @Test
    public void updateAdult() throws SQLException {
        String oldMail = adult.getClientMail();
        Adult.updateAdult(
                adult,
                adult.getClientPassport().getDateOfIssue(),
                adult.getClientPassport().getIssuedBy(),
                adult.getClientPassport().getPassportSerial(),
                adult.getClientPassport().getPassportNumber(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getCountry(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getRegion(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getInhabitedLocality(),
                adult.getClientPassport().getAddressRegistration().getAddressStreet(),
                adult.getClientPassport().getAddressRegistration().getAddressHouse(),
                adult.getClientPassport().getAddressRegistration().getAddressExtension(),
                adult.getClientPassport().getAddressRegistration().getAddressApartment(),
                adult.getUserID(),
                adult.getFirstName(),
                adult.getLastName(),
                adult.getPatronymic(),
                adult.getBirthday(),
                adult.getLogin(),
                adult.getPassword(),
                adult.getClientTelephone(),
                "test"
        );
        String newMail = Adult.getAdult(adult.getUserID()).getClientMail();
        Adult.updateAdult(
                adult,
                adult.getClientPassport().getDateOfIssue(),
                adult.getClientPassport().getIssuedBy(),
                adult.getClientPassport().getPassportSerial(),
                adult.getClientPassport().getPassportNumber(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getCountry(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getRegion(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getInhabitedLocality(),
                adult.getClientPassport().getAddressRegistration().getAddressStreet(),
                adult.getClientPassport().getAddressRegistration().getAddressHouse(),
                adult.getClientPassport().getAddressRegistration().getAddressExtension(),
                adult.getClientPassport().getAddressRegistration().getAddressApartment(),
                adult.getUserID(),
                adult.getFirstName(),
                adult.getLastName(),
                adult.getPatronymic(),
                adult.getBirthday(),
                adult.getLogin(),
                adult.getPassword(),
                adult.getClientTelephone(),
                oldMail
        );
        Assert.assertEquals(newMail,"test");
    }

    @Test
    public void markForDeletionAdult() throws SQLException {
        Adult.markForDeletionAdult(adult);
        Adult adultForDeletion = Adult.getAdult(4);
        int typeOfUser = Adult.getAdult(4).getTypeOfUser();
        Adult.updateAdult(
                adult,
                adult.getClientPassport().getDateOfIssue(),
                adult.getClientPassport().getIssuedBy(),
                adult.getClientPassport().getPassportSerial(),
                adult.getClientPassport().getPassportNumber(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getCountry(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getRegion(),
                adult.getClientPassport().getAddressRegistration().getAddressLocality().getInhabitedLocality(),
                adult.getClientPassport().getAddressRegistration().getAddressStreet(),
                adult.getClientPassport().getAddressRegistration().getAddressHouse(),
                adult.getClientPassport().getAddressRegistration().getAddressExtension(),
                adult.getClientPassport().getAddressRegistration().getAddressApartment(),
                adult.getUserID(),
                adult.getFirstName(),
                adult.getLastName(),
                adult.getPatronymic(),
                adult.getBirthday(),
                adult.getLogin(),
                adult.getPassword(),
                adult.getClientTelephone(),
                adult.getClientMail()
        );
        Assert.assertEquals(4,adultForDeletion.getTypeOfUser());
    }
}