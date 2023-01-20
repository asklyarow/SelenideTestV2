package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class InfoTabPage {

    private static SelenideElement
        contactTabEditBtn = $x("//button[@testid='aao-info-contacts-card-edit-btn']"),
        receivingTabEditBtn = $x("//button[@testid='aao-recipient-card-edit-btn']");
}
