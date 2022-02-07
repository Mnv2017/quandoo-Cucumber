package steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BerlinPage;
import pages.RestaurantPage;

import static com.codeborne.selenide.Selenide.page;

public class RatingSteps {
    BerlinPage berlinPage;
    RestaurantPage restaurantPage;

    public static String firstRestaurantRating;

    @When("Save a restaurant rating value in the list")
    public void saveFirstRestaurantRating() {
        berlinPage = page(BerlinPage.class);
        firstRestaurantRating = berlinPage.getFirstRestRating();
    }

    @And("Click on the restaurant")
    public void clickOnFirstRestaurant() {
        restaurantPage = berlinPage.clickOnFirstRestaurant().initLocators();
    }

    @Then("Ratings on restaurant view card are equal to rating value")
    public void compareRatingsOnCardWithInList() {
        restaurantPage.getLocatorRating(0).shouldHave(Condition.exactText(firstRestaurantRating));
        restaurantPage.getLocatorRating(2).shouldHave(Condition.exactText(firstRestaurantRating));
    }
}
