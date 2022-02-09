package steps;

import io.cucumber.java.en.Given;
import pages.HomePage;

import static com.codeborne.selenide.Selenide.page;

public class HomePageSteps {
    HomePage homePage;

    @Given("Open Home page")
    public void openHomePage() {
        homePage = page(HomePage.class).openPage();
        homePage.acceptCookies();
    }
}
