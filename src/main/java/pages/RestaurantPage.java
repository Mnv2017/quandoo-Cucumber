package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RestaurantPage {

    private static ElementsCollection ratingInfoBlocks;

    private static By endOfPage = By.cssSelector("[data-qa=make-enquiry-button]");
    private static By ratingInfo = By.cssSelector(("[data-qa=merchant-rating]"));
    private static By ratingNumber = By.cssSelector(("[data-qa=reviews-score]>span.r91qah-1.DYnWo"));
    private static By makeAnEnquiryBtn = By.cssSelector("[data-qa=make-enquiry-button]");

    public RestaurantPage initLocators() {
        $(endOfPage).scrollIntoView(false);
        ratingInfoBlocks = $$(ratingInfo);
        return this;
    }

    public SelenideElement getLocatorRating(int i) {
        return ratingInfoBlocks.get(i).find(ratingNumber);
    }

    public EnquiryPage clickOnEnquiryBtn(){
        $(endOfPage).scrollIntoView(false);
        $(makeAnEnquiryBtn).shouldBe(visible).click();
        return page(EnquiryPage.class);
    }
}
