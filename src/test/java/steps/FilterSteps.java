package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BerlinPage;
import pages.HomePage;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.page;

public class FilterSteps {
    HomePage homePage = page(HomePage.class);
    BerlinPage berlinPage = page(BerlinPage.class);

    public static int numberOfRestaurantsBefore;
    public static int numberOfAfricanRestaurants;

    @Given("Open Berlin page")
    public void openBerlinPage(){
        berlinPage.openPage();
        homePage.acceptCookies();
    }

    @Given("Navigate to Berlin page")
    public void navigateToBerlinPage() {
        berlinPage = homePage.navigateToBerlinPage();
    }

    @When("Click on TopRate button")
    public void clickOnTopRateBtn() {
        numberOfRestaurantsBefore = berlinPage.getResultsCount();
        berlinPage.clickOnTopRate();
    }

    @Then("Number of restaurants has decreased")
    public void compareRestaurantsNumber() {
        Assert.assertTrue(berlinPage.getResultsCount() <= numberOfRestaurantsBefore);
    }

    @When("Set up African checkbox")
    public void setUpAfricanCheckbox() {
        numberOfAfricanRestaurants = berlinPage.getCountOfAfricanRestaurants();
        berlinPage.clickOnAfricanCheckbox();
        berlinPage.africanRestaurant(2).shouldHave(exactText("African"));
    }

    @Then("Number of selected restaurants and African restaurant are equals")
    public void compareNumberOfRestaurants() {
        Assert.assertEquals(berlinPage.getResultsCount(), numberOfAfricanRestaurants);
    }

    @Then("All African restaurants are selected")
    public void checkAllAfricanSelected() {
        for (int i = 2; i < numberOfAfricanRestaurants + 1; i++) {
            berlinPage.africanRestaurant(i).shouldHave(exactText("African"));
        }
    }

    @When("Search by word African")
    public void typeAfricanInSearch() {
        berlinPage.searchBy("African");
    }

    @Then("African filter is set up")
    public void checkboxAfricanIsSetUp() {
        berlinPage.africanCheckBox().shouldBe(selected);
    }
}
