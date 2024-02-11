package org.example.PageObjects;

import org.example.AbstractComponent.SearchFlightAvail;
import org.example.AbstractComponent.StrategyFactor;
import org.example.PageComponents.FooterNav;
import org.example.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement=By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;

    public TravelHomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void goTo()
    {
    driver.get("https://rahulshettyacademy.com/dropdownsPractice/");

    }

public NavigationBar getNavigationBar()
    {

        return new NavigationBar(driver,footerNavSectionElement);

    }

    public FooterNav getFooterNav()
    {
        return new FooterNav(driver,sectionElement);
    }

    public void setBookingStrategy(String strategyType)
    {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail= StrategyFactor.CreateStrategy(strategyType);
        this.searchFlightAvail=searchFlightAvail;
    }

    public void checkAvail(HashMap<String,String> reservationDetails)
    {

        searchFlightAvail.checkAvail(reservationDetails);
    }
    public void getLinksCount(String algo)
    {
        if (algo.equalsIgnoreCase("footer"))
        {
            new FooterNav().getLinkCount();
        }
    }

    public String getTitle()

    {
        System.out.println("Hello");
        return driver.getTitle();
    }

}
