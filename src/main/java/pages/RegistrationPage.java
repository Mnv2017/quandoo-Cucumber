package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class RegistrationPage {
    private Faker faker = new Faker();

    public static String passValue;
    public static String emailValue;

    private static By firstName = By.cssSelector("[data-qa=first-name-input]");
    private static By lastName = By.cssSelector("[data-qa=last-name-input]");
    private static By email = By.cssSelector("[data-qa=email-input]");
    private static By password = By.cssSelector("[data-qa=password-input]");
    private static By passwordConfirm = By.cssSelector("[data-qa=password-confirm-input]");
    private static By agreeCheckbox = By.cssSelector(".Svg-jb9ekn-0.bZETVP.nc-icon.outline");
    private static By createAccountBtn = By.cssSelector("[data-qa=submit-btn]");

    public HomePage signIn() {
        $(firstName).setValue(faker.name().firstName()).pressTab();
        $(lastName).setValue(faker.name().lastName()).pressTab();
        emailValue = faker.internet().emailAddress();
        passValue = faker.internet().password();
        $(email).setValue(emailValue).pressTab();
        $(password).setValue(passValue).pressTab();
        $(passwordConfirm).setValue(passValue).pressTab();
        $(agreeCheckbox).click();
        $(createAccountBtn).click();
        return page(HomePage.class);
    }

    public SelenideElement createAccountBtn() {
        return $(createAccountBtn);
    }

}
