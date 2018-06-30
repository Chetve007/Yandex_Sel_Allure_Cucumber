package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.BaseSteps;

import java.util.List;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(BaseSteps.getDriver(), this);
    }

    @FindBy(name = "glf-pricefrom-var")
    WebElement priceFrom;

    @FindBy(name = "glf-priceto-var")
    WebElement priceTo;

    @FindBy(xpath = "//a[@role='button'][2]")
    WebElement buttonShow;

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Цена от":
                fillField(priceFrom, value);
                break;
            case "Цена до":
                fillField(priceTo, value);
                break;
            default: throw new AssertionError("Поле '" + fieldName + "' на странице отсутствует");
        }
    }

    public void fillField(WebElement el, String value) {
        el.clear();
        el.sendKeys(value);
    }

    public void chooseProducers(List<String> producers) {
        producers.forEach((value) -> BaseSteps.getDriver().findElement(By.xpath(String.format("//label[contains(text(), '%s')]", value))).click());
    }

    public void pushButtonShow() {
        buttonShow.click();
    }
}
