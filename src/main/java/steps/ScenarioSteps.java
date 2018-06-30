package steps;

import cucumber.api.java.en.When;

import java.util.List;

public class ScenarioSteps {

    MainSteps mainSteps = new MainSteps();
    MarketSteps marketSteps = new MarketSteps();
    SearchSteps searchSteps = new SearchSteps();

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


}
