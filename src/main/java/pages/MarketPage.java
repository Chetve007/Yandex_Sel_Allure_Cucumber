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
import static org.junit.Assert.assertTrue;

public class MarketPage {

    String firstElement;

    public MarketPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(@class, 'button2 button2_size_m button2_theme_action')]")
    WebElement yourRegion;

    @FindBy(xpath = "//a[contains(text(), 'Перейти ко всем фильтрам')]")
    WebElement filter;

    @FindBy(xpath = "//div[@class and @data-id]//div[contains(@class, 'title')]")
    List<WebElement> amount;

    @FindBy(name = "text")
    WebElement searchLine;

    @FindBy(xpath = "//span//button[@role='button']")
    WebElement toFind;

    @FindBy(xpath = "//h1[@class='title title_size_28 title_bold_yes']")
    WebElement item;

    public void confirmRegion() {
        new WebDriverWait(BaseSteps.getDriver(), 5, 500).until(ExpectedConditions.visibilityOf(yourRegion));
        yourRegion.click();
    }

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
        System.err.println("\nAmount = " + getAmount());
        assertEquals(String.format("Указано неверное количество. Должно быть [%s] (считать разучился что ли!!!).", getAmount()), actualSize, getAmount());
    }

    public String getFirstElementFromAmount() {
        firstElement = amount.get(0).getText().replaceFirst("[А-Яа-я]+", "").trim();
        System.err.println("\nFirst element in list is - " + firstElement);
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
        assertTrue("Значение не равно ожидаемому", getItem().contains(firstElement));
    }
}