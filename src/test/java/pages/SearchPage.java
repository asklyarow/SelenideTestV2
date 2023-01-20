package pages;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    //Search Order
    private static SelenideElement
        typeSearchBtn = $("button.lmui-FilterScreenHeaderWide-QuickFilterDropdown__button"),
        typeSearchMenu = $x("//span[@data-testid='radio-label'][contains(.,'Имя покупателя')]"),
        //searchFld = $x("//input[@id='id_sk1Dn']"),
        searchFld = $x("//input[@data-testid='input-input']"),
        radioBtnNumberSearch = $x("//*[@data-testid='radio-label'][text()='Номер заказа']");
        //radioBtnNumberSearch = $x("//*[@data-testid='radio-label']");
    public static void SearchOrderNumber (String num) {

        searchFld.setValue(num).pressEnter();
        MainPage.selectOrder();
            }
    public static void SearchOrderName (String name) {
        typeSearchBtn.click();
        typeSearchMenu.click(); //TODO Разобраться, как работать с радиокнопками и чекбоксами.
        searchFld.setValue(name).pressEnter();

    }
}
