package org.example;

import org.example.AbstractComponent.SearchFlightAvail;
import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.example.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class DemoTest extends BaseTest{
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
            public void setup()
    {
        driver=initializeDriver();
        TravelHomePage travelHomePage=new TravelHomePage(driver);
    }

    By sectionElement=By.id("flightSearchContainer");
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String,String> reservationDetails)
    {

        driver=initializeDriver();
       System.setProperty("webdriver.chrome.driver","//C://Users//aiescharya.gunasekar//Downloads//chromedriver");
       WebDriver driver=new ChromeDriver();
       WebDriver driver1=new FirefoxDriver();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());
        travelHomePage.getTitle();

        HashMap<String,String> reservationDetails = new <String,String>HashMap();
        reservationDetails.put("origin","MAA");
        reservationDetails.put("destination","HYD");
        reservationDetails.put("destination2","DEL");
        travelHomePage.checkAvail("MAA","HYD");
        travelHomePage.getLinksCount("footer");
        //travelHomePage.setBookingStrategy(new MultiTrip(driver,sectionElement));
        travelHomePage.setBookingStrategy("multitrip");
        travelHomePage.checkAvail(reservationDetails);


    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException
    {

        List<HashMap<String,String>> l=getJsonData(System.getProperty("user.dir")+"//src//test//java//org//example//DataLoads//reservationDetails.json")
        return new Object[][]
                {
                        {l.get(0)}, {l.get(1)
                },
    };


    }
