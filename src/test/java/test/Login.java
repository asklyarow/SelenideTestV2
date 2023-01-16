package test;


import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import pages.Properties;


import java.io.InputStream;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;


public class Login {

    @BeforeClass

    public void setUp() {

            // настройки браузера
            String env = "preprod";
            String size = "normal";
            headless = false;
            browser = Properties.getProperty("chrome");
            browserSize = Properties.getProperty(size);
            baseUrl = Properties.getProperty(env);



        open(baseUrl);

        // открытие страницы с заказами
        String ldap = Properties.getProperty("ldap");
        String pass = Properties.getProperty("password");
        String user = Properties.getProperty("username");

        LoginPage.loginLdap(ldap, pass);

        MainPage.watsNewPopupClose(); //TODO Сделать ветвление, когда не открывается окно

        if (!browserSize.equals("1920x1080")) MainPage.openLeftMenu();
         //если разрешение низкое и требуется нажать кнопку доступа к меню слева


        MainPage.selectShop(user, "0", "35");

        MainPage.checkOrderList();
    }

}
