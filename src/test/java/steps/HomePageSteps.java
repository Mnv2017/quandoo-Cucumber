package steps;

import io.cucumber.java.en.Given;
import pages.HomePage;

public class HomePageSteps {
    HomePage homePage;

    @Given("Open Home page")    // ToDo  два метода в оодном файле работают
    public void openHomePage() {
        homePage = new HomePage().openPage();
        homePage.acceptCookies();
    }
}
