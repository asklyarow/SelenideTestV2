package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    public static SelenideElement
            whatsNew = $x("//button[contains(.,'Дождались, спасибо!')]"),
            leftAreaBtn = $x("//button[@data-testid='lmui-ScreenHeader-LeftAreaBtn-button']");

    public static void watsNewPopupClose() {
       // if (MainPage.whatsNew.waitWhile(30000))
        whatsNew.shouldBe(visible, Duration.ofSeconds(15)).click();

    }

    public static void openLeftMenu () {
        leftAreaBtn.shouldBe(visible, Duration.ofSeconds(15)).click();
    }

    public static SelenideElement userName (String username) {             //открытие попапа с именем пользователя
        return $x("//p[contains(.,'"+username+"')]");
    }

    private static SelenideElement selectCurrentShop(String shop) {              //Выбор текущего магазина из попапа с именем пользователя
        return $x("//p[starts-with(.,'"+shop+"')]");
    }

    private static SelenideElement selectNewShop(String shop) {              //Выбор нового магазина из попапа с именем пользователя
        return  $x("//span[starts-with(.,'"+shop+"')]");
    }

    public static void selectShop (String username, String currentshop, String newshop) {  //Выбор магазина со страницы Main
        userName(username).click();
        selectCurrentShop(currentshop).click();
        selectNewShop(newshop).click();
        $(".loading_progress").should(disappear);
    }


    private static ElementsCollection
            orderList = $$x("//span[(@role='button')]"),
            nameList = $$("span.lmui-Text-ml-gap1");

    public static void checkOrderList() {
        orderList.shouldBe(size(10),Duration.ofSeconds(10));
    }

    private static SelenideElement orderSelect = $x("//span[(@role='button')]");

    public static void selectOrder () {
        orderSelect.click();
    }

    public static void checkSearchList() {
        nameList.shouldBe(size(10),Duration.ofSeconds(10));
    }



}