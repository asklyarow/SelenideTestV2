package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ContentTabPage {

    private static SelenideElement

            product = $x("//div[@class='_88Jz246BAesxb4dh8tD5ew==']");



    private static ElementsCollection productList = $$x("//div[@class='_88Jz246BAesxb4dh8tD5ew==']"); //можно посчитать количество артикулов в заказе

    public static void quantityProduct(Integer qty) {
        productList.shouldBe(size(qty));
    }

}
