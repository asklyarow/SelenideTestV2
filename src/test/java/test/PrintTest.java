package test;


import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.*;
import pages.HeaderPage;
import pages.modal.CloudPrintModal;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PrintTest extends Login{

    //@BeforeClass
    @BeforeMethod
    private void OpenOrder() {
        String currentOrderId = "221204700520";
        open(currentOrderId);

        HeaderPage.chekOrderNumber(currentOrderId); //верный ли заказ открыт?
    }

    @Test
    public void CloudPrintTest() {

        HeaderPage.printOrderIcon.click();
        HeaderPage.cloudPrintButton.click();
        CloudPrintModal.cloudPrintModal.shouldBe(visible).shouldBe(text("Облачная печать"));
        CloudPrintModal.printerNameBtn.click();
        CloudPrintModal.cloudPrintModal.shouldBe(visible).shouldBe(text("Выбор принтера"));
        CloudPrintModal.closeModal.click();
        CloudPrintModal.cloudPrintModal.shouldBe(disappear);

        HeaderPage.printOrderIcon.click();
        HeaderPage.cloudPrintButton.click();
        CloudPrintModal.cloudPrintModal.shouldBe(visible).shouldBe(text("Облачная печать"));
        CloudPrintModal.printBtn.shouldBe(visible).shouldBe(text("Напечатать"));
        CloudPrintModal.printerNameBtn.click();
        CloudPrintModal.backBtn.click();
        CloudPrintModal.cloudPrintModal.shouldBe(visible).shouldNot(text("Выбор принтера"));
        CloudPrintModal.closeModal.click();
        CloudPrintModal.cloudPrintModal.shouldBe(disappear);
    }

    @Test(dataProvider = "getCloudPrintName", dataProviderClass = CloudPrintModal.class)
    public void CloudPrintProvider(String printname, String section) {
        CloudPrintModal.setNewPrinter(printname,section);
    }

    //TODO написать проверки с открытием ПДФ

}
