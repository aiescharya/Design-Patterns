package org.example.AbstractComponent;

import org.example.PageComponents.MultiTrip;
import org.example.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StrategyFactor {
    WebDriver driver;
    By sectionElement=By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver=driver;
    }

    public static SearchFlightAvail CreateStrategy(String strategyType) {

        if(strategyType.equalsIgnoreCase("multitrip"))
        {
            return new MultiTrip(driver,sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver,sectionElement);
        }
    }

    public  searchFlightAvail createStrategy(String strategyType)
    {
        if(strategyType.equalsIgnoreCase("multitrip"))
        {
            return new MultiTrip(driver,sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundtrip"))
        {
            return new RoundTrip(driver,sectionElement);
        }
        return null;
    }
}
