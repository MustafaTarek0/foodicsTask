package Testing.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class checkOutPage extends pageBase{


    @FindBy(css = "a.a-link-normal.expand-panel-button.celwidget[aria-label='Change delivery address']")
    WebElement changeAddress;
    @FindBy(id = "add-new-address-desktop-sasp-tango-link")
    WebElement addNewDeliveryAddressBtn;

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    WebElement addressFullName;
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement addressPhoneNumber;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement addressLine1;
    @FindBy(id = "address-ui-widgets-enter-building-name-or-number")
    WebElement buildingNumber;
    @FindBy(id = "address-ui-widgets-enterAddressCity")
    WebElement city;
    @FindBy(id = "address-ui-widgets-enterAddressDistrictOrCounty")
    WebElement district;
    @FindBy(id = "checkout-primary-continue-button-id")
    WebElement useAddressBtn;
    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    WebElement Governorate;
    @FindBy(id = "address-ui-widgets-autoCompleteResult-0")
    WebElement cityCairo;
    @FindBy(css = "input[name='ppw-instrumentRowSelection'][value*='Loan']")
    WebElement valuePaymentMethod;

    public WebElement getChangeAddress() {
        return changeAddress;
    }

    public WebElement getAddNewDeliveryAddressBtn() {
        return addNewDeliveryAddressBtn;
    }

    public WebElement getAddressFullName() {
        return addressFullName;
    }

    public WebElement getAddressLine1() {
        return addressLine1;
    }

    public WebElement getAddressPhoneNumber() {
        return addressPhoneNumber;
    }

    public WebElement getBuildingNumber() {
        return buildingNumber;
    }

    public WebElement getGovernorate() {
        return Governorate;
    }

    public WebElement getDistrict() {
        return district;
    }

    public WebElement getUseAddressBtn() {
        return useAddressBtn;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCityCairo() {
        return cityCairo;
    }

    public WebElement getValuePaymentMethod() {
        return valuePaymentMethod;
    }
}
