package test;


import io.qameta.allure.AllureId;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import pages.HeaderPage;
import pages.modal.ChangeCustomerModal;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class HeaderTest extends Login {

    @BeforeMethod
    private void OpenOrder() {
        String currentOrderId = "221204700520";
        open(currentOrderId);

        HeaderPage.chekOrderNumber(currentOrderId); //верный ли заказ открыт?
    }

    @Test
    @AllureId("91731")
    private void ChangeCustomerTest(){

        step("Кликнуть на иконку смены клиента", () -> {
                    HeaderPage.customerNumberIcon.click();
                    ChangeCustomerModal.modalWindow.shouldBe(visible)
                            .shouldBe(text("Укажите клиента"))
                            .shouldBe(text("Укажите значение номера клиента"));
                    ChangeCustomerModal.input.shouldBe(visible);
                    ChangeCustomerModal.cancelBtn.shouldBe(enabled);
                    ChangeCustomerModal.saveBtn.shouldBe(disabled);
                });
        step("Ввести буквы и спецсимволы", () -> {
            ChangeCustomerModal.input.setValue("345ffdv");
            ChangeCustomerModal.saveBtn.shouldBe(disabled);
            ChangeCustomerModal.modalWindow.shouldBe(text("Номер клиента должен содержать только цифры"));
                });
        step("Очистить поле", () -> {
                    ChangeCustomerModal.input.click();
                    ChangeCustomerModal.input.sendKeys(Keys.CONTROL + "a");
                    ChangeCustomerModal.input.sendKeys(Keys.DELETE);
                });
        step("Ввести существующий CustomerNumber, отличный от настоящего в заказе", () -> {
            //ChangeCustomerModal.input.clear();
            ChangeCustomerModal.saveBtn.shouldBe(disabled);
            ChangeCustomerModal.modalWindow.shouldBe(text("Укажите значение номера клиента"));

            ChangeCustomerModal.input.setValue("145955445");
            ChangeCustomerModal.saveBtn.shouldBe(enabled);
                });
        step("Кликнуть на Отмена", () -> {
                    ChangeCustomerModal.cancelBtn.click();
                    ChangeCustomerModal.modalWindow.shouldNot(visible);
                });
        step("Ввести существующий CustomerNumber и сохранить", () -> {
                    HeaderPage.customerNumberIcon.click();
                    ChangeCustomerModal.modalWindow.shouldBe(visible)
                            .shouldBe(text("Укажите клиента"))
                            .shouldBe(text("Укажите значение номера клиента"));

                    ChangeCustomerModal.input.setValue("145955445"); //TODO сделать возможность выбора дев и препрод
                    ChangeCustomerModal.saveBtn.shouldBe(enabled);

                    ChangeCustomerModal.saveBtn.click();
                    ChangeCustomerModal.modalWindow.shouldNot(visible);
                    HeaderPage.clientWidget.shouldBe(text("тестИ тестА"));
                });


            //TODO добавить проверки истории заказа
    }
}
