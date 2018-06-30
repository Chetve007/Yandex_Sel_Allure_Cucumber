package steps;

import pages.SearchPage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value) {
        searchPage.fillField(field, value);
    }

    @Step("выбраны производители")
    public void stepChooseProducers(List<String> producers) {
        searchPage.chooseProducers(producers);
    }

    @Step("нажали на кнопку 'Показать подходящие'")
    public void stepPushButtonShow() {
        searchPage.pushButtonShow();
    }
}
