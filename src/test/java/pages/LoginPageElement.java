package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.swing.*;

public class LoginPageElement {

    public LoginPageElement() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='logo']")
    public WebElement logo;

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement popUpClose;

    @FindBy(xpath = "//*[@class='link account-user']")
    public WebElement girisYap;

    @FindBy(id = "login-email")
    public WebElement emailText;

    @FindBy(xpath = "//*[@id=\"login-password-input\"]")
    public WebElement passwordText;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement userEnterButton;

    @FindBy(className = "account-user")
    public WebElement loginButton;

    @FindBy(xpath="//span[text()='E-posta adresiniz ve/veya şifreniz hatalı.']")
    public WebElement loginErrorMessage1;

    @FindBy(xpath="//span[text()='Lütfen geçerli bir e-posta adresi giriniz.']")
    public WebElement loginErrorMessage2;

    @FindBy(xpath="//span[text()='Lütfen şifrenizi giriniz.']")
    public WebElement loginErrorMessage3;

    @FindBy(xpath = "//*[@class='link-text']")
    public WebElement hesabim;

    @FindBy(xpath = "//i[@class='i-eye-close']")
    public WebElement eyeClose;

    @FindBy(xpath = "//i[@class='i-eye-open']")
    public WebElement eyeOpen;

    @FindBy(xpath = "//span[text()='Şifremi Unuttum']")
    public WebElement forgotPassword;

    @FindBy(xpath = "//span[text()='Şifre Yenileme']")
    public WebElement forgotPage;

}
