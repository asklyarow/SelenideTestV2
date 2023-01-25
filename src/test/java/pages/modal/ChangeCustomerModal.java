package pages.modal;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.HeaderPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ChangeCustomerModal {

    public static String invalidCustomerId = "345ffdv";
    public static String validCustomerId = "145955445";

    public static SelenideElement
        modalWindow = $x("//div[@data-testid='modal-window']"),
        closeModal = $x("//button[@aria-label='Close modal']"),
        input = $x("//div[@data-testid='modal-window']//input[@data-testid='input-input']"),
        cancelBtn = $x("//button[@data-testid='aao-change-customer-number-modal-close-btn']"),
        saveBtn = $x("//button[@data-testid='aao-change-customer-number-modal-submit-btn']");

    public static void setInput (String value) {
        input.setValue(value);
        if (value==invalidCustomerId) {
            saveBtn.shouldBe(disabled);
            modalWindow.shouldBe(text("Номер клиента должен содержать только цифры")); //TODO сделать возможность выбора дев и препрод
        } else {
            saveBtn.shouldBe(enabled);
        }
    }

    public static void clearFld () {
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
    }

    public static void clickCancelBtn() {
        cancelBtn.click();
        modalWindow.shouldNot(visible);
    }

    public static void clickSaveBtn() {
        saveBtn.click();
    }
    public static void chekSaveChangeCustomer(){ //TODO в зависимости от номера проставлять текст
        modalWindow.shouldNot(visible);
        HeaderPage.clientWidget.shouldBe(text("тестИ тестА"));
        //TODO добавить проверку истории заказа
    }

}
