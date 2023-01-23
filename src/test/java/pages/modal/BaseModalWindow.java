package pages.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Condition.*;

public class BaseModalWindow {

    String nameModal;

    public static SelenideElement

            modalWindow = $x("//div[@data-testid='modal-window']"),
            closeModal = $x("//button[@aria-label='Close modal']"),
            backBtn = $x("//div[@data-testid='modal-window']//div[@class='lmui-View']//button[@type='button']"),
            cancelBtn,
            saveBtn;

    public void closeModal() {
        closeModal.click();
        modalWindow.shouldBe(disappear);
    }

}
