package steps;

import pages.MarketPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MarketSteps {

    MarketPage marketPage = new MarketPage();

    @Step("в Маркете выбран пункт меню {0}")
    public void stepSelectMainItem(String mainItem) {
        marketPage.selectMarketMenu(mainItem);
    }

    @Step("и выбрана категория {0}")
    public void stepSelectSubItem(String subItem) {
        marketPage.selectSubMarketMenu(subItem);
    }

    @Step("нажали на кнопку 'Перейти ко всем фильтрам'")
    public void stepPushButtonFilter() {
        marketPage.pushButtonFilter();
    }
}
