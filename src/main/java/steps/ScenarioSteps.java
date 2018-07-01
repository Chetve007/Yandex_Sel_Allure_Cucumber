package steps;

import cucumber.api.java.en.When;

import java.util.List;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    SearchSteps searchSteps = new SearchSteps();

    @When("^нажали на 'Подтвердить регион'$")
    public void stepConfirmRegion() {
        marketSteps.stepConfirmRegion();
    }

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem) {
        mainSteps.stepSelectMainMenu(menuItem);
    }

    @When("^в Маркете выбран пункт меню \"(.*)\"$")
    public void stepSelectMarketMenu(String mainItem) {
        marketSteps.stepSelectMainItem(mainItem);
    }

    @When("^и выбрана категория \"(.*)\"$")
    public void stepSelectMarketSubItem(String subItem) {
        marketSteps.stepSelectSubItem(subItem);
    }

    @When("^нажали на кнопку 'Перейти ко всем фильтрам'$")
    public void stepPushFilter() {
        marketSteps.stepPushButtonFilter();
    }

    @When("^поле \"(.*)\" заполняется значением \"(.*)\"$")
    public void stepChoosePrice(String field, String value) {
        searchSteps.stepFillField(field, value);
    }

    @When("^выбраны производители \"(.*)\"$")
    public void stepChooseProd(List<String> producers) {
        searchSteps.stepChooseProducers(producers);
    }

    @When("^нажали на кнопку 'Показать подходящие'$")
    public void stepPushButShow() {
        searchSteps.stepPushButtonShow();
    }

    @When("^количество предтавленных товаров равно \"(.*)\"$")
    public void stepCheckAmount(int size) {
        marketSteps.stepCheckAmount(size);
    }

    @When("^ввели первый элемент из списка в поисковую строку$")
    public void stepEnterFirstValueFromList() {
        marketSteps.stepEnterFirstValueFromList();
    }

    @When("^нажали на кнопку 'Найти'$")
    public void stepPushToFind() {
        marketSteps.stepPushToFind();
    }

    @When("^выведенный товар совпадает с первым товаром полученным из списка найденных$")
    public void stepCheckItem() {
        marketSteps.stepCheckItem();
    }
}
