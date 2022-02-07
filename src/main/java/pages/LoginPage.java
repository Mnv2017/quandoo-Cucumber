package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private static By email = By.cssSelector("[data-qa=email-input]");
    private static By password = By.cssSelector("[data-qa=password-input]");
    private static By loginBtn = By.cssSelector("[data-qa=login-btn]");
    private static By error = By.cssSelector(".sc-bdVaJa.Error__ErrorWrapper-jytvvh-0.eBoGeh");

    public HomePage loginUser(String emailV, String passwordV) {
        $(email).shouldBe(visible).setValue(emailV).pressTab();
        $(password).setValue(passwordV).pressTab();
        $(loginBtn).click();
        return page(HomePage.class);
    }

    public SelenideElement logInBtn() {
        return $(loginBtn);
    }

    public SelenideElement getErrorMessage(){
        return $(error);
    }
}
