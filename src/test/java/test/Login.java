package test;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.MainPage;
import pages.Properties;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.*;


public class Login {

    @BeforeClass
    public void setUp() {
        // настройки браузера
        String env = "test";
        String size = "callcenter";
        browser = Properties.getProperty("chrome");
        browserSize = Properties.getProperty(size);
        headless = false;
        //baseUrl = "https://magportal-dev-magfront-stage.apps.lmru.tech/orders/orders_v2";

        open(Properties.getProperty(env));

        // открытие страницы с заказами
        String ldap = Properties.getProperty("ldap");
        String pass = Properties.getProperty("password");
        String user = Properties.getProperty("username");

        LoginPage.loginLdap(ldap, pass);

        //MainPage.watsNewPopupClose(); //TODO Сделать ветвление, когда не открывается окно

        if (!(size.equals("normal"))) { //если разрешение низкое и требуется нажать кнопку доступа к меню слева
            MainPage.openLeftMenu();
        }

        MainPage.selectShop(user, "0", "35");

        MainPage.checkOrderList();
    }

}
