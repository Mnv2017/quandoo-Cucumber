package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.visible;

public class RegistrationSteps {
    HomePage homePage;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    @When("Open Registration page")
    public void navigateToRegistrationPage() {
        homePage = new HomePage().openPage();
        registrationPage = homePage.clickOnSignUp();
        registrationPage.createAccountBtn().shouldBe(visible);
    }

    @And("Fill registration form with valid data")
    public void fillAndConfirmRegistrationForm() {
        registrationPage.signIn();
        String p = RegistrationPage.passValue;
        String e = RegistrationPage.emailValue;
    }

    @Then("New account is created")
    public void assertSuccessfulLogin() {
        homePage.getAccountIcon().shouldBe(visible);
    }

    @And("It is possible to log in to this account")
    public void logInIntoNewAccount() {
        loginPage = homePage.clickOnLogout().clickOnLogin();
        loginPage.loginUser(RegistrationPage.emailValue, RegistrationPage.passValue);
        homePage.getAccountIcon().shouldBe(visible);
        homePage.clickOnLogout();
    }
}
