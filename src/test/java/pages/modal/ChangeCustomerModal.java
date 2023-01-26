package pages.modal;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.HeaderPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ChangeCustomerModal {

    public static String invalidCustomerId = "345ffdv";
    public static String validCustomerId = "145955445";

    private static SelenideElement
        modalWindow = $x("//div[@data-testid='modal-window']"),
        closeModal = $x("//button[@aria-label='Close modal']"),
        input = $x("//div[@data-testid='modal-window']//input[@data-testid='input-input']"),
        cancelBtn = $x("//button[@data-testid='aao-change-customer-number-modal-close-btn']"),
        saveBtn = $x("//button[@data-testid='aao-change-customer-number-modal-submit-btn']");

    public static void setInput (String value) {
        input.setValue(value);

    }

    public static void clearFld () {
        input.click();
        input.sendKeys(Keys.CONTROL + "a");
        input.sendKeys(Keys.DELETE);
    }

    public static void clickCancelBtn() {
        cancelBtn.click();
    }

    public static void clickSaveBtn() {
        saveBtn.click();
    }
    public static void chekSaveChangeCustomer(){ //TODO в зависимости от номера проставлять текст
        modalWindow.shouldNot(visible);
        HeaderPage.clientWidget.shouldBe(text("тестИ тестА"));
        //TODO добавить проверку истории заказа
    }

    public static void checkOpenModalWindow(){
        ChangeCustomerModal.modalWindow.shouldBe(visible)
                .shouldBe(text("Укажите клиента"))
                .shouldBe(text("Укажите значение номера клиента"));
        ChangeCustomerModal.input.shouldBe(visible);
        ChangeCustomerModal.cancelBtn.shouldBe(enabled);
        ChangeCustomerModal.saveBtn.shouldBe(disabled);
    }

    public static void checkValidInput (boolean validCustomerId) {
        if (validCustomerId) {
            saveBtn.shouldBe(enabled);
        } else {
            saveBtn.shouldBe(disabled);
            modalWindow.shouldBe(text("Номер клиента должен содержать только цифры")); //TODO сделать возможность выбора дев и препрод
        }
    }

    public static void noWindow() {
        modalWindow.shouldNot(visible);
    }
}
