package pages.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CloudPrintPage {

    private static SelenideElement
        headerModal = $x("//h2[contains(.,'Облачная печать')]"),
        prinerNameBtn = $x("//span[contains(.,'S035P-CHOP-001')]"),
        printBtn = $x("//button[contains(.,'Напечатать')]");
        //TODO Подумать, как кнопку закрыть попап описать (есть дубль)

}
