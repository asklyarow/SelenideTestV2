package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;


public class HeaderPage {

    private static SelenideElement numberOrder () {
        return Selenide.$x("//input[contains(@class, 'CopyToClipboardButton__input')]");
    }

    public static void chekOrderNumber(String order) {
        numberOrder().shouldHave(value(order),Duration.ofSeconds(10));
    }
}
