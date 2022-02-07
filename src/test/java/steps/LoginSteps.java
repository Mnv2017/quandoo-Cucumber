package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginSteps {
    HomePage homePage;
    LoginPage loginPage;

    @When("Open Login page")
    public void navigateToLoginPage(){
        homePage = page(HomePage.class);
        loginPage = homePage.clickOnLogin();
        loginPage.logInBtn().shouldBe(exist);
    }

    @And("^Fill the login form with email (.*) and password (.*)$")
    public void fillLoginFormAndConfirm(String email, String password){
        loginPage.loginUser(email,password);
    }

    @Then("Log in is complete")
    public void assertSuccessfulLogin(){
        homePage.getAccountIcon().shouldBe(visible);
        homePage.clickOnLogout();
    }

    @Then(("Error message appears"))
    public void isErrorMessageAppears(){
        loginPage.getErrorMessage().shouldHave(text("Enter valid username or password"));
    }
}
