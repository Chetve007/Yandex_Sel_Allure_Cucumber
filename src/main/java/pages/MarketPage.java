package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

public class MarketPage {

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Перейти ко всем фильтрам')]")
    WebElement filter;

    public void selectMarketMenu(String mainItem) {
        WebElement mainEl = BaseSteps.getDriver().findElement(By.xpath(String.format("//a[@class='link topmenu__link' and contains(text(), '%s')]", mainItem)));
        Actions actions = new Actions(BaseSteps.getDriver());
        actions.moveToElement(mainEl).build().perform();
    }

    public void selectSubMarketMenu(String subItem) {
        WebElement subEl = BaseSteps.getDriver().findElement(By.xpath(String.format("//ul[@class='topmenu__list']//a[text()='%s']", subItem)));
        new WebDriverWait(BaseSteps.getDriver(), 3, 1000).until(ExpectedConditions.visibilityOf(subEl)).click();
    }

    public void pushButtonFilter() {
        filter.click();
    }
}
