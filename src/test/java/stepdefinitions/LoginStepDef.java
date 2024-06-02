package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPageElement;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethod;

public class LoginStepDef {

    LoginPageElement lp= new LoginPageElement();

    @Given("Go to {string}")
    public void goTo(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethod.waitForPageToLoad(7);
        try {
            if (lp.popUpClose.isDisplayed()) {
                lp.popUpClose.click();
            }
        } catch (NoSuchElementException e) {
        }
    }

    @When("Click the “Sign In”")
    public void clickTheSignIn() {
        lp.girisYap.click();
    }

    @When("Enter a unregistered mail {string} in the Email field \\(Must not be a previously registered email)")
    public void enterAUnregisteredMailInTheEmailFieldMustNotBeAPreviouslyRegisteredEmail(String arg0) {
        lp.emailText.sendKeys(ConfigReader.getProperty("validMail"));
    }

    @And("Enter a valid password {string} in the password field")
    public void enterAValidPasswordInThePasswordField(String arg0) {
        lp.passwordText.sendKeys(ConfigReader.getProperty("validPassword"));
    }

    @And("Click the “Sign In” button")
    public void clickTheSignInButton() {
        lp.userEnterButton.click();
        ReusableMethod.waitForClickablility(lp.logo, 7);
    }

    @Then("The user cannot log in successfully")
    public void theUserCannotLogInSuccessfully() {
        ReusableMethod.waitFor(7);
        lp.loginButton.isDisplayed();
    }

    @And("The warning message1 {string} is displayed")
    public void theWarningMessage1IsDisplayed(String arg0) {
        ReusableMethod.waitFor(7);
        lp.loginErrorMessage1.isDisplayed();
    }

    @When("Enter a valid mail {string} in the Email field \\(Must be a previously registered email)")
    public void enterAValidMailInTheEmailFieldMustBeAPreviouslyRegisteredEmail(String arg0) {
        lp.emailText.sendKeys(ConfigReader.getProperty("registeredMail"));
    }

    @And("Enter a invalid\\(lenght) password {string} in the password field")
    public void enterAInvalidLenghtPasswordInThePasswordField(String arg0) {
        lp.passwordText.sendKeys(ConfigReader.getProperty("invalidPasswordLenght"));
    }

    @And("Enter a invalid\\(character) password {string} in the password field")
    public void enterAInvalidCharacterPasswordInThePasswordField(String arg0) {
        lp.passwordText.sendKeys(ConfigReader.getProperty("invalidPasswordCharacter"));
    }

    @And("Enter a invalid\\(numeric) password {string} in the password field")
    public void enterAInvalidNumericPasswordInThePasswordField(String arg0) {
        lp.passwordText.sendKeys(ConfigReader.getProperty("invalidPasswordNumeric"));
    }

    @When("Enter a invalid mail {string} in the Email field")
    public void enterAInvalidMailInTheEmailField(String arg0) {
        lp.emailText.sendKeys(ConfigReader.getProperty("invalidMail"));
    }

    @When("Leave the email {string} field blank")
    public void leaveTheEmailFieldBlank(String arg0) {

    }

    @And("Leave the password {string} field blank")
    public void leaveThePasswordFieldBlank(String arg0) {
    }

    @When("Enter a valid mail {string} in the Email field")
    public void enterAValidMailInTheEmailField(String arg0) {
        ReusableMethod.waitFor(7);
        lp.emailText.sendKeys(ConfigReader.getProperty("validMail"));
    }

    @And("Click on the show password button")
    public void clickOnTheShowPasswordButton() {
        lp.eyeClose.click(); // Show password
        ReusableMethod.waitFor(20);
    }

    @Then("The characters written in the password field are visible")
    public void theCharactersWrittenInThePasswordFieldAreVisible() {
        ReusableMethod.waitFor(7);
        lp.eyeOpen.isDisplayed();
    }

    @When("Click on the show password button again")
    public void clickOnTheShowPasswordButtonAgain() {
        lp.eyeOpen.click(); // Hide password
    }

    @Then("Characters written in the password field appear as asterisks")
    public void charactersWrittenInThePasswordFieldAppearAsAsterisks() {
        ReusableMethod.waitFor(7);
        lp.eyeClose.isDisplayed();
    }

    @When("Click the {string} button")
    public void clickTheButton(String arg0) {
        lp.forgotPassword.click();
    }

    @Then("Redirects to the password renewal page")
    public void redirectsToThePasswordRenewalPage() {
        lp.forgotPage.isDisplayed();
    }

    @Then("The user can log in successfully")
    public void theUserCanLogInSuccessfully() {
    }

    @When("Reopen the browser")
    public void reopenTheBrowser() {
        ReusableMethod.openNewTabAndSwitch("https://www.trendyol.com");
    }

    @Then("The email field is visible")
    public void theEmailFieldIsVisible() {
        lp.emailText.isDisplayed();
    }

    @Then("The password field is visible")
    public void thePasswordFieldIsVisible() {
        lp.passwordText.isDisplayed();
    }

    @Then("The “Sign In” button is visible")
    public void theSignInButtonIsVisible() {
        lp.loginButton.isDisplayed();
    }

    @Then("The “Show Password” button is visible")
    public void theShowPasswordButtonIsVisible() {
        lp.eyeClose.isDisplayed();
    }

    @Then("The {string} button is visible")
    public void theButtonIsVisible(String arg0) {
        lp.forgotPassword.isDisplayed();
    }

    @And("The warning Your e-mail address and-or password is not correct is displayed")
    public void theWarningYourEMailAddressAndOrPasswordIsNotCorrectIsDisplayed() {
        ReusableMethod.waitFor(10);
        lp.loginErrorMessage1.isDisplayed();
    }

    @And("The warning message3 {string} is displayed")
    public void theWarningMessageIsDisplayed(String arg1) {
        ReusableMethod.waitFor(10);
        lp.loginErrorMessage3.isDisplayed();
    }

    @And("The warning message2 {string} is displayed")
    public void theWarningMessage2IsDisplayed(String arg1) {
        ReusableMethod.waitFor(10);
        lp.loginErrorMessage2.isDisplayed();
    }
}
