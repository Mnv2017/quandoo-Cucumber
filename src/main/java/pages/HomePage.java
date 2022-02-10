package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePage {

    public static final String BASE_URL = "https://www.quandoo.de/";

    private static By accCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private static By wrapper = By.cssSelector(".wrapper");

    private static By berlinLnk = By.xpath("//h4[text()='Berlin']");
    private static By logInBtn = By.cssSelector("[data-qa=header-login-btn]");
    private static By signUpBtn = By.cssSelector("[data-qa=header-register-btn]");
    private static By accountIcon = By.cssSelector(("[data-qa=header-navigation-button]"));
    private static By logOutBtn = By.cssSelector("[data-qa=header-navigation-logout]");

    public HomePage openPage() {
        open(BASE_URL + "en/");
        getWebDriver().manage().window().maximize();
        return page(HomePage.class);
    }

    public void acceptCookies() {
        if ($(wrapper).exists()) {
            $(accCookies).shouldBe(visible).click();
        }
    }

    public BerlinPage navigateToBerlinPage(){
        $(berlinLnk).scrollIntoView(false).click();
        return page(BerlinPage.class);
    }

    public LoginPage clickOnLogin() {
        $(logInBtn).shouldBe(visible).click();
        return page(LoginPage.class);
    }

    public RegistrationPage clickOnSignUp() {
        $(signUpBtn).shouldBe(visible).click();
        return page(RegistrationPage.class);
    }

    public SelenideElement getAccountIcon() {
        return $(accountIcon);
    }

    public HomePage clickOnLogout() {
        $(accountIcon).shouldBe(visible).hover();
        $(logOutBtn).shouldBe(visible).click();
        return this;
    }
}
