package pageObjects;

import org.openqa.selenium.By;

public class GiftCardSupplierScreen {

    public String giftCardMoneyAmount = "500";
    public By inputGiftCardAmmount = By.xpath("//input[@placeholder = 'מה הסכום?']");
    public By submitGiftCardMoneyAmount = By.xpath("//button[text() = 'לבחירה']");
}
