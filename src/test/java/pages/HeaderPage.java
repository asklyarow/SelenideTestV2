package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HeaderPage {

    public static SelenideElement
        numberOrder = $x("//input[contains(@class, 'CopyToClipboardButton__input')]"),
        customerNumberIcon = $("#customer-number-edit-btn"),
        copyOrderIcon = $("#create-cart-btn"),
        barCodeIcon = $("#barcode-btn"),
        printOrderIcon = $x("//button[@data-testid='aao-print-order-btn']"),
            cloudPrintButton = $("#printOrderBlankCloudPrint"),
            printOrderInfo = $("#printOrderInfo"),
            printStickerZebra = $("#printStickerStickyLabel"),
            printStickerPaper = $("#printStickerPaper"),
            printStickerPdf = $("#printStickerPdf"),
            printLabel = $("#printLabel"),
        cancelOrderIcon = $("#cancel-order-btn"),

        clientWiget = $x("//div[@class='lmui-View lm-puz2-Order-OrderCustomerCommon']"),
            //clientName = $x("//span[@class='node_modules-fronton-react-typography-styles-module__typography--gU4V0 node_modules-fronton-react-typography-styles-module___m--NTpK1 lm-clients-CustomerControl-ViewCard__link_text node_modules-fronton-react-typography-styles-module__body_accent--GPIDO']");

        orderMainTab = $x("//button[@data-testid='main']"),
        orderCommentTab = $x("//button[@data-testid='comments']"),
        orderInfoTab = $x("//button[@data-testid='info']"),
        orderPickingTab = $x("//button[@data-testid='pickings']"),
        orderGiveAwayTab = $x("//button[@data-testid='giveaway']");

    public static void chekOrderNumber(String order) {
        numberOrder.shouldBe(value(order),Duration.ofSeconds(10));
    }
}
