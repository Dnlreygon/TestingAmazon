package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
    @FindBy(xpath = "//*[@id='ap_email']")
    private WebElement accountField;

    @FindBy(css = ".a-button-input")
    private WebElement nextBtn;
    public void clickNextBtn(){
        this.nextBtn.click();
    }

    @FindBy(css = ".a-alert-heading")
    private WebElement accountInvalid;
    public boolean isAccountInvalidVisible(){
        return this.accountInvalid.isDisplayed();
    }

    public void setUserAccount(String username){
        this.accountField.sendKeys(username);
    }
}
