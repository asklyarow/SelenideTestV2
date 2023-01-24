package pages.modal;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ChangeCustomerModal {

    public static SelenideElement
        modalWindow = $x("//div[@data-testid='modal-window']"),
        closeModal = $x("//button[@aria-label='Close modal']"),
        input = $x("//div[@data-testid='modal-window']//input[@data-testid='input-input']"),
        cancelBtn = $x("//button[@data-testid='aao-change-customer-number-modal-close-btn']"),
        saveBtn = $x("//button[@data-testid='aao-change-customer-number-modal-submit-btn']");


}
