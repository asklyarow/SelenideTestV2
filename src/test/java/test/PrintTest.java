package test;

import static com.codeborne.selenide.Condition.*;
import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.InfoTabPage;
import pages.LoginPage;
import pages.modal.CloudPrintPage;

import static com.codeborne.selenide.Selenide.*;

public class PrintTest extends Login{

    @Test
    public void CloudPrintTest() {
        String currentOrderId = "221204700520";
        open(currentOrderId);

        HeaderPage.chekOrderNumber(currentOrderId); //верный ли заказ открыт?

        HeaderPage.printOrderIcon.click();
        HeaderPage.cloudPrintButton.click();
        CloudPrintPage.modalName.shouldHave();

        CloudPrintPage.prinerNameBtn.click();
        CloudPrintPage.newPrinterNameBtn.click();
        CloudPrintPage.newPrinterNameBtn.shouldHave(visible);

        CloudPrintPage.newPrinterNameBtn.click();
        HeaderPage.printOrderIcon.shouldHave(visible);
        CloudPrintPage.prinerNameBtn.shouldHave(visible);


    }
}
