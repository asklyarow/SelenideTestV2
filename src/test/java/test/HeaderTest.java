package test;


import org.openqa.selenium.Keys;
import org.testng.annotations.*;
import pages.HeaderPage;
import pages.modal.ChangeCustomerModal;

import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class HeaderTest extends Login {

    @BeforeMethod
    private void OpenOrder() {
        String currentOrderId = "221204700520";
        open(currentOrderId);

        HeaderPage.chekOrderNumber(currentOrderId); //верный ли заказ открыт?
    }

    @Test
    private void ChangeCustomerTest(){
        HeaderPage.customerNumberIcon.click();
            ChangeCustomerModal.modalWindow.shouldBe(visible)
                    .shouldBe(text("Укажите клиента"))
                    .shouldBe(text("Укажите значение номера клиента"));
            ChangeCustomerModal.input.shouldBe(visible);
            ChangeCustomerModal.cancelBtn.shouldBe(enabled);
            ChangeCustomerModal.saveBtn.shouldBe(disabled);

        ChangeCustomerModal.input.setValue("345ffdv");
            ChangeCustomerModal.saveBtn.shouldBe(disabled);
            ChangeCustomerModal.modalWindow.shouldBe(text("Номер клиента должен содержать только цифры"));

        ChangeCustomerModal.input.click();
        ChangeCustomerModal.input.sendKeys(Keys.CONTROL + "a");
        ChangeCustomerModal.input.sendKeys(Keys.DELETE);
        //ChangeCustomerModal.input.clear();
            ChangeCustomerModal.saveBtn.shouldBe(disabled);
            ChangeCustomerModal.modalWindow.shouldBe(text("Укажите значение номера клиента"));

        ChangeCustomerModal.input.setValue("145955445");
            ChangeCustomerModal.saveBtn.shouldBe(enabled);

        ChangeCustomerModal.cancelBtn.click();
            ChangeCustomerModal.modalWindow.shouldNot(visible);

        HeaderPage.customerNumberIcon.click();
            ChangeCustomerModal.modalWindow.shouldBe(visible)
                .shouldBe(text("Укажите клиента"))
                .shouldBe(text("Укажите значение номера клиента"));

        ChangeCustomerModal.input.setValue("145955445"); //TODO сделать возможность выбора дев и препрод
            ChangeCustomerModal.saveBtn.shouldBe(enabled);

        ChangeCustomerModal.saveBtn.click();
            ChangeCustomerModal.modalWindow.shouldNot(visible);
            HeaderPage.clientWidget.shouldBe(text("тестИ тестА"));


            //TODO добавить проверки истории заказа
    }
}
