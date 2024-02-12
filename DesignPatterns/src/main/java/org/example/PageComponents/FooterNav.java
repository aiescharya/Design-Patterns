package org.example.PageComponents;
import jdk.javadoc.internal.doclets.formats.html.markup.Links;
import org.example.AbstractComponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {
    WebDriver driver;

    By flights=By.cssSelector("[title='Flights']");
    By links=By.cssSelector("a");
    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String getFlightAttribute()
    {
        return (findElement(flights).getAttribute("class");
    }

    public int getLinkCount()
    {
        return findElements(links).size();
    }
    public void selectFlight()
{
    System.out.println(findElement(flights).getAttribute("class"));
    //driver.findElement(flights).click();
}

}
