package pageObjects;

import org.openqa.selenium.By;

public class GiftCardReceiverScreen {


    public String receiverName = "ReceiverName";
    public String senedrName = "SenderName";
    public String blessingText = "blessingText";
    public String emailForGift = "beuuc@dg.com";

    public By receiverOption = By.xpath("//span[text() = 'למישהו אחר']");

    public By receiverNameElement = By.xpath("//div[@class = 'mx2 md1']/label/input");

    public By senderNameElement = By.xpath("//div[@class = 'mx2 md1']/label[2]/input");

    public By giftCardReasonDropMenu = By.xpath("//span[text() = 'לאיזה אירוע?']");

    public By giftCardReasonOption = By.xpath("//*[text() = 'לידה']");

    public By blessingTextElement = By.xpath("//label[@class = 'ember-view ui-field ui-textarea']/textarea");

    public By loadImage = By.xpath("//div[@class = 'media-fields']/label/input");

    public By GiftPaymentTime = By.cssSelector("label.send-now");

    public By sendGiftCardByEmail = By.cssSelector("span.icon.icon-envelope");

    public  By emailForGiftCard = By.xpath("//input[@placeholder = 'כתובת המייל של מקבל/ת המתנה']");

    public By confirmGiftEmail = By.xpath("//button[text() = 'שמירה']");

    public By submitGiftCardReceiverDetails = By.xpath("//button[text() = 'תשלום']");

}


