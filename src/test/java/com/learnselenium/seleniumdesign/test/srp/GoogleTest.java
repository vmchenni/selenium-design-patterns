package com.learnselenium.seleniumdesign.test.srp;

import com.learnselenium.seleniumdesign.srp.main.GoogleMainPage;
import com.learnselenium.seleniumdesign.srp.result.GoogleResultPage;
import com.learnselenium.seleniumdesign.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;

    @BeforeTest
    public void setupPages(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index){

        //String keyword = "selenium webdriver";
        //int index  = 3;

        googleMainPage.goTo();
        Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchSuggestion().isDisplayed());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);

        googleResultPage.getNavigationBar().goToNews();

        googleResultPage.getNavigationBar().clickOnTools();

        System.out.println(
                googleResultPage.getResultStat().getStat()
        );

    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"selenium", 3},
                {"docker", 2}
        };


    }


}
