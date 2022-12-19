package test;

import org.testng.annotations.Test;
import pages.HeaderPage;

import static com.codeborne.selenide.Selenide.*;

public class PrintTest extends Login{

    @Test
    public void CloudPrintTest() {
        String currentOrderId = "221204700520";
        open(currentOrderId);


        HeaderPage.chekOrderNumber(currentOrderId);
    }
}
