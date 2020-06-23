package pageObjects;

import org.openqa.selenium.By;

/**
 * Gift Card Supplier Screen Page Object
 *
 * @author Meir Shved
 */
public class GiftCardSupplierScreen {

    //class By elements
    public String giftCardMoneyAmount = "500";
    public By inputGiftCardAmmount = By.xpath("//input[@placeholder = 'מה הסכום?']");
    public By submitGiftCardMoneyAmount = By.xpath("//button[text() = 'לבחירה']");
}
