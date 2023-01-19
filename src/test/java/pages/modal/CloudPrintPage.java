package pages.modal;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

public class CloudPrintPage {

    public static SelenideElement
        modalName = $x("//h2[contains(.,'Облачная печать')]"),
        prinerNameBtn = $x("//span[contains(.,'S035P-CHOP-001')]"),
        newPrinterNameBtn = $x("//span[contains(.,'S035P-VEN04-001')]"),
        printBtn = $x("//button[contains(.,'Напечатать')]");
        //TODO Подумать, как кнопку закрыть попап описать (есть дубль)


}
