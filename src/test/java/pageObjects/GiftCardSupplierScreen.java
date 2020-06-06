package pageObjects;

import org.openqa.selenium.By;

public class GiftCardSupplierScreen {

    public String giftCardMoneyAmount = "500";
    public By giftCardAmmount = By.cssSelector("input.form-control.input-theme.input-cash.ember-view.ember-text-field");
    public By submitGiftCardMoneyAmount = By.cssSelector("button.btn.btn-theme");

}
