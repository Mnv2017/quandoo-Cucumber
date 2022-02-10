package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class EnquiryPage {

    private static By submitBtn = By.cssSelector("[data-qa=enquiry-submit]");

    private static By email = By.cssSelector("[data-qa=input-email]");
    private static By firstName = By.cssSelector("[data-qa=input-first-name]");
    private static By lastName = By.cssSelector("[data-qa=input-last-name]");
    private static By phone = By.cssSelector("[data-qa=input-phone]");
    private static By timeSelect = By.cssSelector("[data-qa=widget-time-picker-end] select");
    private static By message = By.cssSelector("[data-qa=message]");
    private static By iAgree = By.cssSelector("#checkoutTermsCheckbox [data-qa=checkbox-icon-box]");

    private static Object[] errTypes = new Object[5];

    public void initErrMsgLocators() {
        errTypes[0] = By.xpath("//div[@id='checkoutCustomerForm']/div/div/div/div/span[2]");
        errTypes[1] = By.xpath("//div[@id='checkoutCustomerForm']/div/div[2]/div/div/div/span[2]");
        errTypes[2] = By.xpath("//div[2]/div[2]/div/div/span[2]");
        errTypes[3] = By.xpath("//div[3]/div[2]/div/div/span[2]");
        errTypes[4] = By.xpath("//div[3]/div[2]/div/div/span[2]");
    }

    public EnquiryPage fillEnquiryForm(String emailV, String firstNameV, String lastNameV, String phoneV) {
        $(timeSelect).selectOptionContainingText("11:30 pm");
        $(email).shouldBe(visible).setValue(emailV).pressTab();
        $(firstName).shouldBe(visible).setValue(firstNameV).pressTab();
        $(lastName).shouldBe(visible).setValue(lastNameV).pressTab();
        $(phone).shouldBe(visible).setValue(phoneV).pressTab();
        $(message).shouldBe(visible).setValue("It is a message");
        $(iAgree).shouldBe(exist).click();
        return this;
    }

    public RestaurantPage clickOnSubmit() {
        $(submitBtn).click();
        return page(RestaurantPage.class);
    }

    public SelenideElement getErrorMessage(int i) {
        return $((By) errTypes[i]).shouldBe(exist);
    }
}
