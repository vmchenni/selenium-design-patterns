package com.learnselenium.seleniumdesign.test.strategy;

import com.learnselenium.seleniumdesign.emirates.*;
import com.learnselenium.seleniumdesign.test.BaseTest;
import com.learnselenium.seleniumdesign.emirates.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class EmiratesTest extends BaseTest {

    private EmiratesPage emiratesPage;

    @BeforeTest
    public void setPaymentScreen(){
        this.emiratesPage = new EmiratesPage(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(FlightSearch flightSearch, Map<String, String> searchDetails){
        this.emiratesPage.goTo();
        this.emiratesPage.setFlightSearch(flightSearch);
        this.emiratesPage.searchForFlights(searchDetails);
    }

    @DataProvider
    public Object[][] getData(){
        Map<String, String> map = new HashMap<>();
        map.put("departureCity", "Austin (AUS)");
        map.put("arrivalCity", "Houston (IAH)");
        map.put("arrivalCity2", "Las Vegas (LAS)");

        return new Object[][] {
            {new OneWay(), map},
            {new TwoWay(), map},
            {new MultiWay(), map},
        };
    }



}
