package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HeaderPage {

    public static SelenideElement
        numberOrder = $x("//input[contains(@class, 'CopyToClipboardButton__input')]"),
        customerNumberIcon = $("customer-number-edit-btn"),
        copyOrderIcon = $("create-cart-btn"),
        barCodeIcon = $("barcode-btn"),
        printOrderIcon = $x("//button[@data-testid='aao-print-order-btn']"),
            cloudPrintButton = $("#printOrderBlankCloudPrint"),
            printOrderInfo = $("#printOrderInfo"),
            printStickerZebra = $("#printStickerStickyLabel"),
            printStickerPaper = $("#printStickerPaper"),
            printStickerPdf = $("#printStickerPdf"),
            printLabel = $("#printLabel"),
        cancelOrderIcon = $("#cancel-order-btn");



    public static void chekOrderNumber(String order) {
        numberOrder.shouldHave(value(order),Duration.ofSeconds(10));
    }
}
