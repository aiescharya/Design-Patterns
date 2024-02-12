package org.example.PageComponents;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    private By rdo = By.id("ct100_maincontent_rbtnl_Trip_1");
    private By from=By.id("ct100_maincontent_ddl_originStation1_CTXT");
    private By to=By.id("ct100_maincontent_ddl_destinationStation1_CTXT");
    private By cb=By.id("ct100_maincontent_chk_IndArm");
    private By search=By.id("ct100_maincontent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("I am inside round trip");
        findElement(rdo).click();
        findElement(from).click();
        selectOriginCity((reservationDetails.get("origin")));
        selectDestinationCity((reservationDetails.get("destination")));
        findElement(cb).click();
        findElement(search).click();
    }
    public void  selectOriginCity(String origin)
    {
        findElement(from).click();
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }

    public void  selectDestinationCity(String destination)
    {
        findElement(to).click();
        findElement(By.xpath("//a[@value='"+destination+"'])[2]")).click();
    }
}
