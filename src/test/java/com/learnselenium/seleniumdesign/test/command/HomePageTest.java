package com.learnselenium.seleniumdesign.test.command;

import com.learnselenium.seleniumdesign.test.BaseTest;
import com.learnselenium.seleniumdesign.command.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePageTest(){
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }

}
