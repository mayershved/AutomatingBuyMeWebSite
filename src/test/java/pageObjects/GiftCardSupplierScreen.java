package pageObjects;

import org.openqa.selenium.By;

public class GiftCardSupplierScreen {

    public String giftCardMoneyAmount = "500";
    public By giftCardAmmount = By.xpath("//input[@placeholder = 'מה הסכום?']");
    public By submitGiftCardMoneyAmount = By.xpath("//button[text() = 'לבחירה']");
}
