package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class MainPage {

    @FindBy(xpath = "//div[@class='home-arrow__tabs']")
    WebElement mainMenu;

    public MainPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    public void selectMainMenu(String menuItem) {
        mainMenu.findElement(By.xpath(String.format(".//a[contains(text(), '%s')]", menuItem))).click();
    }
}
