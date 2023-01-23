package test;


import org.testng.annotations.*;
import pages.HeaderPage;
import pages.modal.ChangeCustomerModal;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class HeaderTest {

    @BeforeMethod
    private void OpenOrder() {
        String currentOrderId = "221204700520";
        open(currentOrderId);

        HeaderPage.chekOrderNumber(currentOrderId); //верный ли заказ открыт?
    }

    @Test
    private void ChangeCustomerIcon(){
        HeaderPage.customerNumberIcon.click();
        ChangeCustomerModal.modalWindow.shouldBe(visible).shouldBe(text("Укажите клиента"));
        ChangeCustomerModal.saveBtn.shouldBe(disabled);


    }
}
