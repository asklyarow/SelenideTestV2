package pages.modal;

import com.codeborne.selenide.SelenideElement;
import pages.HeaderPage;

import org.testng.annotations.DataProvider;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CloudPrintModal {

    public static SelenideElement
            cloudPrintModal = $x("//div[@data-testid='modal-window']"), //div[@data-testid='modal_title-mobile-caption']
            closeModal = $x("//button[@aria-label='Close modal']"),
            printerNameBtn = $x("//span[contains(.,'S035P-CHOP-001')]"),

            printBtn = $x("//button[contains(.,'Напечатать')]"),
            backBtn = $x("//div[@data-testid='modal-window']//div[@class='lmui-View']//button[@type='button']");

    public static SelenideElement newPrinterNameBtn (String printname) {
        return $x("//span[contains(.,'" + printname + "')]");}


    public static void openSelectPrinterModal() {
        printerNameBtn.click();               //переход к модальному окну выбора принтера и выбор нового принтера
        cloudPrintModal.shouldBe(visible).shouldBe(text("Выбор принтера"));
    }

    public static void setNewPrinter(String printname, String section) {
        newPrinterNameBtn(printname).click();
        cloudPrintModal.shouldBe(visible).shouldBe(text(section));
    }

    public static void closeModal() {
        closeModal.click();
        cloudPrintModal.shouldBe(disappear);
    }

    public static void backClickModal() {
        backBtn.click();
        cloudPrintModal.shouldBe(visible).shouldNot(text("Выбор принтера"));
    }

    @DataProvider(name="getCloudPrintName")
    public Object[ ][ ] dataProviderMethod() {
        return new Object[][]{
                {"S035P-POS-006", "Другие"},
                {"S035P-VEN05-001", "05 Напольные покрытия"},
                {"S035P-VEN12-001", "12 Отделочные материалы"}};
    }

}
