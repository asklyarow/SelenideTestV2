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
            HeaderPage.openChangeCustomerModal();
                });
        step("Ввести буквы и спецсимволы", () -> {
            ChangeCustomerModal.setInput(ChangeCustomerModal.invalidCustomerId);
                });
        step("Очистить поле", () -> {
            ChangeCustomerModal.clearFld();
                });
        step("Ввести существующий CustomerNumber, отличный от настоящего в заказе", () -> {
            ChangeCustomerModal.setInput(ChangeCustomerModal.validCustomerId);
                });
        step("Кликнуть на Отмена", () -> {
            ChangeCustomerModal.clickCancelBtn();
                });
        step("Ввести существующий CustomerNumber и сохранить", () -> {
            HeaderPage.openChangeCustomerModal();
            ChangeCustomerModal.setInput(ChangeCustomerModal.validCustomerId);
            ChangeCustomerModal.clickSaveBtn();
            ChangeCustomerModal.chekSaveChangeCustomer();
                });

    }
}
