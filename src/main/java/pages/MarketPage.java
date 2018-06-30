package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MarketPage {

    String firstElement;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(), 'Перейти ко всем фильтрам')]")
    WebElement filter;

    @FindBy(xpath = "//div[@class='n-snippet-card2__title']")
    List<WebElement> amount;

    @FindBy(name = "text")
    WebElement searchLine;

    @FindBy(xpath = "//span//button[@role='button']")
    WebElement toFind;

    @FindBy(xpath = "//h1[@class='title title_size_28 title_bold_yes']")
    WebElement item;

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

    public int getAmount() {
        return amount.size();
    }

    public void checkAmount(int actualSize) {
        assertEquals("Указано неверное количество", actualSize, getAmount());
    }

    public String getFirstElementFromAmount() {
        firstElement = amount.get(0).getText();
        System.err.println("First element in list is - " + firstElement);
        return firstElement;
    }

    public void enterValueInSearchLine() {
        fillField(searchLine, getFirstElementFromAmount());
    }

    public void fillField(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }

    public void pushToFind() {
        toFind.click();
    }

    public String getItem() {
        return item.getText();
    }

    public void checkItem() {
        new WebDriverWait(BaseSteps.getDriver(), 5, 500).until(ExpectedConditions.visibilityOf(item));
        assertEquals("Значение не равно ожидаемому", firstElement, getItem());
    }
}
