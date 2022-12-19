package test;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class PrintTest extends Login{

    @Test
    public void CloudPrintTest() {
        String currentOrderId = "221102777944";

        open(currentOrderId);
    }
}
