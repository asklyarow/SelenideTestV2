package pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CommentTabPage {
    private static SelenideElement
            commentInputFld = $x("//input[contains(@class,'lmui-Input__input-rightIcons-1-lg')]"),
            commentTab = $x("//button[@data-testid='comments']"),
            commentList = $x("//*[@class='lmui-View Vr913SH6EVSfGn8QQR1FZA==']");


    public static void selectCommentTab() {
        commentTab.shouldBe(visible, Duration.ofSeconds(10)).click();
    }

    public static void enterComment(String comm) {
        commentInputFld.setValue(comm).pressEnter();
    }

    public static void chekEnterComment (String comm) {
        commentList.shouldHave(visible.text(comm));
    }

    public static void getQntComm () { }//TODO Разобраться, как получать и присваивать переменным данные
}
