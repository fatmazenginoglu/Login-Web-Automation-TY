package hooks;
import io.cucumber.java.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

public class Hooks {


    //@BeforeStep("@CustomerMovements")
    @AfterStep("@ChoosingProductCriteria")
    public void closeUpPopUpIf1() {
        if (isPopUp()){
            closePUp();
        }
    }
    private boolean isPopUp(){
        try {
            WebElement body = Driver.getDriver().findElement(By.xpath("//*[@class='overlay']"));
            return body.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
    private void closePUp(){
        WebElement body = Driver.getDriver().findElement(By.xpath("//*[@class='overlay']"));
        body.click();
    }

}
