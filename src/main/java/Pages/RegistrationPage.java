package Pages;

import Util.ReadFromConfig;
import Util.util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='id_gender1']")
    WebElement titleBtn;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='newsletter']")
    WebElement newsLetterCheckBox;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement firstNameInputField;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastNameInputField;

    @FindBy(xpath = "//input[@id='company']")
    WebElement companyInputField;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement address1InputField;

    @FindBy(xpath = "//input[@id='address2']")
    WebElement address2InputField;

    @FindBy(xpath = "//select[@id='country']")
    WebElement countryInputField;

    @FindBy(xpath = "//input[@id='state']")
    WebElement stateInputField;

    @FindBy(xpath = "//input[@id='city']")
    WebElement cityInputField;

    @FindBy(xpath = "//input[@id='zipcode']")
    WebElement zipCodeInputField;

    @FindBy(xpath = "//input[@id='mobile_number']")
    WebElement mobileNumberInputField;

    @FindBy(xpath = "//select[@id='days']")
    WebElement daysInputField;

    @FindBy(xpath = "//select[@id='months']")
    WebElement monthsInputField;

    @FindBy(xpath = "//select[@id='years']")
    WebElement yearsInputField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createAccountBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    private void setTitleBtn(){
        util.WaitForTheElement(driver,titleBtn).click();
    }

    private void setPassword(String password){
        util.WaitForTheElement(driver,passwordInputField).sendKeys(password);
    }

    private void setDateOfBirthDays(){
        util.WaitForTheElement(driver,daysInputField).sendKeys("10");
    }

    private void setDateOfBirthMonths(){
        util.WaitForTheElement(driver,monthsInputField).sendKeys("July");
    }

    private void setDateOfBirthYears(){
        util.WaitForTheElement(driver,yearsInputField).sendKeys("1996");
    }

    private void clickNewsLetter(){
        util.WaitForTheElement(driver,newsLetterCheckBox).click();
    }

    private void setFirstName(String firstName){
        util.WaitForTheElement(driver, firstNameInputField).sendKeys(firstName);
    }

    private void setLastName(String LastName){
        util.WaitForTheElement(driver,lastNameInputField).sendKeys(LastName);
    }

    private void setCompany(){
        util.WaitForTheElement(driver,companyInputField).sendKeys("Company");
    }

    private void setAddress1(String address1){
        util.WaitForTheElement(driver,address1InputField).sendKeys(address1);
    }

    private void setAddress2(String address2){
        util.WaitForTheElement(driver,address2InputField).sendKeys(address2);
    }

    private void setCountry(){
        util.WaitForTheElement(driver,countryInputField).sendKeys("United States");
    }

    private void setState(String state){
        util.WaitForTheElement(driver,stateInputField).sendKeys(state);
    }

    private void setCity(String city){
        util.WaitForTheElement(driver,cityInputField).sendKeys(city);
    }

    private void setZipcode(String zipCode){
        util.WaitForTheElement(driver,zipCodeInputField).sendKeys(zipCode);
    }

    private void setMobileNumber(String mobileNumber){
        util.WaitForTheElement(driver,mobileNumberInputField).sendKeys(mobileNumber);
    }

    private void clickCreateAccountBtn(){
        util.WaitForTheElement(driver,createAccountBtn).click();
    }

    public void RegisterWithUser(String correctPassword,String firstName,String lastName,String city,
                                 String zipCode,String mobileNumber,String state,String address1,
                                 String address2){
        this.setTitleBtn();
        this.setPassword(ReadFromConfig.readFromFile(correctPassword));
        this.setDateOfBirthDays();
        this.setDateOfBirthMonths();
        this.setDateOfBirthYears();
        this.clickNewsLetter();
        this.setFirstName(ReadFromConfig.readFromFile(firstName));
        this.setLastName(ReadFromConfig.readFromFile(lastName));
        this.setCompany();
        this.setAddress1(ReadFromConfig.readFromFile(address1));
        this.setAddress2(ReadFromConfig.readFromFile(address2));
        this.setCountry();
        this.setState(ReadFromConfig.readFromFile(state));
        this.setCity(ReadFromConfig.readFromFile(city));
        this.setZipcode(ReadFromConfig.readFromFile(zipCode));
        this.setMobileNumber(ReadFromConfig.readFromFile(mobileNumber));
        this.clickCreateAccountBtn();
    }


















}
