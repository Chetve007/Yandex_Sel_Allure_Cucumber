package steps;

import pages.MainPage;
import ru.yandex.qatools.allure.annotations.Step;

public class MainSteps {

    MainPage mainPage = new MainPage();

    @Step("выбран пункт меню {0}")
    public void stepSelectMainMenu(String menuItem) {
        mainPage.selectMainMenu(menuItem);
    }
}
