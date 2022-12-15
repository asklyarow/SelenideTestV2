package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static SelenideElement inputLogin(String ldap) {
        return $("#Username").setValue(ldap);
    }
    private static SelenideElement inputPass(String pass) {
        return $("#Password").setValue(pass);
    }

    public static void loginLdap(String ldap, String pass) {
        inputLogin(ldap);
        inputPass(pass).pressEnter();
    }

}
