package org.example.PageComponents;

import org.example.AbstractComponent.AbstractComponent;
import org.example.AbstractComponent.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By modalPopup= By.id("MulticityModelAlert");
    private By multiCity_rdo = By.id("ct100_maincontent_rbtnl_Trip_2");
    private By from=By.id("ct100_maincontent_ddl_originStation1_CTXT");
    private By to=By.id("ct100_maincontent_ddl_destinationStation1_CTXT");
    private By submit=By.id("ct100_maincontent_btn_FindFlights");
    private By destination_2=By.id("ct100_maincontent_ddl_originStation1_CTXT");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void getCalendar(String origin, String destination) {
        System.out.println("I am inside multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopup).click();
        selectOriginCity(origin);
        selectDestinationCity(destination);
        selectDestinationCity2("BLR");
        makeStateReady(s->selectCalendar(origin));
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

    public void  selectDestinationCity2(String destination)
    {
        findElement(destination_2).click();
        findElement(By.xpath("//a[@value='"+destination+"'])[2]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer)
    {
        System.out.println("I am inside multi trip");
        findElement(multiCity_rdo).click();
        findElement(modalPopup).click();
        getCalendar();
        consumer.accept(this);
        System.out.println("am done");
    }

    @Override
    public void checkAvail(final HashMap<String, String> reservationDetails) {
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));

    }
}
