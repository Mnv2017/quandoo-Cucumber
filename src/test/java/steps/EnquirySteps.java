package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.docstring.DocString;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EnquiryPage;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class EnquirySteps {
    EnquiryPage enquiryPage = page(EnquiryPage.class);

    @When("Fill Enquiry form fields with invalid data")
    public void fillEnquiryForm(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps();
        String email = dataTable.get(0).get("email");
        String firstName = dataTable.get(0).get("firstName");
        String lastName = dataTable.get(0).get("lastName");
        String phone = dataTable.get(0).get("phone");
        enquiryPage.fillEnquiryForm(email, firstName, lastName, phone);
    }

    @When("Click on Send enquiry button")
    public void clickOnSendEnquiryBtn() {
        enquiryPage.initErrMsgLocators();
        enquiryPage.clickOnSubmit();
    }

    @Then("Error message {} appears")
    public void getErrorMsgAppears(Integer num, DocString docString) {
        enquiryPage.getErrorMessage(num-1).shouldHave(text(docString.getContent()));
    }
}
