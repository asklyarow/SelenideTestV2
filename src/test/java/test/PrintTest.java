package test;


import org.testng.annotations.*;
import pages.HeaderPage;
import pages.modal.CloudPrintPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class PrintTest extends Login{

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
        CloudPrintPage.printerNameBtn.click();
        CloudPrintPage.cloudPrintModal.shouldBe(visible).shouldBe(text("Выбор принтера"));
        CloudPrintPage.closeModal.click();
        CloudPrintPage.cloudPrintModal.shouldBe(disappear);

        HeaderPage.printOrderIcon.click();
        HeaderPage.cloudPrintButton.click();
        CloudPrintPage.cloudPrintModal.shouldBe(visible).shouldBe(text("Другие"));
        CloudPrintPage.printBtn.shouldBe(visible).shouldBe(text("Напечатать"));
        CloudPrintPage.printerNameBtn.click();
        CloudPrintPage.backBtn.click();
        CloudPrintPage.cloudPrintModal.shouldBe(visible).shouldBe(text("Другие"));
        CloudPrintPage.closeModal.click();
        CloudPrintPage.cloudPrintModal.shouldBe(disappear);
    }

    @Test(dataProvider = "getCloudPrintName", dataProviderClass = CloudPrintPage.class)
    public void CloudPrintProvider(String printname, String section) {
        CloudPrintPage.setNewPrinter(printname,section);
    }


}
