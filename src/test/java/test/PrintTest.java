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

        HeaderPage.openCloudPrintModal();
        CloudPrintModal.openSelectPrinterModal();
        CloudPrintModal.closeModal();

        HeaderPage.openCloudPrintModal();
        CloudPrintModal.openSelectPrinterModal();
        CloudPrintModal.backClickModal();
        CloudPrintModal.closeModal();
    }

    @Test(dataProvider = "getCloudPrintName", dataProviderClass = CloudPrintModal.class)
    public void CloudPrintProvider(String printname, String section) {
        HeaderPage.openCloudPrintModal();
        CloudPrintModal.openSelectPrinterModal();
        CloudPrintModal.setNewPrinter(printname,section);
        CloudPrintModal.closeModal();
    }

    //TODO написать проверки с открытием ПДФ

}
