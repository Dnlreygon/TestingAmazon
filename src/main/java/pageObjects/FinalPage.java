package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinalPage {
    @FindBy(xpath = "//*[@id=\"nav-your-amazon-text\"]")
    private WebElement finalPage;

    public boolean isFinalPageVisible(){
        return this.finalPage.isDisplayed();
    }
}
